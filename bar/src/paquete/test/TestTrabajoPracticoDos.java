package paquete.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import paquete.clases.Bar;
import paquete.clases.DebeSerPositivo;
import paquete.clases.EsDisponible;
import paquete.clases.EstaCerrada;
import paquete.clases.Estado;
import paquete.clases.NoDebeTenerConsumiciones;
import paquete.clases.NoPuedeSerOcupada;
 
 
public class TestTrabajoPracticoDos {
   

    @Test
    public void testCambiarMesaDeOcupadaACerrada() throws NoPuedeSerOcupada, NoDebeTenerConsumiciones, EstaCerrada, DebeSerPositivo{
    	Bar bar = Bar.getInstance(5);
        bar.ocuparMesa(2);
        bar.agregarProducto(125, 100, 2, "cerveza");
        bar.agregarConsumicion(2, 2, 2);
        bar.cerrarMesa(2);
        Assert.assertEquals(Estado.Ocupada, bar.estadoMesa(2));
        bar.ReiniciarBar();
    }
       
 
    @Test
    public void testVerSiLaMesaEstaDisponible() throws NoPuedeSerOcupada, NoDebeTenerConsumiciones, EsDisponible {
        Bar bar = Bar.getInstance(5);
       
        bar.ocuparMesa(5);
        bar.ocuparMesa(1);
        bar.ocuparMesa(2);
        bar.ocuparMesa(3);
        bar.desocuparMesa(3);
        Assert.assertEquals(Estado.Disponible, bar.estadoMesa(3));
        bar.ReiniciarBar();
    }
   
    @Test
    public void testVerSiLaMesaEstaOcupada() throws NoPuedeSerOcupada, NoDebeTenerConsumiciones {
 
        Bar bar = Bar.getInstance(5);
        bar.ocuparMesa(1);
        bar.ocuparMesa(2);
        bar.ocuparMesa(3);
        bar.ocuparMesa(4);
        Assert.assertEquals(Estado.Ocupada, bar.estadoMesa(4));
        bar.ReiniciarBar();
    }
   
    @Test
    public void testPasarMesaDeDisponibleACerrada() throws NoPuedeSerOcupada, NoDebeTenerConsumiciones, EstaCerrada {
        Bar bar = Bar.getInstance(5);
        bar.ocuparMesa(1);
        bar.ocuparMesa(2);
        bar.ocuparMesa(3);
        bar.ocuparMesa(4);
        bar.cerrarMesa(5);
        Assert.assertEquals(Estado.Cerrada, bar.estadoMesa(5));
        bar.ReiniciarBar();
    }
   
    @Test
    public void testCambiarMesaDeCerradaAOcupada() throws NoPuedeSerOcupada, NoDebeTenerConsumiciones, EstaCerrada{
 
        Bar bar = Bar.getInstance(5);
        bar.ocuparMesa(1);
        bar.cerrarMesa(2);
        bar.ocuparMesa(2);
       
        Assert.assertEquals(Estado.Cerrada, bar.estadoMesa(2));
        bar.ReiniciarBar();
    }
 
 
    @Test
    public void testAgregarConsumiciones() throws DebeSerPositivo, NoPuedeSerOcupada, NoDebeTenerConsumiciones {
 
        Bar bar = Bar.getInstance(5);
        bar.ocuparMesa(1);
        bar.agregarProducto(125, 100, 12, "cerveza");
        bar.agregarProducto(125, 100, 12, "Agua");
        bar.agregarConsumicion(1, 12, 4);
        bar.ReiniciarBar();
       
    }
   
    @Test
    public void testOtroTest() throws NoPuedeSerOcupada, NoDebeTenerConsumiciones {
 
        Bar bar = Bar.getInstance(5);
        bar.ocuparMesa(1);
        bar.ReiniciarBar();
       
    }
   
