package com.wallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.wallet.ui.addnewcard.AddNewCardFragment
import com.wallet.ui.qr.GenerateQRFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wallet.R
import com.wallet.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var frameLayout: FrameLayout

    private val onBackPressedCallback: OnBackPressedCallback = object: OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        //To handle when user do back gesture
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        getViews()
        setDefaultFragment()
        setBottomNavigationListener()
    }

    private fun getViews() {
        bottomNavigationView = binding.bottomNavigationMain
        frameLayout = binding.flMain
    }

    private fun setDefaultFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flMain, HomeFragment())
            .commit()
    }

    private fun setBottomNavigationListener() {
        bottomNavigationView.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.home -> {
                    goToFragment(HomeFragment())
                    true
                }
                R.id.addCard -> {
                    goToFragment(AddNewCardFragment())
                    true
                }
                R.id.QR -> {
                    goToFragment(GenerateQRFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun goToFragment(destinationFragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flMain, destinationFragment)
            .commit()
    }
}