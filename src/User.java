import java.util.Scanner;

public class User {
    private String name;
    private double grade = 0;
    private int score = 0;

    public User(String name, double grade){
        this.name = name;
        this.grade = grade;
    }

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getGrade(){
        return grade;
    }
    
    public int getScore(){return score;}

    public void displayName(){
        System.out.println(name);
    }

    public void displayGrade(){
        System.out.println(grade);
    }

    public void addScore(){
        score++;
    }

    public static void userSelect(){

    }

    public void evaluateGrade(int questions){

        this.grade = Math.round((double)score/questions * 100);
    }

}
