package com.fkxmz.dao;

import com.fkxmz.jdbcUtils.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    //执行删改查的方法
    public int update(String sql, Object... args) {
        Connection connection = jdbcUtil.getConnection();
        try {
            queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtil.close(connection);
        }
        return -1;
    }

    //查询返回一条JavaBean的sql语句
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = jdbcUtil.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.close(connection);
        }
    }

    //查询返回多条javaBean的sql语句
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = jdbcUtil.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtil.close(connection);
        }
    }
    //返回一行一列的sql语句
    public Object queryForSingleValue(String sql,Object ... args){
        Connection connection = jdbcUtil.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
