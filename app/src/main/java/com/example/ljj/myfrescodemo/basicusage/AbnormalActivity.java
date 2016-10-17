package com.example.ljj.myfrescodemo.basicusage;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 异常加载
 * 失败图
 * 重新加载图
 * 我们为图片的加载添加了监听
 */
public class AbnormalActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_faile)
    SimpleDraweeView simpleDraweeViewFaile;
    @BindView(R.id.simpleView_retry)
    SimpleDraweeView simpleDraweeViewRetry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abnormal);
        ButterKnife.bind(this);

        simpleDraweeViewFaile.setImageURI(ImageUri.getErrorImage());


        // 图片加载监听事件
        ControllerListener listener = new BaseControllerListener<ImageInfo>() {

            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                Toast.makeText(AbnormalActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                Toast.makeText(AbnormalActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        };

        PipelineDraweeControllerBuilder builder = Fresco.newDraweeControllerBuilder();
        AbstractDraweeController controller = builder
                .setTapToRetryEnabled(true)  // 必须在代码中设置这句话,否则即使在XMl中设置了retryImage也是无效
                .setUri(ImageUri.getErrorImage())
                .setControllerListener(listener)
                .build();
        simpleDraweeViewRetry.setController(controller);

    }


}
