package com.pradip.quizapplicartion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pradip.quizapplicartion.databinding.ActivityResultBinding

class Result : AppCompatActivity() {

    private lateinit var resultBinding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultBinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(resultBinding.root)


        val sb = StringBuffer()
        sb.append(
            """
                ${"Correct answers: " + questions.correct}
                
                """.trimIndent()
        )
        val sb2 = StringBuffer()
        sb2.append(
            """
                ${"Wrong Answers: " + questions.wrong}
                
                """.trimIndent()
        )
        val sb3 = StringBuffer()
        sb3.append(
            """
                ${"Final Score: " + questions.correct}
                
                """.trimIndent()
        )

        resultBinding.tvres.text = sb
        resultBinding.tvres2.text = sb2
        resultBinding.tvres3.text = sb3

        questions.correct = 0;
        questions.wrong = 0;

        resultBinding.btnRestart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}