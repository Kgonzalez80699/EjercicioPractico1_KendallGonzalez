package ejerciciopractico1.demo.dao;
import ejerciciopractico1.demo.domain.Queja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuejaDao extends JpaRepository<Queja, Long>{
    
}
