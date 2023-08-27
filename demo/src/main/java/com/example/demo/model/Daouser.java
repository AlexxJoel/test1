package com.example.demo.model;

import com.example.demo.config.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Daouser {
    Connection con = new MySQLConnection().getConnection();
    PreparedStatement ps;
    ResultSet rs;

    private final String LOGIN = "select * from users where email=? and pwd=?;";


    public Beanuser userlogin(Beanuser userlogin) {
        try {
            ps = con.prepareStatement(LOGIN);
            ps.setString(1, userlogin.getEmail());
            ps.setString(2, userlogin.getPwd());
            rs = ps.executeQuery();
            // save on the bean
            Beanuser userdb = new Beanuser();

            if (rs.next()) {
                userdb.setId(rs.getInt("id"));
                userdb.setName(rs.getString("name"));
                userdb.setEmail(rs.getString("email"));
                userdb.setPwd(rs.getString("pwd"));
            }
            return userdb;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
