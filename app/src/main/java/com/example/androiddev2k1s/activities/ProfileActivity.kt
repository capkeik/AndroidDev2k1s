package com.example.androiddev2k1s.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddev2k1s.databinding.ActivityProfileBinding
import com.example.androiddev2k1s.recycler_view_data.HamsterRepository

class ProfileActivity: AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        val id = intent.extras?.getInt("id")
        with(binding){
            val rabbit = id?.let {
                HamsterRepository.getHamsterById(id)
            }
            val name = rabbit?.name
            val breed = rabbit?.breed
            val description = rabbit?.description

            rabbit?.photo?.let {
                ivPhoto.setImageResource(it)
                tvNameProfile.text = "Name: $name"
                tvBreedProfile.text = "Breed: $breed"
                tvDescriptionProfile.text = "Description: $description"
            }
        }
    }
}