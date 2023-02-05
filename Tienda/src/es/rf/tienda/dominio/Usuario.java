package es.rf.tienda.dominio;

import java.time.LocalDate;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;

/**
 * Clase usuario
 * @author m.corchero.blazquez
 * @version Feb2023
 *
 */
public class Usuario {
	
	private static int idAutoincremental = 0;
	private int id_usuario;
	private String user_nombre;
	private String user_email;
	private String user_pass;
	private int user_tipo;
	private String user_dni;
	private LocalDate user_fecAlta;
	private LocalDate user_fecConfirmacion;
	
	private static final int LONGITUD_NOMBRE_MIN = 5;
	private static final int LONGITUD_NOMBRE_MAIL_MAX = 100;
	private static final int LONGITUD_MAIL_MIN = 6;
	private static final int LONGITUD_PASS_MIN = 8;
	private static final int LONGITUD_PASS_MAX = 20;
	private static final int LONGITUD_DNI = 12;
	


	public Usuario() {
		setId_usuario(++idAutoincremental);
	}

	/**
	 * Método observador que devuelve el id del usuario
	 * @return id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}
	
	/**
	 * Método modificador que modifica el id_usuario
	 * @param id_usuario
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	/**
	 * Método observador que devuelve el nombre
	 * @return user_nombre
	 */
	public String getUser_nombre() {
		return user_nombre;
	}
	
	/**
	 * Método modificador que modifica el atributo user_nombre
	 * @param user_nombre
	 * @throws DomainException 
	 */
	public void setUser_nombre(String user_nombre) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(user_nombre) && 
				Validator.cumpleLongitud(user_nombre, LONGITUD_NOMBRE_MIN, LONGITUD_NOMBRE_MAIL_MAX)) {
			this.user_nombre = user_nombre;
		}else {
			throw new DomainException();
		}		
	}
	
	/**
	 * Método observador que devuelve el email
	 * @return user_email
	 */
	public String getUser_email() {
		return user_email;
	}
	
	/**
	 * Método modificador que modifica el email
	 * @param user_email
	 * @throws DomainException 
	 */
	public void setUser_email(String user_email) throws DomainException {
		if(Validator.isEmailValido(user_email) && 
				Validator.cumpleLongitud(user_email, LONGITUD_MAIL_MIN, LONGITUD_NOMBRE_MAIL_MAX)) {
			this.user_email = user_email;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador que devuelve la contraseña del usuario
	 * @return user_pass
	 */
	public String getUser_pass() {
		return user_pass;
	}
	
	/**
	 * Método modificador que modifica la contraseña del usuario
	 * @param user_pass
	 * @throws DomainException 
	 */
	public void setUser_pass(String user_pass) throws DomainException {
		if(Validator.esPasswordValida(user_pass) && 
				Validator.cumpleLongitud(user_pass, LONGITUD_PASS_MIN, LONGITUD_PASS_MAX)) {
			this.user_pass = user_pass;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador que devuelve el tipo de usuario
	 * @return user_tipo
	 */
	public int getUser_tipo() {
		return user_tipo;
	}
	
	/**
	 * Método modificador que modifica el atributo tipo de usuario
	 * @param user_tipo
	 * @throws DomainException 
	 */
	public void setUser_tipo(int user_tipo) {
		this.user_tipo = user_tipo;		
	}
	
	/**
	 * Método observador que devuelve el dni del usuario
	 * @return user_dni
	 */
	public String getUser_dni() {
		return user_dni;
	}
	
	/**
	 * Método modificador que modifica el dni del usuario
	 * @param user_dni
	 * @throws DomainException 
	 */
	public void setUser_dni(String user_dni) throws DomainException {
		if(Validator.cumpleDNI(user_dni) && 
				Validator.cumpleLongitud(user_dni, LONGITUD_DNI, LONGITUD_DNI)) {
			this.user_dni = user_dni;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador que devuelve la fecha de alta del usuario
	 * @return user_fecAlta
	 */
	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}
	
	/**
	 * Método modificador que modifica la fecha de alta del usuario
	 * @param user_fecAlta
	 */
	public void setUser_fecAlta(LocalDate user_fecAlta) {
		this.user_fecAlta = user_fecAlta;
	}
	
	/**
	 * Método observador que devuelve la fecha de confirmación del usuario
	 * @return user_fecConfirmacion
	 */
	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}
	
	/**
	 * Método modificador que modifica la fecha de confirmación del usuario
	 * @param user_fecConfirmacion
	 */
	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) {
		this.user_fecConfirmacion = user_fecConfirmacion;
	}
	
	

	
	
}
