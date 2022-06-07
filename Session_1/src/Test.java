import java.util.List;

public class Test {
    public String title = "Title 1";
    public String topic = "Topic 1";
    public String description = "Description 1";
    public String[] questions = {"Question 1", "Question 2", "Question 3", "Question 4", "Question 5", "Question 6", "Question 7", "Question 8", "Question 9", "Question 10", "Question 11", "Question 12"};
    public String[] questions2 = {"Question", "Question", "Question 3", "Question 4", "Question 5", "Question 6", "Question 7", "Question 8", "Question 9", "Question 10", "Question 11", "Question 12"};
    public int[] answers = {1,5,1,2,2,4,4,3,1,1,1,1};
    public int[] answers2 = {2,5,2,2,2,4,4,3,1,1,1,1};

    public static void main(String[] args) {
        Test test = new Test();
        Surveys surveys = new Surveys();
        Candidates candidates = new Candidates();
        candidates.createCandidate("Edmond", "Tabaku", "sample@sample.com", "697701392");
        candidates.createCandidate("Sample", "Sample", "sample@sample.com", "732823928");
        Candidate candidate1 = candidates.getCandidatesList().get(0);
        Candidate candidate2 = candidates.getCandidatesList().get(1);

        // Adding a new survey to the surveys list
        surveys.createSurvey(test.title, test.topic, test.description, test.questions);
        // This survey will not validate
        surveys.createSurvey(test.title, test.topic, test.description, test.questions2);

        // Getting the survey that we created
        Survey survey1 = surveys.getSurveysList().get(0);

        // Getting the questions from the survey
        List<Question> questions1 = survey1.getQuestions();

        // For each question we give an answer from candidate1
        int i = 0;
        for (Question question : questions1){
            question.getAnswer(candidate1, test.answers[i]);
            i++;
        }

        // For each question we give an answer from candidate2
        int i2 = 0;
        for (Question question : questions1){
            question.getAnswer(candidate2, test.answers2[i2]);
            i2++;
        }

        // Printing the survey result
        System.out.println("The results of the survey are: ");
        survey1.printResult();

        // Printing the answers given by the candidate1
        System.out.println("The answers of candidate: " + candidate1.getFirstName());
        survey1.printAnswers(candidate1);
        System.out.println("The answers of candidate: " + candidate2.getFirstName());
        survey1.printAnswers(candidate2);

        // Printing the candidate with the most surveys
        Candidate bestCandidate = candidates.bestCandidate();
        if (bestCandidate != null){
            System.out.println("The candidate with the most answers is: " + bestCandidate.getFirstName() + " " +bestCandidate.getLastName());
        }

        // Printing the most given answer
        System.out.println("The most given answer is: " + surveys.getSurveysList().get(0).bestAnswer());

    }
}
