package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;

/**
 * Clase dirección
 * @author m.corchero.blazquez
 *
 */
public class Direccion {
	
	private String dir_nombre;
	private String dir_direccion;
	private String dir_poblacion;
	private String dir_cPostal;
	private String dir_provincia;
	private String dir_pais;
	private String dir_correoE;
	private final int LONGITUD_MAXIMA = 100;
	private final int LONGITUD_MINIMA = 5;
	
	/**
	 * Observador del atributo dir_nombre Nombre
	 * @return dir_nombre
	 */
	public String getDir_nombre() {
		return dir_nombre;
	}
	
	/**
	 * Modificador del atributo dir_nombre Nombre
	 * @param dir_nombre
	 * @throws DomainException 
	 */
	public void setDir_nombre(String dir_nombre) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(dir_nombre) &&
				Validator.cumpleLongitud(dir_nombre, LONGITUD_MINIMA, LONGITUD_MAXIMA)){
			this.dir_nombre = dir_nombre;
		}else {
			throw new DomainException();
		}		
	}
	
	
	/**
	 * Observador del atributo dir_direccion Dirección
	 * @return dir_direccion
	 */
	public String getDir_direccion() {
		return dir_direccion;
	}
	
	/**
	 * Modificador del atributo dir_direccion Dirección
	 * @param dir_direccion
	 * @throws DomainException 
	 */
	public void setDir_direccion(String dir_direccion) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(dir_direccion)) {
			this.dir_direccion = dir_direccion;
		}else {
			throw new DomainException();
		}
	}
	
	
	/**
	 * Observador del atributo dir_poblacion Población
	 * @return dir_poblacion
	 */
	public String getDir_poblacion() {
		return dir_poblacion;
	}
	
	/**
	 * Modificador del atributo dir_poblacion Población
	 * @param dir_poblacion
	 * @throws DomainException 
	 */
	public void setDir_poblacion(String dir_poblacion) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(dir_poblacion)) {
			this.dir_poblacion = dir_poblacion;
		}else {
			throw new DomainException();
		}
	}
	
	
	/**
	 * Observador del atributo dir_cPostal Código Postal
	 * @return dir_cPostal
	 */
	public String getDir_cPostal() {
		return dir_cPostal;
	}
	
	/**
	 * Modificador del atributo dir_cPostal Código Postal
	 * @param dir_cPostal
	 * @throws DomainException 
	 */
	public void setDir_cPostal(String dir_cPostal) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(dir_cPostal)) {
			this.dir_cPostal = dir_cPostal;
		}else {
			throw new DomainException();
		}
	}
	
	
	/**
	 * Observador del atributo dir_provincia Provincia
	 * @return dir_provincia
	 */
	public String getDir_provincia() {
		return dir_provincia;
	}
	
	/**
	 * Modificador del atributo dir_provincia Provincia
	 * @param dir_provincia
	 * @throws DomainException 
	 */
	public void setDir_provincia(String dir_provincia) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(dir_provincia)) {
			this.dir_provincia = dir_provincia;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Observador del atributo dir_pais País
	 * @return dir_pais
	 */
	public String getDir_pais() {
		return dir_pais;
	}
	
	/**
	 * Modificador del atributo dir_pais País
	 * @param dir_pais
	 * @throws DomainException 
	 */
	public void setDir_pais(String dir_pais) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(dir_pais)) {
			this.dir_pais = dir_pais;
		}else {
			throw new DomainException();
		}
	}
	
	
	/**
	 * Observador del atributo dir_correoE Correo Electrónico
	 * @return dir_correoE
	 */
	public String getDir_correoE() {
		return dir_correoE;
	}
	
	/**
	 * Modificador del atributo dir_correoE Correo Electrónico
	 * @param dir_correoE
	 * @throws DomainException 
	 */
	public void setDir_correoE(String dir_correoE) throws DomainException {
		if(Validator.isEmailValido(dir_correoE)) {
			this.dir_correoE = dir_correoE;
		}else {
			throw new DomainException();
		}
		
	}
		
		
		
}
