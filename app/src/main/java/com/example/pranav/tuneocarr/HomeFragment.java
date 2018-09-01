package com.example.pranav.tuneocarr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
     //   return super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        return view;
    }
}
