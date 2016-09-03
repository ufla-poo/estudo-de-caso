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
        return rb.getString("app.name");
    }
    
    public static String obterMenuInicio() {
        return rb.getString("menu.home");
    }
    
    public static char obterMnemonicoMenuInicio() {
        return rb.getString("menu.home.mnemonic").charAt(0);
    }

    public static String obterMenuEntrar() {
        return rb.getString("menu.home.signin");
    }
    
    public static String obterMenuCadastrarUsuario() {
        return rb.getString("menu.home.signup");
    }
    
    public static String obterMenuSair() {
        return rb.getString("menu.home.exit");
    }
    
    public static String obterMenuIdioma() {
        return rb.getString("menu.language");
    }
    
    public static char obterMnemonicoMenuIdioma() {
        return rb.getString("menu.language.mnemonic").charAt(0);
    }
    
    public static String obterMenuIdiomaPortugues() {
        return rb.getString("menu.language.pt.br");
    }
    
    public static String obterMenuIdiomaIngles() {
        return rb.getString("menu.language.en.us");
    }
    
    public static String obterConfirmacaoSaida() {
        return rb.getString("confirm.exit");
    }
    
    public static String obterTituloMensagemConfirmacao() {
        return rb.getString("confirm.title");
    }
}
