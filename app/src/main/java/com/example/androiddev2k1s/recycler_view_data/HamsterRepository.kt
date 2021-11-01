package com.example.androiddev2k1s.recycler_view_data

import com.example.androiddev2k1s.R

object HamsterRepository {

    val hamsters = arrayListOf(
        Hamster(
            id = 1,
            photo = R.drawable.syr,
            name = "Volt",
            breed = "Syrian Hamster",
            description = "Syrian Hamsters are the most popular hamster breed to keep as pets. They are also referred to as Teddy Bear Hamsters and generally have a very friendly and loving disposition. These hamsters are said to build a strong bond with their owners and they’re very easy to handle making them the ideal choice of pet for young children.\n" +
                    "\n" +
                    "The Syrian Hamster is a little larger than other hamsters, growing to about 7 inches in length. And they tend to be more relaxed than other breeds, which makes them easy to hold and pet. While they are loving to their owners, they are not a sociable breed, and therefore should be kept alone otherwise they will fight with other hamsters.\n" +
                    "\n" +
                    "This hamster breed is mostly nocturnal, so they won’t be very active in the day time, which might not appeal to you if you’d prefer a pet that you can play with more frequently. A Syrian Hamster can live to around four years old, but their average lifespan is usually 2-3 years."
        ),
        Hamster(
            id = 2,
            photo = R.drawable.syr,
            name = "Darvin",
            breed = "Syrian Hamster",
            description = "Syrian Hamsters are the most popular hamster breed to keep as pets. They are also referred to as Teddy Bear Hamsters and generally have a very friendly and loving disposition. These hamsters are said to build a strong bond with their owners and they’re very easy to handle making them the ideal choice of pet for young children.\n" +
                    "\n" +
                    "The Syrian Hamster is a little larger than other hamsters, growing to about 7 inches in length. And they tend to be more relaxed than other breeds, which makes them easy to hold and pet. While they are loving to their owners, they are not a sociable breed, and therefore should be kept alone otherwise they will fight with other hamsters.\n" +
                    "\n" +
                    "This hamster breed is mostly nocturnal, so they won’t be very active in the day time, which might not appeal to you if you’d prefer a pet that you can play with more frequently. A Syrian Hamster can live to around four years old, but their average lifespan is usually 2-3 years."
        ),
        Hamster(
            id = 3,
            photo = R.drawable.syr,
            name = "Pushisty suicidnik",
            breed = "Syrian Hamster",
            description = "Syrian Hamsters are the most popular hamster breed to keep as pets. They are also referred to as Teddy Bear Hamsters and generally have a very friendly and loving disposition. These hamsters are said to build a strong bond with their owners and they’re very easy to handle making them the ideal choice of pet for young children.\n" +
                    "\n" +
                    "The Syrian Hamster is a little larger than other hamsters, growing to about 7 inches in length. And they tend to be more relaxed than other breeds, which makes them easy to hold and pet. While they are loving to their owners, they are not a sociable breed, and therefore should be kept alone otherwise they will fight with other hamsters.\n" +
                    "\n" +
                    "This hamster breed is mostly nocturnal, so they won’t be very active in the day time, which might not appeal to you if you’d prefer a pet that you can play with more frequently. A Syrian Hamster can live to around four years old, but their average lifespan is usually 2-3 years."
        ),
        Hamster(
            id = 4,
            photo = R.drawable.remy,
            name = "Remi",
            breed = "Krysa Podval'naya",
            description = "Sam ty krysa podval'naya (This breed is a very aggressive)"
        )
    )

    fun getHamsterById(id: Int): Hamster {
        return hamsters[id-1]
    }
}