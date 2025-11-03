package VISTA;

import java.awt.*;
import javax.swing.*;

/**
 * Clase principal que controla la navegación entre los diferentes paneles
 * del sistema Artify.
 * Usa CardLayout para manejar Login, Registro, Inicio, etc.
 */
public class MainArtify extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Paneles
    private LoginUsuario loginPanel;
    private RegistrarUsuario registroPanel;
    private InicioArtify inicioPanel;
    private GenerarRecomendacion recomendacionPanel;
    private EditarPerfil editarPerfilPanel;

    public MainArtify() {
        setTitle("Artify - Plataforma de Arte Inteligente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // === PANEL CENTRAL CON CARDLAYOUT ===
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // === CREAR INSTANCIAS DE LOS PANELES ===
        loginPanel = new LoginUsuario(this);
        registroPanel = new RegistrarUsuario(this);
        inicioPanel = new InicioArtify(this);
        recomendacionPanel = new GenerarRecomendacion(this);
        editarPerfilPanel = new EditarPerfil(this);
        Obras obrasPanel = new Obras(this);
        Eventos eventosPanel = new Eventos(this);




        // === AGREGARLOS AL PANEL PRINCIPAL ===
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registroPanel, "Registro");
        mainPanel.add(inicioPanel, "Inicio");
        mainPanel.add(recomendacionPanel, "Recomendacion");
        mainPanel.add(editarPerfilPanel, "EditarPerfil");
        mainPanel.add(new BusquedaArtify(this), "Busqueda");
        mainPanel.add(obrasPanel, "Obras");
        mainPanel.add(eventosPanel, "Eventos");

        // Mostrar el login primero
        add(mainPanel, BorderLayout.CENTER);
        mostrarPanel("Login");

        setVisible(true);
    }

    /**
     * Cambia el panel visible en el contenedor principal
     * @param nombrePanel nombre del panel agregado en mainPanel
     */
    public void mostrarPanel(String nombrePanel) {
        cardLayout.show(mainPanel, nombrePanel);
    }

    /**
     * Punto de entrada de la aplicación
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainArtify());
    }
}
