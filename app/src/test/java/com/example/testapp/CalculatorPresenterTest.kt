package com.example.testapp

import com.example.testapp.utils.CalculatorSymbol
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

        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("-")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("-1")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_division() {
        calculatorPresenter.addValue("8")
        calculatorPresenter.addValue("/")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("4")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_multiplication() {
        calculatorPresenter.addValue("8")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("24")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_everything() {
        calculatorPresenter.addValue("8")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("30")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_clear() {
        calculatorPresenter.addValue("8")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("CL")
        Mockito.verify(view).showMessage("")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_noneDoesNotMatter() {
        calculatorPresenter.addValue("7")
        calculatorPresenter.addValue("-")
        calculatorPresenter.addValue("")
        calculatorPresenter.addValue("3")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("4")
    }

}