package com.baidu.apistore.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apistore.sdk.demo.R;

/**
 * com.baidu.apistore.sdk.SelectCity
 *
 */
public class SelectCity extends Activity {
    EditText editText_cityName;
    Button button_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);
        editText_cityName=( EditText)findViewById(R.id.editText_cityName);

       // button_submit
    }

    public void myClick(View view){
        String strCityName = ""+editText_cityName.getText();
      //  Toast.makeText(SelectCity.this,strCityName , Toast.LENGTH_SHORT).show();

        //TODO 带着用户输入的城市信息跳转到发送请求页面
        Intent intent=new Intent(SelectCity.this,MainActivity.class);

//        try {
//            String strUtf8=new String( strCityName.getBytes("GBK"),"UTF-8" );
//            intent.putExtra("cityName",strUtf8);//cityName
//            startActivity(intent);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
         intent.putExtra("cityName",strCityName);
         startActivity(intent);

        //多个按钮的情况下
//        switch (view.getId()){
//            case R.id.button_submit:
//                Toast.makeText(SelectCity.this, editText_cityName.getText() , Toast.LENGTH_SHORT).show();
//            break;
//        }
    }
}
