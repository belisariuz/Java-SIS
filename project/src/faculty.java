import java.lang.reflect.Array;
import java.util.*;


   class faculty extends User implements gradingsystem {
    String facultyuid;
    String expertise;
    String officehours;
    String officelocation;
    ArrayList<String> coursesTeaching;
    Map<String,Map<String,Double>> gradebook;

    public void assignToCourse(String courseId) {
        courseId  =courseId;
    }
    public void viewStudentRoster(String courseId) {
        System.out.println("Student roster is assigned to course "+courseId);
    }
    public void assignGrade(String courseId, String studentId, double grade) {
        courseId=courseId;
        studentId=studentId;
        grade=grade;
    }
    @Override
    public void assignGrade() {
        System.out.println("graded");
    }
    public double calculateGPA() {
        return 3.0;
    }
    @Override
    public String getLetterGrade() {
        return "b";
    }

}
