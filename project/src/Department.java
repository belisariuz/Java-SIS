package project.src;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentId;
    private String name;
    private String headOfDepartmentName ;
    private String headOfDepartmentId ;

    private List<String> facultyIds;
    private List <String > availableCourseIds;


    public Department( String departmentId , String name , String headOfDepartmentName , String headOfDepartmentId  ){
        this.departmentId = departmentId;
        this.name = name;
        this.headOfDepartmentName = headOfDepartmentName;
        this.headOfDepartmentId = headOfDepartmentId;
        this.facultyIds = new ArrayList<>();
        this.availableCourseIds = new ArrayList<>();

    }

    // methods
    public boolean addFaculty (String facultyId ){
        if (facultyIds.contains(facultyId)){
            return false;
        }
        else {
            return facultyIds.add(facultyId);
        }

    }

    public boolean removeFaculty (String facultyId){
        if (facultyIds.contains(facultyId)){
        facultyIds.remove(facultyId) ;
        return true;
        }
        else {
            System.out.println("Faculty not available");
        }
        return false;

    }

    // adding a course to department

    public boolean addCourse (String courseId ){
        if (availableCourseIds.contains(courseId)){
            return false;

        }
        return availableCourseIds.add(courseId);

    }


    public boolean removeCourse ( String courseId){
        return availableCourseIds.remove(courseId);

    }

    // getters for lists

    public List <String> getFacultyList (){

        return new ArrayList<>(facultyIds);

    }

    public List <String> getAvailableCourseIds (){

        return new ArrayList<>(availableCourseIds);

    }


    // display details of department

    public void displayDepartmentDetails (){
        System.out.println("Department details : \n");
        System.out.println("Department name : " + name);
        System.out.println("Department ID : " + departmentId);
        System.out.println("Head of department name : " + headOfDepartmentName);
        System.out.println("Faculty Members : ") ;
        for (int i = 0 ; i < facultyIds.size() ; i++){
            System.out.println((i+1) + " " + facultyIds.get(i));
        }

        System.out.println("Available courses : ");
        for (int i =0 ; i< availableCourseIds.size() ; i++){
            System.out.println((i+1) + " " + availableCourseIds.get(i));
        }
    }

    //Getters

    public String getDepartmentName () {
        return name;
    }

    public String getDepartmentId () {
        return departmentId;
    }

    public String getHeadOfDepartmentName () {
        return headOfDepartmentName;
    }

    public String getHeadOfDepartmentId () {
        return headOfDepartmentId;
    }

    public int facultyCount (){
        return facultyIds.size();
    }

    public int coursesCount (){
        return availableCourseIds.size();
    }

    // setters

    public void setName (String name){
        this.name = name;
    }

    public void setHeadOfDepartmentId (String HeadId){

        this.headOfDepartmentId = headOfDepartmentId;
    }

    public void setHeadOfDepartmentName (String HeadName){

        this.headOfDepartmentName = headOfDepartmentName;
    }







}
