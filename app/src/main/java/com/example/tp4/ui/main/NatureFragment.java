package com.example.tp4.ui.main;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tp4.MainActivity;
import com.example.tp4.R;

public class NatureFragment extends Fragment {
    private String title;
    private int page;

    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    public static NatureFragment newInstance(int position, String title) {
        NatureFragment fragment = new NatureFragment();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);

        fragment.setArguments(args);

        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context mContext = getActivity().getApplicationContext();

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView tvLabel = (TextView)view.findViewById(R.id.section_label);
        tvLabel.setText(page + " -- " + title);

        if(page == 3) {
            view = inflater.inflate(R.layout.fragment_saisons, container, false);
        }

        if(page == 3) {
            // ImageListener a = (ImageListener) getActivity();
            // a.onImageClick(page);

            ImageView img0 = (ImageView)view.findViewById(R.id.img0);
            (img0).setImageDrawable(SectionsPagerAdapter.getIcone(4, mContext));
            img0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getActivity()).viewPager.setCurrentItem(4);
                }
            });

            ImageView img1 = (ImageView)view.findViewById(R.id.img1);
            (img1).setImageDrawable(SectionsPagerAdapter.getIcone(5, mContext));
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getActivity()).viewPager.setCurrentItem(5);
                }
            });

            ImageView img2 = (ImageView)view.findViewById(R.id.img2);
            (img2).setImageDrawable(SectionsPagerAdapter.getIcone(6, mContext));
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getActivity()).viewPager.setCurrentItem(6);
                }
            });

            ImageView img3 = (ImageView)view.findViewById(R.id.img3);
            (img3).setImageDrawable(SectionsPagerAdapter.getIcone(7, mContext));
            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)getActivity()).viewPager.setCurrentItem(7);
                }
            });

        } else if(page > 3) {
            ImageView img0 = (ImageView) view.findViewById(R.id.img0);
            Drawable drawable = SectionsPagerAdapter.getIcone(page, mContext);
            img0.setImageDrawable(drawable);
        }

        return view;
    }
}
