package artify;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class RegistrarUsuario extends javax.swing.JFrame {

    public RegistrarUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // ====== COLORES ======
        Color COLOR_PRIMARIO = new Color(102, 153, 255);
        Color COLOR_SECUNDARIO = new Color(240, 245, 255);
        Color COLOR_TEXTO = new Color(60, 60, 60);
        Color COLOR_BORDE = new Color(200, 215, 255);

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();       // 🔹 Nuevo label
        txtNombre = new javax.swing.JTextField();      // 🔹 Nuevo campo de texto
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        txtRecordarContrasenia = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGoogle = new javax.swing.JButton();
        btnFacebook = new javax.swing.JButton();
        btnApple = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Artify - Crear Cuenta");
        getContentPane().setBackground(COLOR_SECUNDARIO);

        // ====== PANEL PRINCIPAL ======
        jPanel1.setBackground(COLOR_SECUNDARIO);
        jPanel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ====== PANEL DEL FORMULARIO ======
        jPanel3.setBackground(Color.WHITE);
        jPanel3.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_BORDE, 1, true),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));

        // ====== CAMPO: NOMBRE COMPLETO ======
        jLabelNombre.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        jLabelNombre.setText("Nombre completo");
        jLabelNombre.setForeground(COLOR_TEXTO);

        txtNombre.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        txtNombre.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_BORDE, 1, true),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        // ====== CAMPO: CORREO ELECTRÓNICO ======
        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        jLabel3.setText("Correo Electrónico");
        jLabel3.setForeground(COLOR_TEXTO);

        txtUsuario.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_BORDE, 1, true),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        // ====== CAMPO: CONTRASEÑA ======
        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        jLabel4.setText("Contraseña");
        jLabel4.setForeground(COLOR_TEXTO);

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        jPasswordField1.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_BORDE, 1, true),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        // ====== CHECKBOX "RECORDAR CONTRASEÑA" ======
        txtRecordarContrasenia.setBackground(Color.WHITE);
        txtRecordarContrasenia.setFocusPainted(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 12));
        jLabel8.setText("Recordar contraseña");
        jLabel8.setForeground(COLOR_TEXTO);
        jLabel8.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRecordarContrasenia.setSelected(!txtRecordarContrasenia.isSelected());
            }
        });

        // ====== BOTÓN REGISTRAR ======
        btnRegistrar.setBackground(COLOR_PRIMARIO);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        btnRegistrar.setText("CREAR CUENTA");
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrar.setBackground(COLOR_PRIMARIO.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrar.setBackground(COLOR_PRIMARIO);
            }
        });

        // ====== LAYOUT PANEL FORMULARIO ======
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelNombre)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(txtUsuario)
                        .addComponent(jLabel4)
                        .addComponent(jPasswordField1)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(txtRecordarContrasenia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8))
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jLabelNombre)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(txtRecordarContrasenia)
                        .addComponent(jLabel8))
                    .addGap(25, 25, 25)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE))
        );

        // ====== TÍTULO PRINCIPAL ======
        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 28));
        jLabel2.setText("Crear Cuenta");
        jLabel2.setForeground(COLOR_PRIMARIO);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        jSeparator1.setForeground(COLOR_BORDE);
        jSeparator2.setForeground(COLOR_BORDE);

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 12));
        jLabel5.setText("o continuar con");
        jLabel5.setForeground(new Color(120, 120, 120));

        // ====== BOTONES DE REDES SOCIALES ======
        btnGoogle.setText("Google");
        configurarBotonSocial(btnGoogle, "/imagenes/google.png", Color.WHITE);

        btnFacebook.setText("Facebook");
        configurarBotonSocial(btnFacebook, "/imagenes/facebook.png", Color.WHITE);

        btnApple.setText("Apple");
        configurarBotonSocial(btnApple, "/imagenes/apple.png", Color.WHITE);

        jLabel6.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel6.setText("Al registrarte aceptas nuestros Términos de Servicio y la Política de Privacidad");
        jLabel6.setForeground(new Color(150, 150, 150));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 10));
        jLabel7.setText("¿Ya tienes cuenta? Inicia Sesión");
        jLabel7.setForeground(COLOR_PRIMARIO);
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // ====== LAYOUT PRINCIPAL ======
        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 15, 0);

        gbc.insets = new Insets(0, 0, 30, 0);
        jPanel1.add(jLabel2, gbc);

        gbc.insets = new Insets(0, 0, 30, 0);
        jPanel1.add(jPanel3, gbc);

        gbc.insets = new Insets(0, 0, 20, 0);
        JPanel panelSeparador = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelSeparador.setBackground(COLOR_SECUNDARIO);
        panelSeparador.add(jSeparator2);
        panelSeparador.add(jLabel5);
        panelSeparador.add(jSeparator1);
        jSeparator1.setPreferredSize(new Dimension(80, 1));
        jSeparator2.setPreferredSize(new Dimension(80, 1));
        jPanel1.add(panelSeparador, gbc);

        gbc.insets = new Insets(0, 0, 25, 0);
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelBotones.setBackground(COLOR_SECUNDARIO);
        panelBotones.add(btnGoogle);
        panelBotones.add(btnFacebook);
        panelBotones.add(btnApple);
        jPanel1.add(panelBotones, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        jPanel1.add(jLabel6, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        jPanel1.add(jLabel7, gbc);

        // ====== ENCABEZADO ======
        jPanel2.setBackground(COLOR_PRIMARIO);
        jPanel2.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setText("🎨 Bienvenido a Artify");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(jLabel1, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jPanel2, BorderLayout.NORTH);
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
        setSize(500, 850);
    }

    // 🔹 Método para configurar botones sociales
    private void configurarBotonSocial(JButton boton, String rutaIcono, Color colorFondo) {
        try {
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(rutaIcono));
            if (iconoOriginal.getImage() != null) {
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
                boton.setIcon(new ImageIcon(imagenEscalada));
            }
        } catch (Exception e) {
            System.out.println("Icono no encontrado: " + rutaIcono);
        }

        boton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        boton.setBackground(colorFondo);
        boton.setForeground(new Color(60, 60, 60));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1, true),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setIconTextGap(8);

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(new Color(245, 245, 245));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(colorFondo);
            }
        });
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new RegistrarUsuario().setVisible(true);
        });
    }

    // Variables
    private javax.swing.JButton btnApple, btnFacebook, btnGoogle, btnRegistrar;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabelNombre;
    private javax.swing.JPanel jPanel1, jPanel2, jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1, jSeparator2;
    private javax.swing.JCheckBox txtRecordarContrasenia;
    private javax.swing.JTextField txtUsuario, txtNombre;  // 🔹 Nuevo campo
}
