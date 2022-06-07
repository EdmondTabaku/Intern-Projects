import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Survey {
    private String title;
    private String topic;
    private String description;
    static AtomicInteger nextId = new AtomicInteger(0);
    private int id;
    private ArrayList<Question> questions = new ArrayList<Question>();

    public Survey(String title, String topic, String description, String[] questions){
        this.title = title;
        this.topic = topic;
        this.description = description;
        addQuestion(questions);
        id = nextId.incrementAndGet();
    }

    // Adding questions to the questions list
    public void addQuestion(String[] questionsList){

        for (String questionContent : questionsList){
            Question question = new Question(questionContent, id);
            questions.add(question);
        }

    }

    // Removing a question from the list
    public void removeQuestion(int questionId){
        Question questionToRemove = null;
        for(Question question : questions){
            if (question.getId() == questionId){
                questionToRemove = question;
            }
        }
        questions.remove(questionToRemove);
    }

    // Checking a question if it is answered by less than 50% of the candidates
    public void checkQuestion(Candidates candidates, int questionId){
        Question checkedQuestion = null;
        for(Question question : questions){
            if (question.getId() == questionId){
                int percentage = (question.answersCount / candidates.getCandidatesList().size()) * 100;
                if (percentage < 50){
                    checkedQuestion = question;
                }
            }
        }
        if (checkedQuestion != null){
            questions.remove(checkedQuestion);
        }
    }

    // Printing the results of the survey
    public void printResult(){
        for (Question question : questions){
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Agree: " + question.agreeCount);
            System.out.println("Slightly Agree: " + question.slightlyAgreeCount);
            System.out.println("Slightly Disagree: " + question.slightlyDisagreeCount);
            System.out.println("Disagree: " + question.disagreeCount);

        }
    }

    // Printing the answers of a candidate
    public void printAnswers(Candidate candidate){
        for (Answer answer : candidate.getAnswers()){
            if (answer.candidateId == candidate.getId()){
                System.out.println("Question: " + answer.getQuestion() + "  || Answer: " + answer.getAnswer());
            }
        }
    }

    // Submitting the survey
    public void submit(Candidate candidate){
        candidate.setSurveysCount(candidate.getSurveysCount() + 1);
    }

    // Finding the most given answer on the survey
    public String bestAnswer(){
        int agree = 0;
        int slightlyAgree = 0;
        int slightlyDisagree = 0;
        int disagree = 0;

        for (Question question : questions){
            agree += question.agreeCount;
            slightlyAgree += question.slightlyAgreeCount;
            slightlyDisagree += question.slightlyDisagreeCount;
            disagree += question.disagreeCount;
        }

        if (agree > slightlyAgree && agree > slightlyDisagree && agree > disagree){
            return "Agree";
        }
        else if (slightlyAgree > slightlyDisagree && slightlyAgree > disagree){
            return "Slightly Agree";
        }
        else if (slightlyDisagree > disagree){
            return "Slightly Disagree";
        }
        else if (disagree != 0){
            return "Disagree";
        }
        else {
            return "None";
        }


    }


    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() { return description; }
    public ArrayList<Question> getQuestions() { return questions; }

}
