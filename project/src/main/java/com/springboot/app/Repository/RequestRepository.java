package com.springboot.app.Repository;

import com.springboot.app.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query("SELECT u FROM Request u WHERE u.id = :id")
    public  Request getRequestById(@Param("id") String id);

}
