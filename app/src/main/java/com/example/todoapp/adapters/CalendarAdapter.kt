package com.example.todoapp.adapters

import android.graphics.Color
import android.provider.CalendarContract.Colors
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.databinding.CalendarItemBinding
import com.example.todoapp.models.CalendarModel

class CalendarAdapter(val list: List<CalendarModel>) :

    RecyclerView.Adapter<CalendarAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: CalendarItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var selectedPosition = -1

        init {
            binding.root.setOnClickListener() {

                when (!list[adapterPosition].selected) {
                    false -> {
                        list[adapterPosition].selected = true
                        binding.dateNumber.setBackgroundResource(R.drawable.rounded_shape_active)
                        binding.dateName.setTextColor(Color.BLACK)
                        list[adapterPosition].selected = false
                    }

                    else -> {
                        binding.dateNumber.setBackgroundResource(R.drawable.rounded_shape_inactive)
                        binding.dateName.setTextColor(Color.YELLOW)
                        list[adapterPosition].selected = true
                    }

                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            CalendarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var dateNumber = list[position].dayNumber
        var dateName = list[position].dayName
    }
}