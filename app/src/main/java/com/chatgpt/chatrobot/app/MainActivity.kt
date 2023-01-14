package com.chatgpt.chatrobot.app

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var progDailog: ProgressDialog? = null
        progDailog = ProgressDialog.show(this, "Loading", "Please wait...", true)
        progDailog.setCancelable(false)

        val webSettings = findViewById<WebView>(R.id.chatGpt).settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        webSettings.setSupportZoom(true)
        webSettings.defaultTextEncodingName = "utf-8"

        findViewById<WebView>(R.id.chatGpt).webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                progDailog.show()
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                progDailog.dismiss()
            }
        }
        findViewById<WebView>(R.id.chatGpt).loadUrl("https://openai.com/blog/chatgpt/")

    }
}