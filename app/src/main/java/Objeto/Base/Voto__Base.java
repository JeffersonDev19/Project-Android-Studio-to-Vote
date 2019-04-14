package Objeto.Base;

import java.io.Serializable;
import java.util.Date;

public class Voto__Base implements Serializable {

    protected String ID;
    protected String chapaPresidente;
    protected String chapaGovernador;
    protected String chapaDeputado;
    protected String ID_Usuario;
    protected Date data;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getChapaPresidente() {
        return chapaPresidente;
    }

    public void setChapaPresidente(String chapaPresidente) {
        this.chapaPresidente = chapaPresidente;
    }

    public String getChapaGovernador() {
        return chapaGovernador;
    }

    public void setChapaGovernador(String chapaGovernador) {
        this.chapaGovernador = chapaGovernador;
    }

    public String getChapaDeputado() {
        return chapaDeputado;
    }

    public void setChapaDeputado(String chapaDeputado) {
        this.chapaDeputado = chapaDeputado;
    }

    public String getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(String ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
