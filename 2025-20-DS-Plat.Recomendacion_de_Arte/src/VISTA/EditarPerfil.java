package VISTA;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class EditarPerfil extends javax.swing.JPanel {

    private MainArtify mainFrame;

    // Constructor con referencia al frame principal
    public EditarPerfil(MainArtify frame) {
        this.mainFrame = frame;
        initComponents();
        cargarImagenPerfil();
    }

    private void initComponents() {

        Color COLOR_PRIMARIO = new Color(74, 107, 255);
        Color COLOR_SECUNDARIO = new Color(230, 240, 255);
        Color COLOR_TEXTO = new Color(45, 45, 45);
        Color COLOR_TEXTO_CLARO = new Color(120, 120, 120);
        Color COLOR_FONDO = new Color(248, 250, 255);
        Color COLOR_BORDE = new Color(210, 220, 240);

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

        JButton btnInicio = crearBotonMenu("🏠 Inicio", false);
        JButton btnBuscar = crearBotonMenu("🔍 Buscar", false);
        JButton btnEventos = crearBotonMenu("📅 Eventos", false);
        JButton btnCatalogo = crearBotonMenu("📚 Catálogo", false);
        JButton btnIntereses = crearBotonMenu("❤️ Mis Intereses", false);
        JButton btnPerfil = crearBotonMenu("👤 Perfil", true);
        JButton btnCerrar = crearBotonMenu("🚪 Cerrar Sesión", false);

        // Acciones de navegación
        btnInicio.addActionListener(e -> mainFrame.mostrarPanel("Inicio"));
        btnBuscar.addActionListener(e -> mainFrame.mostrarPanel("Buscar"));
        btnEventos.addActionListener(e -> mainFrame.mostrarPanel("Eventos"));
        btnCatalogo.addActionListener(e -> mainFrame.mostrarPanel("Catalogo"));
        btnIntereses.addActionListener(e -> mainFrame.mostrarPanel("Intereses"));

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

        // ===== ENCABEZADO =====
        JLabel lblTitulo = new JLabel("👤 Editar Perfil");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setForeground(COLOR_PRIMARIO);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblDescripcion = new JLabel("Actualiza tu información personal y preferencias");
        lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblDescripcion.setForeground(COLOR_TEXTO_CLARO);
        lblDescripcion.setBorder(BorderFactory.createEmptyBorder(5, 0, 30, 0));
        lblDescripcion.setAlignmentX(Component.LEFT_ALIGNMENT);

        // ===== CONTENEDOR PRINCIPAL =====
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setOpaque(false);
        panelPrincipal.setAlignmentX(Component.LEFT_ALIGNMENT);

        // ===== SECCIÓN FOTO DE PERFIL =====
        JPanel panelFoto = crearPanelSeccion("📸 Foto de Perfil");
        
        JPanel panelFotoContenido = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 10));
        panelFotoContenido.setOpaque(false);
        
        // Foto de perfil circular
        JLabel lblFotoPerfil = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Fondo circular
                g2d.setColor(Color.WHITE);
                g2d.fillOval(0, 0, getWidth(), getHeight());
                
                // Borde
                g2d.setColor(COLOR_PRIMARIO);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawOval(1, 1, getWidth()-2, getHeight()-2);
                
                super.paintComponent(g);
            }
        };
        lblFotoPerfil.setPreferredSize(new Dimension(120, 120));
        lblFotoPerfil.setHorizontalAlignment(SwingConstants.CENTER);
        lblFotoPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Botones de foto
        JPanel panelBotonesFoto = new JPanel();
        panelBotonesFoto.setLayout(new BoxLayout(panelBotonesFoto, BoxLayout.Y_AXIS));
        panelBotonesFoto.setOpaque(false);
        
        JButton btnCambiarFoto = crearBotonSecundario("📷 Cambiar Foto");
        JButton btnEliminarFoto = crearBotonTexto("🗑️ Eliminar Foto");
        
        panelBotonesFoto.add(btnCambiarFoto);
        panelBotonesFoto.add(Box.createRigidArea(new Dimension(0, 8)));
        panelBotonesFoto.add(btnEliminarFoto);
        
        panelFotoContenido.add(lblFotoPerfil);
        panelFotoContenido.add(panelBotonesFoto);
        panelFoto.add(panelFotoContenido);

        // ===== SECCIÓN INFORMACIÓN PERSONAL =====
        JPanel panelInfoPersonal = crearPanelSeccion("👤 Información Personal");
        
        JPanel panelCampos = new JPanel(new GridLayout(3, 2, 25, 20));
        panelCampos.setOpaque(false);
        panelCampos.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        // Campos del formulario
        JTextField txtNombre = crearCampoTexto("Nombre completo");
        JTextField txtEmail = crearCampoTexto("Correo electrónico");
        JTextField txtTelefono = crearCampoTexto("Teléfono");
        JTextField txtFechaNacimiento = crearCampoTexto("Fecha de nacimiento");
        JComboBox<String> cmbGenero = crearComboBox(new String[]{"Seleccionar", "Masculino", "Femenino", "Otro", "Prefiero no decir"});
        JTextField txtUbicacion = crearCampoTexto("Ubicación");
        
        panelCampos.add(crearGrupoCampo("Nombre completo *", txtNombre));
        panelCampos.add(crearGrupoCampo("Correo electrónico *", txtEmail));
        panelCampos.add(crearGrupoCampo("Teléfono", txtTelefono));
        panelCampos.add(crearGrupoCampo("Fecha de nacimiento", txtFechaNacimiento));
        panelCampos.add(crearGrupoCampo("Género", cmbGenero));
        panelCampos.add(crearGrupoCampo("Ubicación", txtUbicacion));
        
        panelInfoPersonal.add(panelCampos);

        // ===== SECCIÓN CONTRASEÑA =====
        JPanel panelContraseña = crearPanelSeccion("🔒 Cambiar Contraseña");
        
        JPanel panelCamposContraseña = new JPanel(new GridLayout(2, 2, 25, 20));
        panelCamposContraseña.setOpaque(false);
        panelCamposContraseña.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JPasswordField txtContraseñaActual = new JPasswordField();
        JPasswordField txtNuevaContraseña = new JPasswordField();
        JPasswordField txtConfirmarContraseña = new JPasswordField();
        
        panelCamposContraseña.add(crearGrupoCampo("Contraseña actual", txtContraseñaActual));
        panelCamposContraseña.add(crearGrupoCampo("Nueva contraseña", txtNuevaContraseña));
        panelCamposContraseña.add(crearGrupoCampo("Confirmar contraseña", txtConfirmarContraseña));
        
        panelContraseña.add(panelCamposContraseña);

        // ===== SECCIÓN BIOGRAFÍA =====
        JPanel panelBiografia = crearPanelSeccion("📝 Biografía");
        
        JTextArea areaBiografia = new JTextArea(4, 30);
        areaBiografia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        areaBiografia.setLineWrap(true);
        areaBiografia.setWrapStyleWord(true);
        areaBiografia.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_BORDE, 1, true),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        areaBiografia.setBackground(Color.WHITE);
        
        JScrollPane scrollBiografia = new JScrollPane(areaBiografia);
        scrollBiografia.setPreferredSize(new Dimension(600, 100));
        scrollBiografia.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        scrollBiografia.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panelBiografia.add(scrollBiografia);

        // ===== BOTONES DE ACCIÓN =====
        JPanel panelBotonesAccion = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelBotonesAccion.setOpaque(false);
        panelBotonesAccion.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelBotonesAccion.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        JButton btnGuardar = new JButton("💾 Guardar Cambios") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                GradientPaint gradiente = new GradientPaint(0, 0, COLOR_PRIMARIO, 0, getHeight(), new Color(94, 127, 255));
                g2d.setPaint(gradiente);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                
                super.paintComponent(g);
            }
        };
        
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);

        JButton btnCancelar = crearBotonSecundario("❌ Cancelar");

        btnGuardar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Cambios guardados correctamente.",
                    "Perfil Actualizado",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        panelBotonesAccion.add(btnGuardar);
        panelBotonesAccion.add(btnCancelar);

        // ===== ENSAMBLAJE FINAL =====
        panelPrincipal.add(panelFoto);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 25)));
        panelPrincipal.add(panelInfoPersonal);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 25)));
        panelPrincipal.add(panelContraseña);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 25)));
        panelPrincipal.add(panelBiografia);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 25)));
        panelPrincipal.add(panelBotonesAccion);

        jPanelContenido.add(lblTitulo);
        jPanelContenido.add(lblDescripcion);
        jPanelContenido.add(panelPrincipal);

        add(jPanelMenu, BorderLayout.WEST);
        add(jPanelContenido, BorderLayout.CENTER);
    }

    // ===== MÉTODOS AUXILIARES =====

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

    private JPanel crearPanelSeccion(String titulo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JLabel label = new JLabel(titulo);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(new Color(45, 45, 45));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panel.add(label);
        
        return panel;
    }

    private JTextField crearCampoTexto(String placeholder) {
        JTextField campo = new JTextField();
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(210, 220, 240), 1, true),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        campo.setBackground(Color.WHITE);
        campo.setPreferredSize(new Dimension(250, 45));
        return campo;
    }

    private JComboBox<String> crearComboBox(String[] opciones) {
        JComboBox<String> combo = new JComboBox<>(opciones);
        combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        combo.setBackground(Color.WHITE);
        combo.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(210, 220, 240), 1, true),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        return combo;
    }

    private JPanel crearGrupoCampo(String etiqueta, JComponent campo) {
        JPanel grupo = new JPanel(new BorderLayout());
        grupo.setOpaque(false);
        
        JLabel label = new JLabel(etiqueta);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(80, 80, 80));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
        grupo.add(label, BorderLayout.NORTH);
        grupo.add(campo, BorderLayout.CENTER);
        
        return grupo;
    }

    private JButton crearBotonSecundario(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBackground(Color.WHITE);
        boton.setForeground(new Color(74, 107, 255));
        boton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(74, 107, 255), 1, true),
            BorderFactory.createEmptyBorder(12, 25, 12, 25)
        ));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    private JButton crearBotonTexto(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        boton.setForeground(new Color(120, 120, 120));
        boton.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        boton.setContentAreaFilled(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    private void cargarImagenPerfil() {
        // Implementación para cargar imagen de perfil
        // Puedes agregar la lógica para cargar una imagen aquí
    }
}