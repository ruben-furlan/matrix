# Semáforos en Java

Este documento proporciona una explicación detallada sobre el uso de semáforos en Java, incluyendo su funcionamiento básico, tipos, y un ejemplo de código.

## Contenido
- [Funcionamiento Básico de un Semáforo](#funcionamiento-básico-de-un-semaforo)
- [Tipos de Semáforos](#tipos-de-semaforos)

## Funcionamiento Básico de un Semáforo

En Java, un semáforo es una construcción de concurrencia utilizada para controlar el acceso a un recurso compartido por múltiples hilos. La clase `Semaphore` del paquete `java.util.concurrent` ofrece una implementación de semáforos.

### Inicialización
Al crear un semáforo, puedes especificar el número de permisos disponibles, determinando cuántos hilos pueden acceder al recurso simultáneamente.

Semaphore sem = new Semaphore(3);
### Adquisición de Permisos
Un hilo solicita acceso al recurso mediante la adquisición de un permiso del semáforo.

### Liberación de Permisos
Tras usar el recurso, el hilo libera su permiso, incrementando la disponibilidad en el semáforo.

### Tipos de Semáforos
**Semáforos Binarioss**
   - Un semáforo binario se inicializa con un solo permiso y funciona como un mutex.

**Semáforos de Conteo** 
  - Permiten que un número específico de hilos accedan a un recurso compartido simultáneamente.


## Consideraciones al Usar Semáforos

Al trabajar con semáforos en Java, es importante tener en cuenta los siguientes aspectos para evitar problemas comunes en la programación concurrente:

1. **Deadlocks**
   - Si no se gestionan correctamente, los semáforos pueden conducir a deadlocks. Un deadlock ocurre cuando varios hilos están bloqueados indefinidamente, esperando que otros liberen recursos.

2. **Starvation**
   - La inanición (starvation) puede suceder si algunos hilos nunca obtienen acceso al semáforo, debido a la constante adquisición del semáforo por otros hilos.

3. **Prioridad de Hilos**
   - En la implementación estándar de semáforos, no hay garantía de orden de acceso. Un hilo con menor prioridad podría adquirir un permiso antes que un hilo con mayor prioridad.

4. **Liberación de Semáforos**
   - Es crítico asegurarse de que los semáforos sean siempre liberados, incluso si la ejecución del hilo se interrumpe por una excepción.
