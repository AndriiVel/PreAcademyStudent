package ua.andvel.preacademystudent;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author Andrii Velychko
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentApp app = new StudentApp();
//        PreAcademyStudent[] preAcademyStudents = app.createStudents(sc, 4);
        PreAcademyStudent[] preAcademyStudents = {
                new PreAcademyStudent("A", 2, 3, 4),
                new PreAcademyStudent("B", 2, 1, 4),
                new PreAcademyStudent("C", 5, 3, 2),
                new PreAcademyStudent("D", 4, 2, 3),
        };

        System.out.println("Grading per all points: ");
        PreAcademyStudent[] gradedStudentsPerAllPoints = app.gradeStudentsPerAllPoints(preAcademyStudents);
        Arrays.stream(gradedStudentsPerAllPoints).forEach(x -> System.out.println(x));

        System.out.println("Grading per lectures points: ");
        PreAcademyStudent[] gradedStudentsPerLecturesPoints = app.gradeStudentsPerLecturesPoints(preAcademyStudents);
        Arrays.stream(gradedStudentsPerLecturesPoints).forEach(x -> System.out.println(x));

        System.out.println("Grading per tasks points: ");
        PreAcademyStudent[] gradedStudentsPerTasksPoints = app.gradeStudentsPerTasksPoints(preAcademyStudents);
        Arrays.stream(gradedStudentsPerTasksPoints).forEach(x -> System.out.println(x));

        System.out.println("Grading per activity points: ");
        PreAcademyStudent[] gradedStudentsPerActivityPoints = app.gradeStudentsPerActivityPoints(preAcademyStudents);
        Arrays.stream(gradedStudentsPerActivityPoints).forEach(x -> System.out.println(x));




    }
}
