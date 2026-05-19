package project.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Faculty extends User {
    private String facultyId;
    private String departmentId;
    private String expertise;
    private String officeHours;
    private String officeLocation;
    private List<String> coursesAvailable;
    private Map<String, Map<String, Double>> gradebook;

    public Faculty(String userId, String userName, String password, String name, String email,
                   String facultyId, String departmentId, String expertise, String officeHours, String officeLocation) {
        super(userId, userName, password, name, email, "FACULTY");
        this.facultyId = facultyId;
        this.departmentId = departmentId;
        this.expertise = expertise;
        this.officeHours = officeHours;
        this.officeLocation = officeLocation;
        this.coursesAvailable = new ArrayList<>();
        this.gradebook = new HashMap<>();
    }

    public void assignToCourse(String courseId) {
        if (!coursesAvailable.contains(courseId)) {
            coursesAvailable.add(courseId);
            gradebook.putIfAbsent(courseId, new HashMap<>());
        }
    }

    public void assignGrade(String courseId, String studentId, double grade) {
        if (gradebook.containsKey(courseId)) {
            gradebook.get(courseId).put(studentId, grade);
        } else {
            System.out.println("Course not found in gradebook: " + courseId);
        }
    }

    public double calculateGPA(String studentId) {
        double totalGrades = 0;
        int count = 0;
        for (Map<String, Double> students : gradebook.values()) {
            if (students.containsKey(studentId)) {
                totalGrades += students.get(studentId);
                count++;
            }
        }
        return count == 0 ? 0.0 : totalGrades / count;
    }

    public String getLetterGrade(double grade) {
        if (grade >= 90) return "A";
        if (grade >= 80) return "B";
        if (grade >= 70) return "C";
        if (grade >= 60) return "D";
        return "F";
    }

    public boolean hasPassed(double grade) {
        return grade >= 60.0;
    }

    @Override
    public void displayDashboard() {
        System.out.println("=== Faculty Dashboard ===");
        System.out.println("Name: " + getName());
        System.out.println("Faculty ID: " + facultyId);
        System.out.println("Department: " + departmentId);
        System.out.println("Expertise: " + expertise);
        System.out.println("Office Hours: " + officeHours);
        System.out.println("Office Location: " + officeLocation);
        System.out.println("Courses Teaching: " + coursesAvailable.size());
    }

    @Override
    public void generateReport() {
        System.out.println("=== Faculty Report ===");
        System.out.println("Name: " + getName() + " | ID: " + facultyId);
        System.out.println("Department: " + departmentId);
        System.out.println("Courses:");
        for (String courseId : coursesAvailable) {
            System.out.println("  - " + courseId);
        }
    }

    // Getters
    public String getFacultyId() { return facultyId; }
    public String getDepartmentId() { return departmentId; }
    public String getExpertise() { return expertise; }
    public String getOfficeHours() { return officeHours; }
    public String getOfficeLocation() { return officeLocation; }
    public List<String> getCoursesAvailable() { return coursesAvailable; }
    public Map<String, Map<String, Double>> getGradebook() { return gradebook; }

    // Setters
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }
    public void setExpertise(String expertise) { this.expertise = expertise; }
    public void setOfficeHours(String officeHours) { this.officeHours = officeHours; }
    public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }
}
