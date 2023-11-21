package matrix.concurrency.monitor;


/**
 * La clase MonitorObject contiene una condición (conditionMet) y dos métodos sincronizados (waitForCondition y setConditionTrue).
 * En waitForCondition, los hilos llaman a wait() para esperar hasta que la condición sea verdadera.
 * setConditionTrue cambia la condición a verdadera y notifica a todos los hilos en espera utilizando notifyAll().
 * WorkerThread es un hilo que espera a que la condición en MonitorObject sea verdadera.
 * ControllerThread es un hilo que, después de una breve pausa, cambia la condición y notifica a todos los hilos en espera.
 * En el método main, se crean y se inician 10 instancias de WorkerThread y una instancia de ControllerThread.
 * Este ejemplo ilustra cómo un monitor con métodos wait y notifyAll puede ser utilizado para coordinar la actividad entre varios hilos en Java.
 */

public class MonitorExampleNotifyAllThread {

    static class MonitorObject {
        private boolean conditionMet = false;

        public synchronized void waitForCondition() {
            while (!conditionMet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " is notified!");
        }

        public synchronized void setConditionTrue() {
            conditionMet = true;
            notifyAll(); // Notifica a todos los hilos en espera
        }
    }

    static class WorkerThread extends Thread {
        private final MonitorObject monitor;

        public WorkerThread(MonitorObject monitor) {
            this.monitor = monitor;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " is waiting for condition");
            monitor.waitForCondition();
        }
    }

    static class ControllerThread extends Thread {
        private final MonitorObject monitor;

        public ControllerThread(MonitorObject monitor) {
            this.monitor = monitor;
        }

        public void run() {
            try {
                Thread.sleep(3000); // Simular algún trabajo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            monitor.setConditionTrue();
            System.out.println("ControllerThread has changed the condition and notified all!");
        }
    }

    public static void main(String[] args) {
        MonitorObject monitor = new MonitorObject();

        for (int i = 0; i < 10; i++) {
            new WorkerThread(monitor).start();
        }

       new ControllerThread(monitor).start();
    }
}
