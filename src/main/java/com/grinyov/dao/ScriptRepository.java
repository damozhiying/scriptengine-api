package com.grinyov.dao;

import com.grinyov.model.Script;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Repository for script
 * <p>
 * This repository add CRUD operations for model
 * and search, sorting and pagination for them
 * in declarative style, for detail see spring data
 *
 * @author vgrinyov
 */
public interface ScriptRepository extends PagingAndSortingRepository<Script, Long> {

    /**
     * Query return all scripts from database
     * which status RUNNING
     *
     * @return scripts
     */

    @Query("select script from Script script where script.status = 'RUNNING'")
    @RestResource(path = "running")
    Page<Script> findRunning(Pageable pageable);
}