public class Cuenta {
    private TipoCuenta tipoCuenta;
    private String nombrePropietario;
    private String direccion;
    private int saldo;

    Cuenta(TipoCuenta tipoCuenta, String nombrePropietario, String direccion) {
        this.tipoCuenta = tipoCuenta;
        this.nombrePropietario = nombrePropietario;
        this.direccion = direccion;
        this.saldo = 0;
    }

    public String obtenerNombrePropietario() {
        return this.nombrePropietario;
    }
    public int obtenerSaldo() {
        return this.saldo;
    }

    public void retirar(int cantidad) {
        this.saldo -= cantidad;
    }
    public void guardar(int cantidad) {
        this.saldo += cantidad;
    }
}
