package app.polibuda.gimbus.android_lab5;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class ViewPagerAcitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_acitvity);
        Fragment11 fragment11 = new Fragment11();
        Fragment12 fragment12 = new Fragment12();
        Fragment[] fragments = new Fragment[]{fragment11, fragment12};
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
    }
}
