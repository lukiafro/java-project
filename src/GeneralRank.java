
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GeneralRank {

    private List<Integer> allChoice;
    private int size, counter = 0;
    private Debug d;

    public GeneralRank() {
        allChoice = new ArrayList<Integer>();
        d = new Debug(true);
    }

    public void addElements(int i) {

        allChoice.add(i);
        size = allChoice.size();
        if (d.debuging()) {
            print(size);
        }

        counter = 0;

    }

    int checkRank(int pictureNumber) {
        for (int i = 0; i < (size - 1); i++) {
            if (pictureNumber == allChoice.get(i)) {
                counter++;
            }
        }
        return counter;

    }

    void print(int i) {


        System.out.println("Lista - " + allChoice.get(i - 1) + " " + size);

    }
}