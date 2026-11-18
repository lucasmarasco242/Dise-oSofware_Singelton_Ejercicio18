public class Main {
    public static void main(String[] args) {
        // Simulando los sectores de depósito, consultorios y laboratorio compartiendo la misma instancia
        RegistroInsumos deposito = RegistroInsumos.getInstancia();
        RegistroInsumos consultorios = RegistroInsumos.getInstancia();
        RegistroInsumos laboratorio = RegistroInsumos.getInstancia();

        System.out.println("¿Es la misma instancia en los 3 sectores?: " + (deposito == consultorios && consultorios == laboratorio));

        // 1. Incorporar saldo inicial mediante un movimiento de entrada desde Depósito
        System.out.println("\nRegistrando entradas iniciales:");
        deposito.registrarMovimiento("INS001", "ENTRADA", 100, "Deposito", "06/06/2026");
        deposito.registrarMovimiento("INS002", "ENTRADA", 50, "Deposito", "06/06/2026");

        // 2. Registrar salidas desde Consultorios y Laboratorio
        System.out.println("\nRegistrando salidas de insumos:");
        consultorios.registrarMovimiento("INS001", "SALIDA", 20, "Consultorios", "06/06/2026");
        laboratorio.registrarMovimiento("INS002", "SALIDA", 10, "Laboratorio", "06/06/2026");

        // 3. Pruebas de restricciones (salida excediendo saldo y cantidad negativa)
        System.out.println("\nProbando restricciones y validaciones:");
        consultorios.registrarMovimiento("INS001", "SALIDA", 200, "Consultorios", "06/06/2026");
        laboratorio.registrarMovimiento("INS002", "SALIDA", -5, "Laboratorio", "06/06/2026");

        // 4. Consultar saldos actuales
        System.out.println("\nSaldos actuales calculados:");
        System.out.println("Saldo INS001: " + deposito.calcularSaldo("INS001"));
        System.out.println("Saldo INS002: " + deposito.calcularSaldo("INS002"));

        // 5. Historial completo y filtros
        System.out.println();
        deposito.mostrarHistorial();

        System.out.println();
        consultorios.filtrarPorInsumo("INS001");

        System.out.println();
        laboratorio.filtrarPorSector("Laboratorio");
    }
}