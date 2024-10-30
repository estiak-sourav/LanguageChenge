package com.example.language

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.language.app.BaseActivity
import com.example.language.databinding.ActivityMainBinding
import com.zeugmasolutions.localehelper.Locales
import java.util.Locale

class SecondActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setTitle(R.string.second_activity_title)

        binding.toTRButton.setOnClickListener { updateLocale(Locales.Turkish) }
        binding.toENButton.setOnClickListener { updateLocale(Locale.ENGLISH) }
        binding.toCNButton.setOnClickListener { updateLocale(Locale.CHINA) }
        binding.toURButton.setOnClickListener { updateLocale(Locales.Urdu) }

        //binding.backButton.setOnClickListener { finish() }
    }
}