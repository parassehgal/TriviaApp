package com.example.triviaapp.views

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.triviaapp.R

class FvCricketerActivity : AppCompatActivity() {

    lateinit var radioGroup: RadioGroup
    lateinit var radioButton: RadioButton
    lateinit var btnNext: Button

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> super.onBackPressed()
            else -> throw IllegalStateException("Unexpected value: " + item.itemId)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fv_cricketer)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        try {
            btnNext = findViewById(R.id.btnNext)
            radioGroup = findViewById(R.id.rg_input)

            var intent = intent
            var userName = intent.getStringExtra("userName")
            btnNext.setOnClickListener {

                var intSelectedButton : Int = radioGroup!!.checkedRadioButtonId
                radioButton = findViewById(intSelectedButton)
                var intent2 = Intent(this, FlagColorActivity::class.java)
                intent2.putExtra("userName", userName)
                intent2.putExtra("favCricketer", radioButton.text)
                startActivity(intent2)
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }
}