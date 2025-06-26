package ejerciciopractico1.demo.service;

import ejerciciopractico1.demo.domain.Categoria;
import java.util.List;

/**
 * Interfaz que define los métodos de la lógica de negocio para la entidad Categoria.
 * Estos métodos serán implementados por una clase en el paquete 'Servicelmplementation'.
 */
public interface CategoriaService {

    /**
     * Obtiene una lista de todas las categorías disponibles.
     *
     * @return Una lista de objetos Categoria.
     */
    List<Categoria> getCategorias();

    /**
     * Obtiene una lista de categorías, filtrando por su estado de 'activo'.
     *
     * @param activos Indica si se deben obtener solo las categorías activas (true) o todas (false).
     * @return Una lista de objetos Categoria que cumplen con el criterio de 'activo'.
     */
    List<Categoria> getCategorias(boolean activos);

    /**
     * Busca una categoría por su ID.
     *
     * @param categoriaId El ID de la categoría a buscar.
     * @return El objeto Categoria si se encuentra, o null si no existe.
     */
    Categoria getCategoria(Long categoriaId);

    /**
     * Guarda o actualiza una categoría en la base de datos.
     * Si la categoría tiene un ID, se actualiza; si no, se crea una nueva.
     *
     * @param categoria El objeto Categoria a guardar o actualizar.
     */
    void save(Categoria categoria);

    /**
     * Elimina una categoría de la base de datos por su ID.
     *
     * @param categoriaId El ID de la categoría a eliminar.
     */
    void delete(Long categoriaId);

    public Object listarCategorias();

    public void guardarCategoria(Categoria categoria);

    public Object obtenerPorId(Long id);

    public void eliminarCategoria(Long id);
}
