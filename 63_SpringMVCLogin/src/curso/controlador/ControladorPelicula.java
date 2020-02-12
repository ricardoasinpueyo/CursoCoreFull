package curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidad.Pelicula;
import curso.modelo.negocio.GestorPelicula;

@Controller
public class ControladorPelicula {

	@Autowired
	public GestorPelicula gp;
	
	@RequestMapping("peliculas/alta")
	public String alta() {
		return "peliculas/alta";
	}
	
	@RequestMapping("peliculas/doAltaPelicula")
	public ModelAndView doAltaPelicula(
			@RequestParam() String titulo,
			@RequestParam() String director,
			@RequestParam() String genero,
			@RequestParam() int year,
			ModelAndView mav) {
		
		Pelicula p = new Pelicula();
		p.setTitulo(titulo);
		p.setDirector(director);
		p.setGenero(genero);
		p.setYear(year);
		
		gp.alta(p);
		
		//como estamos accediendo a la url
		//http://localhost:8080/63_SpringMVCLogin/mvc/peliculas/doAltaPelicula
		//no hay que poner peliculas/alta si quiero acceder
		//al primer metodo @RequestMapping("peliculas/alta")
		//si lo hago de manera relativa solo tengo que poner "alta"
		mav.setViewName("redirect:alta");
		mav.getModelMap().addAttribute("mensaje", "La pelicula se ha dado de alta con el id " + p.getId());
		
		return mav;
	}
	
	@RequestMapping("peliculas/listar")
	public ModelAndView listar(ModelAndView mav,
			@RequestParam(required = false) 
			Integer idPelicula) {
		List<Pelicula> listaPeliculas = gp.listar();
		//esto seria por si queremos mostrar el detalle
		//en la misma pagina que el listar
		if(idPelicula != null) {
			Pelicula p = gp.getPeliculaById(idPelicula);
			mav.addObject("pelicula", p);
		}
		mav.setViewName("peliculas/listar");
		mav.addObject("listaPeliculas", listaPeliculas);
		return mav;
	}
	
	@RequestMapping("peliculas/detalle")
	public ModelAndView mostrarInicio(
			@RequestParam() int id,
			ModelAndView mav) {
		
		Pelicula p = gp.getPeliculaById(id);
		mav.setViewName("peliculas/detalle");
		mav.addObject("pelicula", p);
		return mav;
	}
}

