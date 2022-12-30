package com.thetapractice.kotlinprojectbatchdec22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonListenerMethod()
    }

    private fun buttonListenerMethod() {
        val edtUsername: EditText = findViewById(R.id.Username)
        val edtPassword: EditText = findViewById(R.id.Password)
        val login: Button = findViewById(R.id.LoginButton)
        login.setOnClickListener {
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()
            validateUserDetails(username, password)
        }
    }

    private fun validateUserDetails(username: String, password: String) {
        val edtUsername: EditText = findViewById(R.id.Username)
        val edtPassword: EditText = findViewById(R.id.Password)
        if(username.isNotEmpty()&&password.isNotEmpty())
        {
            val intent = Intent(this, NextActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("USERNAME", username)
            intent.putExtra("PASSWORD", password)
            startActivity(intent)
        }
        else if(username.isEmpty())
        {
            edtUsername.error="Required"
        }
        else if(password.isEmpty())
        {
            edtPassword.error="Required"
        }
    }
}