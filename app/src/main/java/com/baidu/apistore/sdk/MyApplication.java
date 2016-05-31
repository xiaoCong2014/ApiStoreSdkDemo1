package com.baidu.apistore.sdk;

import android.app.Application;

// 请在AndroidManifest.xml中application标签下android:name中指定该类
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApiStoreSDK.init(this, "b0551efd391c69d627b36811cb27de22");
        //TODO 项目完成后,把bean和格式化的图片,链接弄好.属性的文档注释弄一下
//TODO 改名 bugMe天气
//        百度定位SDK的key :
//        F7kVVCUTwyZ8cvVNERW61DZSKUgFv7C3

    }
}


/*
"city":"福州",
"id":"CN101230101",
*/
