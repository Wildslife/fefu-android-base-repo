package com.example.theworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.theworld.databinding.ActivityDateItemBinding
import com.example.theworld.databinding.MyActivityItemBinding

class MyActivityAdapter(private val onClickListener: MyActivityClick): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val myActivityList = ArrayList<Activity>()
    private val myActivityDateList = ArrayList<Date>()


    inner class MyActivityHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = MyActivityItemBinding.bind(item)
        fun bind(activity : Activity){
            binding.ItemDistance.text = activity.distance
            binding.ItemTime.text = activity.time
            binding.ItemActivityType.text = activity.type
            binding.ItemTimePassed.text = activity.timePassed
        }

    }

    class MyActivityDateHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ActivityDateItemBinding.bind(item)
        fun bind(date : Date){
            binding.ItemDate.text = date.date
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0 || position == 2) return 1
        return 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 2) {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.my_activity_item, parent, false)
        return MyActivityHolder(view) }
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_date_item, parent, false)
        return MyActivityDateHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1 && position == 0)
            (holder as MyActivityDateHolder).bind(myActivityDateList[position])
        else if (getItemViewType(position) == 1 && position == 2)
            (holder as MyActivityDateHolder).bind(myActivityDateList[1])
        else if (position == 1){
            val activityPosition = position - 1
            (holder as MyActivityHolder).bind(myActivityList[activityPosition])
            holder.binding.root.setOnClickListener {
                onClickListener.onClicked()
            }
        }
        else{
            val activityPosition = position - 2
            (holder as MyActivityHolder).bind(myActivityList[activityPosition])
            holder.binding.root.setOnClickListener {
                onClickListener.onClicked()
            }
        }
    }

    override fun getItemCount(): Int {
        return myActivityList.size + myActivityDateList.size
    }

    fun addActivity(activity : Activity){
        myActivityList.add(activity)
        notifyDataSetChanged()
    }

    fun addDate(date : Date){
        myActivityDateList.add(date)
        notifyDataSetChanged()
    }

}