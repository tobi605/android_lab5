package app.polibuda.gimbus.android_lab5;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements ActionBar.TabListener {
    Fragment11 fragment11;
    Fragment12 fragment12;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragment11 = new Fragment11();
        fragment12 = new Fragment12();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.tab_container, fragment11);
        fragmentTransaction.add(R.id.tab_container, fragment12);
        fragmentTransaction.detach(fragment11);
        fragmentTransaction.detach(fragment12);
        fragmentTransaction.commit();

        android.support.v7.app.ActionBar toolbar = getSupportActionBar();
        toolbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        toolbar.addTab(toolbar.newTab().setText("Fragment 1.1").setTabListener(this).setTag(1));
        toolbar.addTab(toolbar.newTab().setText("Fragment 1.2").setTabListener(this).setTag(2));
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        int index = (int) tab.getTag();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (index){
            case 1:{
                transaction.attach(fragment11);
                break;
            }
            case 2:{
                transaction.attach(fragment12);
                break;
            }
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        int index = (int) tab.getTag();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (index){
            case 1:{
                transaction.detach(fragment11);
                break;
            }
            case 2:{
                transaction.detach(fragment12);
                break;
            }
        }
        transaction.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Toast.makeText(getApplicationContext(),"You are already here :C", Toast.LENGTH_SHORT).show();
    }
}
