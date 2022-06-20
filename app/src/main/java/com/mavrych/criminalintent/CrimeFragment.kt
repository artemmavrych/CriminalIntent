package com.mavrych.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.mavrych.criminalintent.databinding.FragmentCrimeBinding

class CrimeFragment : Fragment() {
    private lateinit var crime: Crime
    private val binding: FragmentCrimeBinding by lazy { FragmentCrimeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.crimeDate.apply {
            text = crime.date.toString()
            isEnabled = false

        }
        binding.crimeSolved.apply {
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked
            }

        }
        return inflater.inflate(R.layout.fragment_crime, container, false)
    }

    override fun onStart() {
        super.onStart()

    }
}