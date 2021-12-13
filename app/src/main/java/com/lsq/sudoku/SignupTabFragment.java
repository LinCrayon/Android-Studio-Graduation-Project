package com.lsq.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.lsq.sudoku.mapper.UserDao;
import com.lsq.sudoku.pojo.User;

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




    public void register(View view){



        String cemail = email.getText().toString();
        String cusername = username.getText().toString();
        String cpassword = password.getText().toString();

        System.out.println(confirm.getText().toString());

        String cconfirm = confirm.getText().toString();


        if(cemail.length() < 2 || cusername.length() < 2 || cpassword.length() < 2 ){
            Toast.makeText(getContext(),"输入信息不符合要求请重新输入",Toast.LENGTH_LONG).show();
            return;

        }


        User user = new User();

        user.setEmail(cemail);
        user.setPassword(cpassword);
        user.setName(cusername);
        user.setConfirmname(cconfirm);

        new Thread(){
            @Override
            public void run() {

                int msg = 0;

                UserDao userDao = new UserDao();

                User uu = userDao.findUser(user.getName());

                if(uu != null){
                    msg = 1;
                }

                boolean flag = userDao.register(user);
                if(flag){
                    msg = 2;
                }
                hand.sendEmptyMessage(msg);

            }
        }.start();


    }
    final Handler hand = new Handler()
    {
        private Object RESULT_CANCELED;


        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0)
            {
                Toast.makeText(getContext(),"注册失败",Toast.LENGTH_LONG).show();

            }
            if(msg.what == 1)
            {
                Toast.makeText(getContext(),"该账号已经存在，请换一个账号",Toast.LENGTH_LONG).show();

            }
            if(msg.what == 2)
            {
                //startActivity(new Intent(getApplication(),MainActivity.class));

                Intent intent = new Intent();
                //将想要传递的数据用putExtra封装在intent中
                intent.putExtra("a","注册");

            }

        }
    };



}
