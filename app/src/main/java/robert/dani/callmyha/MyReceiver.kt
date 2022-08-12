package robert.dani.callmyha

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri

class MyReceiver : BroadcastReceiver() {
    private val sender = StateSender()

    override fun onReceive(context: Context?, intent: Intent) {
        var uri: Uri? = intent.data ?: return
        var state = uri?.host ?: return
        sender.sendState(state)
    }
}