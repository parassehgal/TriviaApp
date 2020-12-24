package com.example.triviaapp.views

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.triviaapp.R
import com.example.triviaapp.Utils
import com.example.triviaapp.contoller.DatabaseHandler
import com.example.triviaapp.model.UserInfo
import java.util.*

class SummaryActivity : AppCompatActivity() {

    lateinit var tvUserName:TextView
    lateinit var tvCricketerName:TextView
    lateinit var tvColorName:TextView
    lateinit var btnFinish:Button
    lateinit var btnHistory:Button

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                super.onBackPressed()
            else -> throw IllegalStateException("Unexpected value: " + item.itemId)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setTitle(R.string.title_summary)

        try {
            tvUserName = findViewById(R.id.tvUserName)
            tvCricketerName = findViewById(R.id.tvCricketerName)
            tvColorName = findViewById(R.id.tvColorName)
            btnFinish = findViewById(R.id.btnFinish)
            btnHistory = findViewById(R.id.btnHistory)

            var intent = intent
            var userName = intent.getStringExtra("userName")
            var favCricketer = intent.getStringExtra("favCricketer")
            var flagColor = intent.getStringExtra("flagColor")

            val context = this

            tvUserName.text = userName
            tvCricketerName.text = favCricketer
            tvColorName.text = flagColor

            var db = DatabaseHandler(context)
            var utils:Utils= Utils()
            var date:Date= Date()
            btnFinish.setOnClickListener {
                var userInfo = UserInfo(userName, favCricketer, flagColor, utils.getFormattedDateWithTime(date))
                db.insertData(userInfo)

                var intent2 = Intent(this, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent2)
            }

            btnHistory.setOnClickListener {
                var userInfo = UserInfo(userName, favCricketer, flagColor, utils.getFormattedDateWithTime(date))
                db.insertData(userInfo)
                var intent3 = Intent(this, GameHistoryActivity::class.java)
                startActivity(intent3)
            }
        }

        catch (e: Exception){
            e.printStackTrace()
        }

    }
}