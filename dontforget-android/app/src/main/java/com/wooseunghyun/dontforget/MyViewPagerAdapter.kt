package com.wooseunghyun.dontforget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class  MyViewPagerAdapter(var context: Context) : RecyclerView.Adapter<MyViewPagerAdapter.MyViewHolder>(){
    val SIZE = 7
//
//    var colorIconMatrix = arrayOf<IntArray>(
//            intArrayOf(android.R.color.holo_red_dark,R.drawable.ic_add_box_24px),
//            intArrayOf(android.R.color.holo_purple,R.drawable.ic_add_box_24px)
//    )
    var day = Day(Calendar.getInstance())
    var calList = day.thisWeekToArrayList()



    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        lateinit var viewBtn:ImageView
        lateinit var viewDate:TextView
        lateinit var container: LinearLayout
        lateinit var recyclerView: RecyclerView
        var reItemList:ArrayList<String> = ArrayList()
        var reItemMap: MutableMap<String,Boolean> = mutableMapOf("" to false)

        init {
            viewDate = itemView.findViewById(R.id.date_text) as TextView
            viewBtn = itemView.findViewById(R.id.add_btn) as ImageView
            container = itemView.findViewById(R.id.pager_container) as LinearLayout
            recyclerView = itemView.findViewById(R.id.recycler_view) as RecyclerView

            //날짜 마다 다른 데이터 가져와야함.먼저 내부 데이터베이스를 구현하고->리스트를 좀더 가독성 있게 담을 클래스를 만들어서 데이터베이스를 가져오자
            reItemList.add("a")
            reItemList.add("b")
            for(i in reItemList){
                reItemMap.put(i,false)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_viewpager,parent,false))
    }

    override fun getItemCount(): Int {
        return SIZE
    }

    fun getTodayDayOfWeek():Int{
        return day.dayOfWeek
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //요일에 따라 현재 포지션 지정해야
        holder.viewDate.setText(calList.get(position).dayToString())
        holder.recyclerView.layoutManager = LinearLayoutManager(context)
        holder.recyclerView.adapter = MyRecyclerViewAdapter(holder.reItemList,holder.reItemMap,context)
        //holder.viewBtn.setImageResource(colorIconMatrix[position][1])
        //holder.container.setBackgroundResource(colorIconMatrix[position][0])
    }
}