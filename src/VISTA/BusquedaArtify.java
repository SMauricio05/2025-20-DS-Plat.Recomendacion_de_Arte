package VISTA;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BusquedaArtify extends JFrame {

    public BusquedaArtify() {
        setTitle("Artify - Búsqueda de Obras y Artistas");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        JButton btnBuscar = crearBotonMenu("🔍 Buscar", true);
        JButton btnEventos = crearBotonMenu("📅 Eventos", false);
        JButton btnCatalogo = crearBotonMenu("📚 Catálogo", false);
        JButton btnIntereses = crearBotonMenu("❤️ Mis Intereses", false);
        JButton btnPerfil = crearBotonMenu("👤 Perfil", false);
        JButton btnCerrar = crearBotonMenu("🚪 Cerrar Sesión", false);

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
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBackground(COLOR_FONDO);
        panelContenido.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel lblTitulo = new JLabel("🔍 Buscar Obras y Artistas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitulo.setForeground(COLOR_PRIMARIO);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JLabel lblDescripcion = new JLabel("Explora el arte según tus preferencias o descubre nuevos artistas.");
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDescripcion.setForeground(COLOR_TEXTO_CLARO);

        // ===== BUSCADOR =====
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 15));
        panelBusqueda.setOpaque(false);

        JTextField txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(400, 40));
        txtBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtBuscar.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 235, 255), 1, true),
                new EmptyBorder(8, 10, 8, 10)
        ));
        txtBuscar.setToolTipText("Escribe el nombre del artista o la obra...");

        JButton btnBuscarArte = new JButton("Buscar");
        btnBuscarArte.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBuscarArte.setBackground(COLOR_PRIMARIO);
        btnBuscarArte.setForeground(Color.WHITE);
        btnBuscarArte.setFocusPainted(false);
        btnBuscarArte.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnBuscarArte.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelBusqueda.add(txtBuscar);
        panelBusqueda.add(btnBuscarArte);

        // ===== RESULTADOS =====
        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new BoxLayout(panelResultados, BoxLayout.Y_AXIS));
        panelResultados.setOpaque(false);

        JScrollPane scrollResultados = new JScrollPane(panelResultados);
        scrollResultados.setBorder(BorderFactory.createEmptyBorder());
        scrollResultados.getViewport().setOpaque(false);
        scrollResultados.setOpaque(false);

        // Acción de búsqueda (simulada)
        btnBuscarArte.addActionListener(e -> {
            panelResultados.removeAll();
            String query = txtBuscar.getText().trim();

            if (query.isEmpty()) {
                JLabel sinTexto = new JLabel("Por favor, ingresa un término de búsqueda.");
                sinTexto.setForeground(COLOR_TEXTO_CLARO);
                sinTexto.setFont(new Font("Segoe UI", Font.ITALIC, 14));
                panelResultados.add(sinTexto);
            } else {
                for (int i = 1; i <= 5; i++) {
                    JPanel item = crearTarjeta("Resultado " + i + ": " + query, "Descripción del resultado " + i);
                    panelResultados.add(item);
                    panelResultados.add(Box.createRigidArea(new Dimension(0, 10)));
                }
            }

            panelResultados.revalidate();
            panelResultados.repaint();
        });

        // ===== ENSAMBLA TODO =====
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setOpaque(false);
        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblDescripcion);
        panelSuperior.add(Box.createRigidArea(new Dimension(0, 15)));
        panelSuperior.add(panelBusqueda);
        panelSuperior.add(Box.createRigidArea(new Dimension(0, 15)));

        panelContenido.add(panelSuperior, BorderLayout.NORTH);
        panelContenido.add(scrollResultados, BorderLayout.CENTER);

        add(jPanelMenu, BorderLayout.WEST);
        add(panelContenido, BorderLayout.CENTER);

        setVisible(true);
    }

    // === Método auxiliar para crear botones del menú ===
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

    // === Método auxiliar para tarjetas ===
    private JPanel crearTarjeta(String titulo, String descripcion) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 230, 250), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(45, 45, 45));

        JLabel lblDesc = new JLabel("<html><p style='width:400px;'>" + descripcion + "</p></html>");
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDesc.setForeground(new Color(100, 100, 100));

        tarjeta.add(lblTitulo);
        tarjeta.add(Box.createRigidArea(new Dimension(0, 5)));
        tarjeta.add(lblDesc);

        return tarjeta;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BusquedaArtify());
    }
}
