package com.uniftec.sportscheduleapp.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.controller.ReservaInfo;
import com.uniftec.sportscheduleapp.controller.ReservaReserva;
import com.uniftec.sportscheduleapp.controller.TesteTabbed;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private final TesteTabbed activity;

    public SectionsPagerAdapter(Context context, FragmentManager fm, TesteTabbed activity) {
        super(fm);
        mContext = context;
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ReservaInfo();
                break;
            case 1:
                fragment = new ReservaReserva(activity);
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}