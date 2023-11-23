package matrix.concurrency.utils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Task {
    private String description;
    private int priority; // 1: alta, 2: media, 3: baja

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}

public class QueueTaskManager {
    public static void main(String[] args) {
        // Crear colas de prioridad para cada nivel de prioridad
        Queue<Task> altaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority));
        Queue<Task> mediaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority));
        Queue<Task> bajaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority));

        // Agregar algunas tareas de ejemplo a las colas
        altaPrioridad.offer(new Task("Resolver problema crítico", 1));
        altaPrioridad.offer(new Task("Responder a la queja del cliente", 1));
        mediaPrioridad.offer(new Task("Actualizar la documentación", 3));
        bajaPrioridad.offer(new Task("Realizar tareas administrativas", 2));

        // Procesar tareas en orden de prioridad
        while (!altaPrioridad.isEmpty()) {
            Task tarea = altaPrioridad.poll();
            System.out.println("Tarea de alta prioridad: " + tarea.getDescription());
        }

        while (!mediaPrioridad.isEmpty()) {
            Task tarea = mediaPrioridad.poll();
            System.out.println("Tarea de media prioridad: " + tarea.getDescription());
        }

        while (!bajaPrioridad.isEmpty()) {
            Task tarea = bajaPrioridad.poll();
            System.out.println("Tarea de baja prioridad: " + tarea.getDescription());
        }
    }
}
