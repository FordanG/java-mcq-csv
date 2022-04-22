public interface Question {
    void setQuestion(String question);
    String getQuestion();
    void setOptions(String[] options);
    String[] getOptions();
    void setAnswer(String answer);
    String getAnswer();
    void displayAnswer();
    void displayQuestion();
    void displayOptions();
}
