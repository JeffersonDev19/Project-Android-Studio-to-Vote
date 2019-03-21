package Objeto;

import Objeto.Base.Usuario__Base;

public class Usuario extends Usuario__Base {

    private Categoria categoria;

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void setPermissao(){
        switch (categoria){
            case Eleitor:
                this.setPermissao(0);
                break;
            case Mesario:
                this.setPermissao(1);
                break;
            case ChefeSessao:
                this.setPermissao(2);
                break;
        }
    }

    public static enum Categoria{
        Eleitor,
        Mesario,
        ChefeSessao
    }
}
