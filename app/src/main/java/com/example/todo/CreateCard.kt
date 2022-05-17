package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_card.*

class CreateCard :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)

        save_button.setOnClickListener {
            if(create_tittle.text.toString().trim{it<=' '}.isNotEmpty()
                && create_priority.text.toString().trim{it<=' '}.isNotEmpty()) {
                var title = create_tittle.text.toString()
                var priority = create_priority.text.toString()
                DataObject.setData(title, priority)
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
