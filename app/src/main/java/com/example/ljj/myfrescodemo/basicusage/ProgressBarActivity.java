package com.example.ljj.myfrescodemo.basicusage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 进度条
 */
public class ProgressBarActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_progressBar)
    SimpleDraweeView progressBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        ButterKnife.bind(this);


        // 方式一
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setProgressBarImage(new ProgressBarDrawable())
                .build();
        progressBarView.setHierarchy(hierarchy);
        progressBarView.setImageURI(ImageUri.getImageProgressBar());


        // 方式二:
//        在XML中添加下面设置,设置自己的加载图片,但是没有进度展示,也支持自定义进度条,重新Drawable-->实现onLevelChange方法
//        fresco:placeholderImage="@color/placeHolder"
//        fresco:progressBarAutoRotateInterval="1000"
//        fresco:progressBarImage="@mipmap/ic_launcher"
//        fresco:progressBarImageScaleType="centerInside"

    }


}
