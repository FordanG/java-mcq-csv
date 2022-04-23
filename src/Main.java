import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line = "";
        int score = 0;
        int questions = 0;
        double grade = 0;

        try {
//          Print Welcome Message
            Styles.printDivider();
            welcomeMessage();
            Styles.printDivider();

//          Initialize User Name
            getUsername();
            System.out.print("Please Enter your Name: ");
            Scanner sc = new Scanner(System.in);
            User user = new User(sc.nextLine());

            Styles.printDivider();
            System.out.println("Hello, " + user.getName() + "! Good luck with the Quiz!" );
            promptEnterKey();
            Styles.printDivider();

//          Initialize CSV File List from questionnaires directory
            ListFiles csvQuestionnaires = new ListFiles("./questionnaires","csv");

//          Get the files
            File[] files = csvQuestionnaires.getFiles();

//          Display File List
            csvQuestionnaires.displayFiles();

//          User Selects a file
            System.out.print("Please Pick a file: ");
            int userMCQ = sc.nextInt();

            String filePath = files[userMCQ-1].getAbsolutePath();
            String fileName = ListFiles.removeFileExtension(files[userMCQ-1].getName(),true);

            Styles.printDivider();
            System.out.println("You have selected: " + fileName);
            promptEnterKey();
            Styles.printDivider();

            //parsing a CSV file into Scanner class constructor
            Scanner fr = new Scanner(new FileReader(filePath));

            //returns a Boolean value
            while (fr.hasNextLine())
            {
                //use comma as separator for the rows
                line = fr.nextLine();
                MCQ questionItem = new MCQ(line.split(","));
                System.out.print(questions+1 + ". ");
                questionItem.display();
                System.out.print("Enter answer: ");
                int answerCode = sc.nextInt();

//              If the answer is correct, add 1 to the score
                if (questionItem.evaluate(answerCode)){
                    user.addScore();
                }
            }
            sc.close();
            user.evaluateGrade(MCQ.getCount());

            System.out.println(user.getName() + ", you answered " + user.getScore() + " Questions Right, " + (MCQ.getCount()-user.getScore()) + " Questions Wrong for a Total of " + MCQ.getCount() + " questions.");
            System.out.println("You scored " + (int)user.getGrade() + "%");
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }



    public static void getUsername(){
        System.out.println("Please Enter your Name:");
        Scanner sc = new Scanner(System.in);
        User user = new User(sc.nextLine());
    }

    static void welcomeMessage(){
        System.out.println("Welcome to the MCQ Test Taker");
    }

    public static void promptEnterKey(){
        System.out.print("\n\nPress \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
