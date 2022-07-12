package com.Diego.listillas.json

import android.content.Context
import android.util.Log
import com.Diego.listillas.list.ListService
import com.Diego.listillas.list.item.Item
import org.json.JSONArray
import java.io.File
import java.util.jar.Attributes

class JsonService(val context: Context) {
    fun createJsonFile(name: String, copyExample:Boolean){
        Log.d("Debug", "CREA UN NUEVO JSON: " + name)
        //TODO crear un nuevo fichero JSON

        var list = mutableListOf<Item>()

        if (copyExample){
            list = getListFromExample()
        }

        //TODO validate name, validate if file exists ...
        val path = context.filesDir

        val folder = File(path, "jsons")
            folder.mkdir()

        val file = File(folder, name+".json")
        file.createNewFile()
    }
    private fun getListFromExample():MutableList<Item>{
        val file = context.assets.open("example.json")
        val jsonArray = JSONArray(file.bufferedReader().use {
            it.readText()
        })
        val list = ListService(context).parseJson(jsonArray)

        return list
    }
}
