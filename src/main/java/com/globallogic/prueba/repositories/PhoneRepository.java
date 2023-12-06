package com.globallogic.prueba.repositories;

import org.springframework.data.repository.CrudRepository;

import com.globallogic.prueba.model.Phone;
import org.springframework.stereotype.Repository;

@Repository
public  interface PhoneRepository extends CrudRepository<Phone, Long> {

}
