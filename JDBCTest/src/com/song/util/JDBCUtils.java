package com.song.util;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 工具类 封装
 * 加载数据库配置、获取连接以及关闭数据库资源。
 */
public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    // 通过静态代码块，来预先执行读取配置文件的配置项，做预处理。
    static {
        try {
            // 获取类路径上的db.properties文件的输入流
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
            // 创建一个Properties对象，这是一个键值对集合，常用于处理配置文件
            Properties properties = new Properties();
            // 从输入流加载键值对到Properties对象
            properties.load(inputStream);
            //getProperty()方法来获取这些值
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        System.out.println("使用");
    }

    /**
     * 建立并返回一个与数据库的连接
     */

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection !=null){
            connection.close();
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection !=null){
            connection.close();
        }

        if (resultSet !=null){
            resultSet.close();
        }
    }
}
