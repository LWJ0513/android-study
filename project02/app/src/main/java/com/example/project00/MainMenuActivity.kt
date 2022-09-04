package com.example.project00

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project00.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCustomerButton()
        initSalesButton()
        initProductButton()
    }

    private fun initCustomerButton() {
        binding.customerButton.setOnClickListener {
            startActivity(Intent(this, CustomerActivity::class.java))
            finish()
        }
    }

    private fun initSalesButton() {
        binding.salesButton.setOnClickListener {
            startActivity(Intent(this, SalesActivity::class.java))
            finish()
        }
    }

    private fun initProductButton() {
        binding.productButton.setOnClickListener {
            startActivity(Intent(this, ProductActivity::class.java))
            finish()
        }
    }

}