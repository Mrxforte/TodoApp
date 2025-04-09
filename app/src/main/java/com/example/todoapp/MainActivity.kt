package com.example.todoapp

import TasksAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.models.TasksModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<TasksModel>()
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
    }

    private fun loadUI() {
        var myAdapter = TasksAdapter(list)
        var myLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.tasksListView.apply {
            adapter = myAdapter
            layoutManager = myLayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity, myLayoutManager.orientation))
        }

    }
}