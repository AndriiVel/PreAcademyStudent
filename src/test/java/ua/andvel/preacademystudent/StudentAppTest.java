package ua.andvel.preacademystudent;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * @author Andrii Velychko
 */
@Test

public class StudentAppTest {
    PreAcademyStudent[] students = {
            new PreAcademyStudent("A", "Z", 1, 2, 1),
            new PreAcademyStudent("B", "Y", 4, 3, 2),
            new PreAcademyStudent("C", "X", 3, 2, 2),
            new PreAcademyStudent("D", "W", 3, 5, 4),
            new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
    };
    StudentApp app = new StudentApp();


    public void testOrderStudentsPerShouldOrderPerAllPoints() {
        PreAcademyStudent[] expectedStudentsOrder = {
                new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
                new PreAcademyStudent("D", "W", 3, 5, 4),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("C", "X", 3, 2, 2),
                new PreAcademyStudent("A", "Z", 1, 2, 1),
        };

        PreAcademyStudent[] orderedStudents = app.orderStudentsPer(PreAcademyStudent::totalPoints, students);

        assertEquals(orderedStudents, expectedStudentsOrder);
    }

    public void testOrderStudentsPerShouldOrderPerLecturesPoints() {
        PreAcademyStudent[] expectedStudentsOrder = {
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
                new PreAcademyStudent("C", "X", 3, 2, 2),
                new PreAcademyStudent("D", "W", 3, 5, 4),
                new PreAcademyStudent("A", "Z", 1, 2, 1),
        };

        PreAcademyStudent[] orderedStudents = app.orderStudentsPer(PreAcademyStudent::lecturesPoints, students);

        assertEquals(orderedStudents, expectedStudentsOrder);
    }

    public void testOrderStudentsPerShouldOrderPerTasksPoints() {
        PreAcademyStudent[] expectedStudentsOrder = {
                new PreAcademyStudent("D", "W", 3, 5, 4),
                new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("A", "Z", 1, 2, 1),
                new PreAcademyStudent("C", "X", 3, 2, 2),
        };

        PreAcademyStudent[] orderedStudents = app.orderStudentsPer(PreAcademyStudent::tasksPoints, students);

        assertEquals(orderedStudents, expectedStudentsOrder);
    }

    public void testOrderStudentsPerShouldOrderPerActivityPoints() {
        PreAcademyStudent[] expectedStudentsOrder = {
                new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
                new PreAcademyStudent("D", "W", 3, 5, 4),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("C", "X", 3, 2, 2),
                new PreAcademyStudent("A", "Z", 1, 2, 1),
        };

        PreAcademyStudent[] orderedStudents = app.orderStudentsPer(PreAcademyStudent::activityPoints, students);

        assertEquals(orderedStudents, expectedStudentsOrder);
    }

    public void testOrderStudentsPerAllPoints() {
        PreAcademyStudent[] expectedStudentsOrder = {
                new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
                new PreAcademyStudent("D", "W", 3, 5, 4),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("C", "X", 3, 2, 2),
                new PreAcademyStudent("A", "Z", 1, 2, 1),
        };

        PreAcademyStudent[] orderedStudents = app.orderStudentsPerAllPoints(students);

        assertEquals(orderedStudents, expectedStudentsOrder);
    }

    public void testOrderStudentsPerLecturesPoints() {
        PreAcademyStudent[] expectedStudentsOrder = {
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
                new PreAcademyStudent("C", "X", 3, 2, 2),
                new PreAcademyStudent("D", "W", 3, 5, 4),
                new PreAcademyStudent("A", "Z", 1, 2, 1),
        };

        PreAcademyStudent[] orderedStudents = app.orderStudentsPerLecturesPoints(students);

        assertEquals(orderedStudents, expectedStudentsOrder);
    }

    public void testOrderStudentsPerTasksPoints() {
        PreAcademyStudent[] expectedStudentsOrder = {
                new PreAcademyStudent("D", "W", 3, 5, 4),
                new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("A", "Z", 1, 2, 1),
                new PreAcademyStudent("C", "X", 3, 2, 2),
        };

        PreAcademyStudent[] orderedStudents = app.orderStudentsPerTasksPoints(students);

        assertEquals(orderedStudents, expectedStudentsOrder);
    }

    public void testOrderStudentsPerActivityPoints() {
        PreAcademyStudent[] expectedStudentsOrder = {
                new PreAcademyStudent("Ba", "Wa", 4, 4, 4),
                new PreAcademyStudent("D", "W", 3, 5, 4),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("C", "X", 3, 2, 2),
                new PreAcademyStudent("A", "Z", 1, 2, 1),
        };

        PreAcademyStudent[] orderedStudents = app.orderStudentsPerActivityPoints(students);

        assertEquals(orderedStudents, expectedStudentsOrder);
    }

    public void testOrderShouldSetArray() throws NoSuchFieldException, IllegalAccessException {
        StudentApp studentApp = new StudentApp();
        Field field = StudentApp.class.getDeclaredField("studentsToSort");
        field.setAccessible(true);

        studentApp.order(students);
        PreAcademyStudent[] fieldValue = (PreAcademyStudent[]) field.get(studentApp);

        assertEquals(fieldValue, students);
    }

    public void testOrderShouldHaveSameFieldClass() throws NoSuchFieldException {
        StudentApp studentApp = new StudentApp();
        Field field = StudentApp.class.getDeclaredField("studentsToSort");

        studentApp.order(students);

        assertEquals(field.getType(), PreAcademyStudent[].class);
    }

    public void testOrderShouldSetProperArray() throws NoSuchFieldException, IllegalAccessException {
        StudentApp studentApp = new StudentApp();
        Field field = StudentApp.class.getDeclaredField("studentsToSort");
        PreAcademyStudent[] fakeStudents = new PreAcademyStudent[] {
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
                new PreAcademyStudent("B", "Y", 4, 3, 2),
        };
        field.setAccessible(true);

        studentApp.order(students);
        PreAcademyStudent[] fieldValue = (PreAcademyStudent[]) field.get(studentApp);

        assertNotEquals(fieldValue, fakeStudents);
    }

    public void testPer() throws NoSuchFieldException, IllegalAccessException {
        StudentApp studentApp = new StudentApp();
        PreAcademyStudent[] studentsOrderedByTotalPoints = {
                new PreAcademyStudent("B", "Y", 5, 5, 5),
                new PreAcademyStudent("B", "Y", 3, 3, 3),
                new PreAcademyStudent("D", "W", 1, 1, 1),
        };
        PreAcademyStudent[] studentsNotOrdered = {
                new PreAcademyStudent("B", "Y", 3, 3, 3),
                new PreAcademyStudent("D", "W", 1, 1, 1),
                new PreAcademyStudent("B", "Y", 5, 5, 5),
        };
        Field field = StudentApp.class.getDeclaredField("studentsToSort");
        field.setAccessible(true);
        field.set(studentApp, studentsNotOrdered);

        PreAcademyStudent[] studentsOrdered = studentApp.per(PreAcademyStudent::totalPoints);

        assertEquals(studentsOrdered, studentsOrderedByTotalPoints);
    }

    public void testCreateSevenPreAcademyStudents() {
        int expectedSize = 7;

        assertEquals(app.createSevenPreAcademyStudents().length, expectedSize);
    }
}
