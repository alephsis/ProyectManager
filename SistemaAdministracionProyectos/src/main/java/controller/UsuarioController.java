/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Proyecto;
import entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author daniel
 */
@Controller
public class UsuarioController{
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String mostrarPantallaInicioSesion(){
       return "PantallaInicioSesion";
    }
    
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String mostrarPantallaPrincipal(){
        return "home";
    }
    

    @RequestMapping(value="/home/salir", method = RequestMethod.GET)
    public String salir (HttpServletRequest request, 
            HttpServletResponse response, RedirectAttributes model){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            model.addFlashAttribute("exito", "Ha salido de su perfil exitosamente");
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    return "redirect:/?salir";
    }
    
    @RequestMapping(value="/home/agregarUsuario", method = RequestMethod.GET)
    public String PantallaAgregarUsuario(){
        return "agregarUsuario";
    }
    
    @RequestMapping(value = "home/agregarUsuario", method = RequestMethod.POST)
    public String crearUsuario(HttpServletRequest request, Model m){
        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("password");
        String rol = request.getParameter("rol");

        UserModel usuarioDB = new UserModel();
        
        Usuario nuevoUsuario; 
        nuevoUsuario = usuarioDB.getUsuarioByName(nombre);
        
        if(nuevoUsuario == null){
            nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setContrasena(contrasena);
            nuevoUsuario.setRol(rol);
            usuarioDB.crearUsuario(nuevoUsuario);
        }
        m.addAttribute("u", nuevoUsuario);
        return "home";
    }
    
    @RequestMapping(value="home/verUsuarios", method = RequestMethod.GET)
    public ModelAndView PantallaVerProyect(HttpServletRequest request,ModelMap model){
        UserModel usuarioDB = new UserModel();
        List<Usuario> pl = usuarioDB.obtenerUsuarios();
          
        model.addAttribute("usuarios", pl);
        
        return new ModelAndView("verUsuario",model);   
    }
    
    @RequestMapping(value="home/buscaUsuario", method = RequestMethod.GET)
    public ModelAndView PantallaBuscProyect(HttpServletRequest request,ModelMap model){
        String nombre = request.getParameter("buscname");      
        System.err.println("==============nombre: " + nombre + " :nombre===============");
        UserModel usuarioDB = new UserModel();
        Usuario u = usuarioDB.buscarUsuarioID(Integer.parseInt(nombre));  
        model.addAttribute("u", u);
        return new ModelAndView("buscaUsuario", model);   
    }
 }
