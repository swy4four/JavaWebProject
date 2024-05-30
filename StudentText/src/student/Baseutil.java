package student;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Baseutil {
    private static  String driver ;
    private static  String url ;
    private static  String username;
    private static  String password ;
    // 第一步：加载驱动
    static{
        try {
            Properties p = new Properties();
            InputStream is = Baseutil.class.getResourceAsStream("db.properties");
            p.load(is);
            driver = p.getProperty("driver");
            Class.forName(driver);

            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() {
        // 第二步：获取连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url.trim(),username.trim(),password.trim());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }


    public int dml(String sql,Object[] param) {
        //System.out.println("进入到dml方法中333");
        Connection conn = null;
        PreparedStatement ps = null;
        int num = 0;
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            if(param != null) {
                for (int i = 0; i < param.length; i++) {
                    ps.setObject((i + 1),param[i] );
                }
                num = ps.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(ps);
            close(conn);
        }
        return num;
    }

    //创建对象，创建集合，给对象属性赋值，将对象存放到集合中
    public  <T> List<T>  dql(String sql,Object[] param,Class<T> clazz) {
        //System.out.println("进入到dql方法中");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T t = null;
        List<T> list = new ArrayList<>();

        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            //存在占位符，给占位符赋值
            if(param != null) {
                for (int i = 0; i < param.length; i++) {
                    ps.setObject((i + 1),param[i] );
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData  rsmd = rs.getMetaData();

            while(rs.next()) {
                t = clazz.newInstance();//反向创建对象
                for (int i = 0;i <  rsmd.getColumnCount();i++) {
                    String colname = rsmd.getColumnName(i + 1);
                    Object value = rs.getObject(colname);
                    setEntry(t,colname,value);
                }
                list.add(t);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(ps);
            close(conn);
        }
        return list;
    }

    //给属性赋值
    public <T> void setEntry(T t,String colname,Object value) {
        //System.out.println(transfer(colname) + "\t" + value);
        try {
            Field f = t.getClass().getDeclaredField(transfer(colname));
            f.setAccessible(true);//运行给私有属性赋值
            f.set(t, value);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 下划线转化转驼峰
    public String transfer(String str){
        str = str.toLowerCase();
        Pattern compile = Pattern.compile("_[a-z]");
        Matcher matcher = compile.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(0).toUpperCase().replace("_", ""));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void close(Object o) {
        if(o instanceof ResultSet) {
            try {
                ((ResultSet)o).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(o instanceof PreparedStatement) {
            try {
                ((PreparedStatement)o).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(o instanceof Connection) {
            try {
                ((Connection)o).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getConn());
    }

}
