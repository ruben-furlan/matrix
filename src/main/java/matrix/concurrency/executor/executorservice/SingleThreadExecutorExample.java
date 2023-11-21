package matrix.concurrency.executor.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejemplo de uso de SingleThreadExecutor.
 * Este tipo de ExecutorService utiliza un solo hilo para ejecutar tareas.
 */
public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> System.out.println("Tarea ejecutada en: " + Thread.currentThread().getName()));

        executor.shutdown();
    }
}
