package com.example.listillas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*

class Lista : AppCompatActivity() {

    var list: MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        Log.d("Debug", "ListOpen")
        val listService = ListService(this)
        list = listService.getListFromFile()
        list.forEach {
            addItemToLayout(it)
        }
      /*  val newItem = findViewById<Button>(R.id.newButton)
        newItem.setOnClickListener {
            addNewItem(listService)
        }
       */

    }
    private fun addNewItem(service: ListService){
        val randomText = Date().toString()
        service.addItemToList(randomText)
        addItemToLayout(randomText)

    }
    private fun addItemToLayout(text: String){
        val textView = TextView(this)
        textView.text = text
        val listLayout = findViewById<LinearLayout>(R.id.listLayout)
        listLayout.addView(textView)
    }
}