package controlador;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class Producto implements Serializable{

     private static final long serialVersionUID = 1L;
    
    public int getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(int pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public int getPro_precio() {
        return pro_precio;
    }

    public void setPro_precio(int pro_precio) {
        this.pro_precio = pro_precio;
    }

    public int getPro_stok() {
        return pro_stok;
    }

    public void setPro_stok(int pro_stok) {
        this.pro_stok = pro_stok;
    }

    public int getAlm_codigo() {
        return alm_codigo;
    }

    public void setAlm_codigo(int alm_codigo) {
        this.alm_codigo = alm_codigo;
    }

    public int getSum_codigo() {
        return sum_codigo;
    }

    public void setSum_codigo(int sum_codigo) {
        this.sum_codigo = sum_codigo;
    }

    public String getAlm_distrito() {
        return alm_distrito;
    }

    public void setAlm_distrito(String alm_distrito) {
        this.alm_distrito = alm_distrito;
    }

    public String getAlm_responsable() {
        return alm_responsable;
    }

    public void setAlm_responsable(String alm_responsable) {
        this.alm_responsable = alm_responsable;
    }

    public String getSum_empresa() {
        return sum_empresa;
    }

    public void setSum_empresa(String sum_empresa) {
        this.sum_empresa = sum_empresa;
    }

    public int getSum_ruc() {
        return sum_ruc;
    }

    public void setSum_ruc(int sum_ruc) {
        this.sum_ruc = sum_ruc;
    }

   
	 int pro_codigo;
	 String pro_nombre;
         int pro_precio;
         int pro_stok;
         int alm_codigo;
         int sum_codigo;
         String alm_distrito;
         String alm_responsable;
         String sum_empresa;
         int sum_ruc;
    
       public String registrar(){
        String render;
		PreparedStatement pst;
		Connection conn = getConnection();
            try{
                String st="insert into productos values(?,?,?,?,?,?)";
            pst = conn.prepareStatement(st);
            pst.setInt(1,pro_codigo);
            pst.setString(2,pro_nombre);
            pst.setInt(3,pro_precio);
            pst.setInt(4,pro_stok);
            pst.setInt(5, alm_codigo);
            pst.setInt(6,sum_codigo);
            pst.executeUpdate();
            render="home";
              
      }catch(Exception e){
            FacesMessage msg=new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "ERROR EN EL PROCESO",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,msg);
                render="home";  
      }
            return render;
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
