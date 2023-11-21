package matrix.concurrency.executor.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejemplo de uso de CachedThreadPool.
 * Este ExecutorService crea nuevos hilos según sea necesario, pero reutiliza hilos disponibles.
 */
public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> System.out.println("Tarea ejecutada en: " + Thread.currentThread().getName()));
        }

        executor.shutdown();
    }
}
