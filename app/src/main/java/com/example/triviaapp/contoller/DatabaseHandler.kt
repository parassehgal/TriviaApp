package com.example.triviaapp.contoller

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.triviaapp.model.UserInfo
import java.util.ArrayList

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Users"
val COL_ID = "id"
val COL_NAME = "name"
val COL_CRICKETER_NAME = "cricketerName"
val COL_COLOR_NAME = "colorName"
val COL_DATE_TIME = "dateTime"

class DatabaseHandler(var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_CRICKETER_NAME + " VARCHAR(256)," +
                COL_COLOR_NAME + " VARCHAR(256)," +
                COL_DATE_TIME + " VARCHAR(256)"+" )";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: UserInfo){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.name)
        cv.put(COL_CRICKETER_NAME,user.cricketerName)
        cv.put(COL_COLOR_NAME,user.colorName)
        cv.put(COL_DATE_TIME,user.dateTime)

        var result = db.insert(TABLE_NAME,null,cv)
        if (result == -1.toLong())
            //Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        else{
            //Failed
        }
            //Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
    }

    fun readData():MutableList<UserInfo>{
        Log.d("paras","Inside insertData")
        var list : ArrayList<UserInfo> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var user = UserInfo()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.cricketerName = result.getString(result.getColumnIndex(COL_CRICKETER_NAME))
                user.colorName = result.getString(result.getColumnIndex(COL_COLOR_NAME))
                user.dateTime = result.getString(result.getColumnIndex(COL_DATE_TIME))
                list.add(user)
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

}