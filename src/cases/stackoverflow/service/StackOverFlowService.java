package cases.stackoverflow.service;

import cases.stackoverflow.model.*;
import cases.stackoverflow.model.enums.VoteType;
import cases.stackoverflow.model.enums.VotingEntityType;

public class StackOverFlowService {
    private final StackOverFlow stackOverFlow;

    public StackOverFlowService() {
        this.stackOverFlow = StackOverFlow.getInstance();
    }

    public StackOverFlow getStackOverFlow() {
        return stackOverFlow;
    }

    //create user
    public User createUser(String userName) {
        User user = new User(userName);
        stackOverFlow.getUsers().put(user.getUserId(), user);
        return user;
    }

    //post question
    public Question createQuestion(User author, String content) {
        Question question = new Question(content, author);

        stackOverFlow.getQuestions().put(question.getQuestionId(), question);
        author.getQuestions().add(question);

        return question;
    }

    //get question
    public Question getQuestion(int questionId) {
        return stackOverFlow.getQuestions().get(questionId);
    }

    //post answer
    public Comment createComment(User author, Question question, String content) {
        Comment comment = new Comment(content, question, author);

        stackOverFlow.getComments().put(comment.getCommentId(), comment);
        author.getComments().add(comment);

        return comment;
    }

    //get answer
    public Comment getComment(int commentId) {
        return stackOverFlow.getComments().get(commentId);
    }

    //voting
    public void upVoteQuestion(Question question, User user) {
        Vote vote = new Vote(user, VoteType.UPVOTE, question.getQuestionId(), VotingEntityType.QUESTION);

        question.getVotes().add(vote);
        stackOverFlow.getVotes().put(vote.getVoteId(), vote);
    }

    public void downVoteQuestion(Question question, User user) {
        Vote vote = new Vote(user, VoteType.DOWNVOTE, question.getQuestionId(), VotingEntityType.QUESTION);

        question.getVotes().add(vote);
        stackOverFlow.getVotes().put(vote.getVoteId(), vote);
    }

    public void upVoteComment(Comment comment, User user) {
        Vote vote = new Vote(user, VoteType.UPVOTE, comment.getCommentId(), VotingEntityType.COMMENT);

        comment.getVotes().add(vote);
        stackOverFlow.getVotes().put(vote.getVoteId(), vote);
    }

    public void downVoteComment(Comment comment, User user) {
        Vote vote = new Vote(user, VoteType.DOWNVOTE, comment.getCommentId(), VotingEntityType.COMMENT);

        comment.getVotes().add(vote);
        stackOverFlow.getVotes().put(vote.getVoteId(), vote);
    }

    public Vote getVote(int id) {
        return stackOverFlow.getVotes().get(id);
    }

}
