package com.fkxmz.jdbcUtils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {
    private static DruidDataSource dataSource;
    static {
        try {
            Properties properties = new Properties();
            //读取配置文件
            InputStream inputStream = jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

            System.out.println(dataSource.getConnection());
            System.out.print("数据库连接成功！\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //获取数据库连接池中的连接,返回null说明返回失败
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    //关闭连接，放回连接池
    public static void close(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
