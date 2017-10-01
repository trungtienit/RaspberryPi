package com.example.trungtien.raspberrypi;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by user on 12/31/15.
 */
public class FirstFragment extends Fragment {

    View myView;
    WebView webview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout, container, false);
        webview = myView.findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(Manager.POSTURL);
        webview.setHorizontalScrollBarEnabled(false);
        return myView;

    }
}
