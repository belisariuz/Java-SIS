public class Enrollment {
    private String courseId;
    private String courseTitle;
    private int creditHours;
    private double grade;
    private String status;
    private String enrollmentDate;

    public Enrollment(String courseId, String courseTitle, int creditHours, String enrollmentDate) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.creditHours = creditHours;
        this.grade = 0.0;
        this.status = "Enrolled";
        this.enrollmentDate = enrollmentDate;
    }

    public void setGrade(double grade) {
        this.grade = grade;
        this.status = "Completed";
    }

    public String getLetterGrade() {
        if (grade >= 90)
            return "A";
        if (grade >= 80)
            return "B";
        if (grade >= 70)
            return "C";
        if (grade >= 60)
            return "D";
        return "F";
    }

    public double getGradePoints() {
        if (grade >= 90)
            return 4.0;
        if (grade >= 80)
            return 3.0;
        if (grade >= 70)
            return 2.0;
        if (grade >= 60)
            return 1.0;
        return 0.0;
    }

    public void withdraw() {
        this.status = "Withdrawn";
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public double getGrade() {
        return grade;
    }

    public String getStatus() {
        return status;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }
}
