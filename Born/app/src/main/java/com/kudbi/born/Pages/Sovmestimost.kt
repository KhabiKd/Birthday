package com.kudbi.born.Pages

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kudbi.born.R
import java.util.*

class Sovmestimost : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sovmestimost)

        val number = findViewById<TextView>(R.id.number)
        val selectDate_btn_1 = findViewById<Button>(R.id.selectDate_btn_1)
        val selectDate_btn_2 = findViewById<Button>(R.id.selectDate_btn_2)
        val btn_sovm = findViewById<Button>(R.id.btn_sovm)

        val argumentsSovm = intent.extras
        val sltDayStrSovm = argumentsSovm!!["Day"].toString()
        val sltMonthStrSovm = argumentsSovm!!["Month"].toString()
        val sltYearStrSovm = argumentsSovm!!["Year"].toString()

        var first_date: String = ""
        var second_date: String = ""

        selectDate_btn_1.setText("$sltDayStrSovm/$sltMonthStrSovm/$sltYearStrSovm")

        selectDate_btn_1.setOnClickListener{ view ->
            clickDatePicker_1(view)
        }

        selectDate_btn_2.setOnClickListener{ view ->
            clickDatePicker_2(view)
        }

        btn_sovm.setOnClickListener {

            if(selectDate_btn_1.text == "Выберите Дату" || selectDate_btn_2.text == "Выберите Дату"){
                Toast.makeText(this,
                        "Пожалуйста, выберите дату", Toast.LENGTH_SHORT).show()
            } else{
                if (first_date == selectDate_btn_1.text.toString() && second_date == selectDate_btn_2.text.toString()){

                } else{
                    first_date = selectDate_btn_1.text.toString()
                    second_date = selectDate_btn_2.text.toString()

                    val random_number = (40 until 101).random()
                    when(random_number){
                        in 47..49 -> number.setTextColor(Color.parseColor("#7d0800"))
                        in 50..65 -> number.setTextColor(Color.parseColor("#fc8403"))
                        in 66..85 -> number.setTextColor(Color.parseColor("#005c16"))
                        in 86..100 -> number.setTextColor(Color.parseColor("#00ff3c"))
                        else -> number.setTextColor(Color.parseColor("#FFFFFF"))
                    }

                    number.text = "$random_number %"
                }
            }



//            if(selectDate_btn_1.text == "Выберите Дату" || selectDate_btn_2.text == "Выберите Дату"){
//                Toast.makeText(this,
//                        "Пожалуйста, выберите дату", Toast.LENGTH_SHORT).show()
//            } else{
//                var random_number = (40 until 101).random()
//                number.text = "$random_number %"
//            }
        }
    }


    fun clickDatePicker_1(view: View){


        val myCalendar_1 = Calendar.getInstance()
        val year_1 = myCalendar_1.get(Calendar.YEAR)
        val month_1 = myCalendar_1.get(Calendar.MONTH)
        val day_1 = myCalendar_1.get(Calendar.DAY_OF_MONTH)

        val selectDate_btn_1 = findViewById<Button>(R.id.selectDate_btn_1)

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    view, year, month, dayOfMonth ->
                    Toast.makeText(this,
                            "Дата успешно выбрана!",
                            Toast.LENGTH_SHORT).show()

                    val selectedDate = "$dayOfMonth/${month+1}/$year"
                    selectDate_btn_1.setText(selectedDate)


                }
                ,year_1
                ,month_1
                ,day_1).show()

    }

    fun clickDatePicker_2(view: View){


        val myCalendar_2 = Calendar.getInstance()
        val year_2 = myCalendar_2.get(Calendar.YEAR)
        val month_2 = myCalendar_2.get(Calendar.MONTH)
        val day_2 = myCalendar_2.get(Calendar.DAY_OF_MONTH)

        val selectDate_btn_2 = findViewById<Button>(R.id.selectDate_btn_2)

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    view, year, month, dayOfMonth ->
                    Toast.makeText(this,
                            "Дата успешно выбрана!",
                            Toast.LENGTH_SHORT).show()

                    val selectedDate = "$dayOfMonth/${month+1}/$year"
                    selectDate_btn_2.setText(selectedDate)


                }
                ,year_2
                ,month_2
                ,day_2).show()

    }

}
