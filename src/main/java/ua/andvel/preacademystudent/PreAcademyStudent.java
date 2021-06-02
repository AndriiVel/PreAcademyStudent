package ua.andvel.preacademystudent;

import java.util.Comparator;

/**
 * @author Andrii Velychko
 */
class PreAcademyStudent implements Comparable<PreAcademyStudent> {

    private final String name;
    private final double lecturePoints;
    private final double tasksPoints;
    private final double activityPoints;
    private int finalGrade;

    PreAcademyStudent(String name, double lecturePoints, double tasksPoints, double activityPoints) {
        this.name = name;
        this.lecturePoints = lecturePoints;
        this.tasksPoints = tasksPoints;
        this.activityPoints = activityPoints;
    }

    static Comparator<PreAcademyStudent> getComparatorPerLecturePoints() {
        // (o1, o2) -> Double.compare(o1.lecturePoints, o2.lecturePoints)
        return Comparator.comparingDouble(o -> o.lecturePoints);
    }

    static Comparator<PreAcademyStudent> getComparatorPerTasksPoints() {
        return Comparator.comparingDouble(o -> o.tasksPoints);
    }

    static Comparator<PreAcademyStudent> getComparatorPerActivityPoints() {
        return Comparator.comparingDouble(o -> o.activityPoints);
    }

    double getAllPoints() {
        return lecturePoints + tasksPoints + activityPoints;
    }

    @Override
    public int compareTo(PreAcademyStudent o) {
        return Double.compare(this.getAllPoints(), o.getAllPoints());
    }

    void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }

    @Override
    public String toString() {
        return "PreAcademyStudent{" +
                "name='" + name + '\'' +
                ", lecturePoints=" + lecturePoints +
                ", tasksPoints=" + tasksPoints +
                ", activityPoints=" + activityPoints +
                ", finalGrade=" + finalGrade +
                '}';
    }
}
