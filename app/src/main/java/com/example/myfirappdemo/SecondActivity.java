package com.example.myfirappdemo;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.TextView;

        public class SecondActivity extends Activity {
            @Override
            protected void onCreate(Bundle savedInstanceSafe) {
                super.onCreate(savedInstanceSafe);
                setContentView(R.layout.second_xml);

                // 获取传递过来的Intent对象
                Intent intent = this.getIntent();
                // 获取Intent中的数据包
                Bundle bundle = intent.getExtras();

                // 从数据包中获取各个数据
                String phone = bundle.getString("phone");
                String paswd = bundle.getString("paswd");
                String sex = bundle.getString("sex");
                String hobby = bundle.getString("hobby");
                String city = bundle.getString("city");

                // 获取TextView控件
                TextView show_text = findViewById(R.id.show_content);

                // 设置TextView的文本内容
                show_text.setText("手机号为：" + phone + "\n" + "密码为：" + paswd + "\n" + "性别是：" + sex + "\n" + "爱好是：" + hobby + "\n" + "城市是：" + city);
            }
        }