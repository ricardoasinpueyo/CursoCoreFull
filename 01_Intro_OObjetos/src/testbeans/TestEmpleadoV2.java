package testbeans;
import beans.Empleado;

public class TestEmpleadoV2 {
	public static void main(String[] args) {
		Empleado emp3 = new Empleado(115,"andrea","sanchez pastor", "M", 78000,24);
		
		System.out.println("mi salario anterior : " + emp3.getSalario());
		System.out.println(emp3.aumentarSalario(1000));
		System.out.println("mi salario actual : " + emp3.nombreCompleto()+ 
				" " +emp3.getSalario());
		
	}

}
