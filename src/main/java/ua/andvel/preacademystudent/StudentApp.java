package ua.andvel.preacademystudent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Andrii Velychko
 */
class StudentApp {

    PreAcademyStudent[] createStudents(Scanner sc, int times) {
        PreAcademyStudent[] preAcademyStudents = new PreAcademyStudent[times];
        for (int i = 0; i < times; i++) {
            String name = getFromConsoleStudentName(sc, i + 1);
            double lecturePoints = getFromConsolePointsFor("lectures", sc, i + 1);
            double tasksPoints = getFromConsolePointsFor("tasks", sc, i + 1);
            double activityPoints = getFromConsolePointsFor("activity", sc, i + 1);
            preAcademyStudents[i] = new PreAcademyStudent(name, lecturePoints, tasksPoints, activityPoints);
        }
        return preAcademyStudents;
    }

    private double getFromConsolePointsFor(String activityName, Scanner sc, int studentNumber) {
        boolean validNumber = false;
        double points = 0;

        while (!validNumber) {
            System.out.printf("Enter student %d points for %s:%n", studentNumber, activityName);
            try {
                points = sc.nextDouble();
                validNumber = true;
            } catch (InputMismatchException ime) {
                System.err.println("Entered value is not a valid number!");
                sc.next();
            }
        }

        return points;
    }

    private String getFromConsoleStudentName(Scanner sc, int id) {
        System.out.printf("Enter student %d name:%n", id);
        return sc.nextLine();
    }

    // If students.length is 10 then best grade is 10
    private void gradeStudentsBySorting(PreAcademyStudent[] students) {
        IntStream.rangeClosed(0, students.length - 1)
                .forEach(num -> students[num].setFinalGrade(num + 1));
    }

    private PreAcademyStudent[] gradeStudentsWithComparator(PreAcademyStudent[] students,
                                                            Comparator<PreAcademyStudent> comp) {
        Arrays.sort(students, comp);
        gradeStudentsBySorting(students);
        return students;
    }

    PreAcademyStudent[] gradeStudentsPerAllPoints(PreAcademyStudent[] students) {
        Arrays.sort(students);
        gradeStudentsBySorting(students);
        return students;
    }

    PreAcademyStudent[] gradeStudentsPerLecturesPoints(PreAcademyStudent[] students) {
        return gradeStudentsWithComparator(students, PreAcademyStudent.getComparatorPerLecturePoints());
    }


    PreAcademyStudent[] gradeStudentsPerTasksPoints(PreAcademyStudent[] students) {
        return gradeStudentsWithComparator(students, PreAcademyStudent.getComparatorPerTasksPoints());
    }

    PreAcademyStudent[] gradeStudentsPerActivityPoints(PreAcademyStudent[] students) {
        return gradeStudentsWithComparator(students, PreAcademyStudent.getComparatorPerActivityPoints());
    }
}
