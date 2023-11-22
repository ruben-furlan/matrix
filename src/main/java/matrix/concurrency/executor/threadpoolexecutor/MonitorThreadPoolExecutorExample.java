package matrix.concurrency.executor.threadpoolexecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Clase MonitorThreadPoolExecutorExample para demostrar el uso de ThreadPoolExecutor con Monitores.
 * En este ejemplo, varios hilos trabajan con un recurso compartido sincronizado utilizando un monitor.
 */
public class MonitorThreadPoolExecutorExample {

    /**
     * Método principal para ejecutar el ejemplo de ThreadPoolExecutor con monitores.
     */
    public static void main(String[] args) {
        // Crear ThreadPoolExecutor con parámetros configurados
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, // corePoolSize
                4, // maximumPoolSize
                1000, // keepAliveTime
                TimeUnit.MILLISECONDS, // unit
                new LinkedBlockingQueue<>() // workQueue
        );

        // Objeto monitor para sincronizar el acceso al recurso compartido
        final Object monitor = new Object();

        // Crear y ejecutar tareas en el executor
        for (int i = 0; i < 40; i++) {
            int taskNumber = i;
            executor.execute(new MonitorTask(monitor, taskNumber));
        }

        // Finalizar el ThreadPoolExecutor
        executor.shutdown();
    }

    /**
     * Tarea que utiliza un monitor para sincronizar el acceso a un recurso compartido.
     */
    static class MonitorTask implements Runnable {
        private final Object monitor;
        private final int taskNumber;

        /**
         * Constructor para MonitorTask.
         *
         * @param monitor Objeto monitor para sincronización.
         * @param taskNumber Número de tarea para identificación.
         */
        public MonitorTask(Object monitor, int taskNumber) {
            this.monitor = monitor;
            this.taskNumber = taskNumber;
        }

        /**
         * Método run que se ejecutará en cada hilo del ThreadPoolExecutor.
         */
        @Override
        public void run() {
            synchronized (monitor) {
                System.out.println("Tarea " + taskNumber + " está en espera. Hilo: " + Thread.currentThread().getName());
                try {
                    monitor.wait(1000); // Espera con tiempo límite
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Tarea " + taskNumber + " completada. Hilo: " + Thread.currentThread().getName());
            }
        }
    }
}
