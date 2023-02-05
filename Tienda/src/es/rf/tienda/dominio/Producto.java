package es.rf.tienda.dominio;

import java.time.LocalDate;
import java.util.Arrays;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;

/**
 * Clase producto
 * @author m.corchero.blazquez
 *
 */
public class Producto {
	
	private String id_producto;
	private String pro_descripcion;
	private String pro_desLarga;
	private double pro_precio;
	private int pro_stock;
	private LocalDate pro_fecRepos;
	private LocalDate pro_fecActi;
	private LocalDate pro_fecDesacti;
	private String pro_uniVenta;
	private double pro_cantXUniVenta;
	private String pro_uniUltNivel;
	private int id_pais;
	private String pro_usoRecomendado;
	private int id_categoria;
	private int pro_stkReservado;
	private int pro_nStkAlto;
	private int pro_nStkBajo;
	private char pro_stat;
	
	private static final int LONGITUD_DESCRCORTA_MIN = 5;
	private static final int LONGITUD_DESCRCORTA_MAX = 100;
	private static final int LONGITUD_MAXIMA_EXPLICACION_USORECOM = 2000;
	private static final int RANGO_MIN = 0;
	private static final int RANGO_MAX = 100;
	private static final int LONGITUD_UNID_VENTA_MIN = 1;
	private static final int LONGITUD_UNID_VENTA_MAX = 10;
	private static final int LONGITUD_USO_RECOMENDADO_MIN = 0;
	private static final int NUM_DECIMALES = 2;
	private static final Character[] ESTADO = {'A', 'B'};
	
	
	/**
	 * Método observador del id de producto
	 * @return id_producto
	 */
	public String getId_producto() {
		return id_producto;
	}
	
	/**
	 * Método modificador de id_producto
	 * @param id_producto
	 * @throws DomainException 
	 */
	public void setId_producto(String id_producto) throws DomainException {
		if(Validator.isAlfanumeric(id_producto) && Validator.cumpleCodigoProducto(id_producto)) {
			this.id_producto = id_producto;
		}else {
			throw new DomainException();
		}		
	}
	
	/**
	 * Método observador de descripción
	 * @return pro_descripcion
	 */
	public String getPro_descripcion() {
		return pro_descripcion;
	}
	
