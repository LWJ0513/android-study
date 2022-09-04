package com.example.project00

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project00.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLoginButton()
    }

    private fun initLoginButton() {
        binding.loginButton.setOnClickListener {
            if (binding.idEditText.text.toString().trim().isEmpty())
                Toast.makeText(this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show()
            else if (binding.passwordEditText.text.toString().trim().isEmpty())
                Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
            else {
                startActivity(Intent(this, MainMenuActivity::class.java))
                finish()
            }
        }
    }
}
