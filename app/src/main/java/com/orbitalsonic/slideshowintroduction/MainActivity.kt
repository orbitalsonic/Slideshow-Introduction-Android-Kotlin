package com.orbitalsonic.slideshowintroduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIntro:Button = findViewById(R.id.btn_introduction)
        btnIntro.setOnClickListener {
            startActivity(Intent(this,IntroductionActivity::class.java))
            finish()
        }
    }
}