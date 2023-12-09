/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.ClienteDbc;
import bean.UsuariosDbc;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author marcelbenitezdasilva
 */
public class UsuariosDAO extends DAO_Abstract {

    @Override
    public void insert(Object objeto) {
      session.beginTransaction();
      session.save(objeto);
      session.getTransaction().commit();
}

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
       session.beginTransaction();
       session.flush();
       session.clear();
       session.delete(object);
       session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosDbc.class);
        criteria.add(Restrictions.eq("idusuarios_dbc", id));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
        
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosDbc.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
        
    }
    public List listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosDbc.class);
        criteria.add(Restrictions.like("nomeDbc", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listCpf(String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosDbc.class);
        criteria.add(Restrictions.like("cpfDbc", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listNomeCpf(String nome, String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosDbc.class);
        criteria.add(Restrictions.like("nomeDbc", "%" + nome + "%"));
        criteria.add(Restrictions.like("cpfDbc", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List lista = usuariosDAO.listNome("nome que você está procurando");
        for (Object usuariosDbc : lista) {
            System.out.println("nome:" + ((UsuariosDbc)usuariosDbc).getNomeDbc());
        }
    }
    public UsuariosDbc login(String usuario, String senha) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(UsuariosDbc.class);
    criteria.add(Restrictions.eq("nomeDbc", usuario));
    criteria.add(Restrictions.eq("senhaDbc", senha));
    UsuariosDbc usuarioAutenticado = (UsuariosDbc) criteria.uniqueResult();
    session.getTransaction().commit();
    return usuarioAutenticado;
    }
}