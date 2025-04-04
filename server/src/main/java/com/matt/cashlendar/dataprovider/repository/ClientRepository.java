package com.matt.cashlendar.dataprovider.repository;

import com.matt.cashlendar.dataprovider.entity.ClientTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientTable, UUID> {
}
