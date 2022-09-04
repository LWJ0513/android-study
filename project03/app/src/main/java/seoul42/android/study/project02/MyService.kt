package seoul42.android.study.project02

import android.app.Service
import android.content.Intent
import android.nfc.Tag
import android.os.IBinder
import android.util.Log
import java.lang.UnsupportedOperationException

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent == null) {
            return START_STICKY
        } else {
            processCommand(intent)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun processCommand(intent: Intent) {
        val command = intent.getStringExtra("command")
        val name = intent.getStringExtra("name")
        val showIntent = Intent(applicationContext, MainActivity::class.java)
        showIntent.addFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TOP
        )
       // showIntent.putExtra("command", "show")
        showIntent.putExtra("name", "$name  - from service.")
        startActivity(showIntent)
    }
    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
        throw UnsupportedOperationException("Not yet implemented")
    }
}