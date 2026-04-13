package proyectoBanco;

public class Persona {
    private final String nombreUsuario;
    private final String direccion;
    private final ServicioBanco servicioBanco;
    private Cuenta cuenta;

    public Persona(String nombreUsuario, String direccion, ServicioBanco servicioBanco) {
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
        this.servicioBanco = servicioBanco;
        this.cuenta = servicioBanco.obtenerCuenta(this.nombreUsuario);
    }

    public void actualizarCuenta() {
        this.cuenta = this.servicioBanco.obtenerCuenta(this.nombreUsuario);
    }
    public void cargarSaldo(int cantidad) {
        if (this.cuenta == null) {
            return;
        }
        this.cuenta.guardar(cantidad);
    }
    public boolean transferir(String receptor, int cantidad) {
        return this.cuenta.transferir(receptor, cantidad);
    }
    public void verBalance() {
        if (this.cuenta == null) {
            return;
        }
        this.cuenta.verBalance();
    }
}
