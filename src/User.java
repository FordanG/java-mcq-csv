public class User {
    private String name;
    private double grade = 0;

    User(String name, double grade){
        this.name = name;
        this.grade = grade;
    }

    User(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getName(){
        return name;
    }

    public void setGrade(double grade){
        this.grade = grade;
    }

    public double getGrade(){
        return grade;
    }

    public void displayName(){
        System.out.println(name);
    }

    public void displayGrade(){
        System.out.println(grade);
    }

}
