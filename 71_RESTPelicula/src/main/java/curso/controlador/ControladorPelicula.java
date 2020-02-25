package curso.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.modelo.entidad.Pelicula;
import curso.modelo.entidad.PeliculaRespuesta;
import curso.modelo.entidad.Peliculas;
import curso.modelo.negocio.GestorPelicula;
import curso.modelo.persistancia.DaoPelicula;

@RestController
public class ControladorPelicula {

	//Ahora SI ponemos el gestor
	@Autowired
	private GestorPelicula gestorPelicula;
	
	@GetMapping(path = "peliculas", produces = 
		{MediaType.APPLICATION_JSON_VALUE, 
				MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Peliculas> listar(
			@RequestParam(name = "titulo",required = false)
			String titulo,
			@RequestParam(name = "exacto", required = false)
			String exacto){
		//URL http://localhost:8080/peliculas?titulo=rambo
		if(titulo != null) {
			//URL http://localhost:8080/peliculas?titulo=rambo?exacto=si
			if(exacto != null) {
				Pelicula pelicula = gestorPelicula.buscarTitulo(titulo);
				Peliculas peliculas = new Peliculas();
				List<Pelicula> lista = new ArrayList<Pelicula>();
				lista.add(pelicula);
				peliculas.setListaPelicula(lista);
				return new ResponseEntity<Peliculas>(peliculas,HttpStatus.OK);
			}
			List<Pelicula> lista = gestorPelicula.listarTituloContaining(titulo);
			Peliculas peliculas = new Peliculas();
			peliculas.setListaPelicula(lista);
			return new ResponseEntity<Peliculas>(peliculas,HttpStatus.OK);
		}else {//URL http://localhost:8080/peliculas
			List<Pelicula> lista = gestorPelicula.listar();
			Peliculas peliculas = new Peliculas();
			peliculas.setListaPelicula(lista);
			return new ResponseEntity<Peliculas>(peliculas,HttpStatus.OK);
		
		}
	}

	// BODY {"titulo":"La guerra de los mundos","director":"Manolo","genero":"accion","year":1980}
	@PostMapping(path = "peliculas", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PeliculaRespuesta> alta(@RequestBody Pelicula p){
		PeliculaRespuesta pr = gestorPelicula.alta(p);
		if(pr.getListaCodigos().contains(0))
			return new ResponseEntity<PeliculaRespuesta>(pr,HttpStatus.CREATED);
		else
			return new ResponseEntity<PeliculaRespuesta>(pr,HttpStatus.BAD_REQUEST);
	}
	
	//como el id que buscamos va como parametro de path o rutas
	//debemos de ponerlo entre llaves
	//la manera de recogerlo sera con la anotacion @PathParam
	@GetMapping(path ="peliculas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pelicula> obtener(@PathVariable("id") Integer id){
		Optional<Pelicula> opt = gestorPelicula.buscarPorId(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Pelicula>(opt.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Pelicula>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path="peliculas/{id}", consumes =  MediaType.APPLICATION_JSON_VALUE,
			produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PeliculaRespuesta> modificar(@RequestBody Pelicula pelicula,
					@PathVariable Integer id){
		pelicula.setId(id);
		PeliculaRespuesta pr = gestorPelicula.modificar(pelicula);
		if(pr.getListaCodigos().contains(0))
			return new ResponseEntity<PeliculaRespuesta>(pr,HttpStatus.OK);
		else
			return new ResponseEntity<PeliculaRespuesta>(pr,HttpStatus.BAD_REQUEST);		
	}
	
	@DeleteMapping(path="peliculas/{id}")
	public ResponseEntity<PeliculaRespuesta> borrar(@PathVariable Integer id){
		PeliculaRespuesta pr = gestorPelicula.borrar(id);
		if(pr.getListaCodigos().contains(0)) {
			return new ResponseEntity<PeliculaRespuesta>(pr,HttpStatus.OK);
		}else {
			return new ResponseEntity<PeliculaRespuesta>(pr,HttpStatus.NOT_FOUND);
		}	
	}
}
