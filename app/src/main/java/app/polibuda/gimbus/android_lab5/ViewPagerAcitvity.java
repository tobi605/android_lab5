package app.polibuda.gimbus.android_lab5;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;


public class ViewPagerAcitvity extends AppCompatActivity {

    private void initUI(int orienation) {
        if (orienation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_view_pager_acitvity);
            Fragment11 fragment11 = new Fragment11();
            Fragment12 fragment12 = new Fragment12();
            Fragment[] fragments = new Fragment[]{fragment11, fragment12};
            FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(adapter);
        } else {
            setContentView(R.layout.activity_view_pager_landscape);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI(getResources().getConfiguration().orientation);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RelativeLayout layout = findViewById(R.id.view_pager_port);
        layout.removeAllViews();
        RelativeLayout layout2 = findViewById(R.id.view_pager_land);
        layout2.removeAllViews();
        initUI(getResources().getConfiguration().orientation);
    }
}
