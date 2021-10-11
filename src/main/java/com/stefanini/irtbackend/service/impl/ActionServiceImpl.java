package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.ActionDao;
import com.stefanini.irtbackend.entity.Action;
//import com.stefanini.irtbackend.entity.Priority;
import com.stefanini.irtbackend.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionDao actionDao;

    @Override
    public boolean create(Action action) {
        return actionDao.create(action);
    }

    @Override
    public Action update(Action action) {
        return actionDao.update(action);
    }

    @Override
    public void delete(Action action) {
        actionDao.delete(action);
    }

    @Override
    public Action findById(Long id) {
        return actionDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        Action byId = actionDao.findById(id);
        actionDao.delete(byId);
    }

    @Override
    public List<Action> findAll() {
        return actionDao.findAll();
    }

    @Transactional
    @Override
    public List<Action> findAllActionsByTicketId(Long ticket_id) {
        return actionDao.findAllActionsByTicketId(ticket_id);
    }

//    @Override
//    public Action changePriority(Long action_id, Priority priority) {
//        Action actionToChange = actionDao.findById(action_id);
//        actionToChange.setPriority(priority);
//        return actionDao.update(actionToChange);
//    }


}