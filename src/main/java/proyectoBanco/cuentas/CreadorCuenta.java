package proyectoBanco.cuentas;

public class CreadorCuenta {
    private CuentaCorriente crearCuentaCorriente(String propietario) {
        return new CuentaCorriente(propietario);
    }
    private CuentaAhorro crearCuentaAhorro(String propietario) {
        return new CuentaAhorro(propietario);
    }

    public Cuenta crearCuenta(TipoCuenta tipoCuenta, String propietario) {
        switch (tipoCuenta) {
            case CuentaCorriente -> {
                return this.crearCuentaCorriente(propietario);
            }
            case CuentaAhorro -> {
                return this.crearCuentaAhorro(propietario);
            }
            default -> {
                return null;
            }
        }
    }
}
