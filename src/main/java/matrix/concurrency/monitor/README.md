# Monitores en Java

Este documento ofrece una explicación detallada sobre el uso de monitores en Java, incluyendo su funcionamiento, consideraciones al usarlos y un ejemplo de código.

## Funcionamiento de Monitores
En Java, un monitor es un mecanismo que se utiliza para gestionar el acceso concurrente a un objeto. Cada objeto en Java tiene su propio monitor intrínseco que puede ser bloqueado o desbloqueado mediante bloques `synchronized`.

### Bloques Synchronized
Un bloque `synchronized` en Java asegura que solo un hilo pueda ejecutar un bloque de código específico en un momento dado. Cuando un hilo entra en un bloque de código sincronizado, automáticamente adquiere el bloqueo del monitor asociado con el objeto especificado en la declaración `synchronized`.

### Métodos Wait y Notify
- `wait()`: Hace que el hilo actual espere hasta que otro hilo invoque el método `notify()` o `notifyAll()` para el mismo objeto.
- `notify()`: Despierta a un solo hilo que está esperando en el monitor del objeto.
- `notifyAll()`: Despierta a todos los hilos que están esperando en el monitor del objeto.

## Consideraciones al Usar Monitores
1. **Deadlocks**: Similar a otros mecanismos de sincronización, el uso inadecuado de monitores puede llevar a deadlocks.
2. **Starvation**: Algunos hilos pueden sufrir de inanición (starvation) si están constantemente esperando para acceder al recurso bloqueado.
3. **Rendimiento**: El uso excesivo de bloques sincronizados puede llevar a un rendimiento reducido, ya que limita la concurrencia.

