package VISTA;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GenerarRecomendacion extends JPanel {

    private MainArtify main;

    public GenerarRecomendacion(MainArtify main) {
        this.main = main;

        setLayout(new BorderLayout());
        Color COLOR_PRIMARIO = new Color(74, 107, 255);
        Color COLOR_SECUNDARIO = new Color(230, 240, 255);
        Color COLOR_TEXTO = new Color(45, 45, 45);
        Color COLOR_TEXTO_CLARO = new Color(120, 120, 120);
        Color COLOR_FONDO = new Color(248, 250, 255);

        // ===== PANEL LATERAL =====
        JPanel jPanelMenu = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, COLOR_SECUNDARIO, 0, getHeight(), Color.WHITE));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jPanelMenu.setPreferredSize(new Dimension(220, getHeight()));
        jPanelMenu.setLayout(new BoxLayout(jPanelMenu, BoxLayout.Y_AXIS));
        jPanelMenu.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));

        JLabel lblLogo = new JLabel("🎨 Artify");
        lblLogo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblLogo.setForeground(COLOR_PRIMARIO);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblLogo.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

        JLabel lblSeccion = new JLabel("Menú Principal");
        lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccion.setForeground(COLOR_TEXTO_CLARO);
        lblSeccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSeccion.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JButton btnInicio = crearBotonMenu("🏠 Inicio", false);
        JButton btnRecomendacion = crearBotonMenu("🎯 Recomendación", true);
        JButton btnBuscar = crearBotonMenu("🔍 Buscar", false);
        JButton btnPerfil = crearBotonMenu("👤 Perfil", false);
        JButton btnCerrar = crearBotonMenu("🚪 Cerrar Sesión", false);

        // --- Acciones de menú ---
        btnInicio.addActionListener(e -> main.mostrarPanel("Inicio"));
        btnRecomendacion.addActionListener(e -> main.mostrarPanel("Recomendacion"));
        btnBuscar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abrir vista de búsqueda"));
        btnPerfil.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abrir perfil de usuario"));

        jPanelMenu.add(lblLogo);
        jPanelMenu.add(lblSeccion);
        jPanelMenu.add(btnInicio);
        jPanelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        jPanelMenu.add(btnRecomendacion);
        jPanelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        jPanelMenu.add(btnBuscar);
        jPanelMenu.add(Box.createVerticalGlue());
        jPanelMenu.add(btnPerfil);
        jPanelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        jPanelMenu.add(btnCerrar);

        // ===== PANEL PRINCIPAL =====
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBackground(COLOR_FONDO);
        panelContenido.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel lblTitulo = new JLabel("🎯 Generador de Recomendaciones de Arte");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(COLOR_PRIMARIO);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JLabel lblDescripcion = new JLabel("Elige tus intereses y obtén sugerencias personalizadas de artistas y obras.");
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDescripcion.setForeground(COLOR_TEXTO_CLARO);

        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(3, 2, 15, 15));
        panelOpciones.setOpaque(false);
        panelOpciones.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        String[] intereses = {"Pintura", "Escultura", "Fotografía", "Arte Digital", "Ilustración", "Diseño 3D"};
        JCheckBox[] checkIntereses = new JCheckBox[intereses.length];

        for (int i = 0; i < intereses.length; i++) {
            checkIntereses[i] = new JCheckBox(intereses[i]);
            checkIntereses[i].setFont(new Font("Segoe UI", Font.PLAIN, 15));
            checkIntereses[i].setOpaque(false);
            panelOpciones.add(checkIntereses[i]);
        }

        JButton btnGenerar = new JButton("Generar Recomendaciones");
        btnGenerar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnGenerar.setBackground(COLOR_PRIMARIO);
        btnGenerar.setForeground(Color.WHITE);
        btnGenerar.setFocusPainted(false);
        btnGenerar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnGenerar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JTextArea txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtResultado.setForeground(COLOR_TEXTO);
        txtResultado.setBackground(Color.WHITE);
        txtResultado.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 230, 250), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setPreferredSize(new Dimension(400, 250));

        btnGenerar.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Basado en tus intereses:\n\n");
            boolean algoSeleccionado = false;

            for (JCheckBox cb : checkIntereses) {
                if (cb.isSelected()) {
                    algoSeleccionado = true;
                    sb.append("- ").append(cb.getText()).append("\n");
                }
            }

            if (!algoSeleccionado) {
                txtResultado.setText("⚠️ Por favor, selecciona al menos un interés antes de generar recomendaciones.");
            } else {
                sb.append("\n🎨 Te recomendamos explorar artistas y obras relacionadas con tus gustos.");
                txtResultado.setText(sb.toString());
            }
        });

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBoton.setOpaque(false);
        panelBoton.add(btnGenerar);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setOpaque(false);
        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblDescripcion);
        panelSuperior.add(Box.createRigidArea(new Dimension(0, 15)));
        panelSuperior.add(panelOpciones);
        panelSuperior.add(panelBoton);

        panelContenido.add(panelSuperior, BorderLayout.NORTH);
        panelContenido.add(scroll, BorderLayout.CENTER);

        add(jPanelMenu, BorderLayout.WEST);
        add(panelContenido, BorderLayout.CENTER);
    }

    // === Método auxiliar para crear botones de menú ===
    private JButton crearBotonMenu(String texto, boolean activo) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        boton.setContentAreaFilled(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setFocusPainted(false);
        boton.setMaximumSize(new Dimension(180, 45));
        boton.setForeground(activo ? Color.WHITE : new Color(45, 45, 45));

        if (activo) {
            boton.setBackground(new Color(74, 107, 255));
            boton.setOpaque(true);
        }

        return boton;
    }
}
