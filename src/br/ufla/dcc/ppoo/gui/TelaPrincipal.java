package br.ufla.dcc.ppoo.gui;

import br.ufla.dcc.ppoo.i18n.I18N;
import br.ufla.dcc.ppoo.imagens.GerenciadorDeImagens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaPrincipal {

    private JFrame janela;

    private JMenuBar menuPrincipal;
    private JMenu menuInicio;
    private JMenu menuIdioma;

    private JMenuItem menuEntrar;
    private JMenuItem menuCadastrarUsuario;
    private JMenuItem menuIdiomaPortugues;
    private JMenuItem menuIdiomaIngles;
    private JMenuItem menuSair;

    private JLabel planoFundo;

    public TelaPrincipal() {
        inicializar();
    }

    private final void inicializar() {
        if (janela != null) {
            janela.dispose();
        }
        construirTela();
        exibirTela();
    }

    private final void confirmarSaida() {
        final int op = JOptionPane.showConfirmDialog(janela, I18N.obterConfirmacaoSaida(),
                I18N.obterTituloMensagemConfirmacao(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private final void configurarAcoesMenu() {
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarSaida();
            }
        });

        menuIdiomaPortugues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.PT_BR);
                inicializar();
            }
        });

        menuIdiomaIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.EN_US);
                inicializar();
            }
        });
    }

    private final void construirMenuLogoff() {
        menuPrincipal = new JMenuBar();
        menuInicio = new JMenu(I18N.obterMenuInicio());
        menuInicio.setMnemonic(I18N.obterMnemonicoMenuInicio());
        menuEntrar = new JMenuItem(I18N.obterMenuEntrar(), GerenciadorDeImagens.ENTRAR);
        menuCadastrarUsuario = new JMenuItem(I18N.obterMenuCadastrarUsuario(), GerenciadorDeImagens.CADASTRAR_USUARIO);
        menuSair = new JMenuItem(I18N.obterMenuSair(), GerenciadorDeImagens.SAIR);

        menuIdioma = new JMenu(I18N.obterMenuIdioma());
        menuIdioma.setMnemonic(I18N.obterMnemonicoMenuIdioma());
        menuIdiomaPortugues = new JMenuItem(I18N.obterMenuIdiomaPortugues(), GerenciadorDeImagens.BANDEIRA_BR);
        menuIdiomaIngles = new JMenuItem(I18N.obterMenuIdiomaIngles(), GerenciadorDeImagens.BANDEIRA_GB);

        menuInicio.add(menuEntrar);
        menuInicio.add(menuCadastrarUsuario);
        menuInicio.addSeparator();
        menuInicio.add(menuSair);

        menuIdioma.add(menuIdiomaPortugues);
        menuIdioma.add(menuIdiomaIngles);

        menuPrincipal.add(menuInicio);
        menuPrincipal.add(menuIdioma);
        janela.setJMenuBar(menuPrincipal);

        configurarAcoesMenu();
    }

    private final void construirTela() {
        janela = new JFrame(I18N.obterNomeDaAplicacao());
        janela.setTitle(I18N.obterNomeDaAplicacao());
        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmarSaida();
            }
        });

        // Configura plano de fundo
        planoFundo = new JLabel(GerenciadorDeImagens.PLANO_FUNDO);
        janela.add(planoFundo);

        construirMenuLogoff();
    }

    private final void exibirTela() {
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setVisible(true);
        janela.setResizable(false);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }

}
