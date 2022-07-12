package com.Diego.listillas.menu

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import com.Diego.listillas.R
import com.Diego.listillas.config.ConfigActivity
import com.Diego.listillas.json.JsonActivity
import com.Diego.listillas.list.Lista
import com.Diego.listillas.login.LoginActivity

class MenuHandler constructor(val context: Context, val current: String) {
    var intent: Intent? = null

    fun itemHandler(item: MenuItem) {
        when (item.itemId) {
            R.id.configMenu -> openConfig(current)
            R.id.listMenu -> openList(current)
            R.id.loginMenu -> openLogin(current)
            R.id.configJson -> openJson(current)
        }
    }

    private fun openConfig(current: String) {
        if (current == "config") {
            intent = null
        } else {
            intent = Intent(context, ConfigActivity::class.java)
        }
    }

    private fun openList(current: String) {
        if (current == "list") {
            intent = null
        }else {
            intent = Intent(context, Lista::class.java)
        }
    }

    private fun openLogin(current: String) {
        if (current == "login") {
            intent = null
        }else {
            intent = Intent(context, LoginActivity::class.java)
        }
    }
    private fun openJson(current: String) {
        if (current == "login") {
            intent = null
        }else {
            intent = Intent(context, JsonActivity::class.java)
        }
    }
}