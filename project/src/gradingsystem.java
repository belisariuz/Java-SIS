package project.src;

public interface GradingSystem {

    double maxGpa = 4.0;
    double minPassing = 1.0;

    void assignGrade(String courseId, String studentId, double grade);
    double calculateGPA(String studentId);
    String getLetterGrade(double grade);
    boolean hasPassed(double grade);
}
