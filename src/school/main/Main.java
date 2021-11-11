package school.main;

import school.Course;
import school.School;
import school.Teacher;

import java.util.List;

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

        List<Teacher> teachers = teacherService.getTeacherList();

        try {
            teacherService.addNewSchool(teachers.get(0).getPersonalNumber(), school.getName());
            teacherService.addNewSchool(teachers.get(4).getPersonalNumber(), school.getName());
            teacherService.addNewSchool(teachers.get(4).getPersonalNumber(), school1.getName());
            teacherService.addNewSchool(teachers.get(4).getPersonalNumber(), school4.getName());
            teacherService.addNewSchool(teachers.get(5).getPersonalNumber(), school2.getName());
            teacherService.addNewSchool(teachers.get(0).getPersonalNumber(), school2.getName());
            teacherService.addNewSchool(teachers.get(0).getPersonalNumber(), school3.getName());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("schools added by teacher " + teachers.get(0).getLastName() + ":\n" +
                teachers.get(0).getSchool());
        System.out.println("******************************************8");
        System.out.println("schools added by teacher " + teachers.get(4).getLastName() + ":\n" +
                teachers.get(4).getSchool());
        System.out.println("******************************************8");

        System.out.println("schools added by teacher " + teachers.get(5).getLastName() + ":\n" +
                teachers.get(5).getSchool());
        System.out.println("******************************************8");


        try {
            teacherService.addNewCourse(teachers.get(0).getPersonalNumber(), course.getName());
            teacherService.addNewCourse(teachers.get(4).getPersonalNumber(), course.getName());
            teacherService.addNewCourse(teachers.get(4).getPersonalNumber(), course1.getName());
            teacherService.addNewCourse(teachers.get(4).getPersonalNumber(), course4.getName());
            teacherService.addNewCourse(teachers.get(5).getPersonalNumber(), course2.getName());
            teacherService.addNewCourse(teachers.get(0).getPersonalNumber(), course2.getName());
            teacherService.addNewCourse(teachers.get(0).getPersonalNumber(), course3.getName());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("courses added by teacher " + teachers.get(0).getLastName() + ":\n" +
                teachers.get(0).getCourse());
        System.out.println("******************************************8");
        System.out.println("courses added by teacher " + teachers.get(4).getLastName() + ":\n" +
                teachers.get(4).getCourse());
        System.out.println("******************************************8");
        System.out.println("courses added by teacher " + teachers.get(5).getLastName() + ":\n" +
                teachers.get(5).getCourse());
        System.out.println("******************************************8");


        System.out.println(" average Salary: " + teacherService.calculateAverageSalary());
        System.out.println("******************************************8");

        teacherService.tenYearsExperienceMap().entrySet().stream().forEach(System.out::println);
        System.out.println("******************************************8");

        teacherService.partTimesWithMoreThan2CourseAndBsDegree().forEach(System.out::println);
        System.out.println("******************************************8");
        teacherService.schoolNamesSetInSystem().stream().forEach(System.out::println);
        System.out.println("******************************************8");
        teacherService.schoolNameMapTeachers().entrySet().stream().forEach(System.out::println);
    }


}
