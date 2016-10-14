package com.example.ljj.myfrescodemo.basicusage;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 圆角图片
 * 圆形图片
 */
public class CircleActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_circle)
    SimpleDraweeView simpleDraweeViewCircle;
    @BindView(R.id.simpleView_corner)
    SimpleDraweeView simpleDraweeViewConrer;
    @BindView(R.id.simpleView_circle_1)
    SimpleDraweeView simpleDraweeViewCircle1;
    @BindView(R.id.simpleView_corner_1)
    SimpleDraweeView simpleDraweeViewConrer1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        ButterKnife.bind(this);

        simpleDraweeViewCircle.setImageURI(ImageUri.getCircleImage());
        simpleDraweeViewConrer.setImageURI(ImageUri.getCircleImage());



        // 动态设置圆形图
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setRoundAsCircle(true);
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setRoundingParams(roundingParams)
                .setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP)  // 在代码中设置scaleType和Point,创建新的GenericDraweeHierarchy类。
                .setActualImageFocusPoint(new PointF(0,0))
                .build();
        simpleDraweeViewCircle1.setHierarchy(hierarchy);
        simpleDraweeViewCircle1.setImageURI(ImageUri.getCircleImage_setInCode());


        // 动态设置圆角图
        // 如果已经在XML中使用了Hierarchy的属性,我们直接通过getHierarchy获取GenericDraweeHierarchy
        RoundingParams roundingParams1 = new RoundingParams();
        roundingParams1.setCornersRadii(50,0,50,0);
        GenericDraweeHierarchy hierarchy2 = simpleDraweeViewConrer1.getHierarchy();
        hierarchy2.setRoundingParams(roundingParams1);
        hierarchy2.setActualImageFocusPoint(new PointF(0,0));
        simpleDraweeViewConrer1.setImageURI(ImageUri.getCircleImage_setInCode());
    }

}
