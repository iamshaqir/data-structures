package org.mshaq.ds.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class H_JobSequencingProblem {


    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {

        List<Job> jobs = getJobs(id, deadline, profit);
        ArrayList<Integer> result = new ArrayList<>();
        jobs.sort(Comparator.comparingInt((Job job) -> job.profit).reversed());

        boolean[] hash = new boolean[id.length + 1];
        int totalProfit = 0;
        int count = 0;

        for (Job job : jobs) {
            for (int i = job.deadline - 1; i >= 0; i--) {
                if (!hash[i]) {
                    totalProfit += job.profit;
                    count++;
                    hash[i] = true;
                    break;
                }
            }
        }
        result.add(count);
        result.add(totalProfit);

        return result;

    }

    private List<Job> getJobs(int[] id, int[] deadline, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            jobs.add(new Job(id[i], deadline[i], profit[i]));
        }
        return jobs;
    }

    public static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}
