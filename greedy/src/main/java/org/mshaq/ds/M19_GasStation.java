package org.mshaq.ds;

/**
 * Leetcode: <a href="https://leetcode.com/problems/gas-station/description/">Gas station</a>
 * <pre>
 *   Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 *   Output: 3
 *   Explanation:
 *   Start at station 3 (index 3) and fill up with 4 unit
 *   of gas.Your tank = 0 + 4 = 4
 *   Travel to station 4. Your tank = 4 - 1 + 5 = 8
 *   Travel to station 0. Your tank = 8 - 2 + 1 = 7
 *   Travel to station 1. Your tank = 7 - 3 + 2 = 6
 *   Travel to station 2. Your tank = 6 - 4 + 3 = 5
 *   Travel to station 3. The cost is 5. Your gas is just enough
 *   to travel back to station 3.
 *   Therefore, return 3 as the starting index.
 * </pre>
 */
public class M19_GasStation {


    /**
     * 1 - Start from 0 index and see If I can travel in that gas by gas[i] - cost[i], if -ve I cannot
     * 2 - If I can travel make sure to check clock wise by (currIdx + 1 % n) which will give next index in circle
     */
    public static int gasStationB(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int tankCapacity = 0;
            boolean canTravel = true;
            int atStation = i;
            for (int j = 0; j < n; j++) {
                tankCapacity += gas[atStation] - cost[atStation];
                if (tankCapacity < 0) {
                    canTravel = false;
                    break;
                }
                atStation = (atStation + 1) % n;
            }
            if (canTravel) return atStation;
        }
        return -1;
    }

    // If total gas is below total cost cannot complete cycle
    public static int gasStation(int[] gas, int[] cost) {
        int n = gas.length;
        int currentCapacity = 0;
        int totalCapacity = 0;
        int start = 0;
        for (int atStation = 0; atStation < n; atStation++) {
            currentCapacity += gas[atStation] - cost[atStation];
            totalCapacity += gas[atStation] - cost[atStation];

            if (currentCapacity < 0) {
                currentCapacity = 0;
                start = atStation + 1;
            }
        }

        return totalCapacity < 0 ? -1 : start;
    }
}
