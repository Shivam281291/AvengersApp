package com.shivaay.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() /*View.OnClickListener*/ {
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos")
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)
//        btnLogin.setOnClickListener(this)
        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvenger = "Avengers"
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            if (mobileNumber == validMobileNumber) {
                /*when (password) {
                    validPassword[0] -> {
                        nameOfAvenger = "Tony Stark"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[1] -> {
                        nameOfAvenger = "Captain America"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[2] -> {
                        nameOfAvenger = "The Hulk"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[3] -> {
                        nameOfAvenger = "The Avengers"
                        intent.putExtra("Name", nameOfAvenger)
                        startActivity(intent)
                    }
                    else -> {
                        Toast.makeText(this@LoginActivity, "Invalid Password", Toast.LENGTH_LONG)
                            .show()
                    }
                }*/
                if (password == validPassword[0]) {
                    nameOfAvenger = "Iron Man"
                    savePreferences(nameOfAvenger)
//                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (password == validPassword[1]) {
                    nameOfAvenger = "Captain America"
                    savePreferences(nameOfAvenger)
//                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (password == validPassword[2]) {
                    nameOfAvenger = "The Hulk"
                    savePreferences(nameOfAvenger)
//                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (password == validPassword[3]) {
                    nameOfAvenger = "The Avengers"
                    savePreferences(nameOfAvenger)
//                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Invalid Password", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Invalid Credentials!!",
                    Toast.LENGTH_LONG
                ).show()
            }
            /*if ((mobileNumber == validMobileNumber)){
                val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
                startActivity(intent)
            } */
        }
        txtForgotPassword.setOnClickListener {
            Toast.makeText(
                this@LoginActivity,
                "You should've remebered your password",
                Toast.LENGTH_LONG
            ).show()
        }
        txtRegister.setOnClickListener {
            Toast.makeText(
                this@LoginActivity,
                "This functionality is not ready yet",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    //    override fun onClick(v: View?) {
//        Toast.makeText(
//            this@LoginActivity,
//            "We clicked on the button to see this toast!!",
//            Toast.LENGTH_LONG
//        ).show()
//    }
    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }

}