package br.ufla.dcc.ppoo.gui;

import br.ufla.dcc.ppoo.i18n.I18N;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TelaAutenticacao {

    private JDialog janela;

    public TelaAutenticacao() {
        construirTela();        
    }
    
    private void construirTela() {
        janela = new JDialog();
        janela.setTitle(I18N.obterTituloTelaAtenticacao());
        janela.setSize(300, 200);
        janela.setModal(true);
    }

    public void exibirTela(JFrame janelaPai) {
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(janela);
        janela.setVisible(true);
        janela.setResizable(false);
    }

}
