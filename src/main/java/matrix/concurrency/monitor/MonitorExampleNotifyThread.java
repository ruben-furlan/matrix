package matrix.concurrency.monitor;


/**
 * Clase que actúa como un monitor para controlar el acceso y las notificaciones entre varios hilos.
 * Contiene un campo booleano conditionMet que representa la condición que los hilos están esperando.
 * Proporciona métodos sincronizados para esperar una condición (waitForCondition) y para establecer la condición y notificar a los hilos (setConditionTrue).
 */
public class MonitorExampleNotifyThread {

    static class MonitorObject {
        private boolean conditionMet = false;

        public synchronized void waitForCondition() {
            while (!conditionMet) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting for condition");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " is notified!");
            // Restablece la condición para el siguiente hilo
            conditionMet = false;
        }

        public synchronized void setConditionTrue() {
            conditionMet = true;
            notify(); // Notifica a un solo hilo en espera
            System.out.println("A thread has been notified.");
        }
    }
    /**
     * Runnable que representa un trabajador que espera una condición específica.
     * Este trabajador llamará a waitForCondition en MonitorObject y esperará hasta que se cumpla la condición.
     */
    static class WorkerRunnable implements Runnable {
        private final MonitorObject monitor;

        public WorkerRunnable(MonitorObject monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            monitor.waitForCondition();
        }
    }


    /**
     * Runnable que actúa como controlador para cambiar la condición en MonitorObject.
     * Cambia la condición y notifica a uno de los hilos en espera.
     */
    static class ControllerRunnable implements Runnable {
        private final MonitorObject monitor;

        public ControllerRunnable(MonitorObject monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000); // Simular algún trabajo
                    monitor.setConditionTrue();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        MonitorObject monitor = new MonitorObject();
        Thread controllerThread = new Thread(new ControllerRunnable(monitor));

        for (int i = 0; i < 10; i++) {
            new Thread(new WorkerRunnable(monitor)).start();
        }

        controllerThread.start();
    }
}
