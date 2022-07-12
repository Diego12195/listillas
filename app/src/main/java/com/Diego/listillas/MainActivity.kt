package com.Diego.listillas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Diego.listillas.config.ConfigService
import com.Diego.listillas.databinding.ActivityMainBinding
import com.Diego.listillas.json.JsonActivity
import com.Diego.listillas.list.Lista
import com.Diego.listillas.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val config = ConfigService()


        // TODO: Check configuration and pass parameters to Login Activity if necessary
        val isLogged = false
        if (isLogged) {
            startActivity(Intent(this, Lista::class.java).apply { })
            return
        }
        // TODO: Is firebase or local?
        if (config.isLocal()) {
            startActivity(Intent(this, JsonActivity::class.java))
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("isLocal", config.isLocal())
            startActivity(intent)
        }
    }
}
