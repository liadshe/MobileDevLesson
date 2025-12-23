package com.example.colman2026classb
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colman2026classb.databinding.StudentRowLayoutBinding
import com.example.colman2026classb.models.Student
import kotlin.text.get

class StudentsAdapter(
    private var students: List<Student>,
    ) : RecyclerView.Adapter<StudentRowViewHolder>() {

    override fun getItemCount(): Int = students.size

    // return the class of the row
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentRowViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = StudentRowLayoutBinding.inflate(inflator, parent, false)
        return StudentRowViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: StudentRowViewHolder,
        position: Int
    ) {

        holder.bind(students[position], position)
    }
    }






