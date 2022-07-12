package com.Diego.listillas.list

import android.content.Context
import com.Diego.listillas.list.item.Item
import org.json.JSONArray
import java.io.IOException

class ListService constructor(context: Context) {

    var list = mutableListOf<Item>()

    init {
        try {
             val json = JSONArray(
                context.assets.open("example.json").bufferedReader().use { it.readText() })
            list = parseJson(json)

            } catch (ioException: IOException) {

        }
    }
    fun parseJson(json: JSONArray):MutableList<Item>{
        var list = mutableListOf<Item>()
        for (i in 0 until json.length()){
            var jsonObject = json.getJSONObject(i)
            var item: Item = Item(
                jsonObject.optString("title"),
                jsonObject.optString("description"),
                jsonObject.getLong ("creationDate"),
                jsonObject.getBoolean("check")
            )
            list.add(item)
        }
        return list
    }
}