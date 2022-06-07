import java.util.ArrayList;
import java.util.List;

public class Candidates {

    // Creating a list of candidates
    private List<Candidate> candidatesList = new ArrayList<>();

    // Adding a new candidate to the list
    public void createCandidate(String firstName, String lastName, String email, String phone){
        Candidate candidate = new Candidate(firstName, lastName, email, phone);
        candidatesList.add(candidate);
    }

    // Finding the candidate who has taken the most surveys
    public Candidate bestCandidate(){
        int nextSurveysCount = 0;
        Candidate best = null;
        for(Candidate candidate : candidatesList){
            if (candidate.getSurveysCount() > nextSurveysCount){
                best = candidate;
                nextSurveysCount = candidate.getSurveysCount();
            }
            else {
                System.out.println("There are more than one candidates with the most surveys taken");
                return null;
            }

        }
        return best;
    }

    // Getters and setters
    public List<Candidate> getCandidatesList() { return candidatesList; }

    public void setCandidatesList(List<Candidate> candidatesList) { this.candidatesList = candidatesList; }

}
