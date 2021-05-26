package com.wooseunghyun.dontforget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var viewPager:ViewPager2
    lateinit var tabDots:TabLayout
    lateinit var parentView:LinearLayout
    lateinit var calBtn:ImageView

    var day = Day(Calendar.getInstance())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.view_pager) as ViewPager2
        tabDots = findViewById(R.id.tab_dots) as TabLayout
        parentView = findViewById(R.id.parent_view) as LinearLayout
        calBtn = findViewById(R.id.cal_btn)as ImageView
        val intent = Intent(this,CalendarActivity::class.java)
        intent.putExtra("day",day.day)
        calBtn.setOnClickListener{
            startActivity(intent)
        }

        init()
    }
    private fun init(){
        viewPager.adapter = MyViewPagerAdapter(this@MainActivity)

        TabLayoutMediator(tabDots,viewPager, TabLayoutMediator.TabConfigurationStrategy({ tab, position ->
            //
        })).attach()

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Snackbar.make(parentView,"You are selected"+day.dayToString(),Snackbar.LENGTH_SHORT).show()
            }
        })
        viewPager.setCurrentItem(day.dayOfWeek-1,false)

    }
}