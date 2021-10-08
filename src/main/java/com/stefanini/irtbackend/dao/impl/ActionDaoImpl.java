package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.ActionDao;
import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.Action;
import com.stefanini.irtbackend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ActionDaoImpl extends GenericDaoImpl<Action> implements ActionDao {

    ActionDaoImpl() {
        super(Action.class);
    }

    @Override
    public List<Action> findAllActionsByTicketId(Long ticket_id) {

        Query query  = entityManager.createQuery("select a from Action a where a.ticket.id = :ticket_id")
                .setParameter("ticket_id", ticket_id);
        return query.getResultList();

    }
}
