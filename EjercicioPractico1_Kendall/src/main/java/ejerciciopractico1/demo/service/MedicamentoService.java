package ejerciciopractico1.demo.service;

import ejerciciopractico1.demo.domain.Medicamento; // Asume que tienes una entidad Medicamento.java
import java.util.List;

/**
 * Interfaz que define los métodos de la lógica de negocio para la entidad Medicamento.
 * Estos métodos serán implementados por una clase en el paquete 'Servicelmplementation'.
 *
 * NOTA: Considera si esta funcionalidad ya está cubierta por 'ProductoService'
 * si 'Medicamento' es solo un tipo de 'Producto' en tu diseño.
 */
public interface MedicamentoService {

    /**
     * Obtiene una lista de todos los medicamentos disponibles.
     *
     * @return Una lista de objetos Medicamento.
     */
    List<Medicamento> getMedicamentos();

    /**
     * Obtiene un medicamento por su ID.
     *
     * @param medicamentoId El ID del medicamento a buscar.
     * @return El objeto Medicamento si se encuentra, o null si no existe.
     */
    Medicamento getMedicamento(Long medicamentoId);

    /**
     * Guarda o actualiza un medicamento en la base de datos.
     * Si el medicamento tiene un ID, se actualiza; si no, se crea uno nuevo.
     *
     * @param medicamento El objeto Medicamento a guardar o actualizar.
     */
    void save(Medicamento medicamento);

    /**
     * Elimina un medicamento de la base de datos por su ID.
     *
     * @param medicamentoId El ID del medicamento a eliminar.
     */
    void delete(Long medicamentoId);

    /**
     * Obtiene una lista de medicamentos que están activos/disponibles.
     * (Asume que la entidad Medicamento tiene un campo 'activo').
     *
     * @param activos Si es true, retorna solo medicamentos activos; si es false, retorna todos.
     * @return Una lista de objetos Medicamento.
     */
    List<Medicamento> getMedicamentos(boolean activos);

    /**
     * Busca medicamentos por parte de su nombre o descripción.
     *
     * @param terminoBusqueda El texto a buscar.
     * @return Una lista de medicamentos que coinciden con el término.
     */
    List<Medicamento> findByNombreContainingOrDescripcionContaining(String terminoBusqueda);

    public void guardarMedicamento(Medicamento medicamento);

    public Medicamento obtenerPorId(Long id);

    public void eliminarMedicamento(Long id);

    public Object listarmedicamentos();
}
