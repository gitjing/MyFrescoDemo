package com.example.ljj.myfrescodemo.basicusage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 淡入淡出效果
 */
public class FadeDurationActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_fade)
    SimpleDraweeView simpleDraweeViewFade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_duration);
        ButterKnife.bind(this);



        simpleDraweeViewFade.getHierarchy().setFadeDuration(3000);

        simpleDraweeViewFade.setImageURI(ImageUri.getFadeImage());

    }

}
