/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author tamyres.carla.santos
 */
public class LoginController {
    
    public final Login view;
    private LoginHelper helper;
    
    public LoginController(Login view){
        this.view = view;
         this.helper = new LoginHelper(view);
}

public void entrarNoSistema(){
//Pegar um  Usuario da View
        Usuario usuario = helper.obterModelo();
  //Pesquisa Usuario no Banco
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
       
       ////Se o usuario da view tiver mesmo usuario e senha que o usuario vindo do banco direcionar para menu principal
       //Senão mostrar uma mensagem ao usuario "Usuario ou senha invalidos"
       if(usuarioAutenticado != null){
           MenuPrincipal menu = new MenuPrincipal();
           menu.setVisible(true);
           this.view.dispose();
       }else{
           view.exibeMensagem("Usuario ou senha invalidos");
       }
}
    
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
}