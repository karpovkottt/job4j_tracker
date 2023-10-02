package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Konstantin Karpov");
        student.setGroup("A-95");
        student.setAdmission(new Date());
        System.out.println("Студент " + student.getName() + " зачислен - " + student.getAdmission() + ", в группу - " + student.getGroup());
    }
}
