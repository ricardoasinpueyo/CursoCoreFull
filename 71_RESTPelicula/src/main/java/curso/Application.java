package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import curso.modelo.entidad.Pelicula;
import curso.modelo.persistancia.DaoPelicula;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		DaoPelicula dao = context.getBean("daoPelicula",DaoPelicula.class);
		
		Pelicula p = new Pelicula();
		p.setTitulo("Murio con las botas puestas");
		p.setDirector("Manolo el del bombo");
		p.setGenero("comedia");
		p.setYear(1990);
		
		dao.save(p);
	}

}
