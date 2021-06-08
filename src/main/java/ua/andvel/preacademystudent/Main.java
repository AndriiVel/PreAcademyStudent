package ua.andvel.preacademystudent;

import java.util.Arrays;

/**
 * @author Andrii Velychko
 */
class Main {
    public static void main(String[] args) {
        StudentApp app = new StudentApp();

//        PreAcademyStudent[] preAcademyStudents = app.getStudentsFromConsole(4);
        PreAcademyStudent[] preAcademyStudents = createSevenPreAcademyStudents();

        printOrderedStudentsUsingFourOrderMethods(app, preAcademyStudents);

        printOrderedStudentsUsingOneOrderMethod(app, preAcademyStudents);

        printOrderedStudentsUsingMethodsChaining(app, preAcademyStudents);
    }

    private static PreAcademyStudent[] createSevenPreAcademyStudents() {
        return new PreAcademyStudent[]{
                new PreAcademyStudent("A", "Z", 2, 3, 4),
                new PreAcademyStudent("B", "Y", 2, 1, 4),
                new PreAcademyStudent("C", "X", 5, 3, 2),
                new PreAcademyStudent("D", "W", 4, 2, 3),
                new PreAcademyStudent("E", "V", 3, 3, 3),
                new PreAcademyStudent("F", "U", 2, 4, 5),
                new PreAcademyStudent("G", "T", 3, 2, 4),
        };
    }

    private static void printOrderedStudentsUsingFourOrderMethods(StudentApp app,
                                                                  PreAcademyStudent[] preAcademyStudents) {
        System.out.println("\nRunning printOrderedStudentsUsingFourOrderMethods:");

        System.out.println("\nGrading per all points: ");
        PreAcademyStudent[] orderedStudentsPerAllPoints = app.orderStudentsPerAllPoints(preAcademyStudents);
        Arrays.stream(orderedStudentsPerAllPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per lectures points: ");
        PreAcademyStudent[] orderedStudentsPerLecturesPoints = app.orderStudentsPerLecturesPoints(preAcademyStudents);
        Arrays.stream(orderedStudentsPerLecturesPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per tasks points: ");
        PreAcademyStudent[] orderedStudentsPerTasksPoints = app.orderStudentsPerTasksPoints(preAcademyStudents);
        Arrays.stream(orderedStudentsPerTasksPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per activity points: ");
        PreAcademyStudent[] orderedStudentsPerActivityPoints = app.orderStudentsPerActivityPoints(preAcademyStudents);
        Arrays.stream(orderedStudentsPerActivityPoints)
                .forEach(System.out::println);
    }

    private static void printOrderedStudentsUsingOneOrderMethod(StudentApp app,
                                                                PreAcademyStudent[] preAcademyStudents) {
        System.out.println("\nRunning printOrderedStudentsUsingOneOrderMethod:");

        System.out.println("\nGrading per all points: ");
        PreAcademyStudent[] orderedStudentsPerAllPoints = app.orderStudentsPer(PreAcademyStudent::totalPoints,
                preAcademyStudents);
        Arrays.stream(orderedStudentsPerAllPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per lectures points: ");
        PreAcademyStudent[] orderedStudentsPerLecturesPoints = app.orderStudentsPer(PreAcademyStudent::lecturesPoints,
                preAcademyStudents);
        Arrays.stream(orderedStudentsPerLecturesPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per tasks points: ");
        PreAcademyStudent[] orderedStudentsPerTasksPoints = app.orderStudentsPer(PreAcademyStudent::tasksPoints,
                preAcademyStudents);
        Arrays.stream(orderedStudentsPerTasksPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per activity points: ");
        PreAcademyStudent[] orderedStudentsPerActivityPoints = app.orderStudentsPer(PreAcademyStudent::activityPoints,
                preAcademyStudents);
        Arrays.stream(orderedStudentsPerActivityPoints)
                .forEach(System.out::println);
    }

    private static void printOrderedStudentsUsingMethodsChaining(StudentApp app,
                                                                 PreAcademyStudent[] preAcademyStudents) {
        System.out.println("\nRunning printOrderedStudentsUsingMethodsChaining:");

        System.out.println("\nGrading per all points: ");
        PreAcademyStudent[] orderedStudentsPerAllPoints = app.order(preAcademyStudents)
                .per(PreAcademyStudent::totalPoints);
        Arrays.stream(orderedStudentsPerAllPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per lectures points: ");
        PreAcademyStudent[] orderedStudentsPerLecturesPoints = app.order(preAcademyStudents)
                .per(PreAcademyStudent::lecturesPoints);
        Arrays.stream(orderedStudentsPerLecturesPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per tasks points: ");
        PreAcademyStudent[] orderedStudentsPerTasksPoints = app.order(preAcademyStudents)
                .per(PreAcademyStudent::tasksPoints);
        Arrays.stream(orderedStudentsPerTasksPoints)
                .forEach(System.out::println);

        System.out.println("\nGrading per activity points: ");
        PreAcademyStudent[] orderedStudentsPerActivityPoints = app.order(preAcademyStudents)
                .per(PreAcademyStudent::activityPoints);
        Arrays.stream(orderedStudentsPerActivityPoints)
                .forEach(System.out::println);
    }
}
