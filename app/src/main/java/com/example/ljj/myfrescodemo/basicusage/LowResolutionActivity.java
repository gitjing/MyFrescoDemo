package com.example.ljj.myfrescodemo.basicusage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 先加载低分辨率图片
 * 需要使用设置高低分辨率图片
 */

public class LowResolutionActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_low_high)
    SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_resolution);
        ButterKnife.bind(this);

        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        AbstractDraweeController controller = pipelineDraweeControllerBuilder
                .setOldController(simpleDraweeView.getController())
                .setLowResImageRequest(ImageRequest.fromUri(ImageUri.getLowResImage()))  // 设置低分辨率
                .setUri(ImageUri.getHighResImage()) // 设置高分辨率
                .setTapToRetryEnabled(true)
                .build();
        simpleDraweeView.setController(controller);
    }
}
