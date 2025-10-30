package VISTA;

import java.awt.*;
import javax.swing.*;

public class MainArtify extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainArtify() {
        setTitle("Artify - Plataforma de Arte Inteligente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // === PANEL CENTRAL CON CARDLAYOUT ===
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Paneles de contenido
        InicioArtify inicioPanel = new InicioArtify(this);
        GenerarRecomendacion recomendacionPanel = new GenerarRecomendacion(this);
        EditarPerfil editarPerfilPanel = new EditarPerfil(this); // ✅ AGREGADO

        // Agregar paneles
        mainPanel.add(inicioPanel, "Inicio");
        mainPanel.add(recomendacionPanel, "Recomendacion");
        mainPanel.add(editarPerfilPanel, "EditarPerfil"); // ✅ AGREGADO

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Cambiar de panel desde cualquier parte
    public void mostrarPanel(String nombrePanel) {
        cardLayout.show(mainPanel, nombrePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainArtify());
    }
}