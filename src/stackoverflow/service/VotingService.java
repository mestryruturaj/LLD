package stackoverflow.service;

import stackoverflow.model.*;
import stackoverflow.model.enums.VoteType;
import stackoverflow.model.enums.VotingEntityType;

public class VotingService {
    private final StackOverFlow stackOverFlow;

    public VotingService(StackOverFlow stackOverFlow) {
        this.stackOverFlow = stackOverFlow;
    }


}
