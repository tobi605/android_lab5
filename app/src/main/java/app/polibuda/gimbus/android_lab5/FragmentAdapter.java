package app.polibuda.gimbus.android_lab5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tobi6 on 28.03.2018.
 */

class FragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;

    public FragmentAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments[position];
    }

    @Override
    public int getCount() {
        return this.fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:{
                title = "Fragment 1.1";
                break;
            }
            case 1:{
                title = "Fragment 1.2";
                break;
            }
        }
        return title;
    }
}
