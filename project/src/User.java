public abstract class User {
    String userId;
    String userName;
    String password;
    String name;
    String email;
    String role;

    public User(String userId , String userName , String password , String name ,  String email , String role ){
        this.userId = userId;
        this.userName = userName;
        this.password = password ;
        this.name = name;
        this.email =  email;
        this.role = role;
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

    public boolean logIn (String userName , String password){
        return false;
    }

    public abstract void displayDashboard();
    public abstract void generateReport();
}
