package com.example.androiddev2k1s.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddev2k1s.R
import com.example.androiddev2k1s.databinding.ActivityMainBinding
import com.example.androiddev2k1s.recycler_view_data.HamsterAdapter
import com.example.androiddev2k1s.recycler_view_data.HamsterRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var hamsterAdapter: HamsterAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hamsterAdapter = HamsterAdapter(HamsterRepository.hamsters)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        findViewById<RecyclerView>(R.id.rv_hamsters).run {
            adapter = hamsterAdapter
        }
    }
}