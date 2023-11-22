package matrix.concurrency.executor.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Ejemplo simple de ThreadPoolExecutor.
 * Este ejemplo crea un ThreadPoolExecutor con una configuración básica y ejecuta algunas tareas.
 */
public class SimpleThreadPoolExecutorExample {
    public static void main(String[] args) {
        // Configuración del ThreadPoolExecutor
        int corePoolSize = 80;
        int maximumPoolSize = 150;
        long keepAliveTime = 1000;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue
        );

        // Ejecución de tareas
        for (int i = 0; i < 100; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Ejecutando tarea " + taskNumber + " en: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
