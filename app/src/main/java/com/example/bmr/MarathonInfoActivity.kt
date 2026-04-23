package com.example.bmr

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.InputStreamReader

class MarathonInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marathon_info)

        val textInfo = findViewById<TextView>(R.id.marathon_info_text)
        val backButton = findViewById<Button>(R.id.back_button)

        // Чтение информации из raw-файла
        val marathonInfo = readMarathonInfoFromFile()
        textInfo.text = marathonInfo

        backButton.setOnClickListener {
            finish()
        }

        // Включаем кнопку "Назад" в ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "О Marathon Skills 2016"
    }


    private fun readMarathonInfoFromFile(): String {
        val stringBuilder = StringBuilder()
        try {
            // Читаем файл из папки raw
            val inputStream = resources.openRawResource(R.raw.marathon_skills_2016_marathon_info)
            val reader = BufferedReader(InputStreamReader(inputStream))

            var line: String? = reader.readLine()
            while (line != null) {
                stringBuilder.append(line).append("\n")
                line = reader.readLine()
            }
            reader.close()
        } catch (e: Exception) {
            stringBuilder.append("Ошибка загрузки информации о марафоне: ${e.message}")
        }
        return stringBuilder.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}