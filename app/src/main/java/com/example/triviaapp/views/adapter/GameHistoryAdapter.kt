package com.example.triviaapp.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.triviaapp.R
import com.example.triviaapp.model.UserInfo

class GameHistoryAdapter(var mCtx:Context,var resources:Int,var items:List<UserInfo>):ArrayAdapter<UserInfo>(mCtx,resources,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources,null)

        val tvGameId : TextView = view.findViewById(R.id.tvGameId)
        val tvDateTime : TextView = view.findViewById(R.id.tvDateTime)
        val tvUserName : TextView = view.findViewById(R.id.tvUserName)
        val tvFavCricketer : TextView = view.findViewById(R.id.tvFavCricketer)
        val tvFavColor : TextView = view.findViewById(R.id.tvFavColor)

        try {
            var mItem: UserInfo = items[position]
            tvGameId.text = items[position].id.toString()
            tvDateTime.text = items[position].dateTime
            tvUserName.text = items[position].name
            tvFavCricketer.text = items[position].cricketerName
            tvFavColor.text = items[position].colorName
        }
        catch (e:Exception){
            e.printStackTrace()
        }
     
        return view
    }
}