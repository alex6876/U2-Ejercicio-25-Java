public class NotificadorEmail implements CanalNotificacion {

    @Override
    public void enviar(String destinatario, String mensaje) {

        if (destinatario.contains("@")) {
            System.out.println("Correo enviado a: " + destinatario);
            System.out.println("Mensaje: " + mensaje);
        } else {
            System.out.println("Error: correo electrónico inválido.");
        }
    }
}