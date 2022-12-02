package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.MainApplication;
import Model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.UsuarioDAO;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;

public class Usuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UsuarioDAO uDAO = new UsuarioDAO();
	private JTable table;
	private JTextField txtId, txtNome, txtLogin, txtDesconto;
	private Container addItemContainer, tabbleContainer;
	private JTextField txtNomeCadastro;
	private JTextField txtDescontoCadastro;
	private JTextField txtLoginCadastro;
	private JTextField txtSenhaCadastro;

	/**
	 * Create the frame.
	 */
	public Usuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Usuario user : uDAO.getLista()) {
					String[] linha = { user.getUsuarioAtivo().toString(), Integer.toString(user.getId()),
							user.getUsuarioNome(), user.getUsuarioLogin(), Double.toString(user.getUsuarioDesconto()) };
					modelo.addRow(linha);
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 1260, 511);

		tabbleContainer = new Container();
		tabbleContainer.setBounds(10, 136, 1260, 573);
		tabbleContainer.add(scrollPane);
		tabbleContainer.setVisible(true);

		addItemContainer = new Container();
		addItemContainer.setBounds(10, 136, 1260, 573);
		addItemContainer.setVisible(false);
		contentPane.add(addItemContainer);

		JLabel lvlAtivoCadastro = new JLabel("Ativo");
		lvlAtivoCadastro.setBounds(50, 67, 46, 14);
		addItemContainer.add(lvlAtivoCadastro);

		JRadioButton rdbAtivoCadastro = new JRadioButton("");
		rdbAtivoCadastro.setSelected(true);
		rdbAtivoCadastro.setBounds(90, 63, 109, 23);
		addItemContainer.add(rdbAtivoCadastro);
		
		JRadioButton rdbCaixa = new JRadioButton("");
		rdbCaixa.setSelected(true);
		rdbCaixa.setBounds(1094, 176, 109, 23);
		addItemContainer.add(rdbCaixa);
		
		JRadioButton rdbGerente = new JRadioButton("");
		rdbGerente.setSelected(true);
		rdbGerente.setBounds(1094, 216, 109, 23);
		addItemContainer.add(rdbGerente);

		JButton btbAdd = new JButton("Adicionar");
		btbAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario user = new Usuario(txtNomeCadastro.getText(), txtLoginCadastro.getText(),
						txtSenhaCadastro.getText(), Integer.parseInt(txtDescontoCadastro.getText()),
						rdbAtivoCadastro.isSelected(), rdbCaixa.isSelected(), rdbGerente.isSelected());
				user.setId(Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 1)));
				if (btbAdd.getText().equals("Adicionar") && uDAO.cadastraUsuario(user))
					JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!");
				else if (uDAO.alteraUsuario(user))
					JOptionPane.showMessageDialog(null, "Usuario Alterado com Sucesso!");
				else
					JOptionPane.showMessageDialog(null, "Informação Invalida!");
				tabbleContainer.setVisible(true);
				addItemContainer.setVisible(false);
			}
		});
		btbAdd.setBounds(450, 396, 161, 45);
		addItemContainer.add(btbAdd);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(637, 396, 161, 45);
		addItemContainer.add(btnCancel);

		JLabel lblNomeCadastro = new JLabel("Nome");
		lblNomeCadastro.setBounds(50, 104, 848, 14);
		addItemContainer.add(lblNomeCadastro);

		txtNomeCadastro = new JTextField();
		txtNomeCadastro.setColumns(10);
		txtNomeCadastro.setBounds(50, 129, 848, 20);
		addItemContainer.add(txtNomeCadastro);

		txtDescontoCadastro = new JTextField();
		txtDescontoCadastro.setColumns(10);
		txtDescontoCadastro.setBounds(908, 129, 295, 20);
		addItemContainer.add(txtDescontoCadastro);

		JLabel lblDescontoCadastro = new JLabel("Desconto");
		lblDescontoCadastro.setBounds(908, 104, 295, 14);
		addItemContainer.add(lblDescontoCadastro);

		txtLoginCadastro = new JTextField();
		txtLoginCadastro.setColumns(10);
		txtLoginCadastro.setBounds(50, 195, 370, 20);
		addItemContainer.add(txtLoginCadastro);

		JLabel lblLoginCadastro = new JLabel("Login");
		lblLoginCadastro.setBounds(50, 170, 370, 14);
		addItemContainer.add(lblLoginCadastro);

		txtSenhaCadastro = new JTextField();
		txtSenhaCadastro.setColumns(10);
		txtSenhaCadastro.setBounds(50, 262, 370, 20);
		addItemContainer.add(txtSenhaCadastro);

		JLabel lblSenhaCadastro = new JLabel("Senha");
		lblSenhaCadastro.setBounds(50, 237, 370, 14);
		addItemContainer.add(lblSenhaCadastro);

		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setBounds(1054, 180, 46, 14);
		addItemContainer.add(lblCaixa);

		JLabel lblGerente = new JLabel("Gerente");
		lblGerente.setBounds(1054, 220, 46, 14);
		addItemContainer.add(lblGerente);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbleContainer.setVisible(true);
				addItemContainer.setVisible(false);
			}
		});
		contentPane.add(tabbleContainer);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Ativo", "Id", "Nome", "Login", "Desconto" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(0).setMinWidth(45);
		table.getColumnModel().getColumn(0).setMaxWidth(45);
		table.getColumnModel().getColumn(1).setMinWidth(75);
		table.getColumnModel().getColumn(1).setMaxWidth(75);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setMinWidth(500);
		table.getColumnModel().getColumn(2).setMaxWidth(1000);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setMinWidth(250);
		table.getColumnModel().getColumn(3).setMaxWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(150);

		Panel panel = new Panel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 1280, 130);
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

		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbleContainer.setVisible(false);
				addItemContainer.setVisible(true);
				btbAdd.setText("Adicionar");
			}
		});
		btnAdd.setBounds(895, 35, 109, 49);
		panel.add(btnAdd);

		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					Usuario user = uDAO.getUsuario(Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 1)));
					tabbleContainer.setVisible(false);
					addItemContainer.setVisible(true);
					btbAdd.setText("Salvar");
					txtNomeCadastro.setText(user.getUsuarioNome());
					txtLoginCadastro.setText(user.getUsuarioLogin());
					txtSenhaCadastro.setText(user.getUsuarioSenha());
					txtDescontoCadastro.setText(String.valueOf(user.getUsuarioDesconto()));
				}
			}
		});
		btnEdit.setBounds(1014, 35, 109, 49);
		panel.add(btnEdit);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					Usuario user = uDAO.getUsuario(Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 1)));
					if (uDAO.excluiUsuario(user))
						JOptionPane.showMessageDialog(null, "Usuario Excluido com Sucesso!");
					else
						JOptionPane.showMessageDialog(null, "Informação Invalida!");
				}
			}
		});
		btnExcluir.setBounds(1133, 35, 109, 49);
		panel.add(btnExcluir);

		JLabel lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(9, 4, 46, 14);
		tabbleContainer.add(lblAtivo);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(47, 4, 46, 14);
		tabbleContainer.add(lblId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(121, 6, 73, 14);
		tabbleContainer.add(lblNome);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(868, 4, 46, 14);
		tabbleContainer.add(lblLogin);

		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setBounds(1112, 4, 83, 14);
		tabbleContainer.add(lblDesconto);

		JRadioButton rdbAtivo = new JRadioButton("Ativo");
		rdbAtivo.setSelected(true);
		rdbAtivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Usuario user : uDAO.getLista()) {
					if (user.getUsuarioAtivo() == rdbAtivo.isSelected()) {
						String[] linha = { user.getUsuarioAtivo().toString(), Integer.toString(user.getId()),
								user.getUsuarioNome(), user.getUsuarioLogin(),
								Double.toString(user.getUsuarioDesconto()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		rdbAtivo.setBounds(10, 25, 22, 23);
		tabbleContainer.add(rdbAtivo);

		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String id = txtId.getText();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Usuario user : uDAO.getLista()) {
					if (Integer.toString(user.getId()).toLowerCase().contains(id.toLowerCase())) {
						String[] linha = { user.getUsuarioAtivo().toString(), Integer.toString(user.getId()),
								user.getUsuarioNome(), user.getUsuarioLogin(),
								Double.toString(user.getUsuarioDesconto()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtId.setColumns(10);
		txtId.setBounds(47, 31, 53, 20);
		tabbleContainer.add(txtId);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String nome = txtNome.getText();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Usuario user : uDAO.getLista()) {
					if (user.getUsuarioNome().toLowerCase().contains(nome.toLowerCase())) {
						String[] linha = { user.getUsuarioAtivo().toString(), Integer.toString(user.getId()),
								user.getUsuarioNome(), user.getUsuarioLogin(),
								Double.toString(user.getUsuarioDesconto()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtNome.setColumns(10);
		txtNome.setBounds(121, 31, 726, 20);
		tabbleContainer.add(txtNome);

		txtLogin = new JTextField();
		txtLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String login = txtLogin.getText();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Usuario user : uDAO.getLista()) {
					if (user.getUsuarioLogin().toLowerCase().contains(login.toLowerCase())) {
						String[] linha = { user.getUsuarioAtivo().toString(), Integer.toString(user.getId()),
								user.getUsuarioNome(), user.getUsuarioLogin(),
								Double.toString(user.getUsuarioDesconto()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtLogin.setColumns(10);
		txtLogin.setBounds(865, 31, 232, 20);
		tabbleContainer.add(txtLogin);

		txtDesconto = new JTextField();
		txtDesconto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String desconto = txtDesconto.getText();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Usuario user : uDAO.getLista()) {
					if (Integer.toString(user.getUsuarioDesconto()).toLowerCase().contains(desconto.toLowerCase())) {
						String[] linha = { user.getUsuarioAtivo().toString(), Integer.toString(user.getId()),
								user.getUsuarioNome(), user.getUsuarioLogin(),
								Double.toString(user.getUsuarioDesconto()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtDesconto.setColumns(10);
		txtDesconto.setBounds(1112, 29, 136, 20);
		tabbleContainer.add(txtDesconto);
	}
}
