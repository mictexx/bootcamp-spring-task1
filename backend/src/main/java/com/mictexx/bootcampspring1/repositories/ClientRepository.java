package com.mictexx.bootcampspring1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mictexx.bootcampspring1.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
