package project.src;

public abstract class User {
    String userId;
    String userName;
    String password;
    String name;
    String email;
    String role;
    String address;
    String emergencyContactName;
    String emergencyContactNumber;
    String phoneNumber;

    public User(String userId , String userName , String password , String name ,  String email , String role , String address ,String emergencyContactName , String emergencyContactNumber , String phoneNumber){
        this.userId = userId;
        this.userName = userName;
        this.password = password ;
        this.name = name;
        this.email =  email;
        this.role = role;
        this.address = address;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
        this.phoneNumber = phoneNumber;
    }

    public void setUserId(){
        this.userId = userId;
    };

    public String getUserId(){
        return userId;
    };


    public void setUserIName(){
        this.userName = userName;
    };

    public String getUserName(){
        return userName;
    };


    public void setPassword(){
        this.password = password;
    };

    public String getPassword(){
        return password;
    };


    public void setName(){
        this.name = name;
    };

    public String getName(){
        return name;
    };



    public void setEmail(){
        this.email = email;
    };

    public String getEmail(){
        return email;
    };


    public void setRole(){
        this.role = role;
    };

    public String getRole(){
        return role;
    };

    // to make sure the password is valid and not less than 6

    public boolean logIn (String userName , String password){
        if (password.length()<6){
            System.out.println("ERROR : Password must be at least 6 characters ! ");
            return false;
        }


        // to check if  password when log in saved password
        if (this.password.equals(password)){
            System.out.println("Login successful! Welcome, " + this.name );
            return true;
        }
        else {
            System.out.println("Invalid password! \n Please try again");
            return false;
        }
    }

    public void updateProfile (String address , String emergencyContactName , String emergencyContactNumber , String newPhoneNumber ){
        this.address = address;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
        this.phoneNumber = newPhoneNumber;

        System.out.println("Profile updated successfully ! ");

    }

    // to change sensetive data as password

    public boolean changePassword (String oldPass ,String newPass){
        if (this.password.equals(oldPass)){
            System.out.println("Current password is incorrect");
            return false;
        }
        if (newPass == null || newPass.length() < 6 ){
            System.out.println("New password must be at least 6 characters");
            return false;
        }

        // to check if new pass is same as old pass
        if (this.password.equals(newPass)){
            System.out.println("New password should be diffrent than the old one ");
            return false;
        }

        this.password = newPass;
        System.out.println("Password changed successfully! ");
        return true;



    }


    public abstract void displayDashboard();
    public abstract void generateReport();
}
