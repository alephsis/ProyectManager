/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.hibernate.Transaction;

/**
 *
 * @author daniel
 */
public class UserModel implements UserDetailsService {
    /*Sesión inyectada por Spring de acuerdo a la configuración
    * de applicationContext.xml
    */
    private SessionFactory sessionFactory;
    
    /**
     * Inicializamos la sesión de la base de datos
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    public Usuario crearUsuario(Usuario usuario){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            sesion.save(usuario);
            sesion.getTransaction().commit();
            sesion.refresh(usuario);
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }finally{
            sesion.close();
        }
        return usuario;
    }
    
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> lst = new ArrayList<>();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        try {
            sesion.beginTransaction();
            lst = sesion.createCriteria(Usuario.class).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }finally{
            sesion.close();
        }
        
        return lst;
    }
    
    public Usuario actualizarUsuario(Usuario usuario){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            sesion.update(usuario);
            sesion.getTransaction().commit();
            sesion.refresh(usuario);
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }finally{
            sesion.close();
        }
        return usuario;
    }
    
    public Usuario buscarUsuarioID(int id){
        Usuario usuario;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        try {
            sesion.beginTransaction();
            Query query = sesion.createQuery("FROM Usuario U WHERE U.id = :id");
            query.setParameter("id", id);
            usuario = (Usuario) query.list().get(0);
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }
        return usuario;
    }
    
    public Usuario eliminarUsuario(Usuario usuario){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            sesion.delete(usuario);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }finally{
            sesion.close();
        }
        return usuario;
    }
    
    public Usuario getUsuarioByName(String nombre){
        Usuario usuario = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try{
            t = sesion.beginTransaction();
            String hql = "from Usuario where nombre = :c";
            Query consulta = sesion.createQuery(hql);
            consulta.setParameter("c", nombre);
            usuario = (Usuario) consulta.uniqueResult();
            t.commit();
        }
        catch (Exception e){
            if (t != null) t.rollback();
            e.printStackTrace();
        }
        finally{
            sesion.close();
        }
    return usuario;
        
    }
    
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException{
        Usuario usuario = this.getUsuarioByName(username);
        if(usuario != null){
            List<GrantedAuthority> autorizaciones = 
                    new ArrayList<>();
            autorizaciones.add(new SimpleGrantedAuthority("ROLE_" + 
                    usuario.getRol().toUpperCase()));
            return new User(usuario.getNombre(), 
                            usuario.getContrasena(),
                            autorizaciones);
          
        }
        else{
            throw new UsernameNotFoundException("Usuario " + username + 
                       " no encontrado.");
        }
    }
}
