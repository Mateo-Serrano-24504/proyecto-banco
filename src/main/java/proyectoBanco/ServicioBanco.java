package proyectoBanco;

public class ServicioBanco {
    private Banco banco;

    public ServicioBanco(Banco banco) {
        this.banco = banco;
    }

    public Cuenta obtenerCuenta(String nombrePropietario) {
        return this.banco.obtenerCuenta(nombrePropietario);
    }
    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, String nombre, String direccion) {
        this.banco.solicitarCrearCuenta(tipoCuenta, nombre, direccion);
    }
    public void solicitarEliminarCuenta(String nombre) {
        this.banco.solicitarEliminarCuenta(nombre);
    }
}
