package com.thetapractice.kotlinprojectbatchdec22

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.net.URLEncoder

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)
        buttonListenerMethod()
    }

    private fun buttonListenerMethod() {
        val googleMaps: Button = findViewById(R.id.GoogleMaps)
        val notepad: Button = findViewById(R.id.Notepad)
        val whatsapp: Button = findViewById(R.id.Whatsapp)
        googleMaps.setOnClickListener {
            val url = "geo:32.5006334,74.5255045?q=Theta Solutions"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        notepad.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Would You Like To Enroll?")
            intent.type = "text/plain"
            startActivity(intent)
        }
        whatsapp.setOnClickListener {
            val url = "https://api.whatsapp.com/send?phone=$+923202284382"+"&text="+URLEncoder.encode("Would You Like To Enroll?", "UTF-8")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}