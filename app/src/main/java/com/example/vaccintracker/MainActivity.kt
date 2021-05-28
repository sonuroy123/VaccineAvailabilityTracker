package com.example.vaccintracker

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService

class MainActivity : AppCompatActivity() {

    lateinit var buttonCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCheck = findViewById(R.id.btnCheck)

        buttonCheck.setOnClickListener {

            if (!isNetworkAvailable == true) {
                AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Internet Connection Alert")
                        .setMessage("Please Check Your Internet Connection")
                        .setPositiveButton("Open Settings"){text, listener ->
                            val settingIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                            startActivity(settingIntent)



                        }
                        .setNegativeButton("Exit") { dialogInterface, i -> finish() }.show()




            } else if(isNetworkAvailable == true) {
                //Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_LONG).show()
                val intent  = Intent(this,Show_data ::class.java)
                startActivity(intent)

            }
        }
    }

    val isNetworkAvailable: Boolean
        get() {
            val connectivityManager =
                    getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    val capabilities =
                            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                    if (capabilities != null) {
                        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                            return true
                        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                            return true
                        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                            return true
                        }
                    }
                }
            }
            return false
        }
}