package org.ccasro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = Stream.of(
                new Student("Ana", 20,"JAVA",5.0),
                new Student("Luis", 21,"PHP",6.0),
                new Student("María", 22,"JAVA",7.0),
                new Student("Pedro", 23,"JAVA",7.0),
                new Student("Sofía", 24,"PHP",8.0),
                new Student("Ana", 20,"JAVA",9.0),
                new Student("Luis", 21,"Php",10.0),
                new Student("María", 22,"JAVA",2.0),
                new Student("Pedro", 23,"PHP",3.0),
                new Student("Sofía", 24,"JAVA",0)).collect(Collectors.toCollection(ArrayList::new));

        System.out.println("All students: ");
        studentList.forEach(student -> System.out.println(student.getName() + " " + student.getAge()));

        List<Student> studentsBeginWithA = studentList.stream().filter(student -> student.getName().toLowerCase().charAt(0) == 'a').toList();

        System.out.println("\nStudents begin with A:");
        studentsBeginWithA.forEach(System.out::println);

        System.out.print("\nPassed: ");
        studentList.stream().filter(student -> student.getGrade() >= 5).forEachOrdered(System.out::println);

        System.out.print("\nPassed not PHP course:  ");
        studentList.stream().filter(student -> student.getGrade() >= 5 && !student.getCourse().equalsIgnoreCase("PHP" )).forEachOrdered(System.out::println);

        System.out.print("\nAdults +18 JAVA course: ");
        studentList.stream().filter(student -> student.getCourse().equalsIgnoreCase( "JAVA") && student.getAge() > 17).forEachOrdered(System.out::println);

    }
}