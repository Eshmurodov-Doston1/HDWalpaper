package com.example.hdwalpaper


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.hdwalpaper.databinding.ActivityMainBinding
import com.example.hdwalpaper.utils.NetworkHelper
import org.imaginativeworld.oopsnointernet.callbacks.ConnectionCallback
import org.imaginativeworld.oopsnointernet.dialogs.pendulum.NoInternetDialogPendulum
import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.hdwalpaper.database.AppDatabase
import com.example.hdwalpaper.utils.LocaleHelper


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var appDatabase: AppDatabase
    lateinit var sharedPreferences1: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("Theme",0)
        appDatabase = AppDatabase.getInstence(this)
        if (!appDatabase.isOpen){appDatabase.openHelper.writableDatabase}
        val color = sharedPreferences.getString("color", "#E8E3E3")
        when(color){
            "#154C79"->{
                setTheme(R.style.AppTheme_One)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE
                window.statusBarColor = Color.parseColor("#154C79")
                window.navigationBarColor = Color.parseColor("#154C79")
            }
            "#4C5BAF"->{
                setTheme(R.style.AppTheme_Two)
               window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE
                window.statusBarColor = Color.parseColor("#4C5BAF")
                window.navigationBarColor = Color.parseColor("#4C5BAF")
            }
            "#F85B915E"->{
                setTheme(R.style.AppTheme_Three)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE
                window.statusBarColor = Color.parseColor("#F85B915E")
                window.navigationBarColor = Color.parseColor("#F85B915E")
            }
            "#E8E3E3"->{
                setTheme(R.style.AppTheme_Four)
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = Color.parseColor("#E8E3E3")
                window.navigationBarColor = Color.parseColor("#E8E3E3")
             }
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val networkHelper = NetworkHelper(this)
        val onAttach = LocaleHelper.onAttach(this)
        if (!networkHelper.isNetworkConnected()) {
            NoInternetDialogPendulum.Builder(
                this,
                lifecycle
            ).apply {
                dialogProperties.apply {
                    connectionCallback = object : ConnectionCallback {
                        override fun hasActiveConnection(hasActiveConnection: Boolean) {
                        if (hasActiveConnection){
                            finish()
                            startActivity(Intent(this@MainActivity,MainActivity::class.java))
                        }
                        }
                    }

                    cancelable = false // Optional
                    noInternetConnectionTitle = onAttach.getString(R.string.noInternet)// Optional
                    noInternetConnectionMessage = onAttach.getString(R.string.connectInt) // Optional
                    showInternetOnButtons = true // Optional
                    pleaseTurnOnText = onAttach.getString(R.string.on) // Optional
                    wifiOnButtonText = "Wifi" // Optional
                    mobileDataOnButtonText = onAttach.getString(R.string.data) // Optional

                    onAirplaneModeTitle = onAttach.getString(R.string.noInternet) // Optional
                    onAirplaneModeMessage = onAttach.getString(R.string.data1) // Optional
                    pleaseTurnOffText = onAttach.getString(R.string.off) // Optional
                    airplaneModeOffButtonText =onAttach.getString(R.string.airPlan) // Optional
                    showAirplaneModeOffButtons = true // Optional
                }
            }.build()
        }
    }


}