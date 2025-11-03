package VISTA;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class InicioArtify extends javax.swing.JPanel {

    private MainArtify mainFrame;

    // Constructor con referencia al frame principal
    public InicioArtify(MainArtify frame) {
        this.mainFrame = frame;
        initComponents();
    }

    private void initComponents() {

        Color COLOR_PRIMARIO = new Color(74, 107, 255);
        Color COLOR_SECUNDARIO = new Color(230, 240, 255);
        Color COLOR_TEXTO = new Color(45, 45, 45);
        Color COLOR_TEXTO_CLARO = new Color(120, 120, 120);
        Color COLOR_FONDO = new Color(248, 250, 255);

        setLayout(new BorderLayout());
        setBackground(COLOR_FONDO);

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

        // ===== BOTONES DEL MENÚ =====
        JButton btnInicio = crearBotonMenu("🏠 Inicio", true);
        JButton btnBuscar = crearBotonMenu("🔍 Buscar", false);
        JButton btnEventos = crearBotonMenu("📅 Eventos", false);
        JButton btnCatalogo = crearBotonMenu("📚 Catálogo", false);
        JButton btnIntereses = crearBotonMenu("❤️ Mis Intereses", false);
        JButton btnPerfil = crearBotonMenu("👤 Perfil", false);
        JButton btnCerrar = crearBotonMenu("🚪 Cerrar Sesión", false);

        // ===== ACCIONES DE LOS BOTONES =====
        btnInicio.addActionListener(e -> mainFrame.mostrarPanel("Inicio"));
        btnBuscar.addActionListener(e -> mainFrame.mostrarPanel("Busqueda")); // ✅ Buscar conectado
        btnEventos.addActionListener(e -> mainFrame.mostrarPanel("Eventos"));
        btnCatalogo.addActionListener(e -> {
        mainFrame.mostrarPanel("Obras");
        });
        btnIntereses.addActionListener(e -> JOptionPane.showMessageDialog(this, "Aquí verás tus intereses culturales."));
        btnPerfil.addActionListener(e -> mainFrame.mostrarPanel("EditarPerfil"));
        btnCerrar.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas cerrar sesión?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                mainFrame.mostrarPanel("Login"); // ✅ vuelve al login
            }
        });

        // Agregar al panel lateral
        jPanelMenu.add(lblLogo);
        jPanelMenu.add(lblSeccion);
        jPanelMenu.add(btnInicio);
        jPanelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        jPanelMenu.add(btnBuscar);
        jPanelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        jPanelMenu.add(btnEventos);
        jPanelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        jPanelMenu.add(btnCatalogo);
        jPanelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        jPanelMenu.add(btnIntereses);
        jPanelMenu.add(Box.createVerticalGlue());
        jPanelMenu.add(btnPerfil);
        jPanelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        jPanelMenu.add(btnCerrar);

        // ===== PANEL PRINCIPAL =====
        JPanel jPanelContenido = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, new Color(250, 252, 255),
                        getWidth(), getHeight(), new Color(235, 240, 255)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jPanelContenido.setLayout(new BoxLayout(jPanelContenido, BoxLayout.Y_AXIS));
        jPanelContenido.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        jPanelContenido.setOpaque(false);

        JLabel lblTitulo = new JLabel("✨ Bienvenido a Artify");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setForeground(COLOR_PRIMARIO);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblDescripcion = new JLabel("<html><p style='width:600px;'>"
                + "Artify es una plataforma impulsada por inteligencia artificial que te ayuda a descubrir arte, eventos culturales y experiencias únicas "
                + "adaptadas a tus gustos e intereses. Conéctate con el mundo creativo de una forma más personalizada."
                + "</p></html>");
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblDescripcion.setForeground(COLOR_TEXTO_CLARO);
        lblDescripcion.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 0));
        lblDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panelTarjetas = new JPanel(new GridLayout(1, 3, 25, 25));
        panelTarjetas.setOpaque(false);
        panelTarjetas.add(crearTarjeta("🎭", "Explora Arte y Cultura",
                "Descubre nuevas obras, estilos y artistas emergentes en un solo lugar."));
        panelTarjetas.add(crearTarjeta("🤖", "Recomendaciones Inteligentes",
                "Nuestro sistema analiza tus gustos y genera sugerencias únicas para ti."));
        panelTarjetas.add(crearTarjeta("📅", "Eventos Cercanos y Personalizados",
                "Encuentra exposiciones, talleres y ferias artísticas en tu zona."));

        JButton btnExplorar = new JButton("🚀 Comienza tu experiencia");
        btnExplorar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnExplorar.setForeground(Color.WHITE);
        btnExplorar.setBackground(COLOR_PRIMARIO);
        btnExplorar.setFocusPainted(false);
        btnExplorar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExplorar.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        btnExplorar.addActionListener(e -> mainFrame.mostrarPanel("Recomendacion"));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setOpaque(false);
        panelBoton.add(btnExplorar);

        jPanelContenido.add(lblTitulo);
        jPanelContenido.add(lblDescripcion);
        jPanelContenido.add(panelTarjetas);
        jPanelContenido.add(Box.createRigidArea(new Dimension(0, 30)));
        jPanelContenido.add(panelBoton);

        add(jPanelMenu, BorderLayout.WEST);
        add(jPanelContenido, BorderLayout.CENTER);
    }

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

    private JPanel crearTarjeta(String emoji, String titulo, String texto) {
        JPanel tarjeta = new JPanel(new BorderLayout());
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 235, 255), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));

        JLabel lblEmoji = new JLabel(emoji, SwingConstants.CENTER);
        lblEmoji.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(45, 45, 45));

        JLabel lblTexto = new JLabel("<html><div style='text-align:center;width:180px;'>" + texto + "</div></html>", SwingConstants.CENTER);
        lblTexto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTexto.setForeground(new Color(120, 120, 120));

        tarjeta.add(lblEmoji, BorderLayout.NORTH);
        tarjeta.add(lblTitulo, BorderLayout.CENTER);
        tarjeta.add(lblTexto, BorderLayout.SOUTH);

        return tarjeta;
    }
}
