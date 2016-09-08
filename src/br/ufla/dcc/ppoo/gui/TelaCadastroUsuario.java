package br.ufla.dcc.ppoo.gui;

import br.ufla.dcc.ppoo.i18n.I18N;
import br.ufla.dcc.ppoo.imagens.GerenciadorDeImagens;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastroUsuario {

    private JDialog janela;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JLabel lbNome;
    private JLabel lbUsuario;
    private JLabel lbSenha;
    private JLabel lbConfirmarSenha;
    private JTextField txtNome;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public TelaCadastroUsuario() {
        construirTela();
    }

    private void adicionarComponente(Component c,
            int anchor, int fill, int linha,
            int coluna, int largura, int altura) {
        gbc.anchor = anchor;
        gbc.fill = fill;
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridwidth = largura;
        gbc.gridheight = altura;
        gbc.insets = new Insets(5, 5, 5, 5);
        layout.setConstraints(c, gbc);
        janela.add(c);
    }

    private void adicionarComponentes() {
        lbNome = new JLabel(I18N.obterRotuloNome());
        adicionarComponente(lbNome,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                0, 0, 1, 1);

        lbUsuario = new JLabel(I18N.obterRotuloUsuario());
        adicionarComponente(lbUsuario,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                1, 0, 1, 1);

        lbSenha = new JLabel(I18N.obterRotuloSenha());
        adicionarComponente(lbSenha,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                2, 0, 1, 1);
        
        lbConfirmarSenha = new JLabel(I18N.obterRotuloConfirmarSenha());
        adicionarComponente(lbConfirmarSenha,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                3, 0, 1, 1);

        txtNome = new JTextField(35);
        adicionarComponente(txtNome,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                0, 1, 1, 1);
        
        txtUsuario = new JTextField(25);
        adicionarComponente(txtUsuario,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                1, 1, 1, 1);

        txtSenha = new JPasswordField(10);
        adicionarComponente(txtSenha,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                2, 1, 1, 1);
        
        txtConfirmarSenha = new JPasswordField(10);
        adicionarComponente(txtConfirmarSenha,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                3, 1, 1, 1);

        btnSalvar = new JButton(I18N.obterBotaoSalvar(),
                GerenciadorDeImagens.OK);

        btnCancelar = new JButton(I18N.obterBotaoCancelar(),
                GerenciadorDeImagens.CANCELAR);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);

        adicionarComponente(painelBotoes,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,
                4, 0, 2, 1);
    }

    private void configurarAcoesBotoes() {
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
            }
        });
    }

    private void construirTela() {
        janela = new JDialog();
        janela.setTitle(I18N.obterTituloTelaAutenticacao());
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        janela.setLayout(layout);
        adicionarComponentes();
        configurarAcoesBotoes();
        janela.pack();
    }

    public void exibirTela(JFrame janelaPai) {
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(janela);
        janela.setModal(true);
        janela.setVisible(true);
        janela.setResizable(false);
    }

}
