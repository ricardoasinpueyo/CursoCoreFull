package curso.modelo.persistancia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.modelo.entidad.Pelicula;

@Repository
public interface DaoPelicula extends JpaRepository<Pelicula, Integer>{
	
	public List<Pelicula> findByGenero(String genero);
	public Pelicula findByTituloIgnoreCase(String titulo);
	public List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
}
