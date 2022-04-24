import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
//          Print Welcome Message
            Styles.printDivider();
            welcomeMessage();
            Styles.printDivider();

//          Initialize User Name
            System.out.print("Please Enter your Name: ");
            Scanner sc = new Scanner(System.in);
            User user = new User(sc.nextLine());

//          Some motivation for the user
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

//          Get the path and file name of the selected file
            String filePath = files[userMCQ-1].getAbsolutePath();
            String fileName = ListFiles.removeFileExtension(files[userMCQ-1].getName(),true);

//          Diplay what the user has selected
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
                String line = fr.nextLine();

//              Instantiate each question by each row in CSV
                MCQ questionItem = new MCQ(line.split(","));

//              Print out the question, together with the options
                System.out.print(MCQ.getCount() + ". ");
                questionItem.display();

//              Get answer from user
                System.out.print("Enter answer: ");
                int answerCode = sc.nextInt();

//              Evaluate answer and if the answer is correct, add 1 to the User score
                if (questionItem.evaluate(answerCode)){
                    user.addScore();
                }
            }
            sc.close();

//          Once the exam is finished, compute the grade of the user
            user.evaluateGrade(MCQ.getCount());


//          Print out the summary of the exam
            System.out.println(user.getName() + ", you answered " + user.getScore() + " Questions Right, " + (MCQ.getCount()-user.getScore()) + " Questions Wrong for a Total of " + MCQ.getCount() + " questions.");
            System.out.println("You scored " + (int)user.getGrade() + "%");
        }
        catch(IOException e) {
            e.printStackTrace();
        }

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
