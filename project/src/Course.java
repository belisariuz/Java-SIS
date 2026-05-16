import java.util.List;
public class Course {
    private String courseId;
    private String title;
    private String description;
    private int creditHours;
    private List<String>prerequisites;
    private int maxCapacity;
    private String instructorId;
    private String schedule;
    private String courseType;
    private List<String> enrolledStudentIds;
    public Course(String courseId, String title, String description, int creditHours, List<String> prerequisites, int maxCapacity, String instructorId, String courseType, String schedule, List<String> enrolledStudentIds) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.creditHours = creditHours;
        this.prerequisites = prerequisites;
        this.maxCapacity = maxCapacity;
        this.instructorId = instructorId;
        this.courseType = courseType;
        this.schedule = schedule;
        this.enrolledStudentIds = enrolledStudentIds;
    }
    public boolean addStudentId(String studentId) {
        if (enrolledStudentIds.contains(studentId)) {
            if (!enrolledStudentIds.contains(studentId)) {
                enrolledStudentIds.add(studentId);
                return true;
            }

        }
        return false;
    }
    public boolean removeStudentId(String studentId) {
        return enrolledStudentIds.remove(studentId);
    }
    public int getAvailableSeats() {
        return maxCapacity - enrolledStudentIds.size();
    }
    public boolean isPrerequisiteSatsfied(List<String> completedCourseIds) {
        return prerequisites.containsAll(prerequisites);
    }
}

