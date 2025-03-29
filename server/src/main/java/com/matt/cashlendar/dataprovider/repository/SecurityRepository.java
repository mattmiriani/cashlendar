package com.matt.cashlendar.dataprovider.repository;

import com.matt.cashlendar.dataprovider.entity.ClientTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SecurityRepository extends JpaRepository <ClientTable, UUID> {

    ClientTable findByEmail(@Param("email") String email);
}
