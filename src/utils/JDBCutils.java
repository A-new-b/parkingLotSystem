package utils;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutils {
    private static DataSource ds;

    static {

        try {
            Properties pro=new Properties();
            InputStream is=JDBCutils.class.getClassLoader().getResourceAsStream("durid.properties");
            pro.load(is);
            //初始化连接池
            ds=DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
    获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }
    public  static Connection getConnection() throws SQLException{
        return  ds.getConnection();
    }
}
