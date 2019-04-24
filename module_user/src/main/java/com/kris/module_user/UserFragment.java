package com.kris.module_user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kris.lib_base.utils.RouteUtils;

@Route(path = RouteUtils.User_Fragment_Main)
public class UserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = getLayoutInflater().inflate(R.layout.user_fragment_layout,null);

        view.findViewById(R.id.find_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findHome();
            }
        });

        return view;


    }

    private void findHome() {
        startActivity(new Intent(getActivity(),UserActivity.class));
    }

}
