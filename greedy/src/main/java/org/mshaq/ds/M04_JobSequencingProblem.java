package org.mshaq.ds;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * GeeksForGeeks: <a href="https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1">Job Sequencing problem</a>
 */
public class M04_JobSequencingProblem {

    /**
     * <ul>
     *     <li>Sort the array in Descending order with profit, as we need to maximize the profit</li>
     *     <li>Use hashing to keep track of day the job got executed, day 0, day 1 etc using deadline</li>
     *      <li>If job is not executed, collect profit execute the job and exit</li>
     * </ul>
     */
    public int[] JobScheduling(int[][] jobs) {
        List<Job> jobsList = getJobs(jobs);
        jobsList.sort(Comparator.comparingInt((Job job) -> job.profit).reversed());
        boolean[] hashing = new boolean[jobs.length + 1];
        int profit = 0;
        int count = 0;
        for (Job job : jobsList) {
            for (int i = job.deadline; i >= 0; i++) {
                if (!hashing[i]) {
                    hashing[i] = true;
                    profit += job.profit;
                    count += 1;
                    break;
                }
            }
        }
        return new int[]{count, profit};


    }

    private List<Job> getJobs(int[][] jobs) {
        List<Job> jobsList = new ArrayList<>();
        for (int[] job : jobs) {
            jobsList.add(new Job(job[0], job[1], job[2]));
        }
        return jobsList;
    }


    public static class Job {
        int jobId;
        int deadline;
        int profit;

        public Job(int jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}
