public interface gradingsystem {

    double maxGpa = 4;
    double minPassing = 1;


    void assignGrade();
    double calculateGPA();
    String getLetterGrade();
    boolean hasPassed();
}
