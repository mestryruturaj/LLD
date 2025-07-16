package cases.stackoverflow.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    private static int ongoingId;
    private int commentId;
    private String comment;
    private Question question;
    private User author;
    private boolean isAccepted;
    private List<Vote> votes;
    private LocalDateTime createdAt;


    public Comment(String comment, Question question, User author) {
        this.commentId = ongoingId++;
        this.comment = comment;
        this.question = question;
        this.author = author;
        this.votes = new ArrayList<>();
        this.isAccepted = false;
        this.createdAt = LocalDateTime.now();
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", comment='" + comment + '\'' +
                ", question=" + question +
                ", isAccepted=" + isAccepted +
                ", createdAt=" + createdAt +
                '}';
    }
}
