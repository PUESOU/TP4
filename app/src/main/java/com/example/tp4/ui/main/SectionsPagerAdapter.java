package com.example.tp4.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tp4.R;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return NatureFragment.newInstance(position, getTitre(position, mContext));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre = getTitre(position, mContext).toUpperCase(l);
        Drawable icone = getIcone(position, mContext);

        SpannableString sb = new SpannableString(" " + titre);
        icone.setBounds(0, 0, icone.getIntrinsicWidth(), icone.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icone, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }

    @Override
    public int getCount() {
        return 8;
    }

    public static Drawable getIcone(int position, Context mContext) {
        switch(position) {
            case 0: return mContext.getResources().getDrawable(R.drawable.mineral);
            case 1: return mContext.getResources().getDrawable(R.drawable.vegetal);
            case 2: return mContext.getResources().getDrawable(R.drawable.animal);
            case 4: return mContext.getResources().getDrawable(R.drawable.printemps);
            case 5: return mContext.getResources().getDrawable(R.drawable.ete);
            case 6: return mContext.getResources().getDrawable(R.drawable.automne);
            case 7: return mContext.getResources().getDrawable(R.drawable.hiver);
        }

        return mContext.getResources().getDrawable(R.drawable.non_image);
    }

    public static String getTitre(int position, Context mContext) {
        switch(position) {
            case 0: return mContext.getString(R.string.titre_section0);
            case 1: return mContext.getString(R.string.titre_section1);
            case 2: return mContext.getString(R.string.titre_section2);
            case 3: return mContext.getString(R.string.titre_section3);
            case 4: return mContext.getString(R.string.titre_section4);
            case 5: return mContext.getString(R.string.titre_section5);
            case 6: return mContext.getString(R.string.titre_section6);
            case 7: return mContext.getString(R.string.titre_section7);
        }

        return "";
    }
}