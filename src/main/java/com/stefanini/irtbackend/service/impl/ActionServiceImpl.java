package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.ActionDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.entity.Action;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;
import com.stefanini.irtbackend.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
class ActionServiceImpl implements ActionService {

    @Autowired
    ActionDao actionDao;

    @Transactional
    @Override
    public Action create(Action action) {
        return actionDao.create(action);
    }

    @Transactional
    @Override
    public Action update(Action action) {
        return actionDao.update(action);
    }

    @Transactional
    @Override
    public void delete(Action action) {
        actionDao.delete(action);
    }

    @Override
    public Action findById(Long id) {
        return actionDao.findById(id).orElseThrow(() -> new NotFoundException("Not found action with id = " + id));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Action byId = actionDao.findById(id).orElseThrow(() -> new NotFoundException("Not found action with id = " + id));
        actionDao.delete(byId);
    }

    @Override
    public List<Action> findAll() {
        return actionDao.findAll();
    }


    @Override
    public List<Action> findAllActionsByTicketId(Long id) {
        return actionDao.findAllActionsByTicketId(id);
    }

    @Transactional
    @Override
    public Action changePriority(Long id, PriorityName priority) {
        Action actionToChange = actionDao.findById(id).orElseThrow(() -> new NotFoundException("Not found action with id = " + id));
        actionToChange.setPriority(priority);
        return actionDao.update(actionToChange);
    }


}
