import java.util.ArrayList;

public class GestorAlertas {

    private ArrayList<CanalNotificacion> canales;

    public GestorAlertas() {
        canales = new ArrayList<>();
    }

    public void agregarCanal(CanalNotificacion canal) {
        canales.add(canal);
    }

    public void difundirAlerta(String destinatario, String mensaje) {

        for (CanalNotificacion canal : canales) {
            canal.enviar(destinatario, mensaje);
        }
    }

    public void enviarAlertaSelectiva(
            CanalNotificacion canal,
            String destinatario,
            String mensaje) {

        canal.enviar(destinatario, mensaje);
    }
}