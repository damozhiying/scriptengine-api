package com.grinyov.event;

import org.springframework.context.ApplicationEvent;

/**
 * Event notifying that the script is running
 *
 * @author vgrinyov
 */
public class ScriptLaunched extends ApplicationEvent {

    Long id;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ScriptLaunched(Object source, Long id) {
        super(source);
        this.id = id;
    }

    public Long getEventData(){
        return id;
    }
}
