package Controladores;

import Objeto.Usuario;
import Repositories.RepositorioUsuario;

public class ControladorCadastro {

    private ModoOperacao modoOperacao;

    public void setModoOperacao(ModoOperacao modoOperacao){
        this.modoOperacao = modoOperacao;

        switch (modoOperacao){

            case SOMENTE_LEITURA:
                break;
            case OPERACAO:
                break;
            case GERENCIA:
                break;
        }
    }


    private void RequisitarSalvarESair(Usuario usuario){
        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        repositorioUsuario.SalvarUsuario(usuario);
    }

    public enum ModoOperacao{
        OPERACAO,
        SOMENTE_LEITURA,
        GERENCIA
    }
}
