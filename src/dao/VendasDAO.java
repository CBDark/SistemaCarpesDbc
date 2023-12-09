/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.ClienteDbc;
import bean.VendasDbc;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author marcelbenitezdasilva
 */
public class VendasDAO extends DAO_Abstract {

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
        Criteria criteria = session.createCriteria(VendasDbc.class);
        criteria.add(Restrictions.eq("idvendas_dbc", id));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
        
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VendasDbc.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
        
    }
    public List listNome(String nome) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VendasDbc.class);
    criteria.createAlias("clienteDbc", "cliente"); // Alias para a associação entre VendasDbc e ClienteDbc
    criteria.add(Restrictions.like("cliente.nomeDbc", "%" + nome + "%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}

public List listValor(double valor) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VendasDbc.class);
    criteria.add(Restrictions.eq("valorTotalDbc", valor));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}

public List listNomeValor(String nome, double valor) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VendasDbc.class);
    criteria.createAlias("clienteDbc", "cliente"); // Alias para a associação entre VendasDbc e ClienteDbc
    criteria.add(Restrictions.like("cliente.nomeDbc", "%" + nome + "%"));
    criteria.add(Restrictions.eq("valorTotalDbc", valor));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}
}