package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.domain.entity.Action;

import java.util.List;


public interface ActionDao extends GenericDao<Action> {

    List<Action> findAllActionsByTicketId(Long ticket_id);

}
