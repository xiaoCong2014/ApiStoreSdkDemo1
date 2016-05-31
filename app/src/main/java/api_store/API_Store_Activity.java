package api_store;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.apistore.sdk.demo.R;
import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;

/**
 * api_store.API_Store_Activity
 */
public class API_Store_Activity extends Activity {
    TextView textView_result;

    public void apiStore() {

        //String strURL = "http://192.168.1.100:8080/test/test.jsp?u=wangyi&p=456";
//        String strURL = "";
//        String strURL = "";
        //String strURL = "https://www.baidu.com/";

        String strURL = "http://blog.csdn.net/dwarven/article/details/7484054";
        final String strResult = "no result";
        Parameters para = new Parameters();
        //para.put("city","" );

        ApiStoreSDK.execute(strURL,
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                       // Log.i("sdkdemo", "onSuccess");
                         textView_result.setText(responseString);
                        //strResult=responseString;

                        //return responseString;
                    }


                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        // Log.i("sdkdemo", "onError, status: " + status);
                        // Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                    }

                });
        //return strResult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net);
        textView_result = (TextView) findViewById(R.id.textView_result);

        apiStore();
        //textView_result.setText( apiStore() );

    }
}