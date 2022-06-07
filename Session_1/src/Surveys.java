import java.util.ArrayList;

public class Surveys {

    private ArrayList<Survey> surveysList = new ArrayList<>();

    // Adding a new survey to the surveys list
    public void createSurvey(String title, String topic, String description, String[] questionsList){

        boolean isValid = validate(questionsList);

        if (isValid){
            Survey survey = new Survey(title, topic, description, questionsList);
            surveysList.add(survey);
        }

    }

    // Validating the questions
    public boolean validate(String[] questions){

        if (questions.length >= 10 && questions.length <= 40){
            String nextQuestion = "";
            for (String question : questions){
                if (question.toLowerCase() == nextQuestion.toLowerCase()){
                    System.out.println("Your questions should be unique. The survey is not valid");
                    return false;
                }
            }
            return true;
        }
        else {
            System.out.println("You have less that 10 or more than 40 questions. The survey is not valid");
            return false;
        }
    }

    // Getters and setters
    public ArrayList<Survey> getSurveysList() { return surveysList; }


}
