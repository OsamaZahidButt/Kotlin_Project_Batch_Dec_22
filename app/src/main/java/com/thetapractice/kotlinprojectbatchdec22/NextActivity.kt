package com.thetapractice.kotlinprojectbatchdec22

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        val edtDisplay: TextView = findViewById(R.id.DisplayUsername)
        val str = intent.getStringExtra("USERNAME")
        edtDisplay.text = str
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        buttonListenerMethod()
    }

    private fun buttonListenerMethod() {
        var currentImage = 0
        val images = arrayOf(R.drawable.background, R.drawable.background1)
        val change: Button = findViewById(R.id.ChangeBackground)
        val go: Button = findViewById(R.id.GoToMarketingScreen)
        val back: Button = findViewById(R.id.BackToHomeScreen)
        change.setOnClickListener {
            val relativeLayout: RelativeLayout = findViewById(R.id.relativeLayout)
            currentImage++
            currentImage %= images.size
            relativeLayout.setBackgroundResource(images[currentImage])
        }
        go.setOnClickListener {
            val intent = Intent(this, ImplicitActivity::class.java)
            startActivity(intent)
        }
        back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}