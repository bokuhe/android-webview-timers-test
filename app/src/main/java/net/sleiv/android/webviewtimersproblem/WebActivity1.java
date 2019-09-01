package net.sleiv.android.webviewtimersproblem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebActivity1 extends AppCompatActivity {

  WebView webView;

  @SuppressLint("SetJavaScriptEnabled")
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.web_activity);

    webView = findViewById(R.id.wv_main);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setDomStorageEnabled(true);
    webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
    webView.setWebChromeClient(new WebChromeClient());
    webView.setWebViewClient(new WebViewClient());
  }

  @Override
  protected void onResume() {
    super.onResume();
    webView.loadUrl("file:///android_asset/test.html");
//    webView.resumeTimers(); // Timer On
  }

  @Override
  protected void onPause() {
    super.onPause();
    webView.pauseTimers(); // Timer Off
  }

  @SuppressWarnings("deprecation")
  @Override
  protected void onDestroy() {
    super.onDestroy();
    if(webView != null) {
      webView.clearHistory();
      webView.clearCache(true);
      webView.loadUrl("about:blank");

      webView.onPause();
      webView.removeAllViews();
      webView.destroyDrawingCache();
      webView.destroy();
      webView = null;
    }
  }
}
