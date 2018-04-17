package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student extends Model{

    @Id
    int id;
    String name;
    Date dateOfBirth;
    String contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Student(int id, String name, Date dateOfBirth, String contact) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
    }

    public Student() {
    }

    /*
    public static Set<Student> students;

    static{
        students=new HashSet<Student>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");

        try {
            students.add(new Student(1,"Dhananjay Sathe",dateFormat.parse("12/02/1991"),"+1 (404) 719 0883"));
            students.add(new Student(2,"Harry potter",dateFormat.parse("12/31/2000"),"+1 (999) 999 9999"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Set<Student> getall(){
        return students;
    }

    public static Student getStudentbyId(int id){
        for(Student S : students){
            if(S.id == id){
                return S;
            }
        }
        return null;
    }
    public static Student update(Student s){
        for(Student S : students){
            if(s.id == S.id){
                S.contact=s.contact;
                S.dateOfBirth=s.dateOfBirth;
                S.name=s.name;
            }
        }
        return s;
    }
    public static Student create(Student s){
        students.add(s);
        return s;
    }
    public static void delete(Student s){
        students.remove(s);
    }
    */
}
