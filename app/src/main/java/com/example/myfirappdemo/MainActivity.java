package com.example.myfirappdemo;

                import android.content.Intent;
                import android.os.Bundle;
                import android.view.View;
                import android.widget.AdapterView;
                import android.widget.ArrayAdapter;
                import android.widget.Button;
                import android.widget.CheckBox;
                import android.widget.EditText;
                import android.widget.RadioButton;
                import android.widget.RadioGroup;
                import android.widget.Spinner;

                import androidx.appcompat.app.AppCompatActivity;

                public class MainActivity extends AppCompatActivity {
                    // 定义字符串变量来存储用户输入的数据
                    private String phone_str = "";
                    private String password_str = "";
                    private String sex_str = "";
                    private String hobby_str = "";
                    private String city_str = "";

                    // 定义 UI 组件
                    EditText editTextPhone, editTextPassword;
                    RadioGroup sex_group;
                    RadioButton nan_but;
                    CheckBox Reading, Sports, Music;
                    Spinner spinner;
                    Button Register;

                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);

                        // 初始化 UI 组件
                        editTextPhone = findViewById(R.id.editTextPhone);
                        editTextPassword = findViewById(R.id.editTextPassword);
                        sex_group = findViewById(R.id.sex_group);

                        // 设置性别选择的监听器
                        sex_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                // 根据选中的 RadioButton 设置性别字符串
                                sex_str = (checkedId == R.id.nan_but ) ? "男性" : "女性";
                            }
                        });

                        nan_but = findViewById(R.id.nan_but);
                        Reading = findViewById(R.id.checkBoxReading);
                        Sports = findViewById(R.id.checkBoxSports);
                        Music = findViewById(R.id.checkBoxMusic);
                        Register = findViewById(R.id.buttonRegister);

                        // 设置注册按钮的点击事件
                        Register.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // 获取用户输入的手机号和密码
                                phone_str = editTextPhone.getText().toString();
                                password_str = editTextPassword.getText().toString();

                                // 获取用户选择的爱好
                                hobby_str = "";
                                if (Reading.isChecked()) {
                                    hobby_str += Reading.getText().toString();
                                }
                                if (Sports.isChecked()) {
                                    hobby_str += Sports.getText().toString();
                                }
                                if (Music.isChecked()) {
                                    hobby_str += Music.getText().toString();
                                }

                                // 创建 Intent 对象并传递数据
                                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("phone", phone_str);
                                bundle.putString("paswd", password_str);
                                bundle.putString("sex", sex_str);
                                bundle.putString("hobby", hobby_str);
                                bundle.putString("city", city_str);
                                intent.putExtras(bundle); // 使用 putExtras 方法传递数据
                                startActivity(intent); // 启动 SecondActivity
                            }
                        });

                        // 设置 Spinner 城市选择的监听器
                        spinner = findViewById(R.id.CitySpinner);
                        final String[] city = new String[]{"北京", "上海", "武汉", "西安"};
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
                        spinner.setAdapter(adapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                // 获取用户选择的城市
                                city_str = city[i];
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                                // 当没有选择任何城市时的处理
                            }
                        });
                    }
                }