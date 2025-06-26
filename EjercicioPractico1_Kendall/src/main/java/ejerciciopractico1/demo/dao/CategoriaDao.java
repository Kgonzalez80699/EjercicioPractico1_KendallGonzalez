package ejerciciopractico1.demo.dao;
import ejerciciopractico1.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
}
