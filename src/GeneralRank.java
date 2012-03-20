
import java.util.ArrayList;
import java.util.List;

public class GeneralRank {

    private List<Integer> allChoice;
    private int size, counter = 0;
    private Debug d;
    private int threeBest[][];

    public GeneralRank() {
        allChoice = new ArrayList<Integer>();
        d = new Debug();
        threeBest = new int[3][2];




    }

    public void addElements(int i) {

        allChoice.add(i);
        size = allChoice.size();


        checkRank(allChoice.get(size - 1));
        if (d.debuging()) {
            print();
        }
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

    /*
     * Ustawienie narazie 1 najlepszego obiektu.
     */
    void setInTab(int pictureNumber, int count) {
        if (count > threeBest[0][1]) {
            threeBest[0][1] = count;
            threeBest[0][0] = pictureNumber;
        }


    }

    int getFirst() {
        return threeBest[0][0];
    }

    int getSecond() {
        return threeBest[1][0];
    }

    int getThird() {
        return threeBest[2][0];
    }

    void print() {


        System.out.println("Lista - " + allChoice.get(size - 1) + " " + size + " Best - " + threeBest[0][0] + "powtorzylo sie " + threeBest[0][1]);

    }
}