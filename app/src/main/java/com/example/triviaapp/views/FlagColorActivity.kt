package com.example.triviaapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.triviaapp.R

class FlagColorActivity : AppCompatActivity() {

    lateinit var checkBox1: CheckBox
    lateinit var checkBox2: CheckBox
    lateinit var checkBox3: CheckBox
    lateinit var checkBox4: CheckBox
    lateinit var nextButton: Button

    lateinit var userName:String
    lateinit var favCricketer:String

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> super.onBackPressed()
            else -> throw IllegalStateException("Unexpected value: " + item.itemId)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag_color)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        try {
            checkBox1 = findViewById(R.id.checkbox1)
            checkBox2 = findViewById(R.id.checkbox2)
            checkBox3 = findViewById(R.id.checkbox3)
            checkBox4 = findViewById(R.id.checkbox4)
            nextButton = findViewById(R.id.btnNext)

            var intent = intent
            userName = intent.getStringExtra("userName")
            favCricketer = intent.getStringExtra("favCricketer")
            bindEvents()
        }
        catch (e:Exception){
            e.printStackTrace()
        }

    }
    fun bindEvents()
    {
     try {
         nextButton.setOnClickListener{

             var colorList:ArrayList<String> = ArrayList()
             if (checkBox1.isChecked){
                 colorList.add(checkBox1.text.toString())
             }
             if (checkBox2.isChecked){
                 colorList.add(checkBox2.text.toString())
             }
             if (checkBox3.isChecked){
                 colorList.add(checkBox3.text.toString())
             }
             if (checkBox4.isChecked){
                 colorList.add(checkBox4.text.toString())
             }

             //For inserting comma
             var colors:String=""
             for (i in colorList.indices){
                 if(i==0){
                     colors += colorList.get(i)
                 }
                 else{
                     colors = colors+" , "+colorList.get(i)
                 }
             }

             if (colors!=null && !colors.isEmpty()){
                 var intent = Intent(this, SummaryActivity::class.java)
                 intent.putExtra("userName", userName)
                 intent.putExtra("favCricketer",favCricketer)
                 intent.putExtra("flagColor",colors)

                 startActivity(intent)
             }
             else{
                 Toast.makeText(this,"Please select the altleast one color", Toast.LENGTH_SHORT).show()
             }
         }

     }
        catch (e:java.lang.Exception){
        e.printStackTrace()}
    }
}