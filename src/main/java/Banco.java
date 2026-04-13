public class Banco {
    Cuenta primeraCuenta;
    Cuenta segundaCuenta;

    Banco() {
        this.primeraCuenta = null;
        this.segundaCuenta = null;
    }

    public void crearCuenta(TipoCuenta tipoCuenta, String nombrePropietario, String direccion) {
        if (this.primeraCuenta == null) {
            this.primeraCuenta = new Cuenta(tipoCuenta, nombrePropietario, direccion);
        } else if (this.segundaCuenta == null) {
            this.segundaCuenta = new Cuenta(tipoCuenta, nombrePropietario, direccion);
        }
    }
    public void eliminarCuenta(String nombrePropietario) {
        if (
                this.primeraCuenta != null &&
                this.primeraCuenta.obtenerNombrePropietario().equals(nombrePropietario)
        ) {
            this.primeraCuenta = null;
        } else if (
                this.segundaCuenta != null &&
                this.segundaCuenta.obtenerNombrePropietario().equals(nombrePropietario)
        ) {
            this.segundaCuenta = null;
        }
    }
}
