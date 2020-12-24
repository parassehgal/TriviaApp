package com.example.triviaapp.model

class UserInfo {
    var id : Int = 0
    var name: String =""
    var cricketerName: String = ""
    var colorName: String = ""
    var dateTime: String = ""

    constructor(name:String,cricketerName:String,colorName:String,dateTime:String){
        this.name = name
        this.cricketerName = cricketerName
        this.colorName = colorName
        this.dateTime = dateTime
    }

    constructor()
}