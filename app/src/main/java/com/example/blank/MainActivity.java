package com.example.blank;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity {
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    private final String TAG = "MainActivity";
    private TextView textView;

// Android OS 9 Pie 버전부터는 WebView에 일반적인 텍스트로 "http://" URL 접근이 막혔습니다.

//    private final String URL = "file:///android_asset/index.html"; //에셋 주소 : /android_asset
//    private final String URL = "http://huniverse.ddns.net:8890/HUNI_WEB/";
//    private final String URL = "https://vvvici.tk/";
    private  final String URL = "http://senspond.iptime.org/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1);
//        textView.append("안녕안녕");
        textView.setText("안녕하십니까?");

        // 버튼 리스너 추가
        onClick(findViewById(R.id.buttonRed), "Red");
        onClick(findViewById(R.id.buttonBlue), "Blue");
        onClick(findViewById(R.id.buttonGreen), "Green");

        // 웹뷰사용
        useWebView(findViewById(R.id.wv), URL);
    }

    public void onClick(Button button, String text){
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Log.v(TAG, text);
                textView.setText(text);
            }
        });
    }

    public void useWebView(WebView mWebView, String url){
//        WebView wv = findViewById(R.id.wv);
        // 기본적으로 웹뷰는 Javascript 실행을 허용하지 않도록 설정되어 있다.
        // 웹뷰의 설정을 통해 JS 사용을 허용하도록 변경
//        WebSettings settings = wv.getSettings();
//        settings.setJavaScriptEnabled(true);

        //2가지 반드시 해야할 설정
        //1. 웹문서가 열릴때 기본적으로 내 WebView가 아니라 새로운 웹뷰를 열어주는 방식을 사용함.
        //그래서 현재의 WebView안에 웹문서가 열리도록 설정
//        wv.setWebViewClient(new WebViewClient());
        //2. alert(), comfirm() 같은 팝업기능의 JS코드가 사용가능하도록하는 코드 필요
//        wv.setWebChromeClient(new WebChromeClient());

        //웹뷰가 보여줄 웹문서 (.html) 로드하기
        //하이브리드앱은 오프라인에서도 동작해야 하므로
        //웹문서가 이 프로젝트 안에 위치해야함

//        wv.loadUrl(URL);

        // 웹뷰 시작
        WebSettings settings = mWebView.getSettings();
        mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게

        settings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        settings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
        settings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        settings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        settings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        settings.setSupportZoom(false); // 화면 줌 허용 여부
        settings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        settings.setDomStorageEnabled(true); // 로컬저장소 허용 여부

        mWebView.loadUrl(url); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작

    }
}
