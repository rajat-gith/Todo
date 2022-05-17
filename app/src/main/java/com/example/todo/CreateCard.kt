package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard :AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)
        database= Room.databaseBuilder(
            applicationContext,myDatabase::class.java,"To_Do"
        ).build()
        save_button.setOnClickListener {
            if(create_tittle.text.toString().trim{it<=' '}.isNotEmpty()
                && create_priority.text.toString().trim{it<=' '}.isNotEmpty()) {
                var title = create_tittle.text.toString()
                var priority = create_priority.text.toString()
                GlobalScope.launch {
                    database.dao().insertTask(Entity(0,title,priority))
                }
                DataObject.setData(title, priority)
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
