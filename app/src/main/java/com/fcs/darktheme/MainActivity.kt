package com.fcs.darktheme

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btg_theme.addOnButtonCheckedListener { _, selectedBtnId, isChecked ->
            if (isChecked) {
                val theme = when (selectedBtnId) {
                    R.id.btnDefault -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    R.id.btnDark -> AppCompatDelegate.MODE_NIGHT_YES
                    else -> AppCompatDelegate.MODE_NIGHT_NO
                }
                Log.d(TAG, "isChecked:$isChecked theme:$theme")
                //                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -- default
                //                AppCompatDelegate.MODE_NIGHT_YES -dark
                //                AppCompatDelegate.MODE_NIGHT_NO - light
                AppCompatDelegate.setDefaultNightMode(theme)
            }
        }
    }
}