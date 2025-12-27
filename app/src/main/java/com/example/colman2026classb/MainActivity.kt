package com.example.colman2026classb

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.colman2026classb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var pinkFragment: BlueFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        fun addPinkFragment() {
            pinkFragment = BlueFragment.newInstance("Hello from MainActivity")
            pinkFragment?.let{
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.frame_layout, it)
                    addToBackStack("TAG")
                    commit()
                }
            }
        }


        fun removePinkFragment() {
            pinkFragment?.let{
                supportFragmentManager.beginTransaction().apply {
                    remove(it)
                    commit()
            }}
            pinkFragment = null
        }

        fun onAddStudentButtonClicked(view: View) {
            if (pinkFragment == null)
            {
                addPinkFragment()
            }
            else
            {
                removePinkFragment()
            }
        }

        binding?.addStudentButton?.setOnClickListener(::onAddStudentButtonClicked)

    }
}

