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
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("-")
        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("1")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_division() {
//        calculatorPresenter.addValue("1")
//        calculatorPresenter.addValue("/")
//        calculatorPresenter.addValue("0")
//        calculatorPresenter.addValue("=")
//        Mockito.verify(view).showMessage("Error")

        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("/")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("0.5")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_multiplication() {
        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("0")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("0")
    }

    @Test
    @Throws(Exception::class)
    fun addValue_everything() {
        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("/")
        calculatorPresenter.addValue("0")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("Error")

        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("/")
        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("3")
    }

    @Test
    @Throws(Exception::class)
    fun AddValue_inOrder() {
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue("*")
        calculatorPresenter.addValue("(")
        calculatorPresenter.addValue("1")
        calculatorPresenter.addValue("+")
        calculatorPresenter.addValue("2")
        calculatorPresenter.addValue(")")
        calculatorPresenter.addValue("=")
        Mockito.verify(view).showMessage("6")
    }



}