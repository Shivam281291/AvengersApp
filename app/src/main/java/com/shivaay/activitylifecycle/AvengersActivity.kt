package com.shivaay.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {
    var titleName:String? = "Avengers"
    lateinit var etTextActivity: EditText
    lateinit var btnSend:Button
    lateinit var btnLogout : Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        titleName = sharedPreferences.getString("Title","The Avengers")
        title = titleName
        btnSend = findViewById(R.id.btnSend)
        etTextActivity = findViewById(R.id.etTextActivity)
        btnLogout = findViewById(R.id.btnLoagout)
        btnSend.setOnClickListener {
            val textMessage = etTextActivity.text.toString()
            val intent = Intent(this@AvengersActivity,MessageActivity::class.java)
            intent.putExtra("Message",textMessage)
            startActivity(intent)
        }
        btnLogout.setOnClickListener {
            logout()
            val intent = Intent(this@AvengersActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun logout(){
        sharedPreferences.edit().clear().apply()
    }
}
