package com.example.ljj.myfrescodemo.postprocessor;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ljj.myfrescodemo.R;
import com.example.ljj.myfrescodemo.utils.ImageUri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 修改图片,添加网格
 * 加网格需要使用PostProgressor
 */

public class PostprocessorActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_processor)
    SimpleDraweeView simpleDraweeViewProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postprocessor);
        ButterKnife.bind(this);

        Postprocessor gridPostProcessor = new BasePostprocessor() {

            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public void process(Bitmap bitmap) {
                for (int i = 0 ; i < bitmap.getWidth() ; i+=2){
                    for (int j = 0 ; j < bitmap.getHeight();j+=2){
                        bitmap.setPixel(i,j, Color.BLACK);
                    }
                }
            }
        };


        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(ImageUri.getPostprocessorImage())
                .setPostprocessor(gridPostProcessor)
                .build();

        PipelineDraweeControllerBuilder builder = Fresco.newDraweeControllerBuilder();//.build();
        AbstractDraweeController build = builder
                .setOldController(simpleDraweeViewProcessor.getController())
                .setImageRequest(request)
                .build();

    simpleDraweeViewProcessor.setController(build);
    }
}
