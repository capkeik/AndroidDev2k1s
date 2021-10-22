package com.example.androiddev2k1s.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.androiddev2k1s.R
import com.example.androiddev2k1s.databinding.ActivityMainBinding
import com.example.androiddev2k1s.fragments.HomeFragment
import com.example.androiddev2k1s.fragments.ProfileFragment
import com.example.androiddev2k1s.fragments.SearchFragment

private const val TAG_HOME = "TAG_HOME"
private const val TAG_SEARCH = "TAG_SEARCH"
private const val TAG_PROFILE = "TAG_PROFILE"


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, HomeFragment())
            .commit()

        with(binding) {

            ibHome.setOnClickListener {
                replaceFragment(HomeFragment(), TAG_HOME)
            }
            ibSearch.setOnClickListener {
                replaceFragment(SearchFragment(), TAG_SEARCH)
            }
            ibProfile.setOnClickListener {
                replaceFragment(ProfileFragment(), TAG_PROFILE)
            }
        }
    }
    private fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(tag)
            .commit()
    }
}
