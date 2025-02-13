package com.financial.incomingsource.repository;

import com.financial.incomingsource.model.IncomingSourceEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingSourceRepository extends CrudRepository<IncomingSourceEntity, Integer>,
        JpaSpecificationExecutor<IncomingSourceEntity> {

}
