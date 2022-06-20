package com.mavrych.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mavrych.criminalintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()



    }
}