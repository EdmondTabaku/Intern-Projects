public class Answer {

    private String question;
    private String answer;
    public int surveyId;
    public int questionId;
    public int candidateId;

    public Answer(String question, String answer, int surveyId, int questionId, int candidateId){
        this.question = question;
        this.answer = answer;
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.candidateId = candidateId;
    }

    // Getters and setters
    public String getQuestion() { return question;}

    public void setQuestion(String question) { this.question = question; }

    public String getAnswer() { return answer; }

    public void setAnswer(String answer) { this.answer = answer; }
}
