package com.thetapractice.kotlinprojectbatchdec22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.thetapractice.kotlinprojectbatchdec22.Database.UserDatabase
import com.thetapractice.kotlinprojectbatchdec22.Entity.UserEntity
import java.util.regex.Pattern

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        buttonListenerMethod()
    }

    private fun buttonListenerMethod() {
        val edtUsername: EditText = findViewById(R.id.Username1)
        val edtEmail: EditText = findViewById(R.id.Email)
        val edtPhone: EditText = findViewById(R.id.Phone)
        val edtPassword: EditText = findViewById(R.id.Password1)
        val register: Button = findViewById(R.id.RegisterButton)
        register.setOnClickListener {
            val username = edtUsername.text.toString()
            val email = edtEmail.text.toString()
            val phone = edtPhone.text.toString()
            val password = edtPassword.text.toString()
            validateUserDetails(username, email, phone, password)
        }
    }

    private fun validateUserDetails(username: String, email: String, phone: String, password: String) {
        if(validateUsername(username)&&validateEmail(email)&&validatePhone(phone)&&validatePassword(password))
        {
            val intent = Intent(this, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            //intent.putExtra("USERNAME1", username)
            //intent.putExtra("EMAIL", email)
            //intent.putExtra("PHONE", phone)
            //intent.putExtra("PASSWORD1", password)
            startActivity(intent)
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
            val user = UserEntity(0, username, email, phone)
            UserDatabase.getDatabase(this).userDao().insertUser(user)
        }
    }

    private fun validateUsername(username: String): Boolean {
        val edtUsername: EditText = findViewById(R.id.Username1)
        if(username.isEmpty()) {
            edtUsername.error="Required"
            return false
        } else if(username.length<8||username.length>20) {
            edtUsername.error="Username should be 8-20 characters long"
            return false
        } else
            return true
    }

    private fun validateEmail(email: String): Boolean {
        val edtEmail: EditText = findViewById(R.id.Email)
        if(email.isEmpty()) {
            edtEmail.error="Required"
            return false
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error="Enter Correct Email Address"
            return false
        } else
            return true
    }

    private fun validatePhone(phone: String): Boolean {
        val edtPhone: EditText = findViewById(R.id.Phone)
        val regEx: Pattern = Pattern.compile("^((\\+92)?(0092)?(92)?(0)?)(3)([0-9]{9})$")
        if(phone.isEmpty()) {
            edtPhone.error = "Required"
            return false
        } else if(!regEx.matcher(phone).matches()) {
            edtPhone.error = "Enter Correct Phone Number"
            return false
        } else
            return true
    }

    private fun validatePassword(password: String): Boolean {
        val edtPassword: EditText = findViewById(R.id.Password1)
        val regEx: Pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[`~!@#$%^&*()+=/-]).{8,}$")
        if(password.isEmpty()) {
            edtPassword.error="Required"
            return false
        } else if(!regEx.matcher(password).matches()) {
            edtPassword.error="Password must contain at least a digit, a special character, a lowercase letter," +
                              " an uppercase letter amd should have a minimum length of 8 characters"
            return false
        } else
            return true
    }
}