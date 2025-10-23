package artify;

import java.awt.*;
import javax.swing.*;

public class RegistroArtify extends JFrame {

    public RegistroArtify() {
        // Configuración general de la ventana
        setTitle("Bienvenido a Artify");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal con fondo degradado
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(28, 96, 206),
                                                     0, getHeight(), new Color(77, 139, 234));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelFondo.setLayout(null);

        // Etiqueta título
        JLabel lblTitulo = new JLabel("Bienvenido a Artify", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(70, 30, 260, 40);
        panelFondo.add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Crea una cuenta", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSubtitulo.setForeground(Color.WHITE);
        lblSubtitulo.setBounds(100, 70, 200, 30);
        panelFondo.add(lblSubtitulo);

        // Panel de formulario blanco
        JPanel panelForm = new JPanel();
        panelForm.setBackground(Color.WHITE);
        panelForm.setBounds(50, 120, 300, 280);
        panelForm.setLayout(null);

        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblCorreo.setBounds(20, 20, 200, 25);
        panelForm.add(lblCorreo);

        JTextField txtCorreo = new JTextField();
        txtCorreo.setBounds(20, 45, 250, 30);
        panelForm.add(txtCorreo);

        JLabel lblContra = new JLabel("Contraseña:");
        lblContra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblContra.setBounds(20, 85, 200, 25);
        panelForm.add(lblContra);

        JPasswordField txtContra = new JPasswordField();
        txtContra.setBounds(20, 110, 250, 30);
        panelForm.add(txtContra);

        JCheckBox chkRecordar = new JCheckBox("Recordar Contraseña");
        chkRecordar.setBackground(Color.WHITE);
        chkRecordar.setBounds(20, 150, 200, 25);
        panelForm.add(chkRecordar);

        JButton btnRegistrar = new JButton("Register");
        btnRegistrar.setBounds(20, 190, 250, 35);
        btnRegistrar.setBackground(Color.BLACK);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        panelForm.add(btnRegistrar);

        panelFondo.add(panelForm);

        // Texto inferior
        JLabel lblContinuar = new JLabel("— o continuar con —", SwingConstants.CENTER);
        lblContinuar.setForeground(Color.WHITE);
        lblContinuar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblContinuar.setBounds(50, 420, 300, 20);
        panelFondo.add(lblContinuar);

        JButton btnGoogle = new JButton("Google");
        btnGoogle.setBounds(120, 450, 160, 35);
        btnGoogle.setBackground(Color.WHITE);
        btnGoogle.setFocusPainted(false);
        btnGoogle.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelFondo.add(btnGoogle);

        JLabel lblTerminos = new JLabel(
            "<html><center>Al hacer clic en Continuar aceptas nuestros<br>"
            + "<u>Términos de servicio</u> y la <u>Política de privacidad</u></center></html>",
            SwingConstants.CENTER
        );
        lblTerminos.setForeground(Color.WHITE);
        lblTerminos.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblTerminos.setBounds(50, 490, 300, 40);
        panelFondo.add(lblTerminos);

        add(panelFondo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistroArtify().setVisible(true);
        });
    }
}
