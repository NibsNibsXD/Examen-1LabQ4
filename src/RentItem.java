/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jorge Aguirre
 */
public abstract class RentItem {
    // Atributos
    private String codigoItem;
    private String nombreItem;
    private double precioRentaItem;
    private int cantidadCopias;

    // Constructor
    public RentItem(String codigoItem, String nombreItem, double precioRentaItem) {
        this.codigoItem = codigoItem;
        this.nombreItem = nombreItem;
        this.precioRentaItem = precioRentaItem;
        this.cantidadCopias = 0; // Se inicializa en 0
    }

    //toString
    @Override
    public String toString() {
        return "Código de Item: " + codigoItem + ", Nombre de Item: " + nombreItem + ", Precio de Renta: " + precioRentaItem;
    }

    // Método abstracto pagoRenta
    public abstract double pagoRenta(int dias);

    // Métodos get para los 3 atributos
    public String getCodigoItem() {
        return codigoItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public double getPrecioRentaItem() {
        return precioRentaItem;
    }
}
