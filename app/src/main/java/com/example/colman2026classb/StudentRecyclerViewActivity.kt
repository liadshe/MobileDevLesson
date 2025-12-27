package com.example.colman2026classb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colman2026classb.databinding.ActivityStudentRecyclerViewBinding
import com.example.colman2026classb.models.Model
import com.example.colman2026classb.models.Student

class StudentRecyclerViewActivity : AppCompatActivity() {
    var binding: ActivityStudentRecyclerViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStudentRecyclerViewBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layout = LinearLayoutManager(this)
        binding?.recyclerView?.layoutManager = layout
        binding?.recyclerView?.setHasFixedSize(true)

        val adapter = StudentsAdapter(Model.shared.students)
        adapter.listener = object: onItemClickListener {
            override fun onItemClick(position: Int)
            {
                val student = Model.shared.students[position]
                presentToastFor(student)
            }

            override fun onStudentItemClick(student: Student) {
                presentToastFor(student)
            }
        }
        binding?.recyclerView?.adapter = adapter
    }

    private fun presentToastFor(student: Student) {
        val presentStatus = if (student.isPresent) "present" else "absent"
        Toast.makeText(this@StudentRecyclerViewActivity,
            "${student.name} is $presentStatus",
            Toast.LENGTH_SHORT).show()

    }
}
