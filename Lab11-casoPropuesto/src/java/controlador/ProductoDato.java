package controlador;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "proDa", eager = true)
@SessionScoped
public class ProductoDato implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Producto> getEmployees() {
		ResultSet rs;
		PreparedStatement pst;
		Connection con = getConnection();
String stm="select p.pro_codigo,p.pro_nombre,p.pro_precio,p.pro_stok,a.alm_codigo,a.alm_distrito,a.alm_responsable,s.sum_codigo,s.sum_empresa,s.sum_ruc "
        + "from productos p,almacen a,suministro s "
        + "where a.alm_codigo=p.alm_codigo and s.sum_codigo=p.sum_codigo";
		List<Producto> records = new ArrayList<Producto>();
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				Producto emp = new Producto();
				emp.setPro_codigo(rs.getInt(1));
				emp.setPro_nombre(rs.getString(2));
                                emp.setPro_precio(rs.getInt(3));
                                emp.setPro_stok(rs.getInt(4));
                                emp.setAlm_codigo(rs.getInt(5));
                                emp.setAlm_distrito(rs.getString(6));
                                emp.setAlm_responsable(rs.getString(7));
                                emp.setSum_codigo(rs.getInt(8));
                                emp.setSum_empresa(rs.getString(9));
                               emp.setSum_ruc(rs.getInt(10)); 
				records.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return records;
	}
        
         public String listar(){
           return "lista";
        }
   
public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "jaz";
		String password = "josue";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
		}
		return con;
	 }
         
}
