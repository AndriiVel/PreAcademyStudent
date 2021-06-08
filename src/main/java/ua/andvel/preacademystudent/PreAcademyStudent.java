package ua.andvel.preacademystudent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

record PreAcademyStudent(String firstName, String lastName, int lecturesPoints, int tasksPoints, int activityPoints,
                         int totalPoints) implements Comparable<PreAcademyStudent> {

    /**
     * The total points are calculated as a sum of all points.
     * Students with the same grade are sorted by first name, based on a natural order.
     *
     * @param firstName      first name
     * @param lastName       last name
     * @param lecturesPoints total points for lectures
     * @param tasksPoints    total points for tasks
     * @param activityPoints total points for activity
     * @see PreAcademyStudent#getTotalPoints(int...)
     */
    PreAcademyStudent(String firstName, String lastName, int lecturesPoints, int tasksPoints, int activityPoints,
                      int totalPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lecturesPoints = lecturesPoints;
        this.tasksPoints = tasksPoints;
        this.activityPoints = activityPoints;
        this.totalPoints = getTotalPoints(lecturesPoints, tasksPoints, activityPoints);
    }

    PreAcademyStudent(String firstName, String lastName, int lecturesPoints, int tasksPoints, int activityPoints) {
        this(firstName, lastName, lecturesPoints, tasksPoints, activityPoints, 0);
    }

    private int getTotalPoints(int... pointsTypes) {
        return Arrays.stream(pointsTypes)
                .sum();
    }

    /**
     * Provides {@link Comparator} that uses the provided function based on which the comparison should be done.
     *
     * @param function a function that the Comparator will be based on
     * @return         a Comparator of students
     */
    static Comparator<PreAcademyStudent> getComparatorFor(ToIntFunction<? super PreAcademyStudent> function) {
        return Comparator.comparingInt(function);
    }

    @Override
    public int compareTo(PreAcademyStudent o) {
        return Integer.compare(this.totalPoints(), o.totalPoints());
    }
}
