package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.MainApplication;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JProgressBar progressBar;
	private Container containerLogin = new Container(), containerLoading = new Container();

	/**
	 * Create the frame.
	 */
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoadingBar();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		containerLogin.setBounds(843, 342, 427, 368);
		containerLogin.setVisible(false);

		containerLoading.setBounds(843, 342, 427, 368);
		contentPane.add(containerLoading);

		progressBar = new JProgressBar();
		progressBar.setBounds(49, 151, 333, 33);
		containerLoading.add(progressBar);
		contentPane.add(containerLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(29, 105, 388, 44);
		txtLogin.setColumns(10);
		containerLogin.add(txtLogin);

		passwordField = new JPasswordField();
		passwordField.setBounds(29, 197, 388, 44);
		containerLogin.add(passwordField);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBackground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(29, 73, 116, 25);
		containerLogin.add(lblLogin);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(29, 160, 116, 25);
		containerLogin.add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtLogin.getText().equals("admin") && "admin".equals(new String(passwordField.getPassword()))) {
					MainApplication.frame.dispose();
					MainApplication.frame = new Menu();
				} else
					JOptionPane.showMessageDialog(null, "Login ou Senha invalida!");
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(111, 271, 221, 44);
		containerLogin.add(btnLogin);

		JLabel lblLogo = new JLabel("");
		lblLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/Img/Logo.png")));
		lblLogo.setBounds(843, 11, 427, 352);
		contentPane.add(lblLogo);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/Img/LoginScreen.png")));
		lblBackground.setBounds(0, 0, 1280, 720);
		contentPane.add(lblBackground);
	}

	public void LoadingBar() {
		new Thread(() -> {
			try {
				for (int i = 0; i <= 100; i++) {
					progressBar.setValue(i);
					Thread.sleep(50);
				}
				containerLogin.setVisible(true);
				containerLoading.setVisible(false);
			} catch (Exception e1) {
			}
		}).start();
	}
}
