package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.entity.Action;
//import com.stefanini.irtbackend.entity.Priority;

import java.util.List;

public interface ActionService {

    boolean create(Action action);

    Action update(Action action);

    void delete(Action action);

    Action findById(Long id);

    void deleteById(Long id);

    List<Action> findAll();

    List<Action> findAllActionsByTicketId(Long ticket_id);

//    Action changePriority(Long action_id, Priority priority);

}
