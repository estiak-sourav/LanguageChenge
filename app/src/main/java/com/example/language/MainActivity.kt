package com.example.language

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.language.app.BaseActivity
import com.example.language.databinding.ActivityMainBinding
import com.zeugmasolutions.localehelper.Locales
import java.util.Locale

class MainActivity : BaseActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        setTitle(R.string.main_activity_title)

        binding.toTRButton.setOnClickListener { updateLocale(Locales.Turkish) }
        binding.toENButton.setOnClickListener { updateLocale(Locale.ENGLISH) }
        binding.toCNButton.setOnClickListener { updateLocale(Locale.CHINA) }
        binding.toURButton.setOnClickListener { updateLocale(Locales.Urdu) }

        binding.secondButton.setOnClickListener { startActivity(Intent(this, SecondActivity::class.java)) }
    }

    override fun updateLocale(locale: Locale) {
        super.updateLocale(locale)
        setTitle(R.string.main_activity_title)
    }
}