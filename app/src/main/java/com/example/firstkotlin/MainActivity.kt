package com.example.firstkotlin

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_date = findViewById<Button>(R.id.date_pick)
        val tv_time = findViewById<MaterialTextView>(R.id.tv_time)


        btn_date.setOnClickListener {
            val cld = Calendar.getInstance()
            val day = cld.get(Calendar.DAY_OF_MONTH)
            val month = cld.get(Calendar.MONTH)
            val year = cld.get(Calendar.YEAR)
            val dateDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val selectedDate = "$dayOfMonth/$month/$year"
                    val simpleDate = SimpleDateFormat("dd/mm/yyyy")
                    val selectedDateInFormat = simpleDate.parse(selectedDate)
                    val selected_in_minute = selectedDateInFormat.time / 60000
                    val currentDate = simpleDate.parse(simpleDate.format(System.currentTimeMillis()))
                    val currentDateInMinute = currentDate.time / 60000;
                    if (selected_in_minute > currentDateInMinute){
                        Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
                    }else {
                        val age_in_min = currentDateInMinute - selected_in_minute

                        tv_time.setText(age_in_min.toString())
                    }

                }, year, month, day);

            dateDialog.show()

        }

    }

}