package project.src;

import java.util.ArrayList;
import java.util.List;
public class Course {



    private String courseId;
    private String title;
    private String description;
    private int creditHours;
    private String prerequisites;
    private String instructorName;
    private String instructorId;
    private String departmentId;
    private int maxCapacity;
    private int currentlyEnrolled;
    private String semster;
    private String schedule;
    private String roomAssigned;
    private String labAssigned;
    private List <String> enrolledStudents;



    // constructor

    public Course( String courseId , String title , String description , int creditHours , String prerequisites ,
                   String instructorName , String instructorId , String departmentId ,int maxCapacity , int currentlyEnrolled ,
                   String semster , String schedule , String roomAssigned , String labAssigned) {
        this.courseId = courseId ;
        this.title = title ;
        this.description = description ;
        this.creditHours = creditHours;
        this.prerequisites = prerequisites;
        this.instructorName = instructorName;
        this.instructorId = instructorId;
        this.departmentId =departmentId;
        this.maxCapacity = maxCapacity;
        this.currentlyEnrolled = currentlyEnrolled;
        this.semster = semster;
        this.schedule = schedule;
        this.roomAssigned = roomAssigned;
        this.labAssigned = labAssigned;
        this.enrolledStudents = new ArrayList<>();
    }



    public boolean addStudent(String studentId) {
    if (currentlyEnrolled >= maxCapacity){
        System.out.println("Courses is at maximum capacity! \n join the waitlist till a seat is empty or someone withdraws ");
        return false;
    } else if (enrolledStudents.contains(studentId)) {
        System.out.println("You're already enrolled in this course !");
        return false;
    }
    enrolledStudents.add(studentId);
    currentlyEnrolled++;
    return true ;

    }


    public boolean  removeStudent(String studentId) {
        if (enrolledStudents.remove(studentId)){
            System.out.println("You have been successfully withdrawn/removed from this course");
            currentlyEnrolled--;
            return true;

        }
        else {
            return false;
        }
    }


    // che3cking if there is enough seats or if the course is full

    public boolean isFull(){
        return currentlyEnrolled >= maxCapacity;
    }

    public int getAvailableSeats() {
        return maxCapacity - enrolledStudents.size();
    }

    // checking if the students prerequisites meet the prerequisites of the course

    public boolean isPrerequisitesSatisfied (){
        return true;
    }

    // display details of department

    public void displayCourseDetails (){
        System.out.println("Course details : \n");
        System.out.println("Course code/ID : " + courseId );
        System.out.println("Title : " + title );
        System.out.println("Description : " + description);
        System.out.println("Credit hours : " + creditHours);
        System.out.println(" Prerequisites: " + (prerequisites  != null ? prerequisites : "No prerequisites needed"));
        System.out.println("Course Instructor name: " + instructorName);
        System.out.println("Course Instructor ID: " + instructorId);
        System.out.println("Schedule : " + schedule);
        System.out.println("Location and room assigned : " + roomAssigned);
        System.out.println("Semster : " + semster);
        System.out.println("Enrolled students = " + enrolledStudents);
        System.out.println("Max capacity = " + maxCapacity);
        System.out.println("Seats left = " + (maxCapacity - enrolledStudents.size()));
    }

    //getters

    public String getCourseId() {
        return courseId;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getLabAssigned() {
        return labAssigned;
    }

    public String getRoomAssigned() {
        return roomAssigned;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getSemster() {
        return semster;
    }

    public int getCurrentlyEnrolled() {
        return currentlyEnrolled;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    // Setters


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSemster(String semster) {
        this.semster = semster;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setRoomAssigned(String roomAssigned) {
        this.roomAssigned = roomAssigned;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }


}
