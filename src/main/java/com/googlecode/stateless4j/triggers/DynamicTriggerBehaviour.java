package com.googlecode.stateless4j.triggers;

import com.googlecode.stateless4j.delegates.Func;
import com.googlecode.stateless4j.delegates.Func2;
import com.googlecode.stateless4j.validation.Enforce;

public class DynamicTriggerBehaviour<TState, TTrigger> extends TriggerBehaviour<TState, TTrigger> {
    private Func2<Object[], TState> destination;

    public DynamicTriggerBehaviour(TTrigger trigger, Func2<Object[], TState> destination, Func<Boolean> guard) throws Exception {
        super(trigger, guard);
        this.destination = Enforce.argumentNotNull(destination, "destination");
    }

    public TState resultsInTransitionFrom(TState source, Object... args) throws Exception {
        return destination.call(args);
    }
}
