package proyectoBanco.comandos;

import proyectoBanco.administrador.Manejador;
import proyectoBanco.cuentas.TipoCuenta;

public record ComandoCrear(TipoCuenta tipoCuenta, String usuario) implements Comando {

    @Override
    public void manejar(Manejador manejador) {
        manejador.manejarCrear(this);
    }

    @Override
    public String toString() {
        return "ComandoCrear(" + this.tipoCuenta +
                ", " + this.usuario +
                ")";
    }
}
