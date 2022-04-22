public class MCQ implements Question {

    private String question;
    private String[] options;
    private String answer;
    private String item;

    MCQ(String[] question){
        this.item = question[0];
        this.question = question[1];
        this.options = new String[] {question[2],question[3],question[4],question[5]};
        this.answer = question[6];
    }

    @Override
    public void setQuestion(String question){
        this.question = question;
    }

    @Override
    public String getQuestion(){
        return question;
    }

    @Override
    public void setOptions(String[] options){
        this.options = options;
    }

    @Override
    public String[] getOptions() {
        return options;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    public void display()
    {
        this.displayQuestion();
        this.displayOptions();
    }

    @Override
    public void displayQuestion()
    {
        System.out.print(this.question + "\n");
    }

    @Override
    public void displayOptions()
    {
        Styles.printDivider();
//        int i = 2 - First Option
//        i = 5 - Fourth Option
        for(int i = 0; i < this.options.length; i++){
            if (this.options[i] != ""){
                System.out.println("\t" + (i+1) + " - " + this.options[i]);
            }
        }
        Styles.printDivider();
    }

    public boolean evaluate(int answerCode)
    {
        if(answerCode == Integer.parseInt(this.answer)){
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

    @Override
    public void displayAnswer(){
        printAnswerCodes(Integer.parseInt(this.answer));
//          Print Correct Answer
        String answer = this.options[Integer.parseInt(this.answer)-1];
        System.out.print(answer + "\n");
    }

    static void printAnswerCodes(int answer){
        switch (answer) {
            case 1 -> System.out.print("1. ");
            case 2 -> System.out.print("2. ");
            case 3 -> System.out.print("3. ");
            case 4 -> System.out.print("4. ");
        }
    }


}
