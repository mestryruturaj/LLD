package cases.stackoverflow;

import cases.stackoverflow.model.Comment;
import cases.stackoverflow.model.Question;
import cases.stackoverflow.model.User;
import cases.stackoverflow.service.StackOverFlowService;

public class Client {
    public static void main(String[] args) {
        StackOverFlowService stackOverFlowService = new StackOverFlowService();

        User ruturaj = stackOverFlowService.createUser("Ruturaj Mestry");
        User snehal = stackOverFlowService.createUser("Snehal Mestry");

        Question question = stackOverFlowService.createQuestion(ruturaj, "Is LLD important in Software Engineering?");
        System.out.println(question + "\n");
        Comment comment1 = stackOverFlowService.createComment(snehal, question, "Yes.");
        Comment comment2 = stackOverFlowService.createComment(snehal, question, "is your question answered?");

        question.setAnswered(true);

        System.out.println(ruturaj);
        System.out.println();
        System.out.println(snehal);
        System.out.println();
        System.out.println(stackOverFlowService.getStackOverFlow());


    }
}
