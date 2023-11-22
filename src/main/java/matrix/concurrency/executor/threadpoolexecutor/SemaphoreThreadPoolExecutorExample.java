package matrix.concurrency.executor.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Ejemplo de ThreadPoolExecutor utilizando Semáforos.
 * Este ejemplo demuestra cómo usar un semáforo para controlar el acceso a un recurso compartido.
 */
public class SemaphoreThreadPoolExecutorExample {
    public static void main(String[] args) {
        // Configuración del ThreadPoolExecutor
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // corePoolSize
                4, // maximumPoolSize
                1000, // keepAliveTime
                TimeUnit.MILLISECONDS, // unit
                new ArrayBlockingQueue<>(2) // workQueue
        );

        // Semáforo para controlar el acceso
        Semaphore semaphore = new Semaphore(2);

        // Ejecución de tareas con control de acceso
        for (int i = 0; i < 4; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Tarea " + taskNumber + " en ejecución");
                    Thread.sleep(500); // Simular trabajo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            });
        }

        executor.shutdown();
    }
}
