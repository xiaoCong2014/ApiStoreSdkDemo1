package mvvm;

import android.app.Activity;
import android.os.Bundle;

import com.apistore.sdk.demo.R;

/**
 * mvvm.MVVM_Activity
 * MVVM 数据双向绑定
 * Data Binding
 */
public class MVVM_Activity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.test);
      //  ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.mvvm);
        //ActivityMainBinding
//        User user = new User("Test", "User");
//        binding.setUser(user);

    }
}
