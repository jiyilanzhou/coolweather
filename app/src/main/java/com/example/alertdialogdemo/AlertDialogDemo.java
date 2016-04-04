package com.example.alertdialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.hoperun.myapplication.R;

public class AlertDialogDemo extends Activity {

    TextView show;
    String[] items = new String[]{
            "疯狂Java讲义", "疯狂Ajax讲义"
            , "轻量级Java EE企业应用实战", "疯狂android讲义"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_demo);
        show = (TextView) findViewById(R.id.showAlert);
        Button simple = (Button) findViewById(R.id.simple);
        Button simpleList = (Button) findViewById(R.id.simpleList);
        Button singleChoice = (Button) findViewById(R.id.singleChoice);
        Button multiChoice = (Button) findViewById(R.id.multiChoice);
        Button customList = (Button) findViewById(R.id.customList);
        Button customView = (Button) findViewById(R.id.customView);
        Button btn1 = (Button) findViewById(R.id.btnPopupWindow);
        Button btn2 = (Button) findViewById(R.id.btnDateDialog);
        Button btn3 = (Button) findViewById(R.id.btnProgressDialog);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlertDialogDemo.this, PopupWindowDemo.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlertDialogDemo.this, DatedialogDemo.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlertDialogDemo.this, ProgressDialogDemo.class));
            }
        });
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this)
                        .setTitle("简单对话框").setIcon(R.drawable.tools)
                        .setMessage("对话框的测试内容\n第二行内容");
                setPositiveButton(builder);
                setNegativeButton(builder)
                        .create()
                        .show();

            }
        });

        simpleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this)
                        .setTitle("简单列表项对话框")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                show.setText("你选中了《" + items[which] + "》" + "=which=" + which);
                            }
                        });
                builder.create().show();
            }
        });

        singleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this)
                        .setTitle("单选列表项对话框").setIcon(R.drawable.libai)
                        .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                show.setText("你选中了《" + items[which] + "》" + "=which=" + which);
                            }
                        });
                setPositiveButton(builder);
                setNegativeButton(builder).create().show();
            }
        });
        multiChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this)
                        .setTitle("多选列表项对话框").setIcon(R.drawable.nongyu)
                        .setMultiChoiceItems(items, new boolean[]{false, true, true, true}, null);
                setPositiveButton(builder);
                setNegativeButton(builder).create().show();
            }
        });

        customList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this)
                        .setTitle("自定义列表项对话框").setIcon(R.drawable.qingzhao)
                        .setAdapter(new ArrayAdapter<String>(AlertDialogDemo.this, R.layout.array_item_alert, items), null);
                setPositiveButton(builder);
                setNegativeButton(builder).create().show();
            }
        });
        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.alert_login, null);
                new AlertDialog.Builder(AlertDialogDemo.this).setIcon(R.drawable.tools)
                        .setTitle("自定义View对话框").setView(loginForm)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                show.setText("你选中了《" + items[which] + "》" + "=which=" + which);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("你选中了《" + items[which] + "》" + "=which=" + which);
                    }
                }).create().show();
            }
        });
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【确定】按钮！" + "=which=" + which);
            }
        });
    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【取消】按钮！" + "=which=" + which);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alert_dialog_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
