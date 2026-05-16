import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class faculty {
    private String facultyId;
    private String department;
    private String expertise;
    private List<String> coursesTeaching;
    private String officeHours;
    private String officeLocation;
    private Map<String, Map<String, Double>> gradebook;
    public faculty(String facultyId, String department, String expertise, String officeHours, String officeLocation) {
        this.facultyId = facultyId;
        this.department = department;
        this.expertise = expertise;
        this.officeHours = officeHours;
        this.officeLocation = officeLocation;
        this.coursesTeaching = new ArrayList<>();
        this.gradebook = new HashMap<>();
    }
    public void assignToCourse(String courseId) {
        if (!coursesTeaching.contains(courseId)) {
            coursesTeaching.add(courseId);
            gradebook.putIfAbsent(courseId, new HashMap<>());
        }
    }

    public void assignGrade(String courseId, String studentId, double grade) {
        if (gradebook.containsKey(courseId)) {
            gradebook.get(courseId).put(studentId, grade);
        } else {
            System.out.println("not founded");
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
        return count == 0?0.0 : totalGrades / count;
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
}