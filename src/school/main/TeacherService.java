package school.main;

import school.*;
import school.enums.Degree;
import school.enums.TeacherType;

import java.util.*;

public class TeacherService {
    List<Teacher> teacherList = new ArrayList<>();
    List<School> schools = new ArrayList<>();
    List<Course> courses = new ArrayList<>();


    public TeacherService() {
        teacherList.add(new FullTimeTeacher("mina", "minayi", "0015512131",
                Degree.PHD, new HashSet<>(), 15, new HashSet<>(), 46, 10000000));
        teacherList.add(new FullTimeTeacher("ali", "safarzade", "0019922131",
                Degree.BS, new HashSet<>(), 3, new HashSet<>(), 27, 4000000));

        teacherList.add(new FullTimeTeacher("morteza", "qolami", "0115512222",
                Degree.BS, new HashSet<>(), 1, new HashSet<>(), 25, 3000000));
        teacherList.add(new FullTimeTeacher("safar", "mortazavi", "2315513181",
                Degree.PHD, new HashSet<>(), 25, new HashSet<>(), 60, 13000000));

        teacherList.add(new PartTimeTeacher("reza", "molayi", "0098712131",
                Degree.PHD, new HashSet<>(), 9, new HashSet<>(), 36, 56, 500000));

        teacherList.add(new PartTimeTeacher("maryam", "vahidi", "0298772431",
                Degree.MA, new HashSet<>(), 4, new HashSet<>(), 29, 80, 200000));

        teacherList.add(new PartTimeTeacher("mina", "shams", "0098532551",
                Degree.BS, new HashSet<>(), 2, new HashSet<>(), 26, 60, 150000));

    }

    public Optional<Teacher> findByPersonalCode(String personalCode) {
        return teacherList.stream().filter(i -> i.getPersonalNumber().equalsIgnoreCase(personalCode)).findAny();

    }

    public Optional<School> findSchoolByName(String name) {
        return schools.stream().filter(school -> school.getName().equalsIgnoreCase(name)).findAny();

    }

    public Optional<Course> findCourseByName(String name) {
        return courses.stream().filter(course -> course.getName().equalsIgnoreCase(name)).findAny();

    }

    public void addNewSchool(String personalCode, String name) {
        Optional<Teacher> teacher = findByPersonalCode(personalCode);
        Optional<School> school = findSchoolByName(name);

        if (teacher.isPresent() && school.isPresent()) {
            if (!(teacher.get().getSchool().contains(school.get()))) {
                teacher.get().addSchool(school.get());
            } else {
                throw new RuntimeException("school is duplicate in teacher list");
            }
        } else {
            throw new RuntimeException("teacher or school name is wrong");
        }
    }

    public void addNewCourse(String personalCode, String name) {
        Optional<Teacher> teacher = findByPersonalCode(personalCode);
        Optional<Course> course = findCourseByName(name);
        if (teacher.isPresent() && course.isPresent()) {
            if (!(teacher.get().getCourse().contains(course.get()))) {
                teacher.get().addCourse(course.get());
            } else {
                throw new RuntimeException("Course is duplicate in teacher list");
            }
        } else {
            throw new RuntimeException("teacher or course name is wrong");
        }
    }

    public Double calculateAverageSalary() {
        Double sum = teacherList.stream().filter(teacher -> teacher.getType().equals(TeacherType.FULL_TIME))
                .map(i -> i.calculateSalary()).reduce(0D, Double::sum);
        int count = (int) teacherList.stream().filter(teacher -> teacher.getType()
                .equals(TeacherType.FULL_TIME)).count();

        return sum / count;
    }

}
