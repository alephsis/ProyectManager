/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import entity.Proyecto;
import java.util.List;
import model.ProjectModel;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author ahernandez
 */

@Controller
public class ProyectoController{
    
    @Autowired
    ProjectModel project_db;
    
    @RequestMapping(value="home/agregarProyecto", method = RequestMethod.GET)
    public String agregaProyectoVista(HttpServletRequest request){
        return "agregarProyecto";
    }
    
    @RequestMapping(value="home/agregarProyectoBoton", method = RequestMethod.GET)
    public String agregaProyecto(HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        String cliente = request.getParameter("cliente");
        String desc = request.getParameter("descripcion");
        
        Proyecto p = new Proyecto(nombre,cliente,desc);
        project_db.crearProyecto(p);
        return "home";
    }
    
    @RequestMapping(value="home/verProyecto", method = RequestMethod.GET)
    public ModelAndView PantallaVerProyect(HttpServletRequest request,ModelMap model){
        List<Proyecto> pl = project_db.obtenerProyectos();
          
        model.addAttribute("proyectos", pl);
        
        return new ModelAndView("verProyecto",model);   
    }
    
    @RequestMapping(value="home/buscProyecto", method = RequestMethod.GET)
    public ModelAndView PantallaBuscProyect(HttpServletRequest request,ModelMap model){
        String nombre = request.getParameter("buscname");                    
        Proyecto p = project_db.buscarProyectoID(Integer.parseInt(nombre));  
        model.addAttribute("p", p);
        return new ModelAndView("buscProyecto",model);   
    }
    
 }
