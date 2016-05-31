package com.baidu.apistore.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.apistore.sdk.demo.R;
import com.baidu.apistore.sdk.network.Parameters;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

import bean.BeanJson;

/*
 * 要在MyApplication.java中配置您的appkey
 */
public class MainActivity extends Activity {
    private TextView mTextView;
    private Button test;
    private Button btnShow;
    private Context context;
    private Gson gson = new Gson();
    private String cityName="";
    //先new一下，后面会空指针
    BeanJson beanJson = new BeanJson();

    ImageView imageView1;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //得到用户输入的城市名称
        cityName=getIntent().getStringExtra("cityName");
//       Toast.makeText(MainActivity.this,cityName, Toast.LENGTH_SHORT).show();

       initUI();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        //imageView1.setImageDrawable( getResources().getDrawable(R.drawable.weathericon_condition_01)  );
    }

    /**
     * 测试一下根据oJson设置图片
     * 如果是ok,则设置为太阳果实的图案
     */
    public void setImage() {
        //  beanJson.heWeatherDataServices[0].aqi.city.aqi
        if ("福州".equals(beanJson.heWeatherDataServices[0].basic.city)) {
            imageView1.setBackgroundResource(R.drawable.weathericon_condition_01);
        }
    }

    /**
     * 根据oJson设置UI界面
     * 如果是ok,则设置为太阳果实的图案
     */
    public void updateUI(BeanJson beanJson,
                         ImageView imageView1,
                         ImageView imageView2
    ) {
//beanJson.heWeatherDataServices[0].status

    }

    /**
     * 查找所有的控件,做基本的初始化
     */
    private void initUI() {
        mTextView = (TextView) findViewById(R.id.mTextView);
        test = (Button) findViewById(R.id.test);
        btnShow = (Button) findViewById(R.id.btnShow);
        //R.drawable.weathericon_condition_01
        imageView1 = (ImageView) findViewById(R.id.imageView1);


        //这个也行 imageView1.setImageDrawable( getResources().getDrawable(R.drawable.weathericon_condition_01)  );

        test.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mTextView.setText("");
                //发送请求
                try {
                    apiTest();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

        });

        btnShow.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //mTextView.setText("");
                // apiTest();
