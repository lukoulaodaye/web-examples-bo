package com.experiment04.service.Impl;

import com.experiment04.entity.Student;
import com.experiment04.resource.DatabaseUtils;
import com.experiment04.service.StudentService;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> addStudent(Student student) {
        DatabaseUtils.listStudents().add(student);
        return DatabaseUtils.listStudents();
    }

    @Override
    public List<Student> listStudentsByYear(int year) {
        return DatabaseUtils.listStudents().stream()
                .filter(student -> student.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listStudentsNames(int year, Student.Sex sex) {
        return DatabaseUtils.listStudents().stream()
                .filter(student -> student.getYear() == year && student.getSex() == sex)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> listStudentsByYearSortedById(int year) {
        return DatabaseUtils.listStudents().stream()
                .filter(student -> student.getYear() == year)
                .sorted((s1, s2) -> s2.getId() - s1.getId())
                .collect(Collectors.toList());
    }

    @Override
    public Map<Student.Sex, List<Student>> listStudentsMapBySex() {
        return DatabaseUtils.listStudents().stream()
                .collect(Collectors.groupingBy(Student::getSex));
    }

    @Override
    public Map<Integer, Student> listStudentsByYearMapById(int year) {
        return DatabaseUtils.listStudents().stream()
                .filter(student -> student.getYear() == year)
                .collect(Collectors.toMap(Student::getId, student -> student));
    }

    @Override
    public boolean removeStudent(int id) {
        List<Student> students = DatabaseUtils.listStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
}