    @Test
    public void testAgregarProductosYEliminarUno() throws DebeSerPositivo, NoPuedeSerOcupada, NoDebeTenerConsumiciones {
 
        Bar bar = Bar.getInstance(5);
        bar.ocuparMesa(1);
        bar.agregarProducto(125, 100, 12, "cerveza");
        bar.agregarProducto(125, 100, 15, "Agua");
        bar.agregarConsumicion(1, 15, 4);
        Assert.assertEquals(true,bar.eliminarProducto(12) );
        bar.ReiniciarBar();
    }
   
    @Test
    public void testCambiarProbarTicketDos(){
        Bar bar = Bar.getInstance(5);
        bar.listarTicketsEnFechas(1, 1, 2017, 12, 12, 2017);
        bar.ReiniciarBar();
 
    }
    
    @Test
    public void testProbarTicket() throws NoPuedeSerOcupada, NoDebeTenerConsumiciones, DebeSerPositivo, EsDisponible{
    	
    	Bar bar = Bar.getInstance(10);
    	
        bar.agregarProducto(15, 10, 1, "Soda");
        bar.agregarProducto(20, 15, 2, "AGUA SABORIZADA");
        bar.agregarProducto(40, 30, 3, "Hamburguesa");
        bar.agregarProducto(25, 5, 4, "Papas Fritas");
        bar.agregarProducto(10, 6, 5, "AGUA");
        bar.agregarProducto(25, 12, 6, "GASEOSA");
        bar.agregarProducto(35, 25, 7, "VINO");
        bar.agregarProducto(40, 25, 8, "CERVEZA");
        bar.agregarProducto(30, 15, 9, "Flan casero");
        bar.agregarProducto(35, 20, 10, "Porción de torta");
        bar.agregarProducto(10, 5, 11, "MediaLuna");
        bar.agregarProducto(25, 10, 12, "Tostado");
        bar.agregarProducto(20, 10, 13, "Licuado");
        bar.agregarProducto(30, 15, 14, "Cafe");
        bar.agregarProducto(22, 10, 15, "Ensalada");
        bar.agregarProducto(25, 10, 16, "Pancho");

        bar.cambiarMes(3);
        bar.cambiarDia(1);
        
        bar.ocuparMesa(3);
        bar.agregarConsumicion(3, 1, 2);
        bar.agregarConsumicion(3, 2, 2);
        bar.agregarConsumicion(3, 3, 2);
        bar.agregarConsumicion(3, 4, 2);
        bar.desocuparMesa(3);
        
        bar.cambiarAño(2017);
        bar.cambiarMes(4);
        bar.cambiarDia(1);
       
        bar.ocuparMesa(1);
        bar.consultarProducto(12);
        bar.consultarProducto(6);
        bar.consultarProducto(3);
        bar.agregarConsumicion(1, 3, 2);
        bar.agregarConsumicion(1, 6, 2);
        bar.desocuparMesa(1);
        
        bar.ocuparMesa(2);
        bar.consultarProducto(16);
        bar.consultarProducto(7);
        bar.consultarProducto(12);
        bar.agregarConsumicion(2, 16, 1);
        bar.agregarConsumicion(2, 6, 2);
        bar.agregarConsumicion(2, 3, 2);
        bar.agregarConsumicion(2, 8, 1);
        bar.desocuparMesa(2);        
        
        bar.cambiarDia(2);
        
        bar.ocuparMesa(3);
        bar.consultarProducto(10);
        bar.consultarProducto(12);
        bar.consultarProducto(13);
        bar.consultarProducto(15);
        bar.agregarConsumicion(3, 10, 1);
        bar.agregarConsumicion(3, 12, 2);
        bar.agregarConsumicion(3, 13, 2);
        bar.agregarConsumicion(3, 15, 1);
        bar.desocuparMesa(3);        
        
        bar.ocuparMesa(4);
        bar.consultarProducto(11);
        bar.consultarProducto(2);
        bar.consultarProducto(3);
        bar.consultarProducto(4);
        bar.agregarConsumicion(4, 11, 1);
        bar.agregarConsumicion(4, 2, 2);
        bar.agregarConsumicion(4, 3, 2);
        bar.agregarConsumicion(4, 4, 1);
        bar.desocuparMesa(4);       
        
        bar.cambiarMes(5);
        bar.cambiarDia(2);
        bar.eliminarProducto(16);
        
        bar.ocuparMesa(5);
        bar.consultarProducto(5);
        bar.consultarProducto(6);
        bar.consultarProducto(7);
        bar.consultarProducto(8);
        bar.agregarConsumicion(5, 5, 2);
        bar.agregarConsumicion(5, 6, 2);
        bar.agregarConsumicion(5, 7, 2);
        bar.agregarConsumicion(5, 8, 2);
        bar.desocuparMesa(5);        
        
        bar.ocuparMesa(6);
        bar.consultarProducto(1);
        bar.consultarProducto(2);
        bar.consultarProducto(3);
        bar.consultarProducto(4);
        bar.agregarConsumicion(6, 1, 2);
        bar.agregarConsumicion(6, 2, 2);
        bar.agregarConsumicion(6, 3, 2);
        bar.agregarConsumicion(6, 4, 2);
        bar.desocuparMesa(6);    
        
        bar.cambiarMes(6);
        bar.cambiarDia(4);
        
        bar.ocuparMesa(8);
        bar.agregarConsumicion(8, 5, 2);
        bar.agregarConsumicion(8, 6, 2);
        bar.agregarConsumicion(8, 7, 2);
        bar.agregarConsumicion(8, 8, 2);
        bar.desocuparMesa(8);        
        
        bar.ocuparMesa(9);
        bar.agregarConsumicion(9, 1, 2);
        bar.agregarConsumicion(9, 2, 2);
        bar.agregarConsumicion(9, 3, 2);
        bar.agregarConsumicion(9, 4, 2);
        bar.desocuparMesa(9);
        
        bar.cambiarMes(7);
        bar.cambiarDia(1);
        
        bar.ocuparMesa(1);
        bar.agregarConsumicion(1, 5, 2);
        bar.agregarConsumicion(1, 6, 2);
        bar.agregarConsumicion(1, 7, 2);
        bar.agregarConsumicion(1, 8, 2);
        bar.desocuparMesa(1);        
        
        bar.ocuparMesa(2);
        bar.agregarConsumicion(2, 1, 2);
        bar.agregarConsumicion(2, 2, 2);
        bar.agregarConsumicion(2, 3, 2);
        bar.agregarConsumicion(2, 4, 2);
        bar.desocuparMesa(2);
        
        bar.cambiarDia(2);
        
        bar.ocuparMesa(3);
        bar.agregarConsumicion(3, 1, 2);
        bar.agregarConsumicion(3, 2, 2);
        bar.agregarConsumicion(3, 3, 2);
        bar.agregarConsumicion(3, 4, 2);
        bar.desocuparMesa(3);
        
        bar.cambiarMes(8);
        bar.cambiarDia(1);
        
        bar.ocuparMesa(4);
        bar.agregarConsumicion(4, 1, 2);
        bar.agregarConsumicion(4, 2, 2);
        bar.agregarConsumicion(4, 3, 2);
        bar.agregarConsumicion(4, 4, 2);
        bar.desocuparMesa(4);
        
        bar.cambiarMes(9);
        bar.cambiarDia(1);
        
        bar.ocuparMesa(3);
        bar.agregarConsumicion(3, 1, 2);
        bar.agregarConsumicion(3, 2, 2);
        bar.agregarConsumicion(3, 3, 2);
        bar.agregarConsumicion(3, 4, 2);
        bar.desocuparMesa(3);
        
        bar.cambiarMes(11);
        bar.cambiarDia(1);
        
        bar.ocuparMesa(3);
        bar.agregarConsumicion(3, 1, 2);
        bar.agregarConsumicion(3, 2, 2);
        bar.agregarConsumicion(3, 3, 2);
        bar.agregarConsumicion(3, 4, 2);
        bar.desocuparMesa(3);
        
        bar.listarTicketsEnFechas(01, 04, 2017, 01, 10, 2017);
        
    }
 
}
