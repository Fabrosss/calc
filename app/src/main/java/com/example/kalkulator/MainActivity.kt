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
    private var result: Float = 0F
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

    fun number_button(view: View){
        if(result == 1F) {
            clearView()
            result = 0F
        }
        var txt : String = "0"
       when(view.id){
           R.id.button1 -> txt = "1"
           R.id.button2 -> txt = "2"
           R.id.button3 -> txt = "3"
           R.id.button4 -> txt = "4"
           R.id.button5 -> txt = "5"
           R.id.button6 -> txt = "6"
           R.id.button7 -> txt = "7"
           R.id.button8 -> txt = "8"
           R.id.button9 -> txt = "9"
           R.id.button0 -> txt = "0"
        }
        updatetext(txt)
    }
    private fun updatetext(txt: String) {
        val resultxt = findViewById<TextView>(R.id.result)
        if(resultxt.text == "0"){
            resultxt.text = txt
        }else resultxt.text = resultxt.text.toString().plus(txt)
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
        var txte : String
        if (txt.length() != 0 ){
            txte  = txt.text.substring(0, txt.text.length-1)
            if(txte.isEmpty()){
                txte = "0"
            }
        }else  txte = "0"

        txt.text = txte


    }

    fun div_ope(view: View) {
        if (currentOperation != "/"){
            currentOperation = "/"
            sendNumbera()
            clearView()
        }
        comecontrol = 1
    }

    fun multi_ope(view: View) {
        if (currentOperation != "*"){
            currentOperation = "*"
            sendNumbera()
            clearView()
        }
        comecontrol = 1

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
        comecontrol = 1
    }
    fun plus_ope(view: View) {
        if (currentOperation != "+"){
            currentOperation = "+"
            sendNumbera()
            clearView()
        }
        comecontrol = 1
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
        result = 1F
    }



}