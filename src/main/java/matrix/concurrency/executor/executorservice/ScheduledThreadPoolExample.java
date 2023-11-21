package matrix.concurrency.executor.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Ejemplo de uso de ScheduledThreadPoolExecutor.
 * Permite la ejecución programada y periódica de tareas.
 */
public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        executor.scheduleAtFixedRate(
                () -> System.out.println("Tarea programada ejecutada en: " + Thread.currentThread().getName()),
                0, 1, TimeUnit.SECONDS);

        executor.schedule(() -> {
            System.out.println("Tarea diferida ejecutada en: " + Thread.currentThread().getName());
            executor.shutdown();
        }, 5, TimeUnit.SECONDS);

    }
}