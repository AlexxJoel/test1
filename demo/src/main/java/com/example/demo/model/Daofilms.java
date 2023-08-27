package com.example.demo.model;

import com.example.demo.config.MySQLConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Daofilms {
    Connection con = new MySQLConnection().getConnection();
    PreparedStatement ps;
    ResultSet rs;

    private final String INSERTFILM = "insert into films(name,description,publish_date,actors,duration,ranking)values(?,?,?,?,?,?)";
    private final String CONSULTALL = "select * from films";
    private final String GETONE = "select * from films where id=?";
    private final String UPDATE="UPDATE `movies`.`films`\n" +
            "SET\n" +
            "`name` = ?,\n" +
            "`description` = ?,\n" +
            "`publish_date` = ?,\n" +
            "`actors` = ?,\n" +
            "`duration` = ?,\n" +
            "`ranking` = ? WHERE `id` = ?;";

    private final String DELETE_SQL = "DELETE from films where id=?";

    public boolean insertfilm(Beanfilms insertfilm) {
        try {
            ps = con.prepareStatement(INSERTFILM);
            ps.setString(1, insertfilm.getName());
            ps.setString(2, insertfilm.getDescription());
            ps.setDate(3, new Date(insertfilm.getPublish_date().getTime()));
            ps.setString(4, insertfilm.getActors());
            ps.setInt(5, insertfilm.getDuration());
            ps.setInt(6, insertfilm.getRanking());
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Beanfilms> getAll(){
        try {
            List<Beanfilms> beanfilmsList = new ArrayList<>();
            Beanfilms film;

            ps = con.prepareStatement(CONSULTALL);
            rs = ps.executeQuery();

            while (rs.next()){
                film = new Beanfilms(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("publish_date"),
                        rs.getString("actors"),
                        rs.getInt("duration"),
                        rs.getInt("ranking"),
                        null, rs.getInt("status")
                );

                beanfilmsList.add(film);
            }

            return beanfilmsList;
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }


    public Beanfilms getById(int id){
        try {
            Beanfilms film;

            ps = con.prepareStatement(GETONE);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()){
                film = new Beanfilms(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDate("publish_date"),
                        rs.getString("actors"),
                        rs.getInt("duration"),
                        rs.getInt("ranking"),
                        null, rs.getInt("status")
                );
            }else film = null;

            return film;
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }


    public boolean update(Beanfilms update) {
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, update.getName());
            ps.setString(2, update.getDescription());
            ps.setDate(3, new Date(update.getPublish_date().getTime()));
            ps.setString(4, update.getActors());
            ps.setInt(5, update.getDuration());
            ps.setInt(6, update.getRanking());
            ps.setInt(7,update.getId());
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }



    public boolean deleteById(int id){
        try {
            Beanfilms film;

            ps = con.prepareStatement(DELETE_SQL);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;


        }catch (Exception e){
            System.out.println("e = " + e);
            return false;
        }
    }


}
