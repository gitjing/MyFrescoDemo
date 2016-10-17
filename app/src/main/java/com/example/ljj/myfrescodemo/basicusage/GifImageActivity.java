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
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * gif图加载及注意事项
 * 注:加载gif图片一定要指定setAutoPlayAnimations为true,来实现图片下载完之后自动播放，同时，当View从屏幕移除时，停止播放,否则加载出来的图片不会动态展示
 * 如果不添加的话可以手动出发动画开始,在Listener中实现anim.satrt方法
 *
 */
public class GifImageActivity extends AppCompatActivity {

    @BindView(R.id.simpleView_gif)
    SimpleDraweeView simpleDraweeViewgif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_image);
        ButterKnife.bind(this);

        // 显示出来加载的gif图
//        simpleDraweeViewgif.setImageURI(ImageUri.getGifImage());

        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        AbstractDraweeController controller = pipelineDraweeControllerBuilder
                .setUri(ImageUri.getGifImage())
                .setAutoPlayAnimations(true)  // 加载gif图一定要添加setAutoPlayAnimations为true
                .build();

        simpleDraweeViewgif.setController(controller);

    }

}
