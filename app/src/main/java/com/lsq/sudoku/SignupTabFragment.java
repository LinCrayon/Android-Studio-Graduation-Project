package com.lsq.sudoku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {

    EditText email,username, password,confirm;
    Button signup;
    float v = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.Password);
        username = root.findViewById(R.id.Username);
        confirm = root.findViewById(R.id.confirm);


        email.setTranslationY(800);
        password.setTranslationY(800);
        username.setTranslationY(800);
        confirm.setTranslationY(800);

        email.setAlpha(v);     //不透明度
        confirm.setAlpha(v);
        username.setAlpha(v);
        password.setAlpha(v);


        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        confirm.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        username.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        return root;
    }
}
