package controllers;

import com.typesafe.config.ConfigFactory;
import models.Student;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DatabaseController {
    private static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ConfigFactory.load().getString("db.default.url"),
                    ConfigFactory.load().getString("db.default.username"),
                    ConfigFactory.load().getString("db.default.password"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static Student insert(Student student) {
        String sql = "INSERT INTO student(id,name,date_of_birth,contact) VALUES(?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setDate(3, new java.sql.Date(student.getDateOfBirth().getTime()));
            pstmt.setString(4, student.getContact());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
    public static Student update(Student student) {
        String sql = "UPDATE student SET name = ?, date_of_birth = ?, contact = ? where id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setDate(2, new java.sql.Date(student.getDateOfBirth().getTime()));
            pstmt.setString(3, student.getContact());
            pstmt.setInt(4, student.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public static Set<Student> getAllStudents(){
        String sql = "Select * from student";
        Set<Student> students = new HashSet<>();
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setDateOfBirth(rs.getDate(3));
                student.setContact(rs.getString(4));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
    public static Student getStudentById(Integer id){
        String sql = "Select * from student where id =?";
        Student student = new Student();
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setDateOfBirth(rs.getDate(3));
                student.setContact(rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public static void deleteStudentById(Integer id){
        String sql = "Delete from student where id =?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
