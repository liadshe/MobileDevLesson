package com.example.colman2026classb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.colman2026classb.models.Model
import com.example.colman2026classb.models.Student

class StudentsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val students = Model.shared.students

        // get list view from layout
        var listView: ListView = findViewById(R.id.student_list_activity_list_view)

        class StudentListAdapter(
            private val students: List<Student>
        ) : BaseAdapter() {
            override fun getCount(): Int = students.size

            override fun getItem(position: Int): Any? {
                return null
            }

            override fun getItemId(position: Int): Long = 0

            override fun getView(
                position: Int,
                convertView: View?,
                parent: ViewGroup?
            ): View {
                val inflator = LayoutInflater.from(parent?.context)

                var view = convertView
                if (convertView == null) {
                    view = inflator.inflate(
                    R.layout.student_row_layout,
                    parent,
                    false)

                    val checkbox: CheckBox = view.findViewById(R.id.checkbox)
                    checkbox.setOnClickListener { view ->
                        (view?.tag as Int)?.let { tag ->
                            students[tag].isPresent = checkbox.isChecked
                        }

                    }
                }

                val nameTextView: TextView = view.findViewById(R.id.name_text_view)
                val idTextView: TextView = view.findViewById(R.id.id_text_view)
                val imageView: ImageView = view.findViewById(R.id.image_view)
                val checkbox: CheckBox = view.findViewById(R.id.checkbox)

                nameTextView.text = students[position].name
                idTextView.text = students[position].id
                checkbox.apply {
                    isChecked = students[position].isPresent
                    tag = position
                }
                return view
            }

        }

        // create adapter for list view
        listView.adapter = StudentListAdapter(
            students = students
        )


    }
}