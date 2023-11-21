package matrix.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class CountingSemaphoreExample {

    private static Semaphore semaphore = new Semaphore(3);

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

    static class ResourceUser implements Runnable {
        SharedResource resource;

        public ResourceUser(SharedResource resource) {
            this.resource = resource;
        }

        @Override
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
        for (int i = 0; i < 6; i++) {
            new Thread(new ResourceUser(sharedResource)).start();
        }
    }

}
