package com.kudbi.born

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //* Назначаем имена всем view, находящиеся в activity_main.xml, которые будем использовать в коде */
        val selectDate_btn = findViewById<Button>(R.id.selectDate_btn)
        val generate_btn = findViewById<Button>(R.id.generate_btn)
        val text_4 = findViewById<TextView>(R.id.text_4)

        //* Вызываем окно Календаря по нажатию кнопки "Выберите дату", айдишку посмотри в xml файле если нужно
        selectDate_btn.setOnClickListener{ view ->
            clickDatePicker(view)
        }

        //* По нажатию кнопки "Узнать о себе всё" открывается экран SelectMenu. Одновременно мы разделяем текст(выбранная пользователем дата) на подстроки по символу "/" тем саммым получаем
        // значение Дня, Месяца и Года(год не прописал, ибо не нужен). Через intent передаем эти значение на экран SelectMenu*/

        generate_btn.setOnClickListener(){
            if(text_4.text == ""){
                Toast.makeText(
                    this,
                    "Пожалуйста, выберите дату", Toast.LENGTH_SHORT
                ).show()
            } else {
                val getDate = text_4.text.toString()
                val getDateSplited = getDate.split("/")
                val getYear = getDateSplited.get(2)
                val getMonth = getDateSplited.get(1)
                val getDay = getDateSplited.get(0)

                val getDayInt = Integer.parseInt(getDay)
                val getMonthInt = Integer.parseInt(getMonth)
                val getYearInt = Integer.parseInt(getYear)

                val intent = Intent(this, SelectMenu::class.java)
                intent.putExtra("month", getMonthInt)
                intent.putExtra("day", getDayInt)
                intent.putExtra("year", getYearInt)
                startActivity(intent)

            }

        }

    }

    //* Функция вызова Календаря*/
    fun clickDatePicker(view: View){


        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val text_4 = findViewById<TextView>(R.id.text_4)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(
                    this,
                    "Дата успешно выбрана!",
                    Toast.LENGTH_SHORT
                ).show()

                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                text_4.setText(selectedDate)


            }, year, month, day).show()

    }

//    private fun selectMenuPage(){
//
//        val intent = Intent(this, SelectMenu::class.java)
//        startActivity(intent)
//    }



}