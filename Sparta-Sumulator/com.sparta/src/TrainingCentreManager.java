import java.util.ArrayList;

public interface TrainingCentreManager {
    int getAvailability(TrainingCentre trainingCentre);
    void createCentre();
    ArrayList getFullCentres();
    ArrayList getAvailableCentres();
    void addCentreToList();
}
