package com.example.FragmentTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/10.
 */
public class BookContent {
    //定义一个内部类，作为系统的业务对象
    public static class Book {
        
        public Integer id;
        public String title;
        public String desc;
        public Book(Integer id, String title, String desc){
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }
    public static List<Book> items = new ArrayList<Book>();
    public  static Map<Integer,Book> ITEM_MAP = new HashMap<Integer, Book>();
    static {
        addItem(new Book(1,"疯狂Java讲义","一本全面、深入的Java学习图书"));
        addItem(new Book(2,"疯狂android讲义","一本非常火的安卓图书"));
        addItem(new Book(3,"轻量级java EE企业应用实战","全面介绍java ee开发的图书"));
    }
    private static void addItem(Book book){
        items.add(book);
        ITEM_MAP.put(book.id,book);
    }
}
