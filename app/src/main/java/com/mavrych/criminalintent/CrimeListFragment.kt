package com.mavrych.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mavrych.criminalintent.databinding.FragmentCrimeListBinding

class CrimeListFragment : Fragment() {
    private  val crimeListViewModel by lazy {  ViewModelProvider(this).get(CrimeListViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding by lazy { FragmentCrimeListBinding.inflate(inflater, container, false) }
        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        val crimesList = crimeListViewModel.crimes
        binding.crimeRecyclerView.adapter = CrimeAdapter(crimesList)

        return binding.root
    }

    companion object{
        fun newInstance() = CrimeListFragment()
    }
}