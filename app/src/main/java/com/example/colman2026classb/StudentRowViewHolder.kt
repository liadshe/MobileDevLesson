package com.example.colman2026classb

import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colman2026classb.databinding.StudentRowLayoutBinding
import com.example.colman2026classb.models.Student
import com.squareup.picasso.Picasso

class StudentRowViewHolder(
    private val binding: StudentRowLayoutBinding
): RecyclerView.ViewHolder(binding.root) {

    private val student: Student? = null
    init {
        binding.checkbox.setOnClickListener { view ->
            (view?.tag as? Int)?.let { tag ->
                student?.isPresent = binding.checkbox.isChecked
            }
        }
    }


    fun bind(student: Student, position: Int) {
        binding.nameTextView.text = student.name
        binding.idTextView.text = student.id
        binding.checkbox.apply {
            isChecked = student.isPresent
            tag = position
                }

        Picasso.get()
            .load(student.avatarUrlString)
            .into(binding.imageView)


            }
        }