	/**
	 * Método modificador de descripción
	 * @param pro_descripcion
	 * @throws DomainException 
	 */
	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(pro_descripcion)  && 
				Validator.cumpleLongitud(pro_descripcion, LONGITUD_DESCRCORTA_MIN, LONGITUD_DESCRCORTA_MAX)) {
			this.pro_descripcion = pro_descripcion;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador de descripción larga
	 * @return pro_desLarga
	 */
	public String getPro_desLarga() {
		return pro_desLarga;
	}
	
	/**
	 * Método modificador de descripción larga
	 * @param pro_desLarga
	 * @throws DomainException 
	 */
	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(pro_desLarga) &&
				Validator.cumpleLongitud(pro_desLarga, LONGITUD_DESCRCORTA_MIN, LONGITUD_MAXIMA_EXPLICACION_USORECOM)) {
			this.pro_desLarga = pro_desLarga;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador de precio
	 * @return pro_precio
	 */
	public double getPro_precio() {
		return pro_precio;
	}
	
	/**
	 * método modificador del precio
	 * @param pro_precio
	 * @throws DomainException 
	 */
	public void setPro_precio(double pro_precio) throws DomainException {
		if(Validator.cumpleDecimales(pro_precio, NUM_DECIMALES) &&
				Validator.cumpleRango(pro_precio, RANGO_MIN, RANGO_MAX)) {
			this.pro_precio = pro_precio;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador de stock
	 * @return pro_stock
	 */
	public int getPro_stock() {
		return pro_stock;
	}
	
	/**
	 * Método modificador de stock de producto
	 * @param pro_stock
	 */
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}
	
	/**
	 * Método observador de fecha prevista de reposición
	 * @return pro_fecRepos
	 */
	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}
	
	/**
	 * Método modificador de fecha prevista de reposición
	 * @param pro_fecRepos
	 * @throws DomainException 
	 */
	public void setPro_fecRepos(LocalDate pro_fecRepos) throws DomainException {
		if(Validator.valDateMin(pro_fecRepos, LocalDate.now())) {
			this.pro_fecRepos = pro_fecRepos;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador de fecha de activación
	 * @return pro_fecActi
	 */
	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}
	
	/**
	 * Método modificador de fecha de activación
	 * @param pro_fecActi
	 * @throws DomainException 
	 */
	public void setPro_fecActi(LocalDate pro_fecActi) throws DomainException {
		if(Validator.valDateMin(pro_fecActi, LocalDate.now())) {
			this.pro_fecActi = pro_fecActi;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador de fecha de desactivación
	 * @return pro_fecDesacti
	 */
	public LocalDate getPro_fecDesacti() {
		return pro_fecDesacti;
	}
	
	/**
	 * Método modificador de fecha de desactivación
	 * @param pro_fecDesacti
	 * @throws DomainException 
	 */
	public void setPro_fecDesacti(LocalDate pro_fecDesacti) throws DomainException {
		if(getPro_fecActi() != null) {
			if(Validator.valDateMin(pro_fecDesacti, getPro_fecActi())) {
				this.pro_fecDesacti = pro_fecDesacti;
			}else {
				throw new DomainException();
			}
		}else {
			if(Validator.valDateMin(pro_fecDesacti, LocalDate.now())) {
				this.pro_fecDesacti = pro_fecDesacti;
			}else {
				throw new DomainException();
			}
		}
	}
	
	/**
	 * Método observador de unidades de venta
	 * @return pro_uniVenta
	 */
	public String getPro_uniVenta() {
		return pro_uniVenta;
	}
	
	/**
	 * Método modificador de unidades de venta
	 * @param pro_uniVenta
	 * @throws DomainException 
	 */
	public void setPro_uniVenta(String pro_uniVenta) throws DomainException {
		if( Validator.isAlfanumericWhiteSpaces(pro_uniVenta) 
				&& Validator.cumpleLongitud(pro_uniVenta, LONGITUD_UNID_VENTA_MIN, LONGITUD_UNID_VENTA_MAX)) {
			this.pro_uniVenta = pro_uniVenta;
		}else {
			throw new DomainException();
		}
		
	}
	
	/**
	 * Método observador de cantidades de unidades últimas
	 * @return pro_cantXUniVenta
	 */
	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}
	
	/**
	 * Método modificador de atributo cantidad de unidades últimas
	 * @param pro_cantXUniVenta
	 * @throws DomainException 
	 */
	public void setPro_cantXUniVenta(double pro_cantXUniVenta) throws DomainException {
		if(Validator.cumpleDecimales(pro_cantXUniVenta, NUM_DECIMALES)) {
			this.pro_cantXUniVenta = pro_cantXUniVenta;
		}else {
			throw new DomainException();
		}
		
	}
	
	/**
	 * Método observador de última unidad
	 * @return pro_uniUltNivel
	 */
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}
	
	/**
	 * Método modificador de última unidad
	 * @param pro_uniUltNivel
	 * @throws DomainException 
	 */
	public void setPro_uniUltNivel(String pro_uniUltNivel) throws DomainException {
		if(Validator.isAlfanumeric(pro_uniUltNivel)) {
			this.pro_uniUltNivel = pro_uniUltNivel;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método observador del id del país origen
	 * @return id_pais
	 */
	public int getId_pais() {
		return id_pais;
	}
	
	/**
	 * Método modificador de id de país origen
	 * @param id_pais
	 */
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	
	/**
	 * Método observador de uso recomendado
	 * @return getPro_usoRecomendado
	 */
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}
	
	/**
	 * Método modificador de uso recomendado
	 * @param pro_usoRecomendado
	 * @throws DomainException 
	 */
	public void setPro_usoRecomendado(String pro_usoRecomendado) throws DomainException {
		if(Validator.isAlfanumericWhiteSpaces(pro_usoRecomendado) && 
				Validator.cumpleLongitud(pro_usoRecomendado, LONGITUD_USO_RECOMENDADO_MIN, LONGITUD_MAXIMA_EXPLICACION_USORECOM)) {
			this.pro_usoRecomendado = pro_usoRecomendado;
		}else {
			throw new DomainException();
		}
	}
	
	/**
	 * Método modificador de id de categoría
	 * @return id_categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}
	
	/**
	 * Método modificador de id de categoría
	 * @param id_categoria
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	/**
	 * Método observador de stock reservado
	 * @return Pro_stkReservados
	 */
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}
	
	/**
	 * Método modificador de stock reservado
	 * @param pro_stkReservado
	 */
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}
	
	/**
	 * Método observador de Stock para nivel alto
	 * @return pro_nStkAlto
	 */
	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}
	
	/**
	 * Método modificador de Stock para nivel alto
	 * @param pro_nStkAlto
	 */
	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}
	
	/**
	 * Método observador de Stock para nivel bajo
	 * @return pro_nStkBajo
	 */
	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}
	
	/**
	 * Método modificador de Stock para nivel bajo
	 * @param pro_nStkBajo
	 */
	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}
	
	/**
	 * Método observador para estado
	 * @return pro_stat
	 */
	public char getPro_stat() {
		return pro_stat;
	}
	
	/**
	 * Método modificador para estado
	 * @param pro_stat
	 * @throws DomainException 
	 */
	public void setPro_stat(char pro_stat) throws DomainException {
		if(Arrays.asList(ESTADO).contains(pro_stat)) {
			this.pro_stat = pro_stat;
		}else {
			throw new DomainException();
		}
		
	}
	
	

}
