package curso.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//por este controla
@Controller
public class ControladorSaludo {

	//mediante esta anotacion le estamos diciendo al
	//super servlet de spring que las peticiones con url
	//"saludo" entren por este metodo. Al no decirle el verbo
	//http, mapea todos los verbos http
	//OJO!!! hay que pasar por el super servlet por lo tanto
	//esta url realmente es : "/mvc/saludo"
	@RequestMapping("saludo")
	public String metodo1() {
		//este tipo de envio seria por forward
		//y consultaria con el viewResolver para saber
		//donde se encuentra esre recurso
		//la direccion del recurso resultante seria
		// /WEB-INF/vistas/inicioSaludo.jsp
		return "inicioSaludo";
	}
}
