package proyectoBanco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

public class ServicioBanco {
    private final Banco banco;

    public ServicioBanco(Banco banco) {
        this.banco = banco;
    }

    public Cuenta obtenerCuenta(String nombrePropietario) {
        return this.banco.obtenerCuenta(nombrePropietario);
    }
    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, String nombre) {
        this.banco.solicitarCrearCuenta(tipoCuenta, nombre);
    }
    public void solicitarEliminarCuenta(String nombre) {
        this.banco.solicitarEliminarCuenta(nombre);
    }
}
