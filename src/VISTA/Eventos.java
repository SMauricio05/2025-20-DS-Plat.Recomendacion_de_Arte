package VISTA;

import MODELO.MostrarEventos;
import MODELO.Evento;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.List;

public class Eventos extends JPanel {

    private MainArtify mainFrame;

    public Eventos(MainArtify frame) {
        this.mainFrame = frame;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initUI();
    }

    private void initUI() {

        Color COLOR_PRIMARIO = new Color(74, 107, 255);
        Color COLOR_SECUNDARIO = new Color(230, 240, 255);
        Color COLOR_TEXTO = new Color(45, 45, 45);
        Color COLOR_TEXTO_CLARO = new Color(120, 120, 120);
        Color COLOR_FONDO = new Color(248, 250, 255);

        // === PANEL LATERAL ===
        JPanel panelMenu = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, COLOR_SECUNDARIO, 0, getHeight(), Color.WHITE));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelMenu.setPreferredSize(new Dimension(220, getHeight()));
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        panelMenu.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));

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
        JButton btnBuscar = crearBotonMenu("🔍 Buscar", false);
        JButton btnEventos = crearBotonMenu("📅 Eventos", true);
        JButton btnCatalogo = crearBotonMenu("📚 Catálogo", false);
        JButton btnIntereses = crearBotonMenu("❤️ Mis Intereses", false);
        JButton btnPerfil = crearBotonMenu("👤 Perfil", false);
        JButton btnCerrar = crearBotonMenu("🚪 Cerrar Sesión", false);

        // === CONEXIÓN DE BOTONES ===
        btnInicio.addActionListener(e -> mainFrame.mostrarPanel("Inicio"));
        btnBuscar.addActionListener(e -> mainFrame.mostrarPanel("Busqueda"));
        btnEventos.addActionListener(e -> mainFrame.mostrarPanel("Eventos"));
        btnCatalogo.addActionListener(e -> mainFrame.mostrarPanel("Obras"));
        btnIntereses.addActionListener(e -> mainFrame.mostrarPanel("Recomendacion"));
        btnPerfil.addActionListener(e -> mainFrame.mostrarPanel("EditarPerfil"));
        btnCerrar.addActionListener(e -> System.exit(0));

        panelMenu.add(lblLogo);
        panelMenu.add(lblSeccion);
        panelMenu.add(btnInicio);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        panelMenu.add(btnBuscar);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        panelMenu.add(btnEventos);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        panelMenu.add(btnCatalogo);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        panelMenu.add(btnIntereses);
        panelMenu.add(Box.createVerticalGlue());
        panelMenu.add(btnPerfil);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 8)));
        panelMenu.add(btnCerrar);

        // === PANEL PRINCIPAL ===
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBackground(COLOR_FONDO);
        panelContenido.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel lblTitulo = new JLabel("📅 Eventos Culturales");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblTitulo.setForeground(COLOR_PRIMARIO);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JLabel lblDescripcion = new JLabel("Descubre los próximos eventos y exposiciones culturales.");
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblDescripcion.setForeground(COLOR_TEXTO_CLARO);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setOpaque(false);
        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblDescripcion);
        panelSuperior.add(Box.createRigidArea(new Dimension(0, 15)));

        panelContenido.add(panelSuperior, BorderLayout.NORTH);

        // === LISTA DE EVENTOS ===
        JPanel panelEventos = new JPanel();
        panelEventos.setLayout(new BoxLayout(panelEventos, BoxLayout.Y_AXIS));
        panelEventos.setOpaque(false);

        JScrollPane scrollEventos = new JScrollPane(panelEventos);
        scrollEventos.setBorder(BorderFactory.createEmptyBorder());
        scrollEventos.getViewport().setOpaque(false);
        scrollEventos.setOpaque(false);

        panelContenido.add(scrollEventos, BorderLayout.CENTER);

        // === CARGAR DATOS DESDE LA BD ===
        MostrarEventos mostrarEventos = new MostrarEventos();
        List<Evento> lista = mostrarEventos.obtenerEventos();

        if (lista.isEmpty()) {
            JLabel sinDatos = new JLabel("No hay eventos registrados en la base de datos.");
            sinDatos.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            sinDatos.setForeground(COLOR_TEXTO_CLARO);
            panelEventos.add(sinDatos);
        } else {
            for (Evento ev : lista) {
                panelEventos.add(crearTarjetaEvento(ev));
                panelEventos.add(Box.createRigidArea(new Dimension(0, 15)));
            }
        }

        add(panelMenu, BorderLayout.WEST);
        add(panelContenido, BorderLayout.CENTER);
    }

    // === Crear Botón ===
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

    // === Crear Tarjeta de Evento ===
    private JPanel crearTarjetaEvento(Evento evento) {
        JPanel tarjeta = new JPanel(new BorderLayout(10, 10));
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(new CompoundBorder(
                new LineBorder(new Color(230, 230, 250), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));

        // Imagen centrada y escalada
        JLabel lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setPreferredSize(new Dimension(200, 150));

        if (evento.getImagenUrl() != null && !evento.getImagenUrl().isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(new java.net.URL(evento.getImagenUrl()));
                Image img = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
            } catch (Exception e) {
                lblImagen.setText("Sin imagen");
                lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            }
        } else {
            lblImagen.setText("Sin imagen");
        }

        // Texto
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);

        JLabel lblTitulo = new JLabel(evento.getNombre());
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JLabel lblUbicacion = new JLabel("📍 " + evento.getUbicacion());
        lblUbicacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblFechas = new JLabel("🗓 " + evento.getFechaInicio() + " - " + evento.getFechaFin());
        lblFechas.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        JLabel lblDescripcion = new JLabel("<html><p style='width:400px;'>" + evento.getDescripcion() + "</p></html>");
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblDescripcion.setForeground(new Color(90, 90, 90));

        info.add(lblTitulo);
        info.add(lblUbicacion);
        info.add(lblFechas);
        info.add(lblDescripcion);

        tarjeta.add(lblImagen, BorderLayout.WEST);
        tarjeta.add(info, BorderLayout.CENTER);

        return tarjeta;
    }
}
