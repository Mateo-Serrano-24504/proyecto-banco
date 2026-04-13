package proyectoBanco.comandos;

import proyectoBanco.Administrador;
import proyectoBanco.cuentas.TipoCuenta;

public record ComandoCrear(TipoCuenta tipoCuenta, String usuario) implements Comando {

    @Override
    public void manejar(Administrador administrador) {
        administrador.manejarCrear(this);
    }

    @Override
    public String toString() {
        return "ComandoCrear(" + this.tipoCuenta +
                ", " + this.usuario +
                ")";
    }
}
