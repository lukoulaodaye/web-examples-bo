package com.experiment05;

import com.experiment05.entity.College;
import com.experiment05.entity.Student;
import com.experiment05.entity.Teacher;
import com.experiment05.resource.DatabaseUtils;
import java.util.List;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        // 示例用法，这些调用假设其他代码部分已经正确实现
         getCollegeName(DatabaseUtils.listStudents().get(0));
         System.out.println(isTeacher(DatabaseUtils.listStudents().get(0), "曾志优"));
         System.out.println(getCollegeName(DatabaseUtils.listStudents(),8888));
         printCollegeName(DatabaseUtils.listStudents(), 201001, 1002);

    }

    /**
     * 基于给定学生，获取学生的导师的所在学院名称。  
     * 任何一项不存在或失败，返回 未知学院  
     */
    private static String getCollegeName(Student student) {
        return Optional.ofNullable(student)
                .map(Student::getTeacher)
                .map(Teacher::getCollege)
                .map(College::getName)
                .orElse("未知学院");
    }

    /**
     * 基于给定学生及教师姓名，判断是否为给定学生的指导教师。  
     * 不匹配或不存在，均返回false  
     */
    private static boolean isTeacher(Student student, String teacherName) {
        return Optional.ofNullable(student)
                .map(Student::getTeacher)
                .map(Teacher::getName)
                .filter(name -> name.equals(teacherName))
                .isPresent();
    }

    /**
     * 基于给定学生集合，学生编号，实现获取学生的导师的所在学院名称。  
     * 任何一项不存在或失败，返回 未知学院  
     */
    private static String getCollegeName(List<Student> students, int sNumber) {
        return students.stream()
                .filter(student -> student.getNumber() == sNumber)
                .findFirst()
                .map(Test::getCollegeName)
                .orElse("未知学院");
    }

    /**
     * 实现在给定学生集合中查询指定编号学生，如果学生导师编号为指定编号，打印显式导师所在学院名称。  
     * 任何一项不存在或失败，打印显式 未知学院  
     */
    private static void printCollegeName(List<Student> students, int sNumber, int tNumber) {
        Optional<String> collegeName = students.stream()
                .filter(student -> student.getNumber() == sNumber)
                .findFirst()
                .map(student -> {
                    Teacher teacher = student.getTeacher();
                    if (teacher != null && teacher.getNumber() == tNumber) {
                        return teacher.getCollege().getName();
                    }
                    return "未知学院";
                });
        System.out.println(collegeName.orElse("未知学院"));
    }
}