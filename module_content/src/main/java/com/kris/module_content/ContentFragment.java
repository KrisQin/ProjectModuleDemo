package com.kris.module_content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kris.lib_base.utils.RouteUtils;

@Route(path = RouteUtils.Content_Fragment_Main)
public class ContentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = getLayoutInflater().inflate(R.layout.content_fragment_layout,null);

        view.findViewById(R.id.show_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showContent();

            }
        });

        return view;


    }

    private void showContent() {
        startActivity(new Intent(getActivity(),ContentActivity.class));
    }
}
