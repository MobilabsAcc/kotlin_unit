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
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("-")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("1")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_division() {
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("/")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("1")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_multiplication() {
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("9")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_everything() {
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("12")    }

    @Test
    @Throws(Exception::class)
    fun addValue_zeroDivision() {
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("/")
        calculatorPresenter.addValue("0")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("Infinity")    }

    @Test
    @Throws(Exception::class)
    fun addValue_zeroMultiplication() {
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("0")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("0")    }

}