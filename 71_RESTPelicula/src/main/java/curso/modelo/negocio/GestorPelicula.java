package curso.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidad.Pelicula;
import curso.modelo.entidad.PeliculaRespuesta;
import curso.modelo.persistancia.DaoPelicula;

@Service
public class GestorPelicula {

	@Autowired
	private DaoPelicula daoPelicula;
	
	/**
	 * 
	 * @param p, el id debe de venir vacio
	 * @return
	 */
	public PeliculaRespuesta alta(Pelicula p) {
		PeliculaRespuesta pr =  validarPelicula(p);
		if(!pr.getListaCodigos().isEmpty()) {
			return pr;
		}
		
		daoPelicula.save(p);
		pr.addCodigo(0);
		pr.addMensaje("Pelicula dada de alta o modificada");
		return pr;
	}

	public PeliculaRespuesta borrar(int id) {
		Optional<Pelicula> opt = daoPelicula.findById(id);
		PeliculaRespuesta pr = new PeliculaRespuesta();
		if(opt.isPresent()) {
			daoPelicula.deleteById(id);
			pr.addCodigo(0);
			pr.addMensaje("Pelicula Borrada");
			pr.setPelicula(opt.get());
		}else {
			pr.addCodigo(-7);
			pr.addMensaje("El id de la pelicula no existe para borrar");
		}
		
		return pr;
	}
	
	/**
	 * 
	 * @param p, el id debe de venir relleno
	 * @return
	 */
	public PeliculaRespuesta modificar(Pelicula p) {
		Optional<Pelicula> opt = daoPelicula.findById(p.getId());
		if(opt.isPresent()) {
			return alta(p);
		}else {
			PeliculaRespuesta pr = new PeliculaRespuesta();
			pr.addCodigo(-6);
			pr.addMensaje("Id de pelicula no encontrado");
			pr.setPelicula(p);
			return pr;
		}
		
	}
	
	public List<Pelicula> listar(){
		return daoPelicula.findAll();
	}
	
	public Pelicula buscarTitulo(String titulo){
		return daoPelicula.findByTituloIgnoreCase(titulo);
	}
	
	public List<Pelicula> listarTituloContaining(String titulo){
		return daoPelicula.findByTituloContainingIgnoreCase(titulo);
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	private PeliculaRespuesta validarPelicula(Pelicula p) {
		PeliculaRespuesta pr = new PeliculaRespuesta();
		pr.setPelicula(p);
		if(p.getTitulo().isEmpty()) {
			pr.addCodigo(-1);
			pr.addMensaje("Titulo vacio");
		}
		if(p.getGenero().isEmpty()) {
			pr.addCodigo(-2);
			pr.addMensaje("Genero vacio");
		}
		if(p.getDirector().isEmpty()) {
			pr.addCodigo(-3);
			pr.addMensaje("Director vacio");
		}
		if(p.getYear() < 1894) {
			pr.addCodigo(-4);
			pr.addMensaje("año menor a 1894 :)");
		}
		if(p.getTitulo().length() < 4) {
			pr.addCodigo(-5);
			pr.addMensaje("El titulo debe tener al menos 4 caracteres");
		}

		return pr;
	}
	
	public Optional<Pelicula> buscarPorId(int id){
		return daoPelicula.findById(id);
	}
}
