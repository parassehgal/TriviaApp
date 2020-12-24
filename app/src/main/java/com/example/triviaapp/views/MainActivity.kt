package com.example.triviaapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.triviaapp.R

class MainActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var btnNext:Button

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.history_button_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent2 = Intent(this, GameHistoryActivity::class.java)
        when (item.itemId) {
            R.id.action_history ->
                startActivity(intent2)
            else -> throw IllegalStateException("Unexpected value: " + item.itemId)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            editTextName = findViewById(R.id.editTextUserName)
            btnNext = findViewById(R.id.btnNext)

            btnNext.setOnClickListener{
                var userName = editTextName.text.toString().trim()
                if (userName!=null && !userName.isEmpty()) {
                    var intent = Intent(this, FvCricketerActivity::class.java)
                    intent.putExtra("userName", userName)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Please enter the name",Toast.LENGTH_SHORT).show()
                }
            }
        }
        catch (e:Exception){
            e.printStackTrace()
        }

    }
}