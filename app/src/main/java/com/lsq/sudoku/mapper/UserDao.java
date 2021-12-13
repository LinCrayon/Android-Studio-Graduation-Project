package com.lsq.sudoku.mapper;


import com.lsq.sudoku.pojo.User;
import com.lsq.sudoku.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    public boolean login(String email,String password){

        String sql = "select * from users where email = ? and password = ?";

        Connection  con = JDBCUtils.getConn();

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,email);
            pst.setString(2,password);

            if(pst.executeQuery().next()){

                return true;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con);
        }

        return false;
    }

    public boolean register(User user){

        String sql = "insert into users(email,password,name,confirmname) values (?,?,?,?)";

        Connection  con = JDBCUtils.getConn();

        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,user.getEmail());
            pst.setString(2,user.getPassword());
            pst.setString(3,user.getName());
            pst.setString(4,user.getConfirmname());

            int value = pst.executeUpdate();

            if(value>0){
                return true;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con);
        }
        return false;
    }

    public User findUser(String email){

        String sql = "select * from users where email = ?";

        Connection  con = JDBCUtils.getConn();
        User user = null;
        try {
            PreparedStatement pst=con.prepareStatement(sql);

            pst.setString(1,email);

            ResultSet rs = pst.executeQuery();

            while (rs.next()){

                String emaildb = rs.getString(1);
                String passworddb = rs.getString(2);
                String namedb  = rs.getString(3);
                String confirmnamedb = rs.getString(4);
                user = new User();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con);
        }

        return user;
    }


}