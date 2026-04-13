public class Administrador {
    private Banco banco;

    public void crearCuenta(TipoCuenta tipoCuenta, String usuario, String direccion) {
        this.banco.crearCuenta(tipoCuenta, usuario, direccion);
    }

    public void eliminarCuenta(String usuario) {
        this.banco.eliminarCuenta(usuario);
    }
}
