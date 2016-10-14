package com.example.ljj.myfrescodemo.basicusage;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 基本显示
 * 占位图显示
 * 缩略图显示
 *
 * 图片的scaleType和ImageView的基本一样,除了FocusCrop
 * FocusCrop需要在代码里面添加FocusPoint(),其中(0f, 0f) 是左上对齐显示，(1f, 1f) 是右下角对齐,(0.5,0.5f)就和centerCrop一样了。
 * 如果基本的scaleType不满足大家的需求,我们还可以自定义ScalType,具体方式大家参考:http://fresco-cn.org/docs/scaling.html
 *
 */
public class SimpleShowActivity extends AppCompatActivity {


    @BindView(R.id.simpleView1)
    SimpleDraweeView simpleDraweeViewbasic;
    @BindView(R.id.simple_scaltype)
    SimpleDraweeView simpleDraweeViewScalType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_show);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        simpleDraweeViewbasic.setImageURI(ImageUri.getBaseImage());

        simpleDraweeViewScalType.getHierarchy().setActualImageFocusPoint(new PointF(0,0));
        simpleDraweeViewScalType.setImageURI(ImageUri.getBaseImage());


    }

}
