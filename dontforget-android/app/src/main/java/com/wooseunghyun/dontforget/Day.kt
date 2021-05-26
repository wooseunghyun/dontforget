package com.wooseunghyun.dontforget

import java.util.*
import kotlin.collections.ArrayList

class Day{
    lateinit var cal:Calendar
    var dayOfWeek:Int
    var day:Int
    var month:Int
    var year:Int

    constructor(calendar: Calendar){
        cal = calendar
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)-1
        if(dayOfWeek ==0)
            dayOfWeek = 7
        day = cal.get(Calendar.DATE)
        month = cal.get(Calendar.MONTH)+1
        year = cal.get(Calendar.YEAR)
    }

    fun dayOfWeekToString():String{
        when(dayOfWeek){
            1-> return "MON"
            2-> return "TUE"
            3-> return "WED"
            4-> return "THUR"
            5-> return "FRI"
            6-> return "SAT"
            7-> return "SUN"
            else -> return "ERROR"
        }
    }

    fun thisWeekToArrayList():ArrayList<Day>{
        val result = ArrayList<Day>()
        //월요일부터 일요일까지 집어넣기//일주일의 첫날은 월요일로
        var tempC:Calendar
        for(i in 1..7){
            tempC = cal.clone() as Calendar
            tempC.add(Calendar.DATE,i-dayOfWeek)
            result.add(Day(tempC))
        }
        return result
    }

    fun dayToString():String{
        return (this.dayOfWeekToString()+"."
                +day.toString()+"."
                +month.toString()+"."
                +year.toString().substring(2,4)+".")
    }

}