package br.ufla.dcc.ppoo.imagens;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GerenciadorDeImagens {

    public static final ImageIcon SAIR = carregarIcone("sair.png");
    public static final ImageIcon ENTRAR = carregarIcone("entrar.png");
    public static final ImageIcon BANDEIRA_BR = carregarIcone("bandeira-br.png");
    public static final ImageIcon BANDEIRA_GB = carregarIcone("bandeira-gb.png");
    public static final ImageIcon CADASTRAR_USUARIO = carregarIcone("cadastrar-usuario.png");
    public static final ImageIcon PLANO_FUNDO = carregarIcone("plano-fundo.png");
    public static final ImageIcon OK = carregarIcone("btn-ok.png");
    public static final ImageIcon CANCELAR = carregarIcone("btn-cancelar.png");
    public static final ImageIcon SOBRE = carregarIcone("sobre.png");

    private static ImageIcon carregarIcone(String caminho) {
        return new ImageIcon(GerenciadorDeImagens.class.getResource(caminho));
    }
}
