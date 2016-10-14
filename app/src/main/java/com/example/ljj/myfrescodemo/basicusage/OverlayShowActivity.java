package com.example.ljj.myfrescodemo.basicusage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 覆盖图片
 * 点击显示覆盖图片
 */
public class OverlayShowActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_overLay)
    SimpleDraweeView simpleDraweeViewOverLay;
    @BindView(R.id.simpleView_press_overlay)
    SimpleDraweeView simpleDraweeViewOverLayPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overlay_show);
        ButterKnife.bind(this);

        simpleDraweeViewOverLay.setImageURI(ImageUri.getOverLayImage());

        simpleDraweeViewOverLayPressed.setImageURI(ImageUri.getOverLayImage());
        simpleDraweeViewOverLayPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
