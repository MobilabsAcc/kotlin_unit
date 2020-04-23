package com.example.testapp

import com.lost.calculator.utils.CalculatorHelper
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CalculatorPresenterTest {
    lateinit var calculatorPresenter: CalculatorPresenter
    lateinit var view: MainActivity

    @Before
    fun before() {
        view = Mockito.mock(MainActivity::class.java)
        calculatorPresenter = CalculatorPresenter(view, CalculatorHelper())
    }

    @Test
    @Throws(Exception::class)
    fun addValue_addition() {
        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("3")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_subtraction() {
        calculatorPresenter.addValue("6")
        calculatorPresenter.addValue("-")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("4")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_division() {
        calculatorPresenter.addValue("54")
        calculatorPresenter.addValue("÷")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("27")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_multiplication() {
        calculatorPresenter.addValue("23")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("69")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_everything() {
        calculatorPresenter.addValue("5")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("11")
    }

    @Test
    @Throws(Exception::class)
    fun multiplicationSub() {
        calculatorPresenter.addValue("10")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("8")
        calculatorPresenter.addValue("-")
        calculatorPresenter.addValue("6")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("74")
    }

    @Test
    @Throws(Exception::class)
    fun divisionMultiplication() {
        calculatorPresenter.addValue("20")
        calculatorPresenter.addValue("÷")
        calculatorPresenter.addValue("4")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("6")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("30")
    }
}