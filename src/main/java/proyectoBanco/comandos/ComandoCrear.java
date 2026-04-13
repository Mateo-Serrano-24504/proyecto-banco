package proyectoBanco.comandos;

import proyectoBanco.Administrador;
import proyectoBanco.TipoCuenta;

public record ComandoCrear(TipoCuenta tipoCuenta, String usuario, String direccion) implements Comando {

    @Override
    public void manejar(Administrador administrador) {
        administrador.manejarCrear(this);
    }
}
