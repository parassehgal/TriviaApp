package com.example.triviaapp

import java.text.SimpleDateFormat
import java.util.*

class Utils {

    fun getFormattedDateWithTime(dateTime: Date): String {

        //return new Date((UTCTicks - TICKS_AT_EPOCH) / TICKS_PER_MILLISECOND);
        var date = ""
        var sd = SimpleDateFormat("dd MMMM YYYY")
        date = date + sd.format(dateTime) + " " + "at"
        sd = SimpleDateFormat(" HH:mm")
        date = date + sd.format(dateTime) + " " + "hours"
        return date
    }

}