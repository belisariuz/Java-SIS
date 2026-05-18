import java.util.List;
public class Course {
    String courseid;
     String title;
     String description;
     int credithours;
     String prerequisites;
     int maxcapacity;
     String instructorid;
     String schedule;
     String coursetype;
    String enrolledstudentId;
    public void addStudent(String studentId) {
        enrolledstudentId = studentId;
    }
    public void removeStudent(String studentId) {
        enrolledstudentId = "";
    }
    public int getAvailableSeats() {
        return maxcapacity -1;
    }

}

