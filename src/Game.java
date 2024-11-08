import java.util.ArrayList;
import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jorge Aguirre
 */


public class Game extends RentItem implements MenuActions {
    // Atributos
    private Calendar fechaPublicacion; // Fecha de publicación del juego
    private ArrayList<String> especificaciones; // Lista de especificaciones

    // Constructor
    public Game(String codigoItem, String nombreItem) {
        super(codigoItem, nombreItem, 20.0); // Precio de renta fijo de Lps. 20
        this.fechaPublicacion = Calendar.getInstance(); // Fecha actual
        this.especificaciones = new ArrayList<>(); // Inicialización del ArrayList
    }

    // Redefinición de toString
    @Override
    public String toString() {
        // Formatear la fecha de publicación
        int dia = fechaPublicacion.get(Calendar.DAY_OF_MONTH);
        int mes = fechaPublicacion.get(Calendar.MONTH) + 1; // Los meses empiezan desde 0
        int año = fechaPublicacion.get(Calendar.YEAR);
        String fechaStr = dia + "/" + mes + "/" + año;

        return super.toString() + ", Fecha de Publicación: " + fechaStr + " – PS3 Game";
    }

    // Método para actualizar la fecha de publicación
    public void setFechaPublicacion(int año, int mes, int dia) {
        fechaPublicacion.set(Calendar.YEAR, año);
        fechaPublicacion.set(Calendar.MONTH, mes - 1); // Restar 1 porque enero es 0
        fechaPublicacion.set(Calendar.DAY_OF_MONTH, dia);
    }

    // Método para obtener la fecha de publicación formateada
    public String getFechaPublicacion() {
        int dia = fechaPublicacion.get(Calendar.DAY_OF_MONTH);
        int mes = fechaPublicacion.get(Calendar.MONTH) + 1;
        int año = fechaPublicacion.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + año;
    }

    // Método para agregar una especificación
    public void agregarEspecificacion(String especificacion) {
        especificaciones.add(especificacion);
    }

    // Método para obtener la lista de especificaciones
    public ArrayList<String> getEspecificaciones() {
        return especificaciones;
    }

    // Método recursivo para obtener las especificaciones como una lista de Strings
    public ArrayList<String> listEspecificaciones() {
        ArrayList<String> listaEspecificaciones = new ArrayList<>();
        listEspecificacionesRecursivo(0, listaEspecificaciones);
        return listaEspecificaciones;
    }

    private void listEspecificacionesRecursivo(int indice, ArrayList<String> lista) {
        if (indice < especificaciones.size()) {
            lista.add(especificaciones.get(indice));
            listEspecificacionesRecursivo(indice + 1, lista);
        }
    }

    // Redefinición de pagoRenta
    @Override
    public double pagoRenta(int dias) {
        return getPrecioRentaItem() * dias;
    }

    // Implementación de submenu de MenuActions
    @Override
    public void submenu() {
        // Este método puede ser implementado para interactuar con la GUI.
        // Por ejemplo, puede devolver una lista de opciones disponibles.
    }

    // Implementación de ejecutarOpcion de MenuActions
    @Override
    public void ejecutarOpcion(int opcion) {
        // Este método será implementado en la GUI para manejar las acciones basadas en la opción seleccionada.
        // Como ya no usamos entradas por consola, los datos necesarios deben ser proporcionados por la GUI.
    }

    // Métodos adicionales para ejecutar opciones con parámetros

    // Opción 1: Actualizar Fecha de Publicación
    public void actualizarFechaPublicacion(int año, int mes, int dia) {
        setFechaPublicacion(año, mes, dia);
    }

    // Opción 2: Agregar Especificación
    public void agregarEspecificacionOpcion(String especificacion) {
        agregarEspecificacion(especificacion);
    }

    // Opción 3: Obtener Especificaciones
    public ArrayList<String> obtenerEspecificaciones() {
        return listEspecificaciones();
    }
}
