public class Banco {
    private Cuenta primeraCuenta;
    private Cuenta segundaCuenta;

    private Cuenta obtenerPorUsuario(String usuario) {
        if (
                this.primeraCuenta != null &&
                this.primeraCuenta.obtenerNombrePropietario().equals(usuario)
        ) {
            return this.primeraCuenta;
        } else if (
                this.segundaCuenta != null &&
                        this.segundaCuenta.obtenerNombrePropietario().equals(usuario)
        ) {
            return this.segundaCuenta;
        }
        return null;
    }

    Banco() {
        this.primeraCuenta = null;
        this.segundaCuenta = null;
    }

    public Cuenta obtenerCuenta(String nombrePropietario) {
        return this.obtenerPorUsuario(nombrePropietario);
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

    public void cargarSaldo(String nombrePropietario, int cantidad) {
        var cuenta = this.obtenerPorUsuario(nombrePropietario);
        if (cuenta == null) {
            return;
        }
        cuenta.guardar(cantidad);
    }
    public boolean transferir(String emisor, String receptor, int cantidad) {
        var cuentaEmisor = this.obtenerPorUsuario(emisor);
        var cuentaReceptor = this.obtenerPorUsuario(receptor);
        if (cuentaEmisor == null || cuentaReceptor == null) {
            return false;
        }
        var saldoEmisor = cuentaEmisor.obtenerSaldo();
        if (saldoEmisor < cantidad) {
            return false;
        }
        cuentaEmisor.retirar(cantidad);
        cuentaReceptor.guardar(cantidad);
        return true;
    }

    public void verBalance(String usuario) {
        var cuenta = this.obtenerPorUsuario(usuario);
        if (cuenta == null) {
            return;
        }
        cuenta.verBalance();
    }
}
