package com.grinyov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.hateoas.Identifiable;
import javax.persistence.*;
import javax.script.CompiledScript;

/**
 * Created by vgrinyov.
 */
@Entity
@Data
public class Script implements Identifiable<Long> {

    @Id
    @GeneratedValue
    private Long id;

//    @Version
//    private Integer version;

    @Column(nullable = false)
    private String script;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    public enum Status {

        NEW,

        RUNNING,

        DONE,

        FAILED
    }

    //@Column(nullable = false)
    private String result;

    @Transient
    @JsonIgnore
    private CompiledScript compiledScript;
}
