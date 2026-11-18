public class RegistroInsumos {
    private static RegistroInsumos instancia;
    private String[] codigos;
    private String[] tipos;
    private int[] cantidades;
    private String[] sectores;
    private String[] fechas;
    private int total;

    private RegistroInsumos() {
        this.codigos = new String[20];
        this.tipos = new String[20];
        this.cantidades = new int[20];
        this.sectores = new String[20];
        this.fechas = new String[20];
        this.total = 0;
    }

    public static RegistroInsumos getInstancia() {
        if (instancia == null) {
            instancia = new RegistroInsumos();
        }
        return instancia;
    }

    public void registrarMovimiento(String codigo, String tipo, int cantidad, String sector, String fecha) {
        if (codigo == null || codigo.isEmpty() || tipo == null || sector == null || fecha == null) {
            System.out.println("Error: Datos incompletos.");
            return;
        }
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser un valor positivo.");
            return;
        }
        if (!tipo.equals("ENTRADA") && !tipo.equals("SALIDA")) {
            System.out.println("Error: Tipo de movimiento inválido (debe ser 'ENTRADA' o 'SALIDA').");
            return;
        }

        // Si es salida, verificar que exista saldo suficiente
        if (tipo.equals("SALIDA")) {
            int saldoActual = calcularSaldo(codigo);
            if (cantidad > saldoActual) {
                System.out.println("Error: Stock insuficiente para el insumo " + codigo + ". Saldo actual: " + saldoActual);
                return;
            }
        }

        if (total < 20) {
            codigos[total] = codigo;
            tipos[total] = tipo;
            cantidades[total] = cantidad;
            sectores[total] = sector;
            fechas[total] = fecha;
            total++;
            System.out.println("Movimiento registrado [" + tipo + "] - Insumo: " + codigo + " | Cantidad: " + cantidad + " | Sector: " + sector);
        } else {
            System.out.println("Error: Capacidad máxima del registro alcanzada.");
        }
    }

    public int calcularSaldo(String codigo) {
        int saldo = 0;
        for (int i = 0; i < total; i++) {
            if (codigos[i].equals(codigo)) {
                if (tipos[i].equals("ENTRADA")) {
                    saldo += cantidades[i];
                } else if (tipos[i].equals("SALIDA")) {
                    saldo -= cantidades[i];
                }
            }
        }
        return saldo;
    }

    public void mostrarHistorial() {
        System.out.println("--- Historial Completo de Movimientos ---");
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + ". Fecha: " + fechas[i] + " | Sector: " + sectores[i] + " | Tipo: " + tipos[i] + " | Insumo: " + codigos[i] + " | Cantidad: " + cantidades[i]);
        }
    }

    public void filtrarPorInsumo(String codigoBuscado) {
        System.out.println("--- Movimientos del Insumo: " + codigoBuscado + " ---");
        boolean encontrado = false;
        for (int i = 0; i < total; i++) {
            if (codigos[i].equals(codigoBuscado)) {
                System.out.println("- [" + fechas[i] + "] Sector: " + sectores[i] + " | " + tipos[i] + ": " + cantidades[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay movimientos registrados para este insumo.");
        }
    }

    public void filtrarPorSector(String sectorBuscado) {
        System.out.println("--- Movimientos del Sector: " + sectorBuscado + " ---");
        boolean encontrado = false;
        for (int i = 0; i < total; i++) {
            if (sectores[i].equals(sectorBuscado)) {
                System.out.println("- [" + fechas[i] + "] Insumo: " + codigos[i] + " | " + tipos[i] + ": " + cantidades[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay movimientos registrados para este sector.");
        }
    }
}