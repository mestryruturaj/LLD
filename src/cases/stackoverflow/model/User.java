package cases.stackoverflow.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int ongoingId;
    private int userId;
    private String name;
    private List<Question> questions;
    private List<Comment> comments;
    private List<Vote> votes;
    private int reputation;

    public User(String name) {
        this.userId = ongoingId++;
        this.name = name;
        this.questions = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.reputation = 0;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                ", comments=" + comments +
                ", reputation=" + reputation +
                '}';
    }
}
