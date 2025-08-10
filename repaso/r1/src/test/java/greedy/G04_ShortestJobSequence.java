package greedy;

public class G04_ShortestJobSequence {

    public long solve(int[] A) {
        int executionTime = 0;
        int waitTime = 0;
        for (int processTime : A) {
            waitTime += executionTime;
            executionTime += processTime;
        }
        return waitTime / A.length;
    }
}
