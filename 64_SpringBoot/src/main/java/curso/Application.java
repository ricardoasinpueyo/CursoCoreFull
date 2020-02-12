package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import curso.modelo.entidad.Persona;
import curso.modelo.persistencia.PersonaDao;

@SpringBootApplication
//Esta anotciones es muy importante ya que engloba varias
//casos

//El pimero hace un Compomnent Scan de todos los paquetes
//que extiendan de este

//El segundo es que hace que esta clase sea de configuracion
//con lo cual podriamos hacer metodos con @Bean

//Tercero y mas importante automaticamente recorre
//nuestro classpath para dar de alta aquellos objetos
//que considere necesarios para el funcionamiento del programa
//por ejemplo, le hemos dicho que queremos crear
//una aplicacion con jpa-data, por lo tanto
//el considera que tiene que tener un objeto entitymanager
//tambien te generara una bbdd en memoria si puede
//(una h2 vale, una mysql no vale)
//en otros ambitos, si le hubieramos dicho que nuestra app
//es web, tambien te le descararia un tomcat y lo 
//levantaria cada vez que ejecutes la app

@ImportResource("classpath:beans.xml")
//con esta anotacion le decimos que vaya a buscar un beans.xml
//que este en la carpeta de "resources"
public class Application {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = SpringApplication.run(Application.class, args);
		
		Persona p = context.getBean("persona", Persona.class);
		
		PersonaDao pd = context.getBean("personaDao",PersonaDao.class);
		p.setNombre("Gandalf");
		p.setEdad(1111);
		p.setPeso(56);
		
		pd.save(p);
		
		Persona p2 = pd.findById(1).get();
		System.out.println(p2);
	}

}
