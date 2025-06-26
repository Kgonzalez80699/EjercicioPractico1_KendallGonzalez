package ejerciciopractico1.demo.dao;
import ejerciciopractico1.demo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository <Cliente, Long>{
    
}
