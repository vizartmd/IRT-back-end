package com.stefanini.irtbackend.controller;

import com.stefanini.irtbackend.entity.Action;
import com.stefanini.irtbackend.entity.Priority;
import com.stefanini.irtbackend.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/action")
public class ActionController {

    private ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    ResponseEntity<List<Action>> findAll() {
        return ResponseEntity.ok(actionService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Action> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(actionService.findById(id));
    }

    @PostMapping
    ResponseEntity<Action> create(@RequestBody Action action) {
        Action createdAction = actionService.create(action);
        return ResponseEntity.created(URI.create("/action/" + createdAction.getId())).body(createdAction);
    }

    @PutMapping
    ResponseEntity<Action> update(@RequestBody Action action) {
        return ResponseEntity.ok(actionService.update(action));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        actionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{ticket_id}")
    ResponseEntity<List<Action>> findAllActionsByTicketId(@PathVariable("ticket_id") Long ticket_id) {
        return ResponseEntity.ok(actionService.findAllActionsByTicketId(ticket_id));
    }

    @PostMapping("/{change_priority")
    ResponseEntity<Action> changePriority(@RequestBody Long action_id, Priority priority) {
        return ResponseEntity.ok(actionService.changePriority(action_id, priority));
    }


}
