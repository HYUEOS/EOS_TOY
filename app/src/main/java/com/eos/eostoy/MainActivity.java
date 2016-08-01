package com.eos.eostoy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton intentBtn, galleryBtn;

    private FragmentManager fm;

    private final int FRAGMENT_INTENT = 0;
    private final int FRAGMENT_GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        intentBtn = (ImageButton)findViewById(R.id.tab_intent_btn);
        galleryBtn = (ImageButton)findViewById(R.id.tab_gallery_btn);

        intentBtn.setOnClickListener(this);
        galleryBtn.setOnClickListener(this);

        replaceFragment(FRAGMENT_INTENT);
    }

    private void replaceFragment(int position) {
        FragmentTransaction ft = fm.beginTransaction();

        if (position == FRAGMENT_INTENT) {
            intentBtn.setSelected(true);
            galleryBtn.setSelected(false);
            ft.replace(R.id.tab_fragment, new IntentFragment());
        } else {
            intentBtn.setSelected(false);
            galleryBtn.setSelected(true);
            ft.replace(R.id.tab_fragment, new GalleryFragment());
        }

        ft.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_intent_btn:
                replaceFragment(FRAGMENT_INTENT);
                break;
            case R.id.tab_gallery_btn:
                replaceFragment(FRAGMENT_GALLERY);
                break;
        }
    }
}
