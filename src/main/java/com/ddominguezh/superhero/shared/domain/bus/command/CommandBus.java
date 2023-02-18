package com.ddominguezh.superhero.shared.domain.bus.command;

public interface CommandBus {
	void dispatch(Command command) throws CommandHandlerExecutionError;
}
