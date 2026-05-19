package project.src;


import java.sql.*;

public class DataBaseManager {
    private static String databaseURL = "jdbc:sqlite:university.db";
    private static DataBaseManager instance ;

    private Connection connection;
    // to establich the connection

    private DataBaseManager() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try{
            // to use the sqlite driver and open connection with database
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection(databaseURL);

            createTables();
            System.out.println("Data base successfully initialized");


        }
        catch (Exception e) {
            System.err.println("Data base connections failed : " + e.getMessage()) ;

        }
    }

    // creating the tables

    private void createTables (){
        try{

            // creation of statement to excute sql commands

            Statement stat = connection.createStatement();

            //Primary key is unique ID , unique not null is muste be unique
            // text not null is required
            // if only TEXT then its optional

            stat.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "userId TEXT PRIMARY KEY," +
                    "username TEXT UNIQUE NOT NULL," +
                    "password TEXT NOT NULL," +
                    "name TEXT NOT NULL," + "email TEXT," +
                    "contactInfo TEXT," +
                    "userRole TEXT NOT NULL," +
                    "CONSTRAINT valid_role CHECK (userRole IN ('STUDENT', 'FACULTY', 'ADMIN_STAFF', 'SYSTEM_ADMIN'))" +
                    ")");

            // table for students
            System.out.println(" Creating Students table ");
            stat.execute("CREATE TABLE IF NOT EXISTS students (" +
                    "studentId TEXT PRIMARY KEY," +
                    "userId TEXT NOT NULL UNIQUE," +
                    "admissionDate TEXT," +
                    "academicStatus TEXT," +
                    "gpa REAL DEFAULT 0.0," +
                    "FOREIGN KEY (userId) REFERENCES users(userId)" +
                    ")");


            // table for departments

            System.out.println("Create Departments table ");
            stat.execute("CREATE TABLE IF NOT EXISTS departments (" + "departmentId TEXT PRIMARY KEY," + "name TEXT NOT NULL UNIQUE," +
                    "headId TEXT," + "FOREIGN KEY (headId) REFERENCES faculty(facultyId)" + ")");

            // Courses tables

            System.out.println(" Making courses table ");
            stat.execute("CREATE TABLE IF NOT EXISTS courses (" + "courseId TEXT PRIMARY KEY," + "title TEXT NOT NULL," + "description TEXT," + "creditHours INT," +
                            "prerequisites TEXT," + "instructorId TEXT," + "departmentId TEXT," + "maxCapacity INT," + "currentEnrollment INT DEFAULT 0," + "schedule TEXT," +
                            "location TEXT," + "semester TEXT," + "FOREIGN KEY (instructorId) REFERENCES faculty(facultyId)," + "FOREIGN KEY (departmentId) REFERENCES departments(departmentId)" + ")");


            // enrolment tablee


            stat.execute("CREATE TABLE IF NOT EXISTS enrollments (" +
                            "enrollmentId INTEGER PRIMARY KEY AUTOINCREMENT,"+ "studentId TEXT NOT NULL," + "courseId TEXT NOT NULL," +
                            "enrollmentDate TEXT," + "grade TEXT," + "status TEXT," + "attendance INT DEFAULT 0," + "UNIQUE(studentId, courseId)," +
                    "FOREIGN KEY (studentId) REFERENCES students(studentId)," + "FOREIGN KEY (courseId) REFERENCES courses(courseId)"     + ")");


            // Assignments for each course
            stat.execute("CREATE TABLE IF NOT EXISTS assignments (" + "assignmentId INTEGER PRIMARY KEY AUTOINCREMENT," + // Auto ID
                    "courseId TEXT NOT NULL," + "title TEXT NOT NULL," + "description TEXT," + "dueDate TEXT," + "totalPoints INT," + "FOREIGN KEY (courseId) REFERENCES courses(courseId)"+ " )");



            System.out.println("Grades table ");
            stat.execute("CREATE TABLE IF NOT EXISTS grades (" +
                            "gradeId INTEGER PRIMARY KEY AUTOINCREMENT," + "enrollmentId INTEGER NOT NULL," + "assignmentId INTEGER," + "score INT," +
                            "FOREIGN KEY (enrollmentId) REFERENCES enrollments(enrollmentId)," +
                    "FOREIGN KEY (assignmentId) REFERENCES assignments(assignmentId)"  + ")");

            stat.close();
            System.out.println("All tables created");




        }
        catch (Exception e) {
            System.err.println("Table creation failed : " + e.getMessage());
        }



    }
    public int executeUpdate(String query, Object... params) {
        try {

            PreparedStatement pstmt = connection.prepareStatement(query);

            // Fill in the ? with actual values
            setParameters(pstmt, params);


            return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(" Database update error: " + e.getMessage());
            return 0;
        }
    }

    public ResultSet executeQuery(String query, Object... params) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            setParameters(pstmt, params);


            return pstmt.executeQuery();

        } catch (SQLException e) {
            // If error, print it and return null
            System.err.println(" Database query error: " + e.getMessage());
            return null;
        }
    }


    private void setParameters(PreparedStatement pstmt, Object[] params) throws SQLException {

        for (int i = 0; i < params.length; i++) {

            if (params[i] == null) {

                pstmt.setNull(i + 1, java.sql.Types.NULL);

            } else if (params[i] instanceof String) {
                pstmt.setString(i + 1, (String) params[i]);

            } else if (params[i] instanceof Integer) {

                pstmt.setInt(i + 1, (Integer) params[i]);

            } else if (params[i] instanceof Double) {
                pstmt.setDouble(i + 1, (Double) params[i]);

            } else if (params[i] instanceof Boolean) {
                pstmt.setBoolean(i + 1, (Boolean) params[i]);
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {

            if (connection != null && !connection.isClosed()) {
                // Close it
                connection.close();
                System.out.println(" Database connection closed");
            }
        } catch (SQLException e) {

            System.err.println(" Error closing database: " + e.getMessage());
        }
    }







}