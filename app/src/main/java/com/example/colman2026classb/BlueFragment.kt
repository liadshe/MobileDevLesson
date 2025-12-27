package com.example.colman2026classb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.colman2026classb.databinding.FragmentBlueBinding

class BlueFragment : Fragment() {
    private var binding : FragmentBlueBinding? = null
    private var textView: TextView? = null
    var title: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(TITLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlueBinding.inflate(inflater, container, false)
        textView = binding?.textView
        textView?.text = title ?: "Oops! what just happened? 😲"

        return binding?.root
    }

    companion object {
        private const val TITLE = "TITLE_KEY"

        @JvmStatic
        fun newInstance(title: String) =
            BlueFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE, title)
                }
            }
    }
}