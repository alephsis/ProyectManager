/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Proyecto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Clase que modela la interacción con la base de datps de los proyectos
 * @author Alephsis
 */
public class ProjectModel {
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
    
    /**
     * Agrega un proyecto a la base
     * @param proyecto el proyecto a agregar
     * @return proyecto el proyecto agregado
     */
    
    public Proyecto crearProyecto(Proyecto proyecto){
        Session sesion = sessionFactory.openSession();
        try {
            sesion.beginTransaction();
            sesion.save(proyecto);
            sesion.getTransaction().commit();
            sesion.refresh(proyecto);
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }finally{
            sesion.close();
        }
        return proyecto;
    }
    
    /**
     * Devuelve todos los proyectos de la base de datos
     * @return lst una lista con los proyectos
     */
    
    public List<Proyecto> obtenerProyectos(){
       List<Proyecto> result= null;
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        try{
        tx=session.beginTransaction();
        String hql= "FROM Proyecto";
        Query query =session.createQuery(hql);
        result=(List<Proyecto>)query.list();
        tx.commit();
        }catch (Exception e){
                if(tx != null){
                tx.rollback();
                }
                e.printStackTrace();
                
                }finally{
                        session.close();
                        }
                return result;
    }
    
    /**
     * Método para actualizar un proyecto
     * @param proyecto el proyecto a actualizar
     * @return proyecto el proyecto actualizado
     */
    
    public Proyecto actualizarProyecto(Proyecto proyecto){
        Session sesion = sessionFactory.openSession();
        try {
            sesion.beginTransaction();
            sesion.update(proyecto);
            sesion.getTransaction().commit();
            sesion.refresh(proyecto);
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }finally{
            sesion.close();
        }
        return proyecto;
    }
    
    /**
     * Busca un proyecto con el id deseado
     * @param id el id del proytecto a buscar
     * @return el proyecto con el id deseado
     */
    
    public Proyecto buscarProyectoID(int id){
        Proyecto proyecto;
        Session sesion = sessionFactory.openSession();
        
        try {
            sesion.beginTransaction();
            Query query = sesion.createQuery("FROM Proyecto U WHERE U.id = :id");
            query.setParameter("id", id);
            proyecto = (Proyecto) query.list().get(0);
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }
        return proyecto;
    }
    
    /**
     * Elimina un proyecto de la base de datos
     * @param proyecto
     * @return el proyecto eliminado
     */
    
    public Proyecto eliminarProyecto(Proyecto proyecto){
        Session sesion = sessionFactory.openSession();
        try {
            sesion.beginTransaction();
            sesion.delete(proyecto);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
            return null;
        }finally{
            sesion.close();
        }
        return proyecto;
    }
    
    /**
     * Da un proyecto que responde a un nombre dado
     * @param nombre el nombre del proyecto
     * @return el proyecto buscado
     */
    
    public Proyecto getProyectoByName(String nombre){
        Proyecto proyecto = null;
        Session sesion = sessionFactory.openSession();
        Transaction t = null;
        try{
            t = sesion.beginTransaction();
            String hql = "from Proyecto where nombre = :c";
            Query consulta = sesion.createQuery(hql);
            consulta.setParameter("c", nombre);
            proyecto = (Proyecto) consulta.uniqueResult();
            t.commit();
        }
        catch (Exception e){
            if (t != null) t.rollback();
            e.printStackTrace();
        }
        finally{
            sesion.close();
        }
    return proyecto;
        
    }
    
   
}
