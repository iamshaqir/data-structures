package greedy;

import java.util.Arrays;

public class G03_ShortestJobFirst {

    /*
        WT  PT
        [0] 1
        [1] 2
        [1 2] 3
        [1 2 3] 4
        [1 2 3 4] 7
     */
    public int solveSJF(int[] A) {
        Arrays.sort(A);

        int waitingTime = 0;
        int executionTime = 0;
        for (int processTime : A) {
            waitingTime += executionTime;
            executionTime += processTime;
        }
        return waitingTime / A.length;
    }

}
