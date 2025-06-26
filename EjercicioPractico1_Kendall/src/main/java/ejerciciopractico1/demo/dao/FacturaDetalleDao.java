package ejerciciopractico1.demo.dao;
import ejerciciopractico1.demo.domain.FacturaDetalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleDao extends JpaRepository<FacturaDetalle, Long>{
    /**
     * @param idFactura El ID de la Factura de la cual se quieren obtener los detalles.
     * @return Una lista de FacturaDetalle que pertenecen a la factura con el ID dado.
     */     
    List<FacturaDetalle> findByFacturaId(Long idFactura);
}
