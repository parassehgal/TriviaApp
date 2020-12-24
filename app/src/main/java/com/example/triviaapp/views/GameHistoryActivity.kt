package com.example.triviaapp.views

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.triviaapp.R
import com.example.triviaapp.contoller.DatabaseHandler
import com.example.triviaapp.views.adapter.GameHistoryAdapter

class GameHistoryActivity : AppCompatActivity() {

    private lateinit var listView:ListView
    private lateinit var emptyLayout: LinearLayout

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var intent2 = Intent(this, MainActivity::class.java)
        when (item.itemId) {
            android.R.id.home ->
                //navigate to main activity
                startActivity(intent2)
            else -> throw IllegalStateException("Unexpected value: " + item.itemId)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_history)

        setTitle(R.string.title_history)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        try {
            listView = findViewById(R.id.listView)
            emptyLayout = findViewById(R.id.empty_layout)
            emptyLayout.visibility = View.GONE

            val context = this
            var db = DatabaseHandler(context)
            var userInfo = db.readData()
            if (userInfo!=null&&userInfo.size>0) {
                emptyLayout.visibility = View.GONE
                listView.adapter = GameHistoryAdapter(this, R.layout.list_item_game_summary, userInfo)
            }
            else{
                emptyLayout.visibility = View.VISIBLE
                listView.visibility = View.GONE
                Toast.makeText(this, "No records found", Toast.LENGTH_SHORT).show()
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }

    }
}