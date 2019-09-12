package com.example.workshopexcersise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title: String = intent.getStringExtra(INTENT_ITEM_TITLE)
        val subtitle: String = intent.getStringExtra(INTENT_ITEM_SUBTITLE)


        val textViewTitle = findViewById<TextView>(R.id.textViewTitle).apply {
            this.text = title
        }

        val textViewSubtitle = findViewById<TextView>(R.id.textViewSubtitle).apply {
            this.text = subtitle
        }
    }
}
