package com.grinyov.util;

import com.grinyov.model.Script;
import com.grinyov.service.ScriptProccessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * Created by vgrinyov
 */
@Component
@RepositoryEventHandler
public class ScriptEventHandler {

    @Autowired
    private ScriptProccessingService scriptProccessingService;

    @HandleAfterCreate
    public void scriptRunning(Script script){
        scriptProccessingService.perform(script.getId());
    }
}