//                btnShow.setText(beanJson.);
                // TODO 注意这里的 oJson有没一解析成功
                //btnShow.setText(beanJson.heWeatherDataServices[0].status);

                setImage();

                //myApiStoreSDK();
            }

        });

    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }

    /**
     * 获取天气信息,strJson
     */
    private void apiTest() throws UnsupportedEncodingException {
//参数写在get请求头里,不是在URL里,即拼接到strURL里
        Parameters para = new Parameters();

        //参数就一个
        // para.put("city", "beijing");
        //para.put("city", "fuzhou");
        // para.put("id", "CN101230101");

        //中国和世界天气预报 的参数 和风天气 heWeather
        //para.put("cityid", "CN101230101");

        //这是 福州 通过城市名称,key是city,不是cityName

        //String utf8=new String(cityName.getBytes("ISO-8859-1"),"UTF-8"
//        byte[] t_gbk = cityName.getBytes("GBK");


//        String strUtf8=new String( cityName.getBytes("GBK"),"UTF-8" );
//        para.put("city",strUtf8 );
        //TODO 有没有可能本来就不行
        //para.put("city","福州" );
        para.put("city",new String( "福州".getBytes("GBK"),"UTF-8" ) );
       // para.put("city",cityName )
        ;

        //不用这个 天气查询 的参数
//        para.put("cityname", "北京");
//        para.put("cityid", "101010100");

        //中国和世界天气预报  HeWeather data service 3.0    免费的  正在用，但strJson命名很乱
        //发get请求到这个网址  http://apis.baidu.com/heweather/weather/free
        //strJson 的开头是  {"HeWeather data service 3.0": [...]..
        String strURL = "http://apis.baidu.com/heweather/weather/free";

        //天气查询
        //编码有问题，用unicode ， 需要多一步转换，而官网没有给方法
        //String strURL="http://apis.baidu.com/apistore/weatherservice/citylist
        //String strURL="http://apis.baidu.com/apistore/weatherservice/recentweathers";

        ApiStoreSDK.execute(strURL,
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess");
                        mTextView.setText(responseString);

//                        responseString.getBytes("GBK")
//                        responseString.getBytes("utf-8");
//                        String newStr=new String(,"utf-8");

                        //  mTextView.setText( unicode2String(responseString));


                        //TODO 先看一下收到的数据。看成功了，然后复制出来格式化一下，但太长了，要切割一下
                        //   String[] strArray = responseString.split("但丝毫不会影响您出行的心情");


                        //TODO  "HeWeather data service 3.0" 改为  "heweatherDataServices",因为名字里面有空格
                       // String strResponse = responseString.replace("HeWeather data service 3.0", "heWeatherDataServices");

                        //TODO 在这里解析strJson字符串
                        // 这一行是错的  HeWeatherDataService heweatherDataServices=gson.fromJson(strResponse, HeWeatherDataService.class);
                       // beanJson = gson.fromJson(strResponse, BeanJson.class);

                        //等5秒
//                        wait(3000.0);
//                        wa


                        // mTextView.setText(strResponse)
                        //TODO 这边应该是要等一下，它解析时间比较长,反应比较慢
                        //用点击事件搞
                        //  test.setText(beanJson.heWeatherDataServices[0].status);

                        //test.setText( "heweatherDataServices.status" );//的确是这样设置按钮上的文字
                        // mTextView.setText(strResponse);//数据正确地接收到

                        // String strTemp1=responseString;
                        //  Log.e("TAG",responseString);
                        //  System.out.print(responseString);


                    }


                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                        mTextView.setText(getStackTrace(e));
                    }

                });

    }

    String getStackTrace(Throwable e) {
        if (e == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append(e.getMessage()).append("\n");
        for (int i = 0; i < e.getStackTrace().length; i++) {
            str.append(e.getStackTrace()[i]).append("\n");
        }
        return str.toString();
    }


    @Override
    public void onStop() {
        super.onStop();

    }


    /**
     * 这样就不用okHttp等网络请求库了
     * 测试成功
     * 故意在这里使用一些百度官方封装的ApiStoreSDK
     */
    public void myApiStoreSDK() {
        //String strURL="https://www.baidu.com/?tn=92989757_hao_pg";
//        String strURL="https://www.baidu.com";
        String strURL = "http://www.bilibili.com";
        //暂时什么参数都不加到get请求头里
        //TODO 试试添加参数,到URL而不是请求头里
//       String strURL="https://www.baidu.com/s?wd=test&rsv_spt=1&rsv_iqid=0xe750f95700020107&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=92989757_hao_pg&rsv_enter=1&rsv_sug3=2&rsv_sug1=2&rsv_sug7=101&rsv_sug2=0&inputT=1033&rsv_sug4=1407";

        Parameters para = new Parameters();

        ApiStoreSDK.execute(strURL,
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess");
                        mTextView.setText(responseString);

//                        responseString.getBytes("GBK")
//                        responseString.getBytes("utf-8");
//                        String newStr=new String(,"utf-8");

                        //  mTextView.setText( unicode2String(responseString));


                        //TODO 先看一下收到的数据。看成功了，然后复制出来格式化一下，但太长了，要切割一下
                        //   String[] strArray = responseString.split("但丝毫不会影响您出行的心情");


                        //TODO  "HeWeather data service 3.0" 改为  "heweatherDataServices",因为名字里面有空格
                        // String strResponse = responseString.replace("HeWeather data service 3.0", "heWeatherDataServices");

                        //TODO 在这里解析strJson字符串
                        // 这是错的  HeWeatherDataService heweatherDataServices=gson.fromJson(strResponse, HeWeatherDataService.class);
                        // beanJson = gson.fromJson(strResponse, BeanJson.class);

                        //等5秒
//                        wait(3000.0);
//                        wa


                        // mTextView.setText(strResponse)
                        //TODO 这边应该是要等一下，它映射比较慢
                        //用点击事件搞
                        //  test.setText(beanJson.heWeatherDataServices[0].status);

                        //test.setText( "heweatherDataServices.status" );//的确是这样设置按钮上的文字
                        // mTextView.setText(strResponse);//数据正确地接收到

                        // String strTemp1=responseString;
                        //  Log.e("TAG",responseString);
                        //  System.out.print(responseString);


                    }


                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                        mTextView.setText(getStackTrace(e));
                    }

                });

    }

}

