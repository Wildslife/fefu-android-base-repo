package com.example.theworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.theworld.databinding.ActivityDateItemBinding
import com.example.theworld.databinding.MyActivityItemBinding
import com.example.theworld.databinding.UsersActivityItemBinding

class UsersActivityAdapter(private val onClickListener: UsersActivityClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val usersActivityList = ArrayList<UsersActivity>()
    private val usersActivityDateList = ArrayList<Date>()
    override fun getItemViewType(position: Int): Int {
        if (position == 0) return 1
        return 2
    }

    class UsersActivityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = UsersActivityItemBinding.bind(itemView)
        fun bind(activity : UsersActivity){
            binding.ItemUser.text = activity.user
            binding.ItemDistance.text = activity.distance
            binding.ItemTime.text = activity.time
            binding.ItemActivityType.text = activity.type
            binding.ItemTimePassed.text = activity.timePassed
        }

    }

    class UsersActivityDateHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ActivityDateItemBinding.bind(itemView)
        fun bind(date : Date){
            binding.ItemDate.text = date.date
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 2) {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.users_activity_item, parent, false)
        return UsersActivityHolder(view)}
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_date_item, parent, false)
        return UsersActivityDateHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1)
            (holder as UsersActivityDateHolder).bind(usersActivityDateList[position])
        else{
            val activityPosition = position - 1
            (holder as UsersActivityHolder).bind(usersActivityList[activityPosition])
            holder.binding.root.setOnClickListener {
                onClickListener.onClicked()
            }
        }
    }

    override fun getItemCount(): Int {
        return usersActivityList.size + usersActivityDateList.size
    }

    fun addActivity(activity : UsersActivity){
        usersActivityList.add(activity)
        notifyDataSetChanged()
    }

    fun addDate(date : Date){
        usersActivityDateList.add(date)
        notifyDataSetChanged()
    }

}