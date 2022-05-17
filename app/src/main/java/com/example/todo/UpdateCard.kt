package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_update_card.*

class UpdateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)
        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val title = DataObject.getData(pos).title
            val priority = DataObject.getData(pos).priority
            create_tittle.setText(title)
            create_priority.setText(priority)

            delete_button.setOnClickListener {
                DataObject.deleteData(pos)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Log.d("Tag", "delete_button clicked")
            }
            update_button.setOnClickListener {
                DataObject.updateData(
                    pos,
                    create_tittle.text.toString(),
                    create_priority.text.toString()
                )
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }

    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}