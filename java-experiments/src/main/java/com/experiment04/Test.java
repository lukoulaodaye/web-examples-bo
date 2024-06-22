package com.experiment04;

import com.experiment04.entity.Student;
import com.experiment04.service.StudentService;
import com.experiment04.service.Impl.StudentServiceImpl;

import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        testAddStudent();
        testListStudentsByYear();
        testListStudentsNames();
        testListStudentsByYearSortedById();
        testListStudentsMapBySex();
        testListStudentsByYearMapById();
        testRemoveStudent();
    }

    public static void testAddStudent() {
        StudentService studentService = new StudentServiceImpl();
        Student student = new Student(202201, Student.Sex.FEMALE,"蔡徐坤", 2022 );
        List<Student> students = studentService.addStudent(student);
        System.out.println("添加学生: " + student );
        System.out.println("所有学生: " + students);

    }

    public static void testListStudentsByYear() {
        StudentService studentService = new StudentServiceImpl();
        int year = 2022;
        List<Student> students = studentService.listStudentsByYear(year);
        System.out.println( year + "入学的学生: " + students);
    }

    public static void testListStudentsNames() {
        StudentService studentService = new StudentServiceImpl();
        int year = 2022;
        Student.Sex sex = Student.Sex.FEMALE;
        List<String> studentNames = studentService.listStudentsNames(year, sex);
        System.out.println( year + "入学且性别是"+ sex+"的学生有："+studentNames);
    }

    public static void testListStudentsByYearSortedById() {
        StudentService studentService = new StudentServiceImpl();
        int year = 2010;
        List<Student> students = studentService.listStudentsByYearSortedById(year);
        System.out.println(year + "入学的学生 " + students);
    }

    public static void testListStudentsMapBySex() {
        StudentService studentService = new StudentServiceImpl();
        Map<Student.Sex, List<Student>> studentMap = studentService.listStudentsMapBySex();
        System.out.println("按性别分组 " + studentMap);
    }

    public static void testListStudentsByYearMapById() {
        StudentService studentService = new StudentServiceImpl();
        int year = 2022;
        Map<Integer, Student> studentMap = studentService.listStudentsByYearMapById(year);
        System.out.println("按年龄分组 " + year+": "  + studentMap);
    }

    public static void testRemoveStudent() {
        StudentService studentService = new StudentServiceImpl();
        int idToRemove = 202201;
        boolean removed = studentService.removeStudent(idToRemove);
        System.out.println("是否移除学号为" + idToRemove + "的学生： " + removed);
    }
}
