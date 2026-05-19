package project.src;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String universityName;
    private List<Department> departments;
    private List<Course> courses;
    private List<Student> students;
    private List<Faculty> faculty;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.faculty = new ArrayList<>();
    }

    public boolean addDepartment(Department department) {
        if (department == null) return false;
        departments.add(department);
        return true;
    }

    public boolean addCourse(Course course) {
        if (course == null) return false;
        courses.add(course);
        return true;
    }

    public boolean addStudent(Student student) {
        if (student == null) return false;
        students.add(student);
        return true;
    }

    public boolean addFaculty(Faculty f) {
        if (f == null) return false;
        faculty.add(f);
        return true;
    }

    public Student findStudentById(String studentId) {

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }

        return null;
    }

    public Course findCourseById(String courseId) {

        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.getCourseId().equals(courseId)) {
                return c;
            }
        }

        return null;
    }

    public Faculty findFacultyById(String facultyId) {

        for (int i = 0; i < faculty.size(); i++) {
            Faculty f = faculty.get(i);


            if (f.getFacultyId().equals(facultyId)) {
                return f;
            }
        }

        return null;
    }

    public void displayUniversityInfo() {
        System.out.println("University: " + universityName);
        System.out.println("Departments: " + departments.size());
        System.out.println("Courses: " + courses.size());
        System.out.println("Students: " + students.size());
        System.out.println("Faculty: " + faculty.size());
    }

    public String getUniversityName() { return universityName; }
    public List<Department> getDepartments() { return departments; }
    public List<Course> getCourses() { return courses; }
    public List<Student> getStudents() { return students; }
    public List<Faculty> getFaculty() { return faculty; }
}
