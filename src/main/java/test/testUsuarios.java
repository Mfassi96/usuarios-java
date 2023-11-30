package test;

import datos.UsuarioDao;
import domain.Usuario;
import java.util.List;

public class testUsuarios {
    public static void main(String[] args) {
        UsuarioDao usuarioDao=new UsuarioDao();
                List <Usuario> usuarios=usuarioDao.seleccionar();
        
        for(Usuario usuario:usuarios){
            System.out.println("persona = " + usuario);
        }
    }
}
