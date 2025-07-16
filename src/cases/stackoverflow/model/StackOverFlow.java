package cases.stackoverflow.model;

import java.util.HashMap;
import java.util.Map;

public class StackOverFlow {
    private static StackOverFlow INSTANCE;
    private Map<Integer, Question> questions;
    private Map<Integer, Comment> comments;
    private Map<Integer, User> users;
    private Map<Integer, Vote> votes;

    private StackOverFlow() {
        this.questions = new HashMap<>();
        this.comments = new HashMap<>();
        this.users = new HashMap<>();
        this.votes = new HashMap<>();
    }

    public static StackOverFlow getInstance() {
        if (INSTANCE == null) {
            synchronized (StackOverFlow.class) {
                if (INSTANCE == null) {
                    INSTANCE = new StackOverFlow();
                }
            }
        }

        return INSTANCE;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<Integer, Question> questions) {
        this.questions = questions;
    }

    public Map<Integer, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Integer, Comment> comments) {
        this.comments = comments;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public Map<Integer, Vote> getVotes() {
        return votes;
    }

    public void setVotes(Map<Integer, Vote> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "StackOverFlow{" +
                "questions=" + questions +
                ", comments=" + comments +
                ", users=" + users +
                ", votes=" + votes +
                '}';
    }
}
