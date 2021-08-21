package com.tyoma17.util.concurrent;

public class WaitNotifyTest {

    public static void main(String[] args) {

        Task task = new Task();
        TaskPostExecutor thread1 = new TaskPostExecutor(task);
        TaskExecutor thread2 = new TaskExecutor(task);

        thread1.start();
        thread2.start();
    }

    private static class TaskExecutor extends Thread {

        private Task task;

        public TaskExecutor(Task task) {
            this.task = task;
        }

        @Override
        public void run() {

            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + currentThread().getName() + " is not ready to complete a task");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Now thread " + currentThread().getName() + " is ready to complete a task!");

            task.complete();
        }
    }

    private static class TaskPostExecutor extends Thread {

        private Task task;

        public TaskPostExecutor(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                task.postComplete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class Task {

        private boolean isComplete;

        public boolean isComplete() {
            return isComplete;
        }

        public void setComplete(boolean complete) {
            isComplete = complete;
        }

        public void postComplete() throws InterruptedException {

            synchronized (this) {
                while (!isComplete) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for completion...");
                    wait();
                }
            }

            System.out.println("Post complete actions! By thread " + Thread.currentThread().getName());
        }

        public void complete() {

            synchronized (this) {
                isComplete = true;
                System.out.println("Task completed! By thread " + Thread.currentThread().getName());
                notify();
            }
        }
    }
}
