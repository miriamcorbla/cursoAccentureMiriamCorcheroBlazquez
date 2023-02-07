package curso.miniapi.S4_MiniApi2.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.miniapi.S4_MiniApi2.dao.CategoriaDao;
import curso.miniapi.S4_MiniApi2.interfaces.RequestHandler;
import curso.miniapi.S4_MiniApi2.modelos.Categoria;

@WebServlet("/Categoria/*")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDao cDao;
	private Categoria cModelo;

	public void init() {
//		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
//		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
//		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			cDao = new CategoriaDao();
			cModelo = new Categoria();
		} catch (Exception e) {
			System.out.println("Error init->" + e);
		}
	}

	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if (action==null) 
				action="index";
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				guardar(request, response);
				break;
/*			case "mostrar":
				obtener(request, response);
				break;
			
			 // case "showedit": showEditar(request, response); break;
			 
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
*/			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	public String nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		cModelo = montaModelo(request, response);
		cDao.guardar(cModelo);
		// Map<String, Object> sessionMap =
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		// sessionMap.put("Categoria", c);
		return "/faces/nuevo.xhtml";
	}
	public Categoria montaModelo(HttpServletRequest request, HttpServletResponse response) {
		return new Categoria(0, 
				request.getParameter("cat_nombre"),
				request.getParameter("cat_descripcion"));
	}

	public String guardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// guarda la fecha de registro
		Date fechaActual = new Date();
		cModelo.setFregistro(new java.sql.Date(fechaActual.getTime()));

		
		cDao.guardar(cModelo);
		return "/faces/index.xhtml";
	}

	public List<Categoria> obtenerCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		/*
		 * List<Categoria> listaCategorias = new ArrayList<>(); Categoria c1 = new
		 * Categoria(); c1.setId(1L); c1.setNombres("Elivar"); c1.setApellidos("Largo");
		 * c1.setDireccion("Loja");
		 * 
		 * Categoria c2 = new Categoria(); c2.setId(1L); c2.setNombres("Elivar1");
		 * c2.setApellidos("Largo1"); c2.setDireccion("Loja1"); listaCategorias.add(c1);
		 * listaCategorias.add(c2);
		 * 
		 * return listaCategorias;
		 */
		return cDao.obtenerCategorias();
	}

	public String editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		
//		c = cDao.buscar(id);
		System.out.println("******************************************");
		System.out.println(cModelo);

		// Map<String, Object> sessionMap =
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		// sessionMap.put("Categoria", c);
		return "/faces/editar.xhtml";
	}

	public String actualizar(Categoria categoria) {
		// guarda la fecha de actualizacion
		Date fechaActual = new Date();
		categoria.setFactualizar(new java.sql.Date(fechaActual.getTime()));

		
		cDao.editar(categoria);
		return "/faces/index.xhtml";
	}

	// eliminar un Categoria
	public String eliminar(Long id) {
		
		cDao.eliminar(id);
		System.out.println("Categoria eliminado..");
		return "/faces/index.xhtml";
	}
}
