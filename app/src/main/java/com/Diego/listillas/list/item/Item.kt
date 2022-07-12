package com.Diego.listillas.list.item

import java.text.SimpleDateFormat
import java.time.Instant


data class Item(
    val title: String,
    val description: String = "",
    val date: Long = Instant.now() as Long,
    var check: Boolean = false
){
    fun getFormatteDate():String{
        val format = SimpleDateFormat("dd-MM-yyyy")
        return format.format(date)

   }
}

