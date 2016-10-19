package com.example.ljj.myfrescodemo.basicusage;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 占位图展示
 */
public class PlaceHolderActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_placeHolder)
    SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_holder);
        ButterKnife.bind(this);
        simpleDraweeView.setImageURI(ImageUri.getBaseImage());

    }
}
