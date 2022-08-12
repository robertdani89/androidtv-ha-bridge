package robert.dani.callmyha

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import kotlin.concurrent.thread

class StateSender {
    val config = Config()

    fun sendState(number: String) {
        val token = config.token
        val url = config.url
        val postData = "{ \"state\": $number }"

        thread {
            with(url.openConnection()as HttpURLConnection) {
                requestMethod = "POST"
                setRequestProperty("Authorization", "Bearer $token");
                val wr = OutputStreamWriter(getOutputStream());
                wr.write(postData);
                wr.flush();

                println("URL : $url")
                println("Response Code : $responseCode")

                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = StringBuffer()

                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                    it.close()
                    println("Response : $response")
                }
            }
        }
    }
}