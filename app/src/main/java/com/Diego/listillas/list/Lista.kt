package com.Diego.listillas.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.Diego.listillas.R
import com.Diego.listillas.itemDetailFragment
import com.Diego.listillas.list.item.Item
import com.Diego.listillas.menu.MenuHandler
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Lista : AppCompatActivity() {

    var list: MutableList<Item> = mutableListOf()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        Log.d("Debug", "ListOpen")

        val listService = ListService(this)
        list = listService.list
        val listLayout = findViewById<LinearLayout>(R.id.listLayout)
        addListToLayout(listLayout)

        val newItem = findViewById<FloatingActionButton>(R.id.new_item)
        newItem.setOnClickListener {
            stringToLayout()
        }

    }
    // Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var menuHandler = MenuHandler(this, "List")
        menuHandler.itemHandler(item)
        if (menuHandler.intent != null) {
            startActivity(menuHandler.intent)
        }
        return super.onOptionsItemSelected(item)
    }





    private fun stringToLayout(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = itemDetailFragment()
        fragmentTransaction.replace(R.id.detailLayout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    private fun addListToLayout(layout: LinearLayout){
        list.forEach {
            var view = LayoutInflater.from(this).inflate(R.layout.item_layout,null,false)
            view.findViewById<CheckBox>(R.id.checkbox).isChecked = it.check
            view.findViewById<TextView>(R.id.title).text = it.title
            view.findViewById<TextView>(R.id.description).text = it.description
            view.findViewById<TextView>(R.id.date).text = it.getFormatteDate()
            var editButton = view.findViewById<Button>(R.id.editbutton)
            editButton.setOnClickListener {
                stringToLayout()
            }
            layout.addView(view)

        }

    }

    private fun addItemToLayout(text: String) {
        val textView = TextView(this)
        textView.text = text
        val listLayout = findViewById<LinearLayout>(R.id.listLayout)
        listLayout.addView(textView)
    }
}