package matrix.concurrency.executor.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejemplo de uso de FixedThreadPool.
 * Este ExecutorService utiliza un número fijo de hilos para ejecutar tareas.
 */
public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println("Tarea ejecutada en: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
