package com.tongfu.mybrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        var uri = intent.getStringExtra("uri")
        if(!uri.startsWith("http")){
            uri = "https://$uri"
        }
        wv_main.settings.javaScriptEnabled = true
        wv_main.webChromeClient = MyWebChromeClient()
        wv_main.webViewClient = MyWebViewClient()
        wv_main.settings.setSupportZoom (true)
        wv_main.settings.useWideViewPort = true
        wv_main.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        wv_main.settings.loadWithOverviewMode = true
        wv_main.settings.userAgentString = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36"
        WebView.setWebContentsDebuggingEnabled(true)
        wv_main.loadUrl(uri)
    }

    override fun onBackPressed() {
        if(wv_main.canGoBack()){
            wv_main.goBack()
        }else{
            super.onBackPressed()
        }

    }
}
