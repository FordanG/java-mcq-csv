public class MCQ implements IQuestion {
    /*
     *   @param count counts the instances of the question
     *   @param question stores the question for the MCQ
     *   @param options stores the options for the MCQ
     *   @param answer stores the answer for the MCQ
     *   @param id this stores the key id of the question
     */
    static int count;
    private String question;
    private String[] options;
    private String answer;
    private String id;

//    Constructor for the MCQ Class
    public MCQ(String[] question){
        this.setId(question[0]);
        this.setQuestion(question[1]);
        this.setOptions(new String[] {question[2],question[3],question[4],question[5]});
        this.setAnswer(question[6]);
        count++;
    }
    
    public void setId(String id){this.id =id;}

    public void setQuestion(String question){this.question = question;};

    public String getQuestion(){return question;}

    public static int getCount() {
        return count;
    }

    public void setOptions(String[] options){
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void displayQuestion()
    {
        System.out.print(this.getQuestion() + "\n");
    }

//    Displays the options together with their answer code - equivalent
    public void displayOptions()
    {
        Styles.printDivider();
        for(int i = 0; i < this.getOptions().length; i++){
            if (this.getOptions()[i] != ""){
                System.out.println("\t" + (i+1) + " - " + this.getOptions()[i]);
            }
        }
        Styles.printDivider();
    }

    public void displayAnswer(){
        printAnswerCodes(Integer.parseInt(this.answer));
//          Print Correct Answer
        String answer = this.options[Integer.parseInt(this.answer)-1];
        System.out.print(answer + "\n");
    }


    //    Displays the question and options
    public void displayItem()
    {
        this.displayQuestion();
        this.displayOptions();
    }

//    Evaluates the answer of the user with the answer from the MCQ set
    public boolean evaluate(int answerCode)
    {
        if(answerCode == Integer.parseInt(this.getAnswer())){
            System.out.println("Correct Answer!");
            Main.promptEnterKey();
            Styles.printDividerTwo();
            return true;
        }else{
            System.out.print("Wrong Answer. The Correct Answer is " );
            displayAnswer();
            Main.promptEnterKey();
            Styles.printDividerTwo();
            return false;
        }
    }

//  Prints the choices for the options
    static void printAnswerCodes(int answer){
        switch (answer) {
            case 1 -> System.out.print("1. ");
            case 2 -> System.out.print("2. ");
            case 3 -> System.out.print("3. ");
            case 4 -> System.out.print("4. ");
        }
    }


}
