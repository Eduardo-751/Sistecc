package View;

import java.awt.Cursor;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
    private JButton btnCliente = new JButton();
    private JButton btnCompra = new JButton();
    private JButton btnProduto = new JButton();
    private JButton btnSair = new JButton();
    private JButton btnVenda = new JButton();
    private JDesktopPane desktopPane;
    private JToolBar toolBar;
    
	public MenuFrame() {
		initComponents();
	}
	
	/**
	 * Create the frame.
	 */
	private void initComponents() {

        toolBar = new JToolBar();
        desktopPane = new JDesktopPane();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Vendas");

        toolBar.setFloatable(false);

        btnVenda.setText("Venda");
        btnVenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVenda.setFocusable(false);
        btnVenda.setHorizontalTextPosition(SwingConstants.CENTER);
        btnVenda.setMargin(new Insets(2, 12, 2, 12));
        btnVenda.setVerticalAlignment(SwingConstants.BOTTOM);
        btnVenda.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        toolBar.add(btnVenda);

        btnCompra.setText("Compra");
        btnCompra.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCompra.setFocusable(false);
        btnCompra.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCompra.setMargin(new Insets(2, 12, 2, 12));
        btnCompra.setVerticalAlignment(SwingConstants.BOTTOM);
        btnCompra.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });
        toolBar.add(btnCompra);

        btnProduto.setText("Produto");
        btnProduto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnProduto.setFocusable(false);
        btnProduto.setHorizontalTextPosition(SwingConstants.CENTER);
        btnProduto.setMargin(new Insets(2, 12, 2, 12));
        btnProduto.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	CadastroProduto c = new CadastroProduto();
                desktopPane.add(c);
                c.setVisible(true);
            }
        });
        toolBar.add(btnProduto);

        btnCliente.setText("Cliente");
        btnCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCliente.setFocusable(false);
        btnCliente.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCliente.setMargin(new Insets(2, 12, 2, 12));
        btnCliente.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        toolBar.add(btnCliente);

        btnSair.setText("Sair");
        btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSair.setMargin(new Insets(2, 12, 2, 12));
        btnSair.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	System.exit(0);
            }
        });
        toolBar.add(btnSair);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        desktopPane.setOpaque(false);
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);


        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }
}
