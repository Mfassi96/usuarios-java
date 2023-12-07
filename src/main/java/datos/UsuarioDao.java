package datos;

//CLASE ENCARGADA DE IMPLEMENTAR LA CONEXION Y CREAR METODOS CRUD

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    
    private static String SQL_SELECT="SELECT * FROM usuarios";
    private static String SQL_UPDATE="UPDATE usuarios SET usuario=?,password=? WHERE ID=?";
    private static String SQL_INSERT="INSERT INTO usuarios (usuario, password) VALUES(?,?)";
    private static String SQL_DELETE="DELETE FROM usuarios WHERE ID=?";
    
    public  List<Usuario>seleccionar(){
     Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery(); //devueve todo el set de resultado de la consulta

            while (rs.next()) {

                int idUsuario = rs.getInt("ID");
                String nombreUsuario = rs.getString("usuario");
                String password = rs.getString("password");
                

                //se crea el objeto usuario
                usuario = new Usuario(idUsuario, nombreUsuario, password);

                // y se agrega a la lista
                usuarios.add(usuario);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return usuarios;
        
        
    }
    
    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros=0;
        
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(SQL_INSERT);
            
            //pasar valores a la consukta
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            registros=stmt.executeUpdate(); //este metodo puede ejecutar sentencias tipo insert, update o delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        
    }
        return registros;

    }
    
    // metodo update
    
        public int actualizar (Usuario ousuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            //pasar valores a la consukta
            // cada numero hace referencia a la posicion del valor a setear en la consulta
            stmt.setString(1, ousuario.getUsuario());
            stmt.setString(2, ousuario.getPassword());
             stmt.setInt(3, ousuario.getIdUsuario()); 
            registros = stmt.executeUpdate(); //este metodo puede ejecutar sentencias tipo insert, update o delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;

    }
        
        public int eliminar (Usuario ousuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            //pasar valores a la consukta
            stmt.setInt(1, ousuario.getIdUsuario());
            registros = stmt.executeUpdate(); //este metodo puede ejecutar sentencias tipo insert, update o delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;

    }
    
    
}
