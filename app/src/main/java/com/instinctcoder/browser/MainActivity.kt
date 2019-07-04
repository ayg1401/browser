package com.instinctcoder.browser

import android.app.AlertDialog
import android.app.ProgressDialog
import android.app.SearchManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pDialog = ProgressDialog(this@MainActivity)
        pDialog.setMessage("Please Wait....Loading")
        wview.loadUrl("http://www.google.com")
        wview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                pDialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                pDialog.dismiss()
            }

        }
        wview.settings.javaScriptEnabled = true
        wview.settings.builtInZoomControls = true

        search.setOnClickListener {
            wview.loadUrl("https://www.google.com/#q="+et1.text.toString())

        }

        fb.setOnClickListener {
            wview.loadUrl("http://www.facebook.com")
        }
        google.setOnClickListener {
            wview.loadUrl("http://www.google.com")
        }
        you.setOnClickListener {
            wview.loadUrl("http://www.youtube.com")
        }

        insta.setOnClickListener {
            wview.loadUrl("http://www.instagram.com")
        }
        twitter.setOnClickListener { wview.loadUrl("http://www.twitter.com")
        }

    }
}

