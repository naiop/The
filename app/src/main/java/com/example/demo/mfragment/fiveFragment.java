package com.example.demo.mfragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.activity.AboutActivity;
import com.example.demo.activity.Browser;
import com.example.demo.activity.CodeActivity;
import com.example.demo.activity.LoginActivity;
import com.example.demo.activity.MainTbs;
import com.example.demo.activity.SettingActivity;
import com.example.demo.activity.TestFactory;
import com.example.demo.utils.WXQQUtil;
import com.example.demo.utils.SoundUtils;


public class fiveFragment extends Fragment {

    RelativeLayout aboutapp, webbrowser, tbsfile, qqgroup, factorymodel, downlaodpath, setting, exitlogin, de;
    ImageView img_header;

    private void initView(View view) {
        aboutapp = view.findViewById(R.id.aboutapp);
        webbrowser = view.findViewById(R.id.webbrowser);
        tbsfile = view.findViewById(R.id.tbsfile);
        qqgroup = view.findViewById(R.id.qqgropu);
        factorymodel = view.findViewById(R.id.factorymodel);
        downlaodpath = view.findViewById(R.id.downloadpath);
        setting = view.findViewById(R.id.Setting);
        exitlogin = view.findViewById(R.id.exitlogin);
        de = view.findViewById(R.id.de);
        img_header = view.findViewById(R.id.img_header);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five, container, false);

        initView(view);
        initData();
        return view;
    }

    private void initData() {

        initBtnListenser();
        img_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent, 0);

            }
        });
    }

    private void initBtnListenser() {

        //??????app
        aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);

            }
        });

        //Text
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "????????????", Toast.LENGTH_SHORT).show();
                SoundUtils.playSound(R.raw.sucess);
                Intent intent = new Intent(getActivity(), CodeActivity.class);
                startActivity(intent);


            }
        });

        //?????????
        webbrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Browser.class);
                startActivity(intent);

            }
        });

        //tbs file
        tbsfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainTbs.class);
                startActivity(intent);
            }
        });


        //??????qq group
        qqgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!WXQQUtil.joinQQGroup("Oo7Jsgqio1N3n50qJcLYX50EODExfbQk ", getActivity())) {
                    Toast.makeText(getActivity(), "????????????Q???????????????????????????", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //????????????
        downlaodpath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(getContext(), R.style.style_dialog);
                View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_path, null);
                dialog.setContentView(view); //??????????????????Dialog
                Window window = dialog.getWindow();
                window.setGravity(Gravity.BOTTOM); //??????Dialog?????????????????????
                WindowManager.LayoutParams lp = window.getAttributes();//?????????????????????
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;   //????????????????????????
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes(lp);  //????????????????????????
                window.setWindowAnimations(R.style.style_dialog);  //????????????
                dialog.show();//???????????????

            }
        });


        //??????Demo?????? ???????????????
        factorymodel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TestFactory.class);
                startActivity(intent);
            }
        });

        //??????
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });

        //??????app
        exitlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

    }


}