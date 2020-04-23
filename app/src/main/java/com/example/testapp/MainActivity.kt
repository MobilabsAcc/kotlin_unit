package com.example.testapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lost.calculator.utils.CalculatorHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var calculatorPresenter   : CalculatorPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

        calculatorPresenter = CalculatorPresenter(this, CalculatorHelper())
    }

    fun buttonOnClick(view: View) {
        calculatorPresenter.addValue((view as TextView).text.toString())
    }

    fun showMessage(message: String?) {
        resultTextView.text = message
    }
}
