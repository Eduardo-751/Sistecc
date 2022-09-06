package View;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Janela de cadastro de produto
 */
public class CadastroProduto extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JButton btnCancelar = new JButton();
    private JButton btnExcluir = new JButton();
    private JButton btnNovo = new JButton();
    private JButton btnSalvar = new JButton();
    private JPanel pnBarraFerramentas = new JPanel();

    public CadastroProduto() {
        initComponents();
    }

	private void initComponents() {
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de produtos");

        btnNovo.setText("Novo");
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            }
        });
        pnBarraFerramentas.add(btnNovo);

        btnSalvar.setText("Salvar");
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        pnBarraFerramentas.add(btnSalvar);

        btnExcluir.setText("Excluir");
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        pnBarraFerramentas.add(btnExcluir);

        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        pnBarraFerramentas.add(btnCancelar);

        getContentPane().add(pnBarraFerramentas, java.awt.BorderLayout.PAGE_START);

        setBounds(10, 10, 400, 450);
    }
}
