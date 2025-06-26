package ejerciciopractico1.demo.service;

import ejerciciopractico1.demo.domain.Factura;
import ejerciciopractico1.demo.domain.FacturaDetalle;
import java.util.List;

/**
 * Interfaz que define los métodos de la lógica de negocio para la entidad FacturaDetalle.
 * Estos métodos serán implementados por una clase en el paquete 'Servicelmplementation'.
 */
public interface FacturaDetalleService {

    /**
     * Obtiene una lista de todos los detalles de factura.
     *
     * @return Una lista de objetos FacturaDetalle.
     */
    List<FacturaDetalle> getFacturaDetalles();

    /**
     * Obtiene un detalle de factura por su ID.
     *
     * @param facturaDetalleId El ID del detalle de factura a buscar.
     * @return El objeto FacturaDetalle si se encuentra, o null si no existe.
     */
    FacturaDetalle getFacturaDetalle(Long facturaDetalleId);

    /**
     * Obtiene una lista de detalles de factura asociados a una factura específica.
     *
     * @param factura La factura de la cual se quieren obtener los detalles.
     * @return Una lista de objetos FacturaDetalle asociados a la factura dada.
     */
    List<FacturaDetalle> getFacturaDetallesByFactura(Factura factura);

    /**
     * Guarda o actualiza un detalle de factura en la base de datos.
     * Si el detalle tiene un ID, se actualiza; si no, se crea uno nuevo.
     *
     * @param facturaDetalle El objeto FacturaDetalle a guardar o actualizar.
     */
    void save(FacturaDetalle facturaDetalle);

    /**
     * Guarda una lista de detalles de factura.
     * Útil cuando se crea una factura y se guardan todos sus detalles a la vez.
     *
     * @param detalles Una lista de objetos FacturaDetalle a guardar.
     */
    void saveAll(List<FacturaDetalle> detalles);

    /**
     * Elimina un detalle de factura de la base de datos por su ID.
     *
     * @param facturaDetalleId El ID del detalle de factura a eliminar.
     */
    void delete(Long facturaDetalleId);

    /**
     * Elimina todos los detalles de factura asociados a una factura específica.
     *
     * @param factura La factura de la cual se eliminarán todos sus detalles.
     */
    void deleteAllByFactura(Factura factura);
}