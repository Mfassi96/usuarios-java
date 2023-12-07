package test;

import datos.UsuarioDao;
import domain.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

public class testUsuarios {
    
    public static void imprimir(UsuarioDao ousuarioDao){
                        List <Usuario> usuarios=ousuarioDao.seleccionar();
        
        for(Usuario usuario:usuarios){
            System.out.println("usuario = " + usuario);
        }
    }
    
    
    public static void main(String[] args) {
        UsuarioDao ousuarioDao=new UsuarioDao(); //objeto usado para manipular los metodos de la clase DAO
        
//            insertar usuario
//        Usuario usuarionuevo=new Usuario(JOptionPane.showInputDialog("Ingresa el nombre del usuario"),JOptionPane.showInputDialog("Ingresa la contraseña"));
//        
//        ousuarioDao.insertar(usuarionuevo);
//        

// Actualizar usuario
Usuario usuarioactualizar=new Usuario(28, "usuario123", "usuario-123");
ousuarioDao.actualizar(usuarioactualizar);


        imprimir(ousuarioDao);

    }
}
