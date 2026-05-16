import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String studentId;
    private String admissionDate;
    private String academicStatus;
    private List<Enrollment> enrolledCourses;
    private int maxCredits = 18;

    public Student(String userId, String userName, String password, String name, String email, String role,
            String studentId, String admissionDate, String academicStatus) {
        super(userId, userName, password, name, email, role);
        this.studentId = studentId;
        this.admissionDate = admissionDate;
        this.academicStatus = academicStatus;
        this.enrolledCourses = new ArrayList<>();
    }

    public boolean registerForCourse(Enrollment enrollment) {
        int currentCredits = enrolledCourses.stream().mapToInt(Enrollment::getCreditHours).sum();
        if (currentCredits + enrollment.getCreditHours() <= maxCredits) {
            enrolledCourses.add(enrollment);
            return true;
        } else {
            System.out.println("no credits");
            return false;
        }
    }

    public boolean dropCourse(String courseId) {
        for (int i = 0; i < enrolledCourses.size(); i++) {
            Enrollment enrollment = enrolledCourses.get(i);
            if (enrollment.getCourseId().equals(courseId)) {
                enrolledCourses.remove(i);
                return true;
            }
        }
        return false;
    }

    public void viewGrades() {
        System.out.println("Grades for " + getName() + ":");
        for (Enrollment e : enrolledCourses) {
            System.out.println(e.getCourseTitle() + ": " + e.getLetterGrade() + " (" + e.getGrade() + ")");
        }
    }

    public double calculateGPA() {
        if (enrolledCourses.isEmpty())
            return 0.0;
        double totalPoints = 0;
        int totalCredits = 0;
        for (Enrollment e : enrolledCourses) {
            if (e.getStatus().equals("Completed")) {
                totalPoints += e.getGradePoints() * e.getCreditHours();
                totalCredits += e.getCreditHours();
            }
        }
        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + studentId);
        System.out.println("Status: " + academicStatus);
        System.out.println("GPA: " + calculateGPA());
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
    }

    @Override
    public void generateReport() {
        System.out.println("Student: " + getName() + " ID: " + studentId + "");
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Academic Status: " + academicStatus);
        System.out.println("GPa: " + calculateGPA());
        System.out.println("Courses:");
        for (Enrollment e : enrolledCourses) {
            System.out.println(
                    "course: " + e.getCourseId() + ": " + e.getCourseTitle() + " Credits: " + e.getCreditHours()
                            + "  Grade: " + e.getLetterGrade());
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(String academicStatus) {
        this.academicStatus = academicStatus;
    }

    public List<Enrollment> getEnrolledCourses() {
        return enrolledCourses;
    }

    public int getMaxCredits() {
        return maxCredits;
    }

    public void setMaxCredits(int maxCredits) {
        this.maxCredits = maxCredits;
    }
}
