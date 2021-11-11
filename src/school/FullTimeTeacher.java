package school;

import school.enums.Degree;
import school.enums.TeacherType;

import java.util.Set;

public class FullTimeTeacher extends Teacher {
    private double baseSalary;
    public FullTimeTeacher(String name, String lastName, String personalCode, Degree degree
            , Set<School> school, Integer experienceYear, Set<Course> course, int age, double baseSalary) {
        super(name, lastName, personalCode, degree, school, experienceYear, course, age);
        this.baseSalary = baseSalary;
        this.setType(TeacherType.FULL_TIME);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public Double calculateSalary() {
        return baseSalary - super.calculateInsurance(baseSalary) - super.calculateTax(baseSalary);
    }

    @Override
    public String toString() {
        return "FullTimeTeacher{" +
                "name=" + this.getName() + ' ' +
                ", lastName=" + this.getLastName() + ' ' +
                ", personalNumber=" + this.getPersonalNumber() + ' ' +
                ", degree=" + this.getDegree().toString() +
                ", experienceYear=" + this.getExperienceYear() +
                ", age=" + this.getAge() +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
