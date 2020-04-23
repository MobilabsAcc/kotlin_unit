package com.example.testapp

import com.lost.calculator.utils.CalculatorHelper
import junit.framework.Assert.assertEquals
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
        calculatorPresenter.addValue("9")
        calculatorPresenter.addValue("-")
        calculatorPresenter.addValue("6")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("3")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_division() {
        calculatorPresenter.addValue("10")
        calculatorPresenter.addValue("/")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("5")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_multiplication() {
        calculatorPresenter.addValue("10")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("20")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_everything() {
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("6")
    }

    @Test
    @Throws(Exception::class)
    fun custom1() {
        calculatorPresenter.addValue("0.0001")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("0.0001")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("0.0001")
        //           :)
    }

    @Test
    @Throws(Exception::class)
    fun custom2() {
        calculatorPresenter.addValue("0.001")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("0.001")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("0.002")
    }

}