/**
 * Representa un producto y, al mismo tiempo, un nodo
 * dentro del árbol binario de búsqueda.
 */
public class Producto {

    int id;
    String nombre;

    // Referencia al hijo izquierdo del nodo.
    Producto izquierdo;

    // Referencia al hijo derecho del nodo.
    Producto derecho;

    /**
     * Construye un nuevo producto.
     *
     * @param id identificador único del producto
     * @param nombre nombre del producto
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;

        // Inicialmente el producto no tiene hijos.
        this.izquierdo = null;
        this.derecho = null;
    }
}