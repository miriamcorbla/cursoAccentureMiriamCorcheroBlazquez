package bbdd.ficheros.dao;

import java.util.List;

import bbdd.ficheros.modelos.Employee;

public interface EmployeesDAOInterface {
	
	public Employee leerUno(int employee_id);
	public List<Employee> leerTodos();
	public int actualizar(Employee employee); //update de employee, y devuelvo las filas afectadas, por eso dev int
	public int actualizar(int employee_id);
	public int delete(Employee employee);
	public int delete(int employee_id);
	public Employee insert(Employee employee);
	
}
