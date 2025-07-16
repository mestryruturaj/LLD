package cases.stackoverflow.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private static int ongoingId;
    private int questionId;
    private String content;
    private User author;
    private List<Comment> comments;
    private List<Vote> votes;
    private boolean isAnswered;
    private LocalDateTime createdAt;

    public Question(String content, User author) {
        this.questionId = ongoingId++;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.isAnswered = false;
        this.createdAt = LocalDateTime.now();
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", content='" + content + '\'' +
                ", isAnswered=" + isAnswered +
                ", createdAt=" + createdAt +
                '}';
    }
}
