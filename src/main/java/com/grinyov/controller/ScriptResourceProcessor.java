package com.grinyov.controller;

import com.grinyov.model.Script;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author vgrinyov
 */
@Component
public class ScriptResourceProcessor implements ResourceProcessor<Resource<Script>> {

    @Override
    public Resource<Script> process(Resource<Script> resource) {
        final Script script = resource.getContent();

        resource.add(linkTo(methodOn(ScriptResourceController.class).
                perform(script.getId(), null)).withRel("run"));
        resource.add(linkTo(methodOn(ScriptResourceController.class).
                viewOne(script.getId(), null)).withRel("status"));
        resource.add(linkTo(methodOn(ScriptResourceController.class).
                terminateOne(script.getId(), null)).withRel("terminate"));
        return resource;
    }
}