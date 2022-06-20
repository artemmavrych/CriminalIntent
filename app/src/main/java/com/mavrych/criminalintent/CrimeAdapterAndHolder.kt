package com.mavrych.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mavrych.criminalintent.databinding.ListItemCrimeBinding
import com.mavrych.criminalintent.databinding.ListItemCrimePoliceBinding

class CrimeAdapter(private var crimes: List<Crime>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class CrimeHolder(val binding: ListItemCrimeBinding) : RecyclerView.ViewHolder(binding.root)
    class CrimeHolderWithPolice(val binding: ListItemCrimePoliceBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice) {
            R.layout.list_item_crime_police // тут можна було просто якісь константи використати для ідентифікації, але я для спрощення вставив такі константи
        } else {
            R.layout.list_item_crime // тут можна було просто якісь константи використати для ідентифікації, але я для спрощення вставив такі константи
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == R.layout.list_item_crime){
            CrimeHolder(ListItemCrimeBinding.inflate(LayoutInflater.from(parent.context),parent, false))
        } else {
            CrimeHolderWithPolice(ListItemCrimePoliceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(getItemViewType(position) == R.layout.list_item_crime){ // тут можна було просто якісь константи використати для ідентифікації, але я для спрощення вставив такі константи
            (holder as CrimeHolder).binding.apply {
                crimeTitle.text = crimes[position].title
                crimeDate.text = android.text.format.DateFormat.format("EEEE, MMM dd, yyyy",crimes[position].date)
                //crimeDate.text = crimes[position].date.toString()
                crimeSolvedImage.visibility = if (crimes[position].isSolved) View.VISIBLE else View.GONE
            }
        }
        else {
            (holder as CrimeHolderWithPolice).binding.apply {
                crimeTitle.text = crimes[position].title
                crimeDate.text = android.text.format.DateFormat.format("EEEE, MMM dd, yyyy",crimes[position].date)
                //crimeDate.text = crimes[position].date.toString()
                crimeSolvedImage.visibility = if (crimes[position].isSolved) View.VISIBLE else View.GONE
            }
        }
    }
    override fun getItemCount() = crimes.size

}