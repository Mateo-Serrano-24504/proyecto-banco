public class Cuenta {
    private TipoCuenta tipoCuenta;
    private String nombrePropietario;
    private String direccion;
    private int saldo;
    private Banco banco;

    Cuenta(TipoCuenta tipoCuenta, String nombrePropietario, String direccion, Banco banco) {
        this.tipoCuenta = tipoCuenta;
        this.nombrePropietario = nombrePropietario;
        this.direccion = direccion;
        this.saldo = 0;
        this.banco = banco;
    }

    public void verBalance() {
        System.out.println("Balance de cuenta.");
        System.out.println("    - Tipo de cuenta: " + this.tipoCuenta);
        System.out.println("    - Propietario: " + this.nombrePropietario);
        System.out.println("    - Direccion: " + this.direccion);
        System.out.println("    - Saldo: " + this.saldo);
    }

    public String obtenerNombrePropietario() {
        return this.nombrePropietario;
    }
    public int obtenerSaldo() {
        return this.saldo;
    }

    public boolean transferir(String receptor, int cantidad) {
        return this.banco.transferir(this.nombrePropietario, receptor, cantidad);
    }
    public void retirar(int cantidad) {
        this.saldo -= cantidad;
    }
    public void guardar(int cantidad) {
        this.saldo += cantidad;
    }
}
