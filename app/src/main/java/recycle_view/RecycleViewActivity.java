//package recycle_view;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.OrientationHelper;
//import android.support.v7.widget.RecyclerView;
//
//import com.apistore.sdk.demo.R;
//
////recycle_view.RecycleViewActivity
//
//public class RecycleViewActivity extends Activity {
//    RecyclerView recyclerView;
//    MyRecyclerAdapter myRecyclerAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
////设置布局管理器
//        recyclerView.setLayoutManager(layoutManager);
////设置为垂直布局，这也是默认的
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
////设置Adapter
//        recyclerView.setAdapter(myRecyclerAdapter);
//        //设置分隔线
//        //recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
//
//        //设置增加或删除条目的动画
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//
//    }
//}
