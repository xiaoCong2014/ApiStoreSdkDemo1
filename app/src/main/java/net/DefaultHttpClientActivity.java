package net;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.apistore.sdk.demo.R;
import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * net.DefaultHttpClientActivity
 */
public class DefaultHttpClientActivity extends Activity {
    TextView textView_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net);
        textView_result = (TextView) findViewById(R.id.textView_result);
      //  init();
        apiStore();
    }


    private void apiStore() {

        //String strURL = "http://192.168.1.100:8080/test/test.jsp?u=wangyi&p=456";
//        String strURL = "";
//        String strURL = "";
        //String strURL = "https://www.baidu.com/";

        String strURL = "http://blog.csdn.net/dwarven/article/details/7484054";

        Parameters para = new Parameters();
        //para.put("city","" );

        ApiStoreSDK.execute(strURL,
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess");
                        textView_result.setText(responseString);
                    }


                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                    }

                });
    }




//TODO 设置一下请求头,浏览器添加进去? key   访问百度定位api
    //TODO 百度api市场 的 天气api 继续
    public void init(){

        /*URL可以随意改*/
        //String strURL = "http://192.168.1.100:8080/test/test.jsp?u=wangyi&p=456";
//        String strURL = "";
//        String strURL = "";
        //String strURL = "https://www.baidu.com/";

        String strURL = "http://blog.csdn.net/dwarven/article/details/7484054";

        String strResult ="";

/*建立HTTP Get对象*/
        HttpGet httpRequest = new HttpGet(strURL);
        try {
  /*发送请求并等待响应*/
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
  /*若状态码为200 ok*/
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
    /*读*/
                strResult = EntityUtils.toString(httpResponse.getEntity());
	/*去没有用的字符*/
                // strResult = eregi_replace("(\r\n|\r|\n|\n\r)","",strResult);
                textView_result.setText(strResult);
            } else {
                textView_result.setText("Error Response: " + httpResponse.getStatusLine().toString());
            }
        } catch (Exception e) {
            textView_result.setText(e.getMessage().toString());
            e.printStackTrace();
        }
    }

}
