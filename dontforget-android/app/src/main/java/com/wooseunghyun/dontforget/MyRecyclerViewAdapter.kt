package com.wooseunghyun.dontforget

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MyRecyclerViewAdapter(val items:ArrayList<String>,val itemMap:MutableMap<String,Boolean>, val context: Context):RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_recyclerview,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //
        //holder
        //체크박스 생성 초기화
        holder.checkBoxItem.setText(items[position])
        holder.checkBoxItem.setOnCheckedChangeListener(null)
        if(itemMap[items[position]]!=null){
            holder.checkBoxItem.isChecked = itemMap[items[position]]!!
            if(holder.checkBoxItem.isChecked){
                itemMap.put(items.get(position),true)
                holder.checkBoxItem.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                holder.checkBoxItem.text = items.get(position)+" checked"

            }else{
                itemMap.put(items.get(position),false)
                holder.checkBoxItem.paintFlags = 0
                holder.checkBoxItem.text = items.get(position)

            }
        }
        holder.checkBoxItem.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener(){buttonView, isChecked ->
            if(isChecked){
                itemMap.put(items.get(position),true)
                holder.checkBoxItem.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                holder.checkBoxItem.text = items.get(position)+" checked"

            }else{
                itemMap.put(items.get(position),false)
                holder.checkBoxItem.paintFlags = 0
                holder.checkBoxItem.text = items.get(position)

            }
        })
        holder.checkBoxItem.setOnLongClickListener(object :View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {

                Toast.makeText(context,"long",Toast.LENGTH_SHORT).show()
                return true
            }
        })
    }
}
class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var checkBoxItem:CheckBox = itemView.findViewById(R.id.checkBoxItem) as CheckBox
    init {
        checkBoxItem.textSize = 20F
    }
}
