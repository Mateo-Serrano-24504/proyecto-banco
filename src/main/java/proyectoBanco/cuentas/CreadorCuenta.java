package proyectoBanco.cuentas;

import proyectoBanco.Banco;

public class CreadorCuenta {
    private CuentaCorriente crearCuentaCorriente(String propietario, Banco banco) {
        return new CuentaCorriente(propietario, banco);
    }
    private CuentaAhorro crearCuentaAhorro(String propietario, Banco banco) {
        return new CuentaAhorro(propietario, banco);
    }

    public Cuenta crearCuenta(TipoCuenta tipoCuenta, String propietario, Banco banco) {
        switch (tipoCuenta) {
            case CuentaCorriente -> {
                return this.crearCuentaCorriente(propietario, banco);
            }
            case CuentaAhorro -> {
                return this.crearCuentaAhorro(propietario, banco);
            }
            default -> {
                return null;
            }
        }
    }
}
