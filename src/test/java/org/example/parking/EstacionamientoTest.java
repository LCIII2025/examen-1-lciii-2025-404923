package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

import java.time.LocalDateTime;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        Estacionamiento estacionamiento = new Estacionamiento();
        Vehiculo vehiculo = new Vehiculo("123456789", "Mercedes", Vehiculo.Tipo.AUTO);
        estacionamiento.ingresarVehiculo("123456789", "Juan Perez", vehiculo);

        Ticket ticket = estacionamiento.retirarVehiculo("123456789");

        assertEquals(vehiculo, ticket.getVehiculo());
        //TODO test
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        Ticket ticket = new Ticket(new Cliente("123456789", "Juan Perez"), new Vehiculo("123456789", "Mercedes", Vehiculo.Tipo.AUTO));

        ticket.marcarSalida();
        if (ticket.calcularMinutos() <= 60) {
            assertEquals(100, ticket.calcularPrecio(), 0.0);
        }
        if (ticket.calcularMinutos() > 60 && ticket.getHoraSalida().getMinute() <= 120) {
            assertEquals(200, ticket.calcularPrecio(), 0.0);
        }
        if (ticket.calcularMinutos() > 120) {
            assertEquals(300, ticket.calcularPrecio(), 0.0);
        }


            
        // TODO test
    }

}