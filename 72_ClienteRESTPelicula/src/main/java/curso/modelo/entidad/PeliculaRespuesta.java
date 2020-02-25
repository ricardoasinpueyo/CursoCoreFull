package curso.modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PeliculaRespuesta {
	private Pelicula pelicula;
	private List<String> listaMensajes = new ArrayList<String>();
	private List<Integer> listaCodigos = new ArrayList<Integer>();
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public List<String> getListaMensajes() {
		return listaMensajes;
	}
	public void setListaMensajes(List<String> listaMensajes) {
		this.listaMensajes = listaMensajes;
	}
	public void addMensaje(String mensaje) {
		listaMensajes.add(mensaje);
	}
	
	public void addCodigo(Integer codigo) {
		listaCodigos.add(codigo);
	}
	
	public List<Integer> getListaCodigos() {
		return listaCodigos;
	}
	public void setListaCodigos(List<Integer> listaCodigos) {
		this.listaCodigos = listaCodigos;
	}
	
	
}
