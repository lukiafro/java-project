
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GeneralRank {

    private List<Integer> allChoice;
    private int size, counter = 0;
    private Debug d;
    private int threeBest[];
    private int counting[];

    public GeneralRank() {
        allChoice = new ArrayList<Integer>();
        d = new Debug();
        threeBest = new int[3];
        counting = new int[3];
    }

    public void addElements(int i) {

        allChoice.add(i);
        size = allChoice.size();
        if (d.debuging()) {
            print(size);
        }

        checkRank(allChoice.get(size - 1));
        counter = 0;

    }

    void checkRank(int pictureNumber) {
        for (int i = 0; i < (size - 1); i++) {
            if (pictureNumber == allChoice.get(i)) {
                counter++;
            }
        }
        if (counter > 0) {
            setInTab(pictureNumber, counter);
        }

    }

    void setInTab(int pictureNumber, int count) {
    }

    void print(int i) {


        System.out.println("Lista - " + allChoice.get(i - 1) + " " + size);

    }
}