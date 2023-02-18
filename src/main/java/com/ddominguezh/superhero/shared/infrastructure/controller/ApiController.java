package com.ddominguezh.superhero.shared.infrastructure.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

import com.ddominguezh.superhero.shared.domain.DomainError;
import com.ddominguezh.superhero.shared.domain.bus.command.Command;
import com.ddominguezh.superhero.shared.domain.bus.command.CommandBus;
import com.ddominguezh.superhero.shared.domain.bus.command.CommandHandlerExecutionError;
import com.ddominguezh.superhero.shared.domain.bus.query.Query;
import com.ddominguezh.superhero.shared.domain.bus.query.QueryBus;
import com.ddominguezh.superhero.shared.domain.bus.query.QueryHandlerExecutionError;

public abstract class ApiController {
    private final QueryBus   queryBus;
    private final CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

	protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

    abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();
}
