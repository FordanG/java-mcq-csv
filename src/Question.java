public interface Question {
    void setOptions(String[] options);
    String[] getOptions();
    void setAnswer(String answer);
    String getAnswer();
    void displayAnswer();
    void displayQuestion();
    void displayOptions();
}
