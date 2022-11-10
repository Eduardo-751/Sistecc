package View;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import DB.ProdutoDAO;
import Model.Produto;

import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private ProdutoDAO pDAO = new ProdutoDAO();
	/**
	 * Create the frame.
	 */
	public RegistrarProduto() {
		IniciarElementos();
	}
	
	public RegistrarProduto(Produto p) {
		IniciarElementos();
		txtNome.setText(p.getNome());
		txtDescricao.setText(p.getDescricao());
		txtPreco.setText(Double.toString(p.getPrecoVenda()));
	}
	
	public void IniciarElementos() {
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setUndecorated(true);
		setVisible(true);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		Panel panel = new Panel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 500, 64);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(50, 99, 39, 17);
		contentPane.add(lblName);

		txtNome = new JTextField();
		txtNome.setBounds(99, 97, 197, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblPrice = new JLabel("Pre\u00E7o:");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setBounds(355, 101, 46, 14);
		contentPane.add(lblPrice);

		JLabel lblDescription = new JLabel("Descri\u00E7\u00E3o:");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(10, 141, 79, 17);
		contentPane.add(lblDescription);

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(99, 139, 368, 20);
		contentPane.add(txtDescricao);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(411, 97, 56, 20);
		contentPane.add(txtPreco);
		
		JButton btbAdd = new JButton("Adicionar");
		btbAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto p = new Produto(txtNome.getText(), txtDescricao.getText(), Double.valueOf(txtPreco.getText()));
				
				if(pDAO.cadastraProduto(p)) {
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Informação Invalida!");
			}
		});
		btbAdd.setBounds(169, 239, 89, 23);
		contentPane.add(btbAdd);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(282, 239, 89, 23);
		contentPane.add(btnCancel);
	}
}
