package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hoperun.myapplication.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class SchemeHostPortPathType extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme_host_port_path_type);
        Button button = (Button) findViewById(R.id.btnSchemeHostPortPathType);
        Button button1 = (Button) findViewById(R.id.btnParseXml);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String uri = "lee://www.fkjava.org:8888/mypath";
//                intent.setData(Uri.parse(uri));
                intent.setDataAndType(Uri.parse(uri), "abc/xyz");

                TextView view = (TextView) findViewById(R.id.txtSchemeHostPortPathType);
                view.setText(uri+getIntent().getData());
                Log.d(this.toString(), uri);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //根据XML资源的ID获取解析该资源的解析器
                //xmlResourceParse是XmlPullParse的子类
                XmlResourceParser parser = getResources().getXml(R.xml.books);

                StringBuilder sb = new StringBuilder("");
                try {
                    while (parser.getEventType() != XmlPullParser.END_DOCUMENT){
                        //如果遇到开始标签
                        if (parser.getEventType() == XmlPullParser.START_TAG){
                            //获取该标签的标签名
                            String tagName = parser.getName();
                            Log.d("tagName","parser.getName()="+parser.getName());
                            Log.d("getAttributeCount()","getAttributeCount()"+parser.getAttributeCount());
                            if (tagName.equals("book")){
                                //根据属性名获取属性值

                                String bookName = parser.getAttributeValue(null,"price");
                                sb.append("价格：");
                                sb.append(bookName);
                                //根据属性索引来获取属性值
                                String bookPrice = parser.getAttributeValue(1);
                                sb.append(" 出版日期：");
                                sb.append(bookPrice);
                                sb.append(" 书名：");
                                //获取文本节点的值
                                sb.append(parser.nextText());
                            }
                            sb.append("\n");
                        }
                        //获取解析器的下一个事件
                        parser.next();
                    }
                    TextView tv = (TextView) findViewById(R.id.txtShowXml);
                    tv.setText(sb.toString());
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scheme_host_port_path_type, menu);
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
