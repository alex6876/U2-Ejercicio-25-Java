public class NotificadorSMS implements CanalNotificacion {

    @Override
    public void enviar(String destinatario, String mensaje) {

        if (!destinatario.isEmpty()) {
            System.out.println("SMS enviado al número: " + destinatario);
            System.out.println("Mensaje: " + mensaje);
        } else {
            System.out.println("Error: número de teléfono inválido.");
        }
    }
}