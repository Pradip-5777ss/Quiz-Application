package com.pradip.quizapplicartion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pradip.quizapplicartion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.startButton.setOnClickListener {

            val name = mainBinding.editName.text.toString()

            val intent = Intent(this, questions::class.java)
            intent.putExtra("myName",name)
            startActivity(intent)
            finish()
        }
    }
}