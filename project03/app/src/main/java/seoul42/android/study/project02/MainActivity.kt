package seoul42.android.study.project02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import seoul42.android.study.project02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.sendButton.setOnClickListener {
            val name = binding.editText.text.toString()
            val intent = Intent(applicationContext, MyService::class.java)

            intent.putExtra("command", "show")
            intent.putExtra("name", name)
            startService(intent)
        }

        val passedIntent = intent
        processIntent(passedIntent)
    }

    override fun onNewIntent(intent: Intent) {
        processIntent(intent)
        super.onNewIntent(intent)
    }

    private fun processIntent(intent: Intent?) {
        if (intent != null) {
            val command = intent.getStringExtra("command")
            val name = intent.getStringExtra("name")

            binding.textView.text = name;
          //  Toast.makeText(this, "command : $command, name : $name", Toast.LENGTH_LONG).show()
        }
    }
}