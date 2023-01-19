package com.example.firstkotlin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_date = findViewById<Button>(R.id.date_pick)

        btn_date.setOnClickListener {
            val cld = Calendar.getInstance()
            val day = cld.get(Calendar.DAY_OF_MONTH)
            val month = cld.get(Calendar.MONTH)
            val year = cld.get(Calendar.YEAR)
            val dateDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  }
                ,year,month,day);

            dateDialog.show()

        }

    }

}