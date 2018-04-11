package app.mumandroidassignment.lesson7.byjava.question1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import app.mumandroidassignment.R;

public class LoginActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        webView = findViewById(R.id.wv);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/login.html");
        webView.addJavascriptInterface(this, "loginActivity");
    }

    @JavascriptInterface
    public void login(String name,String pass){
        Log.d("zhq.debug","userName "+(name==null));
        Log.d("zhq.debug","passwork "+pass);
        if(!name.equals("123")||!pass.equals("123")){
            Toast.makeText(this,"name or password illigle",Toast.LENGTH_SHORT).show();
            return;
        }
        gotoWebActivity();
    }

    private void gotoWebActivity(){
        Intent intent = new Intent(this,WebBrowseActivity.class);
        startActivity(intent);
        finish();
    }



}
