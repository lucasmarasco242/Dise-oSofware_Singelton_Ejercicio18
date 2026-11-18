Ejercicio 18 - Registro Compartido de Movimientos de Insumos

Explicación del programa

En este ejercicio se creó una clase llamada RegistroInsumos que aplica el patrón Singleton para centralizar y unificar el registro de movimientos de insumos entre los sectores de depósito, consultorios y laboratorio sin utilizar librerías externas ni imports.
La clase cuenta con:
- Una variable estática privada llamada instancia.
- Arreglos privados (codigos, tipos, cantidades, sectores, fechas) y un contador (total) para mantener la información protegida e inalterable desde el exterior.
- Un constructor privado que inicializa los arreglos de almacenamiento.
- Un método estático público llamado getInstancia() que devuelve siempre la misma referencia única compartida por todos los sectores.
- Métodos públicos para registrar movimientos con validación estricta de cantidades positivas y control de stock disponible, calcular saldos, mostrar el historial completo y filtrar por insumo o sector.

Luego, dentro del método main, se simulan los tres sectores obteniendo referencias al Singleton:
RegistroInsumos deposito = RegistroInsumos.getInstancia();
RegistroInsumos consultorios = RegistroInsumos.getInstancia();
RegistroInsumos laboratorio = RegistroInsumos.getInstancia();

Finalmente, se utilizó System.out.println() para comprobar que todos los sectores comparten la misma instancia, registrar entradas y salidas, validar restricciones ante stock insuficiente o cantidades negativas, y consultar los saldos e historiales filtrados.

Lógica utilizada

La lógica del programa consiste en:
- Restringir la creación de objetos externos mediante un constructor privado.
- Controlar el acceso global a través de getInstancia() para asegurar que depósito, consultorios y laboratorio escriban y lean sobre el mismo registro unificado.
- Validar que las salidas nunca superen el saldo disponible calculado de forma dinámica a partir de las entradas y salidas registradas.

Resultado de la ejecución

La ejecución del programa muestra en la consola lo siguiente:
¿Es la misma instancia en los 3 sectores?: true

Registrando entradas iniciales:
Movimiento registrado [ENTRADA] - Insumo: INS001 | Cantidad: 100 | Sector: Deposito
Movimiento registrado [ENTRADA] - Insumo: INS002 | Cantidad: 50 | Sector: Deposito

Registrando salidas de insumos:
Movimiento registrado [SALIDA] - Insumo: INS001 | Cantidad: 20 | Sector: Consultorios
Movimiento registrado [SALIDA] - Insumo: INS002 | Cantidad: 10 | Sector: Laboratorio

Probando restricciones y validaciones:
Error: Stock insuficiente para el insumo INS001. Saldo actual: 80
Error: La cantidad debe ser un valor positivo.

Saldos actuales calculados:
Saldo INS001: 80
Saldo INS002: 40

--- Historial Completo de Movimientos ---
1. Fecha: 06/06/2026 | Sector: Deposito | Tipo: ENTRADA | Insumo: INS001 | Cantidad: 100
2. Fecha: 06/06/2026 | Sector: Deposito | Tipo: ENTRADA | Insumo: INS002 | Cantidad: 50
3. Fecha: 06/06/2026 | Sector: Consultorios | Tipo: SALIDA | Insumo: INS001 | Cantidad: 20
4. Fecha: 06/06/2026 | Sector: Laboratorio | Tipo: SALIDA | Insumo: INS002 | Cantidad: 10

--- Movimientos del Insumo: INS001 ---
- [06/06/2026] Sector: Consultorios | SALIDA: 20
- [06/06/2026] Sector: Deposito | ENTRADA: 100

--- Movimientos del Sector: Laboratorio ---
- [06/06/2026] Insumo: INS002 | SALIDA: 10

Captura de pantalla

<img width="870" height="537" alt="image" src="https://github.com/user-attachments/assets/462ff734-a711-49fe-8d36-d12108416402" />
<img width="790" height="411" alt="image" src="https://github.com/user-attachments/assets/69ab4c2b-898f-4f98-8960-31c31f55f1b6" />

