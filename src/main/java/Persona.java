public class Persona {
    private String nombreUsuario;
    private String direccion;
    private Banco banco;

    Persona(String nombreUsuario, String direccion, Banco banco) {
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
        this.banco = banco;
    }

    public void crearCuenta(TipoCuenta tipoCuenta) {
        this.banco.crearCuenta(tipoCuenta, this.nombreUsuario, this.direccion);
    }
    public boolean transferir(String receptor, int cantidad) {
        return this.banco.transferir(this.nombreUsuario, receptor, cantidad);
    }
}
