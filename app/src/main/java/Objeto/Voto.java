package Objeto;

import Objeto.Base.Voto__Base;

public class Voto extends Voto__Base {

    @Override
    public String toString() {
        return "Voto " + super.ID;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
