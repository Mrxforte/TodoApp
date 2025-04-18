package com.example.todoapp

import TasksAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.adapters.CalendarAdapter
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.models.CalendarModel
import com.example.todoapp.models.TasksModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<TasksModel>()
    private var list1 = arrayListOf<CalendarModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadData()
        loadUI()
    }

    private fun loadData() {
        for (i in 1..100) {
            list.add(TasksModel(false, 12, "Swimming --> $i"))
        }
        for (i in 1..100) {
            list1.add(CalendarModel(i, "day $i"))
        }
    }

    private fun loadUI() {

//        the first adapter

        var adapter1 = CalendarAdapter(list1)
        var firstLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.selectDateListView.apply {
            adapter = adapter1
            layoutManager = firstLayoutManager
        }

        var myAdapter = TasksAdapter(list)
        var myLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.tasksListView.apply {
            adapter = myAdapter
            layoutManager = myLayoutManager
        }
        binding.roundedUserImg.setOnClickListener {
            // Toggle between day and night modes
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

            // Recreate activity to apply theme changes
            recreate()
        }
    }

}
