package com.proyectojava;

public class Main {
    public static void main (String[] args){
        // Crear cuenta bancaria de prueba
        CuentaBancaria cuentaMoises = new CuentaBancaria("SV-023072002","Moises Urrutia", 500.00 );

        System.out.println("Titular: " + cuentaMoises.getTitular());
        System.out.println("Saldo inicial: $" + cuentaMoises.getSaldo());


        // Probar depositos y retiros

        cuentaMoises.depositar(150.00);
        cuentaMoises.retirar(200.00);
    }
}
