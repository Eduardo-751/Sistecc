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
import Model.Produto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.ProdutoDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Estoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ProdutoDAO pDAO = new ProdutoDAO();
	private JTable table;
	private JTextField txtId, txtDescricao, txtCodBarras, txtValor, txtEstoque, txtDescricaoCadastro, txtNcmCadastro,
			txtValorCadastro, txtCodBarrasCadastro, txtEstoqueCadastro, txtICMSCadastro;
	private Container addItemContainer, tabbleContainer;

	/**
	 * Create the frame.
	 */
	public Estoque() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Produto p : pDAO.getLista()) {
					String[] linha = { p.getAtivo().toString(), Integer.toString(p.getId()), p.getDescricao(),
							p.getCodBarra(), Double.toString(p.getPreco()), Double.toString(p.getEstoque()) };
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

		txtDescricaoCadastro = new JTextField();
		txtDescricaoCadastro.setColumns(10);
		txtDescricaoCadastro.setBounds(50, 118, 848, 20);
		addItemContainer.add(txtDescricaoCadastro);

		JLabel lblDescricaoCadastro = new JLabel("Descri\u00E7\u00E3o");
		lblDescricaoCadastro.setBounds(50, 93, 848, 14);
		addItemContainer.add(lblDescricaoCadastro);

		JLabel lblNcmCadastro = new JLabel("NCM");
		lblNcmCadastro.setBounds(50, 246, 370, 14);
		addItemContainer.add(lblNcmCadastro);

		txtNcmCadastro = new JTextField();
		txtNcmCadastro.setColumns(10);
		txtNcmCadastro.setBounds(50, 271, 370, 20);
		addItemContainer.add(txtNcmCadastro);

		txtValorCadastro = new JTextField();
		txtValorCadastro.setColumns(10);
		txtValorCadastro.setBounds(908, 118, 295, 20);
		addItemContainer.add(txtValorCadastro);

		JLabel lblValorCadastro = new JLabel("Valor");
		lblValorCadastro.setBounds(908, 93, 295, 14);
		addItemContainer.add(lblValorCadastro);

		txtCodBarrasCadastro = new JTextField();
		txtCodBarrasCadastro.setColumns(10);
		txtCodBarrasCadastro.setBounds(50, 189, 370, 20);
		addItemContainer.add(txtCodBarrasCadastro);

		JLabel lblCodBarrasCadastro = new JLabel("Codigo de Barras");
		lblCodBarrasCadastro.setBounds(50, 164, 370, 14);
		addItemContainer.add(lblCodBarrasCadastro);

		txtEstoqueCadastro = new JTextField();
		txtEstoqueCadastro.setColumns(10);
		txtEstoqueCadastro.setBounds(908, 189, 295, 20);
		addItemContainer.add(txtEstoqueCadastro);

		JLabel lblEstoqueCadastro = new JLabel("Qtd Estoque");
		lblEstoqueCadastro.setBounds(908, 164, 295, 14);
		addItemContainer.add(lblEstoqueCadastro);

		JLabel lblCSTCadastro = new JLabel("CST");
		lblCSTCadastro.setBounds(731, 245, 356, 14);
		addItemContainer.add(lblCSTCadastro);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "0 - Nacional", "1 - Importa\u00E7\u00E3o Direta", "2 - Estrangeira Adquirida" }));
		comboBox.setBounds(731, 269, 356, 22);
		addItemContainer.add(comboBox);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "T", "F", "N", "S" }));
		comboBox_1.setBounds(593, 270, 97, 22);
		addItemContainer.add(comboBox_1);

		JLabel lblICMSCadastro = new JLabel("ICMS");
		lblICMSCadastro.setBounds(467, 246, 91, 14);
		addItemContainer.add(lblICMSCadastro);

		JButton btbAdd = new JButton("Adicionar");
		btbAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p = new Produto(txtCodBarrasCadastro.getText(), txtDescricaoCadastro.getText(),
						Double.parseDouble(txtValorCadastro.getText()), txtNcmCadastro.getText(),
						comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString().charAt(0),
						Double.parseDouble(txtICMSCadastro.getText()), Double.parseDouble(txtEstoqueCadastro.getText()),
						rdbAtivoCadastro.isSelected());
				p.setId(Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 1)));
				if (btbAdd.getText().equals("Adicionar") && pDAO.cadastraProduto(p))
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
				else if (pDAO.alteraProduto(p))
					JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");
				else
					JOptionPane.showMessageDialog(null, "Informação Invalida!");
				tabbleContainer.setVisible(true);
				addItemContainer.setVisible(false);
			}
		});
		btbAdd.setBounds(450, 396, 161, 45);
		addItemContainer.add(btbAdd);

		txtICMSCadastro = new JTextField();
		txtICMSCadastro.setColumns(10);
		txtICMSCadastro.setBounds(467, 271, 91, 20);
		addItemContainer.add(txtICMSCadastro);

		JLabel lblTributacaoCadastro = new JLabel("Tributacao");
		lblTributacaoCadastro.setBounds(599, 246, 91, 14);
		addItemContainer.add(lblTributacaoCadastro);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(637, 396, 161, 45);
		addItemContainer.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabbleContainer.setVisible(true);
				addItemContainer.setVisible(false);
				txtICMSCadastro.setText("");
				txtCodBarrasCadastro.setText("");
				txtValorCadastro.setText("");
				txtNcmCadastro.setText("");
				txtDescricaoCadastro.setText("");
				txtEstoqueCadastro.setText("");
			}
		});
		contentPane.add(tabbleContainer);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ativo", "Id", "Descricao", "Cod Barras", "Valor", "Qtd Estoque" }));
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
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMaxWidth(100);

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
					Produto p = pDAO.getProduto(Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 1)));
					tabbleContainer.setVisible(false);
					addItemContainer.setVisible(true);
					btbAdd.setText("Salvar");
					txtICMSCadastro.setText(p.getIcms().toString());
					txtCodBarrasCadastro.setText(p.getCodBarra());
					txtValorCadastro.setText(p.getPreco().toString());
					txtNcmCadastro.setText(p.getNcm());
					txtDescricaoCadastro.setText(p.getDescricao());
					txtEstoqueCadastro.setText(p.getEstoque().toString());
					comboBox.setSelectedItem(p.getCst());
					comboBox_1.setSelectedItem(p.getTributacao());
				}
			}
		});
		btnEdit.setBounds(1014, 35, 109, 49);
		panel.add(btnEdit);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					Produto p = pDAO.getProduto(Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 1)));
					if (pDAO.excluiProduto(p))
						JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso!");
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

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(121, 6, 73, 14);
		tabbleContainer.add(lblDescricao);

		JLabel lblCodBarras = new JLabel("CodBarras");
		lblCodBarras.setBounds(763, 4, 46, 14);
		tabbleContainer.add(lblCodBarras);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(1013, 4, 46, 14);
		tabbleContainer.add(lblValor);

		JLabel lblQrdEstoque = new JLabel("Qrd Estoque");
		lblQrdEstoque.setBounds(1165, 4, 83, 14);
		tabbleContainer.add(lblQrdEstoque);

		JRadioButton rdbAtivo = new JRadioButton("Ativo");
		rdbAtivo.setSelected(true);
		rdbAtivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Produto p : pDAO.getLista()) {
					if (p.getAtivo() == rdbAtivo.isSelected()) {
						String[] linha = { p.getAtivo().toString(), Integer.toString(p.getId()), p.getDescricao(),
								p.getCodBarra(), Double.toString(p.getPreco()), Double.toString(p.getEstoque()) };
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
				for (Produto p : pDAO.getLista()) {
					if (Integer.toString(p.getId()).toLowerCase().contains(id.toLowerCase())) {
						String[] linha = { p.getAtivo().toString(), Integer.toString(p.getId()), p.getDescricao(),
								p.getCodBarra(), Double.toString(p.getPreco()), Double.toString(p.getEstoque()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtId.setColumns(10);
		txtId.setBounds(47, 31, 53, 20);
		tabbleContainer.add(txtId);

		txtDescricao = new JTextField();
		txtDescricao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String descricao = txtDescricao.getText();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Produto p : pDAO.getLista()) {
					if (p.getDescricao().toLowerCase().contains(descricao.toLowerCase())) {
						String[] linha = { p.getAtivo().toString(), Integer.toString(p.getId()), p.getDescricao(),
								p.getCodBarra(), Double.toString(p.getPreco()), Double.toString(p.getEstoque()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(121, 31, 632, 20);
		tabbleContainer.add(txtDescricao);

		txtCodBarras = new JTextField();
		txtCodBarras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String codBarras = txtCodBarras.getText();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Produto p : pDAO.getLista()) {
					if (p.getCodBarra().toLowerCase().contains(codBarras.toLowerCase())) {
						String[] linha = { p.getAtivo().toString(), Integer.toString(p.getId()), p.getDescricao(),
								p.getCodBarra(), Double.toString(p.getPreco()), Double.toString(p.getEstoque()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtCodBarras.setColumns(10);
		txtCodBarras.setBounds(763, 31, 240, 20);
		tabbleContainer.add(txtCodBarras);

		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String valor = txtValor.getText();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Produto p : pDAO.getLista()) {
					if (Double.toString(p.getPreco()).toLowerCase().contains(valor.toLowerCase())) {
						String[] linha = { p.getAtivo().toString(), Integer.toString(p.getId()), p.getDescricao(),
								p.getCodBarra(), Double.toString(p.getPreco()), Double.toString(p.getEstoque()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtValor.setColumns(10);
		txtValor.setBounds(1013, 31, 142, 20);
		tabbleContainer.add(txtValor);

		txtEstoque = new JTextField();
		txtEstoque.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String estoque = txtEstoque.getText();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for (Produto p : pDAO.getLista()) {
					if (Double.toString(p.getEstoque()).toLowerCase().contains(estoque.toLowerCase())) {
						String[] linha = { p.getAtivo().toString(), Integer.toString(p.getId()), p.getDescricao(),
								p.getCodBarra(), Double.toString(p.getPreco()), Double.toString(p.getEstoque()) };
						modelo.addRow(linha);
					}
				}
			}
		});
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(1165, 29, 83, 20);
		tabbleContainer.add(txtEstoque);
	}
}
