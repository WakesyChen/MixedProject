package com.servey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hz6_23_spinner.R;

public class ServeyActivity extends AppCompatActivity {

    private EditText et_name, et_psw;
    private RadioGroup rg_sex;
    private RadioButton rb_man, rb_woman;
    private CheckBox cb_1, cb_2, cb_3;
    private Button btn_show;
    String str_et1;
    String str_et2;
    String sex;
    String infor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey_main);

        initView();


    }

    public void click(View v) {


        switch (v.getId()) {

            case R.id.btn_show:
                String str_cb1 = "", str_cb2 = "", str_cb3 = "";
                Intent intent = new Intent(ServeyActivity.this, ServeySecond.class);
                str_et1 = et_name.getText().toString().trim();
                str_et2 = et_psw.getText().toString().trim();

                if(cb_1.isChecked())str_cb1=cb_1.getText().toString();
                if(cb_2.isChecked())str_cb2=cb_2.getText().toString();
                if(cb_3.isChecked())str_cb3=cb_3.getText().toString();
                sex = rb_man.isChecked() ? rb_man.getText().toString() : rb_woman.getText().toString();

                infor = "用户名是：" + str_et1 + " \n" + "密 码：" + str_et2 + " \n" + "性别：" + sex + "\n"
                        + "爱好：" + str_cb1 + "\t" + str_cb2 + "\t" + str_cb3;
                intent.putExtra("infor", infor);
                startActivity(intent);

                break;


        }



    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_psw = (EditText) findViewById(R.id.et_psw);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        rb_man = (RadioButton) findViewById(R.id.rb_man);
        rb_woman = (RadioButton) findViewById(R.id.rb_woman);
        cb_1 = (CheckBox) findViewById(R.id.cb_1);
        cb_2 = (CheckBox) findViewById(R.id.cb_2);
        cb_3 = (CheckBox) findViewById(R.id.cb_3);
        btn_show = (Button) findViewById(R.id.btn_show);

    }

}
