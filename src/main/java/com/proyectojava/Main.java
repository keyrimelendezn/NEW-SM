package com.proyectojava;

public class Main {
    public static void main(String[] args) {
        // Crear dos cuentas de prueba
        CuentaBancaria cuentaMoises = new CuentaBancaria("SV-001928", "Moisés Urrutia", 500.00);
        CuentaBancaria cuentaDiana = new CuentaBancaria("SV-321015", "Diana del Carmen", 200.00);

        // Operaciones en la cuenta de Moisés
        cuentaMoises.depositar(150.00);
        cuentaMoises.retirar(200.00);

        // Transferencia hacia la cuenta de Diana
        cuentaMoises.transferir(cuentaDiana, 150.00);

        // Consultar el historial completo de la cuenta de Moisés
        cuentaMoises.mostrarHistorial();

        // Consultar el historial completo de la cuenta de Diana
        cuentaDiana.mostrarHistorial();
    }
}
