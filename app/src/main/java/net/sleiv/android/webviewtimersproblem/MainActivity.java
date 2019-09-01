package net.sleiv.android.webviewtimersproblem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    WebView.setWebContentsDebuggingEnabled(true);

    findViewById(R.id.btn_show_web_1).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        MainActivity.this.startActivity(new Intent(MainActivity.this, WebActivity1.class));
      }
    });

    findViewById(R.id.btn_show_web_2).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        MainActivity.this.startActivity(new Intent(MainActivity.this, WebActivity2.class));
      }
    });
  }
}
