public class Cuenta {
    private TipoCuenta tipoCuenta;
    private String nombrePropietario;
    private String direccion;

    Cuenta(TipoCuenta tipoCuenta, String nombrePropietario, String direccion) {
        this.tipoCuenta = tipoCuenta;
        this.nombrePropietario = nombrePropietario;
        this.direccion = direccion;
    }
}
