package stackoverflow.model;

import stackoverflow.model.enums.VoteType;
import stackoverflow.model.enums.VotingEntityType;

import java.time.LocalDateTime;

public class Vote {
    private static int ongoingId = 0;
    private int voteId;
    private User author;
    private VoteType voteType;
    private int votingEntityId;
    private VotingEntityType votingEntityType;
    private LocalDateTime createdAt;

    public Vote(User author, VoteType voteType, int votingEntityId, VotingEntityType votingEntityType) {
        this.voteId = ongoingId++;
        this.author = author;
        this.voteType = voteType;
        this.votingEntityId = votingEntityId;
        this.votingEntityType = votingEntityType;
        this.createdAt = LocalDateTime.now();
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public int getVotingEntityId() {
        return votingEntityId;
    }

    public void setVotingEntityId(int votingEntityId) {
        this.votingEntityId = votingEntityId;
    }

    public VotingEntityType getVotingEntityType() {
        return votingEntityType;
    }

    public void setVotingEntityType(VotingEntityType votingEntityType) {
        this.votingEntityType = votingEntityType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
