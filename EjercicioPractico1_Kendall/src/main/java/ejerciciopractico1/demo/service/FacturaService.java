package ejerciciopractico1.demo.service;

import ejerciciopractico1.demo.domain.Factura;
import ejerciciopractico1.demo.domain.Cliente;
import java.util.List;
import java.time.LocalDateTime; // Para manejar fechas y horas de la factura

/**
 * Interfaz que define los métodos de la lógica de negocio para la entidad Factura.
 * Estos métodos serán implementados por una clase en el paquete 'Servicelmplementation'.
 */
public interface FacturaService {

    /**
     * Obtiene una lista de todas las facturas registradas.
     *
     * @return Una lista de objetos Factura.
     */
    List<Factura> getFacturas();

    /**
     * Obtiene una factura por su ID.
     *
     * @param facturaId El ID de la factura a buscar.
     * @return El objeto Factura si se encuentra, o null si no existe.
     */
    Factura getFactura(Long facturaId);

    /**
     * Guarda o actualiza una factura en la base de datos.
     * Si la factura tiene un ID, se actualiza; si no, se crea una nueva.
     *
     * @param factura El objeto Factura a guardar o actualizar.
     */
    void save(Factura factura);

    /**
     * Elimina una factura de la base de datos por su ID.
     *
     * @param facturaId El ID de la factura a eliminar.
     */
    void delete(Long facturaId);

    /**
     * Obtiene una lista de facturas para un cliente específico.
     *
     * @param cliente El cliente del cual se quieren obtener las facturas.
     * @return Una lista de objetos Factura asociados al cliente dado.
     */
    List<Factura> getFacturasByCliente(Cliente cliente);

    /**
     * Obtiene una lista de facturas dentro de un rango de fechas.
     *
     * @param fechaInicio La fecha y hora de inicio del rango (inclusive).
     * @param fechaFin La fecha y hora de fin del rango (inclusive).
     * @return Una lista de objetos Factura que caen dentro del rango de fechas.
     */
    List<Factura> getFacturasByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Opcional: Podrías añadir un método para calcular el total de una factura
    // o para crear una factura con sus detalles en una sola operación transaccional.

    public Object listarFacturas();

    public Object obtenerPorId(Long id);

    public Object obtenerDetalleFactura(Long id);
}
