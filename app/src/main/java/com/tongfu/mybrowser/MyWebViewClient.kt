package com.tongfu.mybrowser

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        val scheme = request.url.scheme
        if(scheme!=null && !scheme.startsWith("http")){
            return true
        }
        return super.shouldOverrideUrlLoading(view, request)
    }
}
