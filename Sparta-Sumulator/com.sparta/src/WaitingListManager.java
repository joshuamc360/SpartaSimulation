import java.util.ArrayList;

public interface WaitingListManager {
    ArrayList getTrainees();
    void addToWaitingList(TraineeDTO traineeDTO);
    TraineeDTO removeFromWaitingList();
}
