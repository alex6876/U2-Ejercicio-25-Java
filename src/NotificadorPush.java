public class NotificadorPush implements CanalNotificacion {

    @Override
    public void enviar(String destinatario, String mensaje) {

        if (!destinatario.isEmpty()) {
            System.out.println("Notificación Push enviada al dispositivo: " + destinatario);
            System.out.println("Mensaje: " + mensaje);
        } else {
            System.out.println("Error: identificador de dispositivo inválido.");
        }
    }
}