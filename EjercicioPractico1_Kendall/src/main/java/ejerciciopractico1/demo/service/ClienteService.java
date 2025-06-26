package ejerciciopractico1.demo.service;

import ejerciciopractico1.demo.domain.Cliente;
import java.util.List;

/**
 * Interfaz que define los métodos de la lógica de negocio para la entidad Cliente.
 * Estos métodos serán implementados por una clase en el paquete 'Servicelmplementation'.
 */
public interface ClienteService {

    /**
     * Obtiene una lista de todos los clientes registrados.
     *
     * @return Una lista de objetos Cliente.
     */
    List<Cliente> getClientes();

    /**
     * Obtiene un cliente por su ID.
     *
     * @param clienteId El ID del cliente a buscar.
     * @return El objeto Cliente si se encuentra, o null si no existe.
     */
    Cliente getCliente(Long clienteId);

    /**
     * Guarda o actualiza un cliente en la base de datos.
     * Si el cliente tiene un ID, se actualiza; si no, se crea uno nuevo.
     *
     * @param cliente El objeto Cliente a guardar o actualizar.
     */
    void save(Cliente cliente);

    /**
     * Elimina un cliente de la base de datos por su ID.
     *
     * @param clienteId El ID del cliente a eliminar.
     */
    void delete(Long clienteId);

    /**
     * Busca clientes por un nombre o apellido parcial (ejemplo).
     *
     * @param terminoBusqueda El término a buscar en el nombre o apellido del cliente.
     * @return Una lista de clientes que coinciden con el término.
     */
    List<Cliente> findByNombreContainingOrApellidosContaining(String terminoBusqueda);

    public Object listarClientes();

    public void guardarCliente(Cliente cliente);

    public Object obtenerPorId(Long id);

    public void eliminarCliente(Long id);
}