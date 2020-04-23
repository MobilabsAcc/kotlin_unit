package com.example.testapp

import com.lost.calculator.utils.CalculatorHelper

class CalculatorPresenter(
    private val view: MainActivity,
    private val calculatorHelper: CalculatorHelper
) {
    fun addValue(value: String?) {
        view.showMessage(calculatorHelper.addValue(value))
    }

    interface View {
        fun showMessage(message: String?)
    }

}
