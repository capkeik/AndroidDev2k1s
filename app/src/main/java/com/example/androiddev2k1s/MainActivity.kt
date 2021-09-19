package com.example.androiddev2k1s

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class Musician(name: String) {
    protected var listenersCount: Int = 0
    protected fun morePopularity (newListeners: Int) {
        this.listenersCount += newListeners
    }
}

interface Rock {
    fun vocal()
}

interface HipHop {
    fun fastFlow()
}

class Rocker(name:String, private val extremeVocal: Boolean) : Musician(name), Rock {
    override fun vocal() {
        if (extremeVocal) {
            println("Put your middle fingers up\n" +
                    "Take a shot, throw it up and don't stop\n" +
                    "I'm, I'm, I'm living that life on the dark side\n")
        }
        else println("I've become so numb\n" +
                "I can't feel you there\n" +
                "Become so tired\n" +
                "So much more aware\n" +
                "I'm becoming this\n" +
                "All I want to do\n" +
                "Is be more like me\n" +
                "And be less like you")
        this.morePopularity(100)
    }
}

class Raper(name: String) : Musician(name), HipHop {
    override fun fastFlow() {
        println("Uh, summa-lumma, dooma-lumma, you assumin’ I’m a human\n" +
                "What I gotta do to get it through to you I’m superhuman?\n" +
                "Innovative and I’m made of rubber so that anything you say is ricochetin’ off of me and it’ll glue to you and\n" +
                "I’m devastating, more than ever demonstrating\n" +
                "How to give a motherfuckin’ audience a feeling like it’s levitating\n" +
                "Never fading, and I know the haters are forever waiting\n" +
                "For the day that they can say I fell off, they’ll be celebrating\n" +
                "‘Cause I know the way to get ’em motivated\n" +
                "I make elevating music, you make elevator music")
        this.morePopularity(100)
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val eminem= Raper("Slim Shady")
        eminem.fastFlow()
        val legend= Rocker("Chester Bennington", extremeVocal = false)
        legend.vocal()
        val eurovisionFavorite = Rocker("Joel Hokka", extremeVocal = true)
        eurovisionFavorite.vocal()
    }
}