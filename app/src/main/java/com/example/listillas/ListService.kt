package com.example.listillas

import android.content.Context
import android.util.Log
import java.io.File

class ListService(context: Context){

    val contextList = context
    val fileName = "list.txt"
    var list = mutableListOf<String>()
    val file = File(contextList.filesDir, fileName)

    //Obtener datos del fichero local list.txt
    fun getListFromFile():MutableList<String>{
        if (!file.exists()){
            file.createNewFile()
        }
        list = file.readLines() as  MutableList<String>

        Log.d("Listas", "Este es el filesDir: "+ contextList.filesDir)
        return list
    }

    fun addItemToList(item: String){
        list.add(item)
        file.printWriter().use {
            out -> list.forEach {
                out.println(it)
        }
        }
    }
}