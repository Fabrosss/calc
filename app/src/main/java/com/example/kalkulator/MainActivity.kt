package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var currentOperation: String  = " "
    private var comecontrol: Int = 1
    private var numbera : Float  = 0F
    private var numberb : Float = 0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun ac_operation(view:View) {
        clearView()

        numbera = 0F
        numberb = 0F
    }

    private fun clearView() {
        val resultxt = findViewById<TextView>(R.id.result)
        resultxt.text = "0"
    }

    private fun updatetext(txt: String) {
        val resultxt = findViewById<TextView>(R.id.result)
        if(resultxt.text == "0"){
            resultxt.text = txt
        }else resultxt.text = resultxt.text.toString().plus(txt)
    }


    fun one_ope(view:View) {
        val txt : String = "1"
        updatetext(txt)
    }

    fun two_ope(view:View) {
        val txt : String = "2"
        updatetext(txt)
    }
    fun three_ope(view:View) {
        val txt : String = "3"
        updatetext(txt)
    }
    fun four_ope(view:View) {
        val txt : String = "4"
        updatetext(txt)
    }
    fun five_ope(view:View) {
        val txt : String = "5"
        updatetext(txt)
    }
    fun six_ope(view:View) {
        val txt : String = "6"
        updatetext(txt)
    }
    fun seven_ope(view:View) {
        val txt : String = "7"
        updatetext(txt)
    }
    fun eight_ope(view:View) {
        val txt : String = "8"
        updatetext(txt)
    }
    fun nine_ope(view:View) {
        val txt : String = "9"
        updatetext(txt)
    }
    fun zero_ope(view:View) {
        val txt : String = "0"
        updatetext(txt)
    }
    private fun sendNumbera() {
        val txt = findViewById<TextView>(R.id.result)
        numbera = txt.text.toString().toFloat()
    }
    private fun sendNumberb() {
        val txt = findViewById<TextView>(R.id.result)
        numberb = txt.text.toString().toFloat()

    }
    fun cancel_ope(view: View) {
        var txt  = findViewById<TextView>(R.id.result)
        val txte : String = txt.text.substring(0, txt.text.length-1)
        txt.text = txte


    }

    fun div_ope(view: View) {
        if (currentOperation != "/"){
            currentOperation = "/"
            sendNumbera()
            clearView()
        }
    }

    fun multi_ope(view: View) {
        if (currentOperation != "*"){
            currentOperation = "*"
            sendNumbera()
            clearView()
        }

    }
    fun coma_ope(view: View) {
        if(comecontrol == 1){
            val txt : String = "."
            updatetext(txt)
            comecontrol = 0
        }

    }
    fun minus_ope(view: View) {
        if (currentOperation != "-"){
            currentOperation = "-"
            sendNumbera()
            clearView()
        }
    }
    fun plus_ope(view: View) {
        if (currentOperation != "+"){
            currentOperation = "+"
            sendNumbera()
            clearView()
        }
    }
    fun equal_ope(view: View) {
        if(currentOperation != " "){
            sendNumberb()
            val txt = findViewById<TextView>(R.id.result)
            val result: String = when(currentOperation){
                "+" ->{
                    "${numbera+numberb}"
                }
                "-" ->{
                    "${numbera-numberb}"
                }
                "*" ->{
                    "${numbera*numberb}"
                }
                "/" ->{
                    "${numbera/numberb}"
                }
                else ->  "error"
            }
            txt.text = result
            currentOperation = " "
            if(comecontrol==0){
                comecontrol =1
            }
        }

    }



}