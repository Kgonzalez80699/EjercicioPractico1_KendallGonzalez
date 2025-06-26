package ejerciciopractico1.demo.dao;
import ejerciciopractico1.demo.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository<Factura, Long>{
    
}
