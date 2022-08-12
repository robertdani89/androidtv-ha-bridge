package robert.dani.callmyha

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    val sender = StateSender()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = this.findViewById(R.id.button1) as Button
        val button2 = this.findViewById(R.id.button2) as Button
        val button3 = this.findViewById(R.id.button3) as Button

        button1.setOnClickListener {
            sender.sendState("1")
        }

        button2.setOnClickListener {
            sender.sendState("2")
        }

        button3.setOnClickListener {
            sender.sendState("3")
        }
    }
}