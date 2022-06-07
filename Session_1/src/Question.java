import java.util.concurrent.atomic.AtomicInteger;

public class Question {

    private String question;
    private int surveyId;
    static AtomicInteger nextId = new AtomicInteger(0);
    private int id;
    public int answersCount = 0;
    public int agreeCount = 0;
    public int slightlyAgreeCount = 0;
    public int slightlyDisagreeCount = 0;
    public int disagreeCount = 0;

    public Question(String question, int surveyId){
        this.question = question;
        this.surveyId = surveyId;
        id = nextId.incrementAndGet();
    }

    // Getting the answer from the candidate
    public String getAnswer(Candidate candidate, int n){
        switch (n){
            case 1:
                agreeCount++;
                answersCount++;
                candidate.saveAnswers(question, "Agree", surveyId, id);
                return "Agree";

            case 2:
                slightlyAgreeCount++;
                answersCount++;
                candidate.saveAnswers(question, "Slightly Agree", surveyId, id);
                return "Slightly Agree";

            case 3:
                slightlyDisagreeCount++;
                answersCount++;
                candidate.saveAnswers(question, "Slightly Disagree", surveyId, id);
                return "Slightly Disagree";

            case 4:
                disagreeCount++;
                answersCount++;
                candidate.saveAnswers(question, "Disagree", surveyId, id);
                return "Disagree";

        }

        return "Candidate did not answer";

    }

    // Getters and setters
    public String getQuestion() { return question; }

    public int getSurveyId() { return surveyId; }

    public int getId() { return id; }

}
