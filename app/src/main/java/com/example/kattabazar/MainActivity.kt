package com.example.kattabazar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.kattabazar.databinding.ActivityMainBinding
import com.example.kattabazar.ui.fragments.CartFragment
import com.example.kattabazar.ui.fragments.HomeFragment
import com.example.kattabazar.ui.fragments.ProfileFragment
import com.example.kattabazar.ui.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> replaceFragment(HomeFragment())
                R.id.searchFragment -> replaceFragment(SearchFragment())
                R.id.cartFragment -> replaceFragment(CartFragment())
                R.id.profileFragment -> replaceFragment(ProfileFragment())
                else -> Unit
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_tag,fragment)
        }
    }
}