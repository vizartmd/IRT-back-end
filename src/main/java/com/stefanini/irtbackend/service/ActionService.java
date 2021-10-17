package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.entity.Action;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;

import java.util.List;

public interface ActionService {

    Action create(Action action);

    Action update(Action action);

    void delete(Action action);

    Action findById(Long id);

    void deleteById(Long id);

    List<Action> findAll();

    List<Action> findAllActionsByTicketId(Long ticket_id);

    Action changePriority(Long action_id, PriorityName priority);
}
