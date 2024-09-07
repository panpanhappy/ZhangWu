package com.sjxy.app;

import com.sjxy.view.MainView;
import java.sql.*;

public class MainApp {
    public static void main(String[] args) throws SQLException {

            // 创建 MainView 类的实例
            MainView mainView = new MainView();
            // 通过实例调用 run 方法
            mainView.run();
    }

}
