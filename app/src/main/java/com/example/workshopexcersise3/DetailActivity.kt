package com.example.workshopexcersise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.example.workshopexcersise3.ListItem.Companion.INTENT_ITEM_SUBTITLE
import com.example.workshopexcersise3.ListItem.Companion.INTENT_ITEM_TITLE

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val title: String = intent.getStringExtra(INTENT_ITEM_TITLE)
        val subtitle: String = intent.getStringExtra(INTENT_ITEM_SUBTITLE)

        val textViewTitle = findViewById<TextView>(R.id.textViewTitle).apply {
            this.text = title
        }

        val textViewSubtitle = findViewById<TextView>(R.id.textViewSubtitle).apply {
            this.text = subtitle
        }
    }
    //setting menu in action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu_detail,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        return when (item.itemId){
            R.id.action_share -> {
                //Do something..
                Toast.makeText(this,"Share action selected", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
