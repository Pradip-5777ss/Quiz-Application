package com.pradip.quizapplicartion

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pradip.quizapplicartion.databinding.ActivityQuestionsBinding


class questions : AppCompatActivity() {
    private lateinit var questionsBinding: ActivityQuestionsBinding

    private val question = arrayOf(
        "Which method can be defined only once in a program?",
        "Which of these is not a bitwise operator?",
        "Which keyword is used by method to refer to the object that invoked it?",
        "Which of these keywords is used to define interfaces in Java?",
        "Which of these access specifiers can be used for an interface?",
        "Which of the following is correct way of importing an entire package ‘pkg’?",
        "What is the return type of Constructors?",
        "Which of the following package stores all the standard java classes?",
        "Which of these method of class String is used to compare two String objects for their equality?",
        "An expression involving byte, int, & literal numbers is promoted to which of these?"
    )

    private val answer = arrayOf(
        "main method",
        "<=",
        "this",
        "interface",
        "public",
        "import pkg.*",
        "None of the mentioned",
        "java",
        "equals()",
        "int"
    )

    private val options = arrayOf(
        "finalize method", "main method", "static method", "private method",
        "&", "&=", "|=", "<=",
        "import", "this", "catch", "abstract",
        "Interface", "interface", "intf", "Intf",
        "public", "protected", "private", "All of the mentioned",
        "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
        "int", "float", "void", "None of the mentioned",
        "lang", "java", "util", "java.packages",
        "equals()", "Equals()", "isequal()", "Isequal()",
        "int", "long", "byte", "float"
    )

    private var flag = 0

    companion object {
        var marks = 0
        var correct: Int = 0
        var wrong: Int = 0
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        questionsBinding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(questionsBinding.root)

        val score = questionsBinding.textView4
        val name = intent.getStringExtra("myName")

        if (name!!.trim() == "") {
            questionsBinding.DisplayName.text = "Hello User"
        } else {
            questionsBinding.DisplayName.text = "Hello $name"
        }


        questionsBinding.Questions.text = question[flag]

        questionsBinding.radioButton1.text = options[0]
        questionsBinding.radioButton2.text = options[1]
        questionsBinding.radioButton3.text = options[2]
        questionsBinding.radioButton4.text = options[3]

        questionsBinding.buttonSubmit.setOnClickListener {

            if (questionsBinding.answersGroup.checkedRadioButtonId == -1) {
                Toast.makeText(applicationContext, "Please select one choice", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val uAns = findViewById<RadioButton>(questionsBinding.answersGroup.checkedRadioButtonId)
            val ansText = uAns.text.toString()
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();

            if (ansText == answer[flag]) {
                correct++
                Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                wrong++
                Toast.makeText(applicationContext, "Wrong", Toast.LENGTH_SHORT).show()
            }

            flag++

            score.text = "" + correct

            if (flag < question.size) {
                questionsBinding.Questions.text = question[flag]
                questionsBinding.radioButton1.text = options[flag * 4]
                questionsBinding.radioButton2.text = options[flag * 4 + 1]
                questionsBinding.radioButton3.text = options[flag * 4 + 2]
                questionsBinding.radioButton4.text = options[flag * 4 + 3]
            } else {
                marks = correct
                val intent = Intent(applicationContext, Result::class.java)
                startActivity(intent)
            }
            questionsBinding.answersGroup.clearCheck()
        }

        questionsBinding.buttonQuit.setOnClickListener {
            startActivity(Intent(this, Result::class.java))
            finish()
        }
    }
}
