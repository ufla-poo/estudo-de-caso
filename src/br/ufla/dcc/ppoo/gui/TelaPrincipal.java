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
    private JMenu menuAjuda;

    private JMenuItem menuEntrar;
    private JMenuItem menuCadastrarUsuario;
    private JMenuItem menuIdiomaPortugues;
    private JMenuItem menuIdiomaIngles;
    private JMenuItem menuSair;
    private JMenuItem menuSobre;

    private JLabel planoFundo;

    public TelaPrincipal() {
        inicializar();
    }

    private void inicializar() {
        // Serve para o caso em que o usuário
        // decidiu mudar o idioma da aplicação.
        if (janela != null) {
            janela.dispose();
        }
        construirTela();
    }

    private boolean confirmarSaida() {
        final int op = JOptionPane.showConfirmDialog(janela, I18N.obterConfirmacaoSaida(),
                I18N.obterTituloMensagemConfirmacao(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return op == JOptionPane.YES_OPTION;
    }

    private void exibirInfoSobreSistema() {
        JOptionPane.showMessageDialog(janela, I18N.obterSobre(),
                I18N.obterTituloMensagemSobre(), JOptionPane.INFORMATION_MESSAGE);
    }

    private void configurarAcoesMenu() {
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (confirmarSaida()) {
                    System.exit(0);
                }
            }
        });

        menuIdiomaPortugues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.PT_BR);
                inicializar();
                exibirTela();
            }
        });

        menuIdiomaIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.EN_US);
                inicializar();
                exibirTela();
            }
        });

        menuEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaAutenticacao().exibirTela(janela);
            }
        });

        menuCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroUsuario().exibirTela(janela);
            }
        });

        menuSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirInfoSobreSistema();
            }
        });
    }

    private final void construirMenuUsuarioNaoAutenticado() {
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

        menuAjuda = new JMenu(I18N.obterMenuAjuda());
        menuAjuda.setMnemonic(I18N.obterMnemonicoMenuAjuda());
        menuSobre = new JMenuItem(I18N.obterMenuSobre(), GerenciadorDeImagens.SOBRE);

        menuInicio.add(menuEntrar);
        menuInicio.add(menuCadastrarUsuario);
        menuInicio.addSeparator();
        menuInicio.add(menuSair);

        menuIdioma.add(menuIdiomaPortugues);
        menuIdioma.add(menuIdiomaIngles);

        menuAjuda.add(menuSobre);

        menuPrincipal.add(menuInicio);
        menuPrincipal.add(menuIdioma);
        menuPrincipal.add(menuAjuda);

        janela.setJMenuBar(menuPrincipal);

        configurarAcoesMenu();
    }

    private final void construirTela() {
        janela = new JFrame(I18N.obterTituloTelaPrincipal());
        janela.setTitle(I18N.obterNomeDoSistema());
        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (confirmarSaida()) {
                    System.exit(0);
                }
            }
        });

        // Configura plano de fundo
        planoFundo = new JLabel(GerenciadorDeImagens.PLANO_FUNDO);
        janela.add(planoFundo);

        construirMenuUsuarioNaoAutenticado();
    }

    private void exibirTela() {
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setVisible(true);
        janela.setResizable(false);
    }

    public static void main(String[] args) {
        new TelaPrincipal().exibirTela();
    }

}
