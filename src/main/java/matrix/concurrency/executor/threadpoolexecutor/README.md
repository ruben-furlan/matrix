# ThreadPoolExecutor en Java

Este documento proporciona una explicación detallada sobre `ThreadPoolExecutor` en Java, incluyendo sus conceptos básicos, parámetros de configuración y tipos de colas de trabajo.

## Conceptos Básicos

`ThreadPoolExecutor` es una implementación concreta de `ExecutorService` que ejecuta cada tarea enviada en uno de los hilos de un pool. Es parte del paquete `java.util.concurrent` y proporciona una manera eficiente de manejar múltiples tareas en un entorno de múltiples hilos.

## Parámetros de Configuración

`ThreadPoolExecutor` requiere varios parámetros para su configuración:

1. **corePoolSize**: El número de hilos a mantener en el pool, incluso si están inactivos.
2. **maximumPoolSize**: El límite máximo de hilos en el pool.
3. **keepAliveTime**: El tiempo máximo que los hilos en exceso sobre `corePoolSize` pueden permanecer inactivos antes de ser terminados.
4. **unit**: La unidad de tiempo para el `keepAliveTime`.
5. **workQueue**: La cola utilizada para almacenar tareas antes de que sean ejecutadas.


## Colas de Trabajo en ThreadPoolExecutor en Java

Este documento proporciona detalles sobre los diferentes tipos de colas de trabajo (`workQueue`) que se pueden utilizar con `ThreadPoolExecutor` en Java.

## Tipos de Colas de Trabajo

### 1. ArrayBlockingQueue

- **Capacidad Fija**: Una cola basada en un arreglo con capacidad fija, que debe ser definida al momento de su creación.
- **Orden FIFO**: Funciona bajo el principio FIFO (First-In, First-Out), procesando elementos en el orden en que fueron añadidos.
- **Bloqueo**: Si la cola está llena, cualquier intento de agregar más elementos resultará en un bloqueo del hilo hasta que haya espacio. Del mismo modo, si está vacía, intentar extraer un elemento bloqueará el hilo hasta que esté disponible un elemento.
- **Uso en ThreadPoolExecutor**: Adecuada cuando se necesita limitar el número de tareas pendientes en la cola.

### 2. LinkedBlockingQueue

- **Capacidad Opcionalmente Acotada**: Puede ser acotada o ilimitada. Si se especifica un tamaño, opera con ese límite; de lo contrario, su capacidad es prácticamente infinita.
- **Orden FIFO**: Al igual que `ArrayBlockingQueue`, maneja los elementos según el principio FIFO.
- **Flexibilidad de Espacio**: Menos propensa al bloqueo por una cola llena, pero puede aumentar el uso de memoria si se acumulan muchas tareas pendientes.
- **Uso en ThreadPoolExecutor**: Ideal para situaciones en las que se desea una cola que pueda crecer según sea necesario.

### 3. SynchronousQueue

- **Sin Almacenamiento de Elementos**: No almacena elementos, cada inserción debe coincidir con una extracción y viceversa.
- **Transferencia Directa**: Se usa para la transferencia directa de elementos de un hilo a otro.
- **Uso en ThreadPoolExecutor**: Útil cuando cada tarea debe ser manejada de manera inmediata. Si no hay hilos disponibles, la tarea se rechaza o se crea un nuevo hilo, según la configuración del `ThreadPoolExecutor`.

### Conclusión

La elección de la cola de trabajo para un `ThreadPoolExecutor` depende de las necesidades específicas de manejo de tareas: un límite estricto en el número de tareas pendientes, flexibilidad en la gestión de la cola o el manejo inmediato de tareas sin almacenarlas en una cola.

