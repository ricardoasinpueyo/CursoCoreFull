package testbeans;

import beans.Departamento;
import beans.Director;
import beans.Empleado;
import beans.Gerente;
import beans.Operativo;

public class TestEmpleadosHerencia {

	public static void main(String[] args) {
		Empleado [] empleados = cargarEmpleados();
		for (Empleado ele: empleados) {
			if (ele instanceof Gerente)
				System.out.println("Gerente Tipo movil : " +((Gerente) ele).getMovil());
			else if (ele instanceof Director)
				System.out.println("Directior acciones : " + ((Director) ele).getAcciones());
			else if (ele instanceof Operativo)
				System.out.println("Operativo horas extra : " + ((Operativo)ele).getHorasExtras());
			
			System.out.print(ele.getClass() + " : " +ele.nombreCompleto() + 
					"  " + ele.totalSalario()+"\n");
			
		}

	}
	
	public static Empleado[] cargarEmpleados() {
		Departamento dep10 = new Departamento(10, "Ventas");
		Departamento dep20 = new Departamento(20, "TI");
		Departamento dep30 = new Departamento(30, "Admon");
		
		Empleado e600 = new Operativo(600, "genaro", "de gracia", "H", 20_000, 28, 0, dep10, 50);
		
		Empleado emp100, emp115, empGerente200, empGerente201, 
			empDirector400;
		Gerente gerente300, gerente301;
		Director director114, director250;
		
 		emp100 = new Operativo(100, "mario", "vargas", "H", 
								30000, 45, 1000, dep10,15);
		
		emp115 = new Operativo(115, "carlos", "lopez", "H", 
				40000, 35, 2000, dep20,50);
		
		empGerente200 = new Gerente(200, "daniel", "travieso", "H", 30_000, 32, 3000, 
				dep10, 60, "sony xperia", 10_000);
		
		empGerente201 = new Gerente(201, "jose", "coronado", "H", 60_000, 42, 2000, 
				dep20, 61, "sony xperia 2", 7_000);
		
		empDirector400 = new Director(400, "isabel", "prendes", "M", 100_000, 49, 
				50_000, dep30, 400, "tableta la mejor");
		
		gerente300 = new Gerente(300, "sara", "varas", "M", 50_000, 52, 7000, 
				dep10, 65, "nokia ladrillo", 20_000);
		
		gerente301 = new Gerente(301, "eva", "perez", "M", 55_000, 42, 5000, 
				dep20, 64, "nisu ultimo modelo", 10_000);
		
		director114 = new Director(114, "rafael", "alberti", "H", 80_000, 56, 
				30_000, dep10, 200, "super tableta 3D");
		
		director250 = new Director(250, "maria", "pita", "M", 90_000, 49, 
				20_000, dep20, 180, "tableta gigante");
		
		dep10.setJefe(director114);
		dep20.setJefe(director250);
		dep30.setJefe(empDirector400);
		
		dep10.sonido();
		dep10.saludar();
		
		Empleado [] lista = {e600,emp100,emp115, empGerente200,empGerente201,
				empDirector400, gerente300,gerente301, director114,director250};
		return lista;
		}
	}

 
