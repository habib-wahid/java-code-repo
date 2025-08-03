package leetcode;

import java.util.*;

public class TaskSchedular {
    static class Task {
        public char ch;
        public int occ;

        public Task(char ch, int occ) {
            this.ch = ch;
            this.occ = occ;
        }
    }

    public int solution(char[] tasks, int n) {

        if (tasks.length == 1 || n == 0)
            return tasks.length;

        PriorityQueue<Task> pq = new PriorityQueue<>(
                (p, q) -> q.occ - p.occ);

        int[] count = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new Task((char) ('A'+ i), count[i]));
            }
        }

        int totalTasks = 0;

        while (!pq.isEmpty()) {

            List<Task> taskList = new ArrayList<>();
            Task task = pq.poll();
            task.occ = task.occ - 1;

            totalTasks++;

            if (task.occ != 0) {
                taskList.add(task);
                for (int i = 0; i < n; i++) {
                    if (!pq.isEmpty()) {
                        Task task2 = pq.poll();
                        task2.occ = task2.occ - 1;
                        taskList.add(task2);
                    }
                }

                totalTasks += n;
            }


            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).occ > 0) {
                    pq.offer(taskList.get(i));
                }
            }

        }


        return totalTasks;

    }
    public static void main(String[] args) {

        char[] tasks = new char[] {'A','A','A','B','C'};

        TaskSchedular taskSchedular = new TaskSchedular();
        System.out.println(taskSchedular.solution(tasks, 3));
    }
}
