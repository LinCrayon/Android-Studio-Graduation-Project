package com.lsq.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.lsq.sudoku.mapper.UserDao;


public class LoginTabFragment  extends Fragment {
    Button button;




    public void login(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);
        EditText EditTextemail = (EditText) root.findViewById(R.id.email);
        EditText EditTextpassword = (EditText) root.findViewById(R.id.pass);

        new Thread() {

            @Override
            public void run() {

                UserDao userDao = new UserDao();

                boolean aa = userDao.login(EditTextemail.getText().toString(), EditTextpassword.getText().toString());
                int msg = 0;
                if (aa) {
                    msg = 1;
                }

                hand1.sendEmptyMessage(msg);


            }
        }.start();
    }



    final Handler hand1 = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        button = root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });

        return root;
    }
 }