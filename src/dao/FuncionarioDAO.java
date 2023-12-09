/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.FuncionarioDbc;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author duals
 */
public class FuncionarioDAO extends DAO_Abstract{
    
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
        Criteria criteria = session.createCriteria(FuncionarioDbc.class);
        criteria.add(Restrictions.eq("idusuarios_dbc", id));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
        
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioDbc.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
        
    }
    public List listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioDbc.class);
        criteria.add(Restrictions.like("nomeDbc", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listSalario(double salario) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioDbc.class);
        criteria.add(Restrictions.eq("salarioDbc", salario));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
}
    public List listNomeSalario(String nome, double salario) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FuncionarioDbc.class);
        criteria.add(Restrictions.like("nomeDbc", "%" + nome + "%"));
        criteria.add(Restrictions.eq("salarioDbc", salario));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
}

    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List lista = funcionarioDAO.listNome("nome que você está procurando");
        for (Object funcionarioDbc : lista) {
            System.out.println("nome:" + ((FuncionarioDbc)funcionarioDbc).getNomeDbc());
        }
    }
}
