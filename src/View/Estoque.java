package View;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class Estoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ProdutoDAO pDAO = new ProdutoDAO();
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Estoque() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				for(Produto p : pDAO.getLista()) {
					String[] linha = {
							Integer.toString(p.getId()),
							p.getNome(),
							p.getDescricao(),
							Double.toString(p.getPrecoVenda())
					};
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

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Descri\u00E7\u00E3o", "Valor"
			}
		));
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.setBounds(10, 146, 1260, 563);
		contentPane.add(table);

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
				MainApplication.frame = new RegistrarProduto();
			}
		});
		btnAdd.setBounds(1014, 35, 109, 49);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					Produto p = new Produto((String)table.getValueAt(table.getSelectedRow(), 1), (String)table.getValueAt(table.getSelectedRow(), 2), Double.parseDouble((String)table.getValueAt(table.getSelectedRow(), 3)));
					p.setId(Integer.valueOf((String) table.getValueAt(table.getSelectedRow(), 0)));
					MainApplication.frame = new EditarProduto(p);
				}
			}
		});
		btnEdit.setBounds(1133, 35, 109, 49);
		panel.add(btnEdit);
	}
}
