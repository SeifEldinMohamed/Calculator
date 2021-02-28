package com.seif.calculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //numbers
        btn_zero.setOnClickListener { appendonExpression("0", true) }
        btn_one.setOnClickListener { appendonExpression("1", true) }
        btn_two.setOnClickListener { appendonExpression("2", true) }
        btn_three.setOnClickListener { appendonExpression("3", true) }
        btn_four.setOnClickListener { appendonExpression("4", true) }
        btn_five.setOnClickListener { appendonExpression("5", true) }
        btn_six.setOnClickListener { appendonExpression("6", true) }
        btn_seven.setOnClickListener { appendonExpression("7", true) }
        btn_eight.setOnClickListener { appendonExpression("8", true) }
        btn_nine.setOnClickListener { appendonExpression("9", true) }
        btn_dot.setOnClickListener { appendonExpression(".", true) }

        // operations
        btn_plus.setOnClickListener { appendonExpression("+", false) }
        btn_minus.setOnClickListener { appendonExpression("-", false) }
        btn_multi.setOnClickListener { appendonExpression("*", false) }
        btn_divide.setOnClickListener { appendonExpression("/", false) }
        btn_lpracket.setOnClickListener { appendonExpression("(", false) }
        btn_rpracket.setOnClickListener { appendonExpression(")", false) }

        btn_clear.setOnClickListener {
            txt_exp.text = ""
            txtx_result.text = ""
        }

        btn_erase.setOnClickListener {
            val str = txt_exp.text.toString()
            if (str.isNotEmpty()) {
                txt_exp.text = str.substring(0, str.length - 1)
            }
            txtx_result.text = ""
        }
        btn_equal.setOnClickListener {
            try {
                val expresion = ExpressionBuilder(txt_exp.text.toString()).build()
                val result = expresion.evaluate()
                val longresult = result.toLong()
                if (result == longresult.toDouble()) {
                    txtx_result.text = longresult.toString()
                }
                else {
                    txtx_result.text = result.toString()
                }
            } catch (e: Exception) {
                Log.d("Exception", "message: ${e.message}")
            }
        }
    }

    fun appendonExpression(str: String, check: Boolean) {
        if (txtx_result.text.isNotEmpty()) {
            txt_exp.text = ""
        }
        if (check) {
            txtx_result.text = ""
            txt_exp.append(str)
        }
        else {
            txt_exp.append(txtx_result.text)
            txt_exp.append(str)
            txtx_result.text = ""
        }
    }
}