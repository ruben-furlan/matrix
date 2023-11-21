# ExecutorService en Java

Este documento ofrece una explicación detallada sobre `ExecutorService` en Java, incluyendo su definición, tipos y configuración.

## ¿Qué es ExecutorService?

`ExecutorService` es un framework proporcionado por el paquete `java.util.concurrent` que simplifica la ejecución de tareas en hilos separados. Es una interfaz que extiende `Executor`, proporcionando métodos para gestionar la terminación y producir `Future` para realizar un seguimiento del progreso de las tareas.

## Tipos de ExecutorService

Hay varios tipos de `ExecutorService` disponibles en Java:

1. **SingleThreadExecutor**: Utiliza un solo hilo trabajador para ejecutar tareas.
2. **FixedThreadPool**: Utiliza un número fijo de hilos para ejecutar tareas.
3. **CachedThreadPool**: Crea nuevos hilos según sea necesario, pero reutilizará hilos previamente construidos cuando estén disponibles.
4. **ScheduledThreadPoolExecutor**: Permite la ejecución programada y periódica de tareas.

## Configuración de ExecutorService

`ExecutorService` se puede configurar de varias maneras, dependiendo del tipo que elijas usar. Se puede configurar utilizando los métodos estáticos en `Executors`:

- `Executors.newSingleThreadExecutor()`: Crea un `ExecutorService` que utiliza un solo hilo.
- `Executors.newFixedThreadPool(int nThreads)`: Crea un `ExecutorService` con un número fijo de hilos.
- `Executors.newCachedThreadPool()`: Crea un `ExecutorService` que crea nuevos hilos según sea necesario.
- `Executors.newScheduledThreadPool(int corePoolSize)`: Crea un `ExecutorService` con un tamaño de pool central para tareas programadas.
