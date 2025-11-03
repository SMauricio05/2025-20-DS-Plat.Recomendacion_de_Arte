package VISTA;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BusquedaArtify extends JPanel {

    private MainArtify mainFrame;

    public BusquedaArtify(MainArtify frame) {
        this.mainFrame = frame;
        setLayout(new BorderLayout());
        setBackground(new Color(248, 250, 255));

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

        // Acción de botones del menú
        btnInicio.addActionListener(e -> mainFrame.mostrarPanel("Inicio"));
        btnCerrar.addActionListener(e -> mainFrame.mostrarPanel("Login"));
        btnEventos.addActionListener(e -> mainFrame.mostrarPanel("Eventos"));
        btnCatalogo.addActionListener(e -> mainFrame.mostrarPanel("Obras"));
        btnIntereses.addActionListener(e -> mainFrame.mostrarPanel("Recomendacion"));
        btnPerfil.addActionListener(e -> mainFrame.mostrarPanel("EditarPerfil"));
        btnCerrar.addActionListener(e -> System.exit(0));

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
        MODELO.BuscarEnBD buscador = new MODELO.BuscarEnBD();
        java.util.List<MODELO.BuscarEnBD.Obra> obras = buscador.buscarObras(query);

        if (obras.isEmpty()) {
            JLabel sinResultados = new JLabel("No se encontraron coincidencias para \"" + query + "\".");
            sinResultados.setForeground(COLOR_TEXTO_CLARO);
            sinResultados.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            panelResultados.add(sinResultados);
        } else {
            for (MODELO.BuscarEnBD.Obra obra : obras) {
                JPanel item = crearTarjeta(
        obra.getTitulo() + " — " + obra.getArtista(),
        "<b>Categoría:</b> " + obra.getCategoria() +
        "<br><b>Fecha:</b> " + obra.getFechaCreacion() +
        "<br><br>" + obra.getDescripcion(),
        obra.getImagenUrl()
);

                panelResultados.add(item);
                panelResultados.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
    }

    panelResultados.revalidate();
    panelResultados.repaint();
        });

        // ENSAMBLAR TODO
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
// === Método auxiliar para tarjetas (ahora con imagen) ===
private JPanel crearTarjeta(String titulo, String descripcion, String imagenUrl) {
    JPanel tarjeta = new JPanel(new BorderLayout(15, 0));
    tarjeta.setBackground(Color.WHITE);
    tarjeta.setBorder(new CompoundBorder(
            new LineBorder(new Color(230, 230, 250), 1, true),
            new EmptyBorder(10, 10, 10, 10)
    ));

JPanel imagePanel = new JPanel(new GridBagLayout()); // centra cualquier componente
imagePanel.setPreferredSize(new Dimension(120, 120));
imagePanel.setOpaque(false); // deja fondo transparente para que la tarjeta muestre su propio fondo

JLabel lblImagen = new JLabel();
lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
lblImagen.setVerticalAlignment(SwingConstants.CENTER);

// Crea icono escalado centrado dentro de 120x120
if (imagenUrl != null && !imagenUrl.isEmpty()) {
    try {
        java.net.URL url = new java.net.URL(imagenUrl);
        java.awt.image.BufferedImage imgOriginal = javax.imageio.ImageIO.read(url);

        if (imgOriginal != null) {
            int maxAncho = 120;
            int maxAlto = 120;

            double ratioAncho = (double) maxAncho / imgOriginal.getWidth();
            double ratioAlto = (double) maxAlto / imgOriginal.getHeight();
            double ratioFinal = Math.min(ratioAncho, ratioAlto);

            int nuevoAncho = (int) (imgOriginal.getWidth() * ratioFinal);
            int nuevoAlto = (int) (imgOriginal.getHeight() * ratioFinal);

            // BufferedImage blanco para evitar fondo negro
            java.awt.image.BufferedImage imagenFinal = new java.awt.image.BufferedImage(maxAncho, maxAlto, java.awt.image.BufferedImage.TYPE_INT_RGB);
            java.awt.Graphics2D g2d = imagenFinal.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, maxAncho, maxAlto);

            // Dibujar la imagen escalada centrada
            int x = (maxAncho - nuevoAncho) / 2;
            int y = (maxAlto - nuevoAlto) / 2;
            g2d.drawImage(imgOriginal, x, y, nuevoAncho, nuevoAlto, null);
            g2d.dispose();

            lblImagen.setIcon(new ImageIcon(imagenFinal));
        } else {
            lblImagen.setText("🖼️");
            lblImagen.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
        }
    } catch (Exception e) {
        lblImagen.setText("🖼️");
        lblImagen.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
    }
} else {
    lblImagen.setText("🖼️");
    lblImagen.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
}

// Añadir etiqueta (imagen) al panel centrador
imagePanel.add(lblImagen);

// En la tarjeta: en lugar de poner lblImagen en WEST, pon imagePanel
tarjeta.add(imagePanel, BorderLayout.WEST);


    // Panel derecho: texto
    JPanel panelTexto = new JPanel();
    panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));
    panelTexto.setOpaque(false);

    JLabel lblTitulo = new JLabel(titulo);
    lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
    lblTitulo.setForeground(new Color(45, 45, 45));

    JLabel lblDesc = new JLabel("<html><p style='width:400px;'>" + descripcion + "</p></html>");
    lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    lblDesc.setForeground(new Color(100, 100, 100));

    panelTexto.add(lblTitulo);
    panelTexto.add(Box.createRigidArea(new Dimension(0, 5)));
    panelTexto.add(lblDesc);

    tarjeta.add(lblImagen, BorderLayout.WEST);
    tarjeta.add(panelTexto, BorderLayout.CENTER);

    return tarjeta;
}

}
