import proyectoBanco.*;

import proyectoBanco.comandos.ServicioComando;

void main() {
    var banco = new Banco();
    var servicioComando = new ServicioComando();
    var administrador = new Administrador(banco, servicioComando);
    var servicioBanco = new ServicioBanco(banco);

    banco.cambiarAdministrador(administrador);

    var persona1 = new Persona("Mateo", "La Boca", servicioBanco);
    var persona2 = new Persona("Carlos", "Tablada", servicioBanco);

    persona1.solicitarCrearCuenta();
    persona2.solicitarCrearCuenta();

    administrador.procesarComandos();

    persona1.actualizarCuenta();
    persona2.actualizarCuenta();

    persona1.verBalance();
    persona2.verBalance();

    persona1.cargarSaldo(1000);

    persona1.transferir("Carlos", 100);

    System.out.println("\n\nLuego de la transferencia\n");
    persona1.verBalance();
    persona2.verBalance();
}