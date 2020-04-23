package com.example.testapp.utils

enum class CalculatorSymbol {
    DIVIDE("/", "÷"), MULTIPLY(
        "*",
        "×"
    ),
    ADDITION("+"), SUBTRACTION("-"), CLEAR("CL"), EQUALS("="), NONE("");

    val maths: String
    val visual: String

     constructor(maths: String) {
        this.maths = maths
        visual = maths
    }

     constructor(maths: String, visual: String) {
        this.maths = maths
        this.visual = visual
    }

    companion object {
        fun getSymbol(character: String): CalculatorSymbol {
            var returnCalculatorSymbol = NONE
            for (calculatorSymbol in values()) {
                if (calculatorSymbol.visual == character) {
                    returnCalculatorSymbol = calculatorSymbol
                    break
                }
            }
            return returnCalculatorSymbol
        }
    }
}