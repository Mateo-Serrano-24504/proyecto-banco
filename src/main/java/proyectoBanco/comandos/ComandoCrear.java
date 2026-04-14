package proyectoBanco.comandos;

import proyectoBanco.administrador.Manejador;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

public record ComandoCrear(TipoCuenta tipoCuenta, String usuario, String contr) implements Comando {

    @Override
    public void manejar(Manejador manejador) {
        manejador.manejarCrear(this);
    }

    @Override
    public String toString() {
        return "ComandoCrear(" + this.tipoCuenta +
                ", " + this.usuario +
                ", " + this.contr +
                ")";
    }
}
