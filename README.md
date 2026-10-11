# 📨 Simulación de Sistema de Alertas y Notificaciones (POO e Interfaces en Java)

Este proyecto es una aplicación en Java que modela un sistema de gestión de alertas corporativas capaz de despachar mensajes a través de múltiples canales de comunicación (Email, SMS y Notificaciones Push). Pone en práctica el uso de **interfaces**, **polimorfismo**, colecciones dinámicas y validaciones específicas de formato por canal.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se compone de una interfaz contractual, múltiples implementaciones concretas y un gestor central:

*   **`CanalNotificacion` (Interfaz)**: Define el contrato genérico que todo canal de comunicación debe implementar mediante el método `enviar(String destinatario, String mensaje)`.
*   **`NotificadorEmail`**, **`NotificadorSMS`** y **`NotificadorPush`**: Clases concretas que implementan la interfaz. Cada una aplica sus propias reglas de validación sobre el destinatario (ej. comprobar la presencia de `@` en el correo o verificar que los campos no estén vacíos).
*   **`GestorAlertas`**: Actúa como el orquestador central del sistema.
    *   **Atributos:** Mantiene una colección dinámica `ArrayList<CanalNotificacion>` para registrar los canales activos.
    *   **Métodos principales:**
        *   `agregarCanal(CanalNotificacion canal)`: Incorpora un nuevo medio de notificación a la flota.
        *   `difundirAlerta(String destinatario, String mensaje)`: Recorre la colección completa y propaga el mensaje a todos los canales registrados (difusión masiva).
        *   `enviarAlertaSelectiva(CanalNotificacion canal, String destinatario, String mensaje)`: Envía la alerta utilizando exclusivamente un canal específico pasado por parámetro.
*   **`Main`**: Punto de entrada del programa. Configura el gestor, registra los tres tipos de notificadores y ejecuta pruebas tanto de difusión masiva como de envío selectivo.

---

## ⚙️ Reglas de Negocio y Control de Validación

Cada canal de notificación implementa una validación defensiva antes de proceder con el envío:

1. **Email (`NotificadorEmail`):** Verifica que el texto del destinatario contenga el carácter `@` (`destinatario.contains("@")`). Si no lo cumple, rechaza el envío con un mensaje de error.
2. **SMS y Push (`NotificadorSMS` / `NotificadorPush`):** Validán que el campo del destinatario o identificador del dispositivo no se encuentre vacío (`!destinatario.isEmpty()`).
3. **Difusión Polimórfica:** Al invocar `difundirAlerta()`, el gestor itera sobre la lista sin necesidad de conocer los detalles internos de cada notificador, delegando la ejecución en tiempo de ejecución al método correspondiente de cada clase.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
=== DIFUSIÓN MASIVA ===
Correo enviado a: empleado@empresa.com
Mensaje: Alerta corporativa: reunión obligatoria a las 10:00.
SMS enviado al número: empleado@empresa.com
Mensaje: Alerta corporativa: reunión obligatoria a las 10:00.
Notificación Push enviada al dispositivo: empleado@empresa.com
Mensaje: Alerta corporativa: reunión obligatoria a las 10:00.

=== ALERTA SELECTIVA ===
Correo enviado a: gerente@empresa.com
Mensaje: Se requiere su presencia en la oficina.
