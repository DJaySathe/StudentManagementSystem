package controllers;

import models.Student;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.students.*;

import javax.inject.Inject;
import java.util.Set;

public class StudentController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result index(){
        //Set<Student> students = Student.getall();
        Set<Student> students = DatabaseController.getAllStudents();
        return ok(index.render(students));
    }

    public Result getStudentById(Integer id){
        //Student student = Student.getStudentbyId(id);
        Student student = DatabaseController.getStudentById(id);
        return ok(show.render(student));
    }

    public Result add(){
        Form<Student> form= formFactory.form(Student.class);
        return ok(create.render(form));
    }

    public Result create(){
        Form<Student> studentForm = formFactory.form(Student.class).bindFromRequest();
        Student student =studentForm.get();
        //Student.create(student);
        DatabaseController.insert(student);
        return redirect(routes.StudentController.index());
    }

    public Result edit(Integer id){
        //Student student = Student.getStudentbyId(id);
        Student student = DatabaseController.getStudentById(id);
        Form<Student> form= formFactory.form(Student.class).fill(student);
        return ok(edit.render(form));
    }
    public Result update(){
        Form<Student> studentForm = formFactory.form(Student.class).bindFromRequest();
        Student student =studentForm.get();
        //Student.update(student);
        DatabaseController.update(student);
        return redirect(routes.StudentController.index());
    }

    public Result delete(Integer id){
        //Student student = Student.getStudentbyId(id);
        Student student = DatabaseController.getStudentById(id);
        if(student == null){
            return notFound("Student not found");
        }
        //Student.delete(student);
        DatabaseController.deleteStudentById(id);
        return redirect(routes.StudentController.index());
    }
}
