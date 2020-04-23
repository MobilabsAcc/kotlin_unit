package com.lost.calculator.utils

import com.example.testapp.utils.CalculatorSymbol

class CalculatorHelper {
    private var currentEquation = ""
    fun addValue(value: String?): String {
        if (value != null) { // Reset the equation if last response was bad
            if (currentEquation == BAD_RESPONSE) {
                currentEquation = ""
            }
            val calculatorSymbol: CalculatorSymbol = CalculatorSymbol.getSymbol(value)
            when (calculatorSymbol) {
                CalculatorSymbol.DIVIDE, CalculatorSymbol.MULTIPLY, CalculatorSymbol.ADDITION, CalculatorSymbol.SUBTRACTION -> addSymbol(calculatorSymbol)
                CalculatorSymbol.CLEAR -> currentEquation = ""
                CalculatorSymbol.EQUALS -> computeCurrentEquation()
                CalculatorSymbol.NONE -> currentEquation += value
            }
        }
        return currentEquation
    }

    private fun computeCurrentEquation() {
        if (currentEquation.length > 0) {
            var tempEquation = currentEquation
            for (calculatorSymbol in CalculatorSymbol.values()) {
                val valueToReplace: String = calculatorSymbol.visual
                if (valueToReplace != null) {
                    tempEquation = tempEquation.replace(valueToReplace, calculatorSymbol.maths)
                }
            }
            val result: Double
            try {
                result = CalculatorUtils.evaluate(tempEquation)
                currentEquation = java.lang.Double.toString(result)
            } catch (runTimeException: RuntimeException) {
                currentEquation = BAD_RESPONSE
            }
            if (currentEquation != BAD_RESPONSE) { // Remove trailing .0
                if (currentEquation.endsWith(".0")) {
                    currentEquation = currentEquation.substring(0, currentEquation.length - 2)
                }
            }
        }
    }

    private fun addSymbol(calculatorSymbol: CalculatorSymbol) {
        if (currentEquation.length > 0) {
            if (CalculatorSymbol.getSymbol(currentEquation.substring(currentEquation.length - 1)) ===
                CalculatorSymbol.NONE
            ) {
                currentEquation += calculatorSymbol.visual
            }
        }
    }

    companion object {
        const val BAD_RESPONSE = "N/A"
    }
}