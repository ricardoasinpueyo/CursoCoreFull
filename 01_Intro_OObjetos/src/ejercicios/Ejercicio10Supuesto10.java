package ejercicios;
import java.util.Scanner;

public class Ejercicio10Supuesto10 {
	public static void main(String[] args) {
		String usuario=null, pwd = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("usuario ");
		usuario = sc.next();
		System.out.print("contraseña ");
		pwd = sc.next();
		sc.close();
		if (usuario.equals("sara")) {
			if (pwd.equals("sarita"))
				System.out.println("usuario y contraseña correctas, bienvenido a la aplicación");
			else
				System.out.println("contraseña incorrecta");
		}else
			System.out.println("usuario incorrecto");
		
		
		
		
		
		
		
		if (usuario.equals("sara")&& pwd.equals("sarita"))
			System.out.println("usuario y contraseña correctas, bienvenido a la aplicación");
		else
			System.out.println("usuario o contraseña incorrectos, sorry");
			
		
	}
	

}
