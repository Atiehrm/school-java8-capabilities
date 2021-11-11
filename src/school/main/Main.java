package school.main;

import school.Course;
import school.School;

public class Main {
    private static final TeacherService teacherService = new TeacherService();

    public static void main(String[] args) {

        Course course = new Course("math", 1);
        Course course1 = new Course("computer", 2);
        Course course2 = new Course("physic", 3);
        Course course3 = new Course("history", 4);
        Course course4 = new Course("art", 5);

        teacherService.courses.add(course);
        teacherService.courses.add(course1);
        teacherService.courses.add(course2);
        teacherService.courses.add(course3);
        teacherService.courses.add(course4);

        School school = new School("maktab", 1);
        School school1 = new School("madani", 2);
        School school2 = new School("alavi", 3);
        School school3 = new School("razavi", 3);
        School school4 = new School("jalal", 1);
        School school5 = new School("diba", 1);

        teacherService.schools.add(school);
        teacherService.schools.add(school1);
        teacherService.schools.add(school2);
        teacherService.schools.add(school3);
        teacherService.schools.add(school4);
        teacherService.schools.add(school5);

    }


}
