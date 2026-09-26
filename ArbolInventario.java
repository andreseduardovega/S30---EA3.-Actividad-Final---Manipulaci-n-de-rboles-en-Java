/**
 * Contiene la lógica del árbol binario de búsqueda
 * utilizado para organizar el inventario.
 */
public class ArbolInventario {

    private Producto raiz;

    /**
     * Inserta un producto en el árbol.
     *
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @return true si el producto fue registrado;
     *         false si el ID ya existe.
     */
    public boolean insertar(int id, String nombre) {

        Producto nuevo = new Producto(id, nombre);

        // Si el árbol está vacío, el nuevo producto se convierte en la raíz.
        if (raiz == null) {
            raiz = nuevo;
            return true;
        }

        return insertarRecursivo(raiz, nuevo);
    }

    /**
     * Busca recursivamente la posición correcta para insertar
     * el nuevo producto.
     *
     * @param actual nodo desde el cual continúa la búsqueda
     * @param nuevo producto que se desea insertar
     * @return true si se insertó; false si el ID ya existe
     */
    private boolean insertarRecursivo(Producto actual, Producto nuevo) {

        if (nuevo.id < actual.id) {

            // Los ID menores se ubican en el subárbol izquierdo.
            if (actual.izquierdo == null) {

                // El puntero izquierdo referencia al nuevo nodo.
                actual.izquierdo = nuevo;
                return true;
            }

            return insertarRecursivo(actual.izquierdo, nuevo);

        } else if (nuevo.id > actual.id) {

            // Los ID mayores se ubican en el subárbol derecho.
            if (actual.derecho == null) {

                // El puntero derecho referencia al nuevo nodo.
                actual.derecho = nuevo;
                return true;
            }

            return insertarRecursivo(actual.derecho, nuevo);
        }

        // El ID ya existe. No se inserta un producto duplicado.
        return false;
    }

    /**
     * Muestra todos los productos utilizando un recorrido inorden.
     *
     * El recorrido inorden visita:
     * izquierda → raíz → derecha.
     *
     * En un árbol binario de búsqueda esto permite mostrar
     * los productos ordenados por ID.
     */
    public void mostrarInventario() {

        if (raiz == null) {
            System.out.println("El inventario está vacío.");
            return;
        }

        recorridoInorden(raiz);
    }

    /**
     * Realiza recursivamente el recorrido inorden.
     *
     * @param actual nodo que se está procesando
     */
    private void recorridoInorden(Producto actual) {

        if (actual != null) {

            // Primero se recorren los nodos menores.
            recorridoInorden(actual.izquierdo);

            // Se muestra el nodo actual.
            System.out.println(
                    "ID: " + actual.id +
                    " | Nombre: " + actual.nombre
            );

            // Finalmente se recorren los nodos mayores.
            recorridoInorden(actual.derecho);
        }
    }

    /**
     * Busca un producto utilizando su ID.
     *
     * @param id identificador que se desea buscar
     * @return el producto encontrado o null si no existe
     */
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    /**
     * Realiza la búsqueda de forma recursiva.
     *
     * @param actual nodo desde el cual continúa la búsqueda
     * @param id identificador que se desea encontrar
     * @return el producto encontrado o null
     */
    private Producto buscarRecursivo(Producto actual, int id) {

        // Si llegamos a null, el producto no existe.
        if (actual == null) {
            return null;
        }

        // El ID coincide con el nodo actual.
        if (id == actual.id) {
            return actual;
        }

        // Los ID menores se buscan hacia la izquierda.
        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        }

        // Los ID mayores se buscan hacia la derecha.
        return buscarRecursivo(actual.derecho, id);
    }
}