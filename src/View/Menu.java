package View;

import Main.MainApplication;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(0, 0, 1920, 1080);
		setUndecorated(true);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 1920, 130);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblBack = new JLabel("");
		lblBack.setIcon(new ImageIcon(Menu.class.getResource("/Img/icons8-back-32.png")));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApplication.frame.dispose();
			}
		});
		lblBack.setBounds(49, 35, 42, 49);
		panel.add(lblBack);

		Panel lblIcons = new Panel();
		lblIcons.setBackground(new Color(240, 248, 255));
		lblIcons.setBounds(0, 481, 1920, 601);
		contentPane.add(lblIcons);
		lblIcons.setLayout(null);

		JLabel lblCaixa = new JLabel("");
		lblCaixa.setIcon(new ImageIcon(Menu.class.getResource("/Img/Caixa.png")));
		lblCaixa.setBounds(56, 70, 250, 146);
		lblIcons.add(lblCaixa);

		JLabel lblEstoque = new JLabel("");
		lblEstoque.setIcon(new ImageIcon(Menu.class.getResource("/Img/Estoque.png")));
		lblEstoque.setBounds(388, 70, 250, 146);
		lblIcons.add(lblEstoque);

		JLabel lblClientes = new JLabel("");
		lblClientes.setIcon(new ImageIcon(Menu.class.getResource("/Img/Client.png")));
		lblClientes.setBounds(701, 70, 250, 146);
		lblIcons.add(lblClientes);

		JLabel lblWelcome = new JLabel("Bem vindo.");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWelcome.setBounds(24, 180, 81, 23);
		contentPane.add(lblWelcome);

		JLabel lblName = new JLabel("Administrador");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblName.setBounds(24, 214, 248, 110);
		contentPane.add(lblName);
	}
}
