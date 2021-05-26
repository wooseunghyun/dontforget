package com.wooseunghyun.dontforget

import android.R.color
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.prolificinteractive.materialcalendarview.*
import com.prolificinteractive.materialcalendarview.spans.DotSpan
import java.util.*


class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        var startTimeCalendar = Calendar.getInstance()
        var endTimeCalendar = Calendar.getInstance()

        val materialCalendar = findViewById<MaterialCalendarView>(R.id.materialCalendar)
        val currentYear = startTimeCalendar.get(Calendar.YEAR)
        val currentMonth = startTimeCalendar.get(Calendar.MONTH)
        val currentDate = startTimeCalendar.get(Calendar.DATE)
        val decorator = Decorator(this)
        endTimeCalendar.set(Calendar.MONTH, currentMonth+3)

        materialCalendar.addDecorator(decorator)

        materialCalendar.state().edit()
            .setFirstDayOfWeek(Calendar.MONDAY)
//            .setMinimumDate(CalendarDay.from(currentYear, currentMonth, 1))
//            .setMaximumDate(CalendarDay.from(currentYear, currentMonth+3, endTimeCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit()


    }

    class Decorator(context: Context): DayViewDecorator {
        private var date = CalendarDay.today()
        val drawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_cal_background )
        override fun shouldDecorate(day: CalendarDay?): Boolean {
           // return day?.equals(date)!!
            return true
        }
        override fun decorate(view: DayViewFacade?) {
            if(drawable != null){
                //배경색
                //배경을 3종류로 만들어서 다 수행되지 않았으면 반개짜리.이런식으로 보이게 할것
                //배경 3종류 직접 만들기....
                view?.setBackgroundDrawable(drawable)
                //글자색
//                view?.addSpan(StyleSpan(Typeface.BOLD));
//                view?.addSpan(RelativeSizeSpan(1.4f));
//                view?.addSpan(ForegroundColorSpan(Color.GREEN));
                //글자 아래 점
                view!!.addSpan(DotSpan(5F, Color.RED))
            }
        }
    }
}