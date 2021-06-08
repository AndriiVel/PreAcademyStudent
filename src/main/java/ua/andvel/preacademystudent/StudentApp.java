package ua.andvel.preacademystudent;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @author Andrii Velychko
 */
class StudentApp {

    private PreAcademyStudent[] studentsToSort;

    /**
     * Get data needed for {@link PreAcademyStudent} creation.
     *
     * @param times number of students to ask data for
     * @return      array of students
     */
    PreAcademyStudent[] getStudentsFromConsole(int times) {
        Scanner sc = new Scanner(System.in);
        PreAcademyStudent[] preAcademyStudents = new PreAcademyStudent[times];
        for (int i = 0; i < times; i++) {
            String firstName = getFromConsoleStudentFirstName(sc, i + 1);
            String lastName = getFromConsoleStudentLastName(sc, i + 1);
            int lecturePoints = getFromConsolePointsFor("lectures", sc, i + 1);
            int tasksPoints = getFromConsolePointsFor("tasks", sc, i + 1);
            int activityPoints = getFromConsolePointsFor("activity", sc, i + 1);
            preAcademyStudents[i] = new PreAcademyStudent(firstName, lastName, lecturePoints, tasksPoints,
                    activityPoints);
        }
        return preAcademyStudents;
    }

    private int getFromConsolePointsFor(String activityName, Scanner sc, int studentNumber) {
        boolean validNumber = false;
        int points = 0;

        while (!validNumber) {
            System.out.printf("Enter student %d points for %s:%n", studentNumber, activityName);
            try {
                points = sc.nextInt();
                validNumber = true;
            } catch (InputMismatchException ime) {
                System.err.println("Entered value is not a valid number!");
                sc.next();
            }
        }

        return points;
    }

    private String getFromConsoleStudentFirstName(Scanner sc, int id) {
        System.out.printf("Enter student %d first name:%n", id);
        return sc.nextLine();
    }

    private String getFromConsoleStudentLastName(Scanner sc, int id) {
        System.out.printf("Enter student %d last name:%n", id);
        return sc.nextLine();
    }

    /**
     * Sorts an array of {@link PreAcademyStudent} according to provided function. Sorting is done in reversed
     * order, where students with higher score appear at the beginning of the array.
     *
     * @param function a function that retrieves type of points based on which the sorting should be done
     * @return         sorted array
     */
    PreAcademyStudent[] orderStudentsPer(ToIntFunction<? super PreAcademyStudent> function, PreAcademyStudent[] preAcademyStudents) {
        Comparator<PreAcademyStudent> comparator = PreAcademyStudent.getComparatorFor(function);
        Arrays.sort(preAcademyStudents, Collections.reverseOrder(comparator));
        return preAcademyStudents;
    }

    /**
     * Sorts students per their total points. Sorting is done in reversed order, where students with higher score
     * appear at the beginning of the array.
     *
     * @param preAcademyStudents array to be sorted
     * @return                   sorted array
     */
    PreAcademyStudent[] orderStudentsPerAllPoints(PreAcademyStudent[] preAcademyStudents) {
        Comparator<PreAcademyStudent> comparator = PreAcademyStudent.getComparatorFor(PreAcademyStudent::totalPoints);
        Arrays.sort(preAcademyStudents, Collections.reverseOrder(comparator));
        return preAcademyStudents;
    }

    /**
     * Sorts students per their lectures points. Sorting is done in reversed order, where students with higher score
     * appear at the beginning of the array.
     *
     * @param preAcademyStudents array to be sorted
     * @return                   sorted array
     */
    PreAcademyStudent[] orderStudentsPerLecturesPoints(PreAcademyStudent[] preAcademyStudents) {
        Comparator<PreAcademyStudent> comparator = PreAcademyStudent.getComparatorFor(PreAcademyStudent::lecturesPoints);
        Arrays.sort(preAcademyStudents, Collections.reverseOrder(comparator));
        return preAcademyStudents;
    }

    /**
     * Sorts students per their tasks points. Sorting is done in reversed order, where students with higher score
     * appear at the beginning of the array.
     *
     * @param preAcademyStudents array to be sorted
     * @return                   sorted array
     */
    PreAcademyStudent[] orderStudentsPerTasksPoints(PreAcademyStudent[] preAcademyStudents) {
        Comparator<PreAcademyStudent> comparator = PreAcademyStudent.getComparatorFor(PreAcademyStudent::tasksPoints);
        Arrays.sort(preAcademyStudents, Collections.reverseOrder(comparator));
        return preAcademyStudents;
    }

    /**
     * Sorts students per their activity points. Sorting is done in reversed order, where students with higher score
     * appear at the beginning of the array.
     *
     * @param preAcademyStudents array to be sorted
     * @return                   sorted array
     */
    PreAcademyStudent[] orderStudentsPerActivityPoints(PreAcademyStudent[] preAcademyStudents) {
        Comparator<PreAcademyStudent> comparator = PreAcademyStudent.getComparatorFor(PreAcademyStudent::activityPoints);
        Arrays.sort(preAcademyStudents, Collections.reverseOrder(comparator));
        return preAcademyStudents;
    }

    /**
     * Sets the the array to sort. This method should be used in conjunction with
     * {@link StudentApp#per(ToIntFunction)}
     *
     * @param  preAcademyStudents array that should be later sorted
     * @return                    same object on which the method was called
     */
    StudentApp order(PreAcademyStudent[] preAcademyStudents) {
        studentsToSort = preAcademyStudents;
        return this;
    }

    /**
     * Sorts students according to provided function. Sorting is done in reversed order, where students with higher
     * score appear at the beginning of the array.
     * This method is similar to {@link StudentApp#orderStudentsPer(ToIntFunction, PreAcademyStudent[])}, however the
     * {@link StudentApp#order(PreAcademyStudent[])} method should be called first to specify the array of
     * {@link PreAcademyStudent} to sort.
     *
     * @param function a function that retrieves type of points based on which the sorting should be done
     * @return         sorted array
     */
    PreAcademyStudent[] per(ToIntFunction<? super PreAcademyStudent> function) {
        Comparator<PreAcademyStudent> comparator = PreAcademyStudent.getComparatorFor(function);
        Arrays.sort(studentsToSort, Collections.reverseOrder(comparator));
        return studentsToSort;
    }
}
