package test;

import datos.UsuarioDao;
import domain.Usuario;
import java.util.List;

public class testUsuarios {
    public static void main(String[] args) {
        UsuarioDao ousuarioDao=new UsuarioDao();
        
        Usuario usuarionuevo=new Usuario("minuevousuario2","minuevousuario2");
        
        ousuarioDao.insertar(usuarionuevo);
        
                List <Usuario> usuarios=ousuarioDao.seleccionar();
        
        for(Usuario usuario:usuarios){
            System.out.println("persona = " + usuario);
        }
    }
}
