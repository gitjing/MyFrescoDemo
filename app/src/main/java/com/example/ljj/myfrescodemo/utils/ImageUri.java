package com.example.ljj.myfrescodemo.utils;

import android.net.Uri;

import java.net.URI;

/**
 * Created by ljj on 16/10/13.
 */

public class ImageUri {

    public static final String baseImage = "http://imga1.pic21.com/bizhi/140219/07653/s04.jpg";

    public static final String fadeImage = "http://h6.86.cc/walls/20160831/mid_aa936453ec02928.jpg";

    public static final String circleImage = "http://file.ynet.com/2/1608/26/11650051.jpg";

    public static final String circleImage_setInCode = "http://p.ishowx.com/uploads/allimg/160924/47-160924104056.jpg";

    public static final String imageProgressBar = "http://img15.3lian.com/2015/f2/50/d/71.jpg";
    public static final String overLayImage = "http://p.ishowx.com/uploads/allimg/160926/486-160926094238-51.jpg";
    public static final String gifImage = "http://dn-assets-gitcafe-com.qbox.me/Kaedea/Kaede-Assets/raw/gitcafe-pages/image/other/animation2.gif";
    public static final String highResImage = "http://img0.ph.126.net/5Qzyq0bNejstcEaEJwWy6Q==/6630442143582805578.jpg";
    public static final String lowResImage = "http://imga1.pic21.com/bizhi/140219/07653/s04.jpg";




    public static Uri getBaseImage() {
        return Uri.parse(baseImage);
    }
    public static Uri getFadeImage() {
        return Uri.parse(fadeImage);
    }
    public static Uri getCircleImage() {
        return Uri.parse(circleImage);
    }
    public static Uri getCircleImage_setInCode() {
        return Uri.parse(circleImage_setInCode);
    }
    public static Uri getErrorImage() {
        return Uri.parse("http://file.ynet.com/2/1608/26.jpg");
    }

    public static Uri getImageProgressBar() {
        return Uri.parse(imageProgressBar);
    }

    public static Uri getOverLayImage() {
        return Uri.parse(overLayImage);
    }

    public static Uri getGifImage() {
        return Uri.parse(gifImage);
    }

    public static Uri getHighResImage() {
        return Uri.parse(highResImage);
    }

    public static Uri getLowResImage() {
        return Uri.parse(lowResImage);
    }
}
