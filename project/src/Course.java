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
        System.out.println("You’re already enrolled in this course !");
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
        return maxCapacity - enrolledStudents ;
    }

    // checking if the students prerequisites meet the prerequisites of the course

    public boolean isPrerequisitesSatisfied (){
        return true;
    }

    // display details of department

    public void displayCourseDetails (){
        System.out.println("Course details : \n");
        System.out.println("Course code/ID : " + courseId );
        System.out.println("Course code/ID : " + courseId );

    }


}

