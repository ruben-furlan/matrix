package matrix.concurrency.semaphore;

import java.util.concurrent.Semaphore;


public class BinarySemaphoreExample {
    private static Semaphore semaphore = new Semaphore(1);

    static class SharedResource {
        public void use() {
            System.out.println(Thread.currentThread().getName() + " is using the resource");
            try {
                Thread.sleep(1000); // Simulando trabajo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has finished using the resource");
        }
    }

    static class MyThread extends Thread {
        SharedResource resource;

        public MyThread(SharedResource resource) {
            this.resource = resource;
        }

        public void run() {
            try {
                semaphore.acquire();
                resource.use();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        new MyThread(sharedResource).start();
        new MyThread(sharedResource).start();
    }
}
