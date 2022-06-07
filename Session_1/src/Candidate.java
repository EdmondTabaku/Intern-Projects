import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    static AtomicInteger nextId = new AtomicInteger(0);
    private int id;
    private int surveysCount = 0;
    private ArrayList<Answer> answers = new ArrayList<>();

    public Candidate(String firstName, String lastName, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        id = nextId.incrementAndGet();
    }

    // Saving a new answer
    public void saveAnswers(String question, String answer, int surveyId, int questionId){
        Answer newAnswer = new Answer(question, answer, surveyId, questionId, id);
        answers.add(newAnswer);
    }

    // Getters and setters
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() { return id; }

    public int getSurveysCount() { return surveysCount; }

    public void setSurveysCount(int surveysCount) { this.surveysCount = surveysCount; }

    public ArrayList<Answer> getAnswers() { return answers; }

    public void setAnswers(ArrayList<Answer> answers) { this.answers = answers; }



}
