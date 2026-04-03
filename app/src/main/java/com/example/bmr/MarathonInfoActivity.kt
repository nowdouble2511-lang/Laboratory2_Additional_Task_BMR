package com.example.bmr

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MarathonInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marathon_info)

        val textInfo = findViewById<TextView>(R.id.marathon_info_text)
        //чтение файла textInfo.setText(R.string.marathon_info)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}