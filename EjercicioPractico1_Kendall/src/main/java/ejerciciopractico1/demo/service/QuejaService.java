package ejerciciopractico1.demo.service;

import ejerciciopractico1.demo.domain.Queja;
import java.util.List;

/**
 * Interfaz que define los métodos de la lógica de negocio para la entidad Queja.
 * Estos métodos serán implementados por una clase en el paquete 'Servicelmplementation'.
 */
public interface QuejaService {

    /**
     * Obtiene una lista de todas las quejas y sugerencias registradas.
     *
     * @return Una lista de objetos Queja.
     */
    List<Queja> getQuejas();

    /**
     * Obtiene una queja o sugerencia por su ID.
     *
     * @param quejaId El ID de la queja a buscar.
     * @return El objeto Queja si se encuentra, o null si no existe.
     */
    Queja getQueja(Long quejaId);

    /**
     * Guarda o actualiza una queja/sugerencia en la base de datos.
     * Este método se usaría tanto para que un usuario envíe una nueva queja
     * como para que un administrador la marque como "resuelta", por ejemplo.
     *
     * @param queja El objeto Queja a guardar o actualizar.
     */
    void save(Queja queja);

    /**
     * Elimina una queja o sugerencia de la base de datos por su ID.
     *
     * @param quejaId El ID de la queja a eliminar.
     */
    void delete(Long quejaId);

    /**
     * Obtiene una lista de quejas/sugerencias por su estado (ej. "Pendiente", "Resuelta").
     * (Asume que la entidad Queja tiene un campo 'estado').
     *
     * @param estado El estado por el cual filtrar las quejas.
     * @return Una lista de objetos Queja que coinciden con el estado.
     */
    List<Queja> getQuejasByEstado(String estado);

    /**
     * Busca quejas/sugerencias por parte del nombre de contacto o el asunto.
     *
     * @param terminoBusqueda El término a buscar en el nombre de contacto o asunto.
     * @return Una lista de quejas que coinciden con el término.
     */
    List<Queja> findByNombreContactoContainingOrAsuntoContaining(String terminoBusqueda);

    public void guardarQueja(Queja queja);
}