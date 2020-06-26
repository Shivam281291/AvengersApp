package com.shivaay.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {
    var recievedText:String? = "Text"
    lateinit var txtMainText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        txtMainText = findViewById(R.id.txtMainText)
        if (intent != null){
            recievedText = intent.getStringExtra("Message")
        }
        txtMainText.text = recievedText
//        if(intent!=null){
//            titleName = intent.getStringExtra("nameOfAvenger")
//        }
//        title = titleName
    }
}
