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
//    private static String SQL_UPDATE="";
//    private static String SQL_INSERT="INSERT INTO usuarios usuario, password VALUES(usuario=?,password=?)";
//    private static String SQL_DELETE="";
    
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
    
    
    
}
