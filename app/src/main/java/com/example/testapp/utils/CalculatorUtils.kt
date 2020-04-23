package com.lost.calculator.utils

/**
 * Utils to help calculating equations
 */
object CalculatorUtils {
    /**
     * Takes in an equation in the form of a string and returns the calculated response
     * Will throw an exception if you pass in something it can't handle
     *
     *
     * http://stackoverflow.com/a/26227947
     *
     * @param str
     * @return
     */
    @Throws(RuntimeException::class)
    fun evaluate(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0
            fun nextChar() {
                ch = if (++pos < str.length) str[pos].toInt() else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            // Grammar:
// expression = term | expression `+` term | expression `-` term
// term = factor | term `*` factor | term `/` factor
// factor = `+` factor | `-` factor | `(` expression `)`
//        | number | functionName factor | factor `^` factor
            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.toInt()) ) x += parseTerm() // addition
                    else if (eat('-'.toInt())) x -= parseTerm() // subtraction
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.toInt())) x *= parseFactor() // multiplication
                    else if (eat('/'.toInt())) x /= parseFactor() // division
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor() // unary plus
                if (eat('-'.toInt())) return -parseFactor() // unary minus
                var x: Double
                val startPos = pos
                if (eat('('.toInt())) { // parentheses
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) { // numbers
                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()
                    x =
                        str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) { // functions
                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func =
                        str.substring( startPos, pos)
                     x = parseFactor()
                    if ( func == "sqrt")  x = Math.sqrt( x)
                    else if ( func == "sin")  x = Math.sin(Math.toRadians( x))
                    else if ( func == "cos")  x = Math.cos(Math.toRadians( x))
                    else if ( func == "tan")  x = Math.tan(Math.toRadians( x))
                    else throw RuntimeException(
                        "Unknown function: " +  func
                    )
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                if (eat('^'.toInt()))  x =
                    Math.pow( x, parseFactor()) // exponentiation
                return  x
            }
        }.parse()
    }
}