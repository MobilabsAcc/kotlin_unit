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
        //TODO: fill it
    }

    @Test
    @Throws(Exception::class)
    fun addValue_division() {
        //TODO: fill it
    }

    @Test
    @Throws(Exception::class)
    fun addValue_multiplication() {
        //TODO: fill it
    }

    @Test
    @Throws(Exception::class)
    fun addValue_everything() {
        //TODO: fill it
    }

}