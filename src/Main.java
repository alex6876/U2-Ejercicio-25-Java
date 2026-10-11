public class Main {

    public static void main(String[] args) {

        GestorAlertas gestor = new GestorAlertas();

        CanalNotificacion email = new NotificadorEmail();
        CanalNotificacion sms = new NotificadorSMS();
        CanalNotificacion push = new NotificadorPush();

        gestor.agregarCanal(email);
        gestor.agregarCanal(sms);
        gestor.agregarCanal(push);

        String mensaje = "Alerta corporativa: reunión obligatoria a las 10:00.";

        System.out.println("=== DIFUSIÓN MASIVA ===");

        gestor.difundirAlerta(
                "empleado@empresa.com",
                mensaje
        );

        System.out.println("\n=== ALERTA SELECTIVA ===");

        gestor.enviarAlertaSelectiva(
                email,
                "gerente@empresa.com",
                "Se requiere su presencia en la oficina."
        );
    }
}