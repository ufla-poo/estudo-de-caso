package br.ufla.dcc.ppoo.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18N {

    private static final String CAMINHO_ARQUIVOBASE_I18N = "br/ufla/dcc/ppoo/i18n/Strings";
    private static ResourceBundle rb = ResourceBundle.getBundle(CAMINHO_ARQUIVOBASE_I18N, Locale.getDefault());
    public static final Locale PT_BR = new Locale("pt", "BR");
    public static final Locale EN_US = new Locale("en", "US");

    public static void alterarLocalidade(Locale localidade) {
        Locale.setDefault(localidade);
        rb = ResourceBundle.getBundle(CAMINHO_ARQUIVOBASE_I18N, localidade);
    }

    public static String obterNomeDaAplicacao() {
        return rb.getString("sistema.nome");
    }

    public static String obterMenuInicio() {
        return rb.getString("menu.inicio");
    }

    public static char obterMnemonicoMenuInicio() {
        return rb.getString("mnemonico.menu.inicio").charAt(0);
    }

    public static String obterMenuEntrar() {
        return rb.getString("menu.inicio.entrar");
    }

    public static String obterMenuCadastrarUsuario() {
        return rb.getString("menu.inicio.cadastrar");
    }

    public static String obterMenuSair() {
        return rb.getString("menu.inicio.sair");
    }

    public static String obterMenuIdioma() {
        return rb.getString("menu.idioma");
    }

    public static char obterMnemonicoMenuIdioma() {
        return rb.getString("mnemonico.menu.idioma").charAt(0);
    }

    public static String obterMenuIdiomaPortugues() {
        return rb.getString("menu.idioma.pt_br");
    }

    public static String obterMenuIdiomaIngles() {
        return rb.getString("menu.idioma.en_us");
    }

    public static String obterConfirmacaoSaida() {
        return rb.getString("confirmacao.saida.descricao");
    }

    public static String obterTituloMensagemConfirmacao() {
        return rb.getString("confirmacao.titulo");
    }

    public static String obterTituloTelaAtenticacao() {
        return rb.getString("tela.autenticacao.titulo");
    }

    public static String obterTituloTelaPrincipal() {
        return obterNomeDaAplicacao();
    }
}
