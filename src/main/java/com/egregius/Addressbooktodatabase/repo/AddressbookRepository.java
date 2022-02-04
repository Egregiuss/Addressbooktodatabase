package com.egregius.Addressbooktodatabase.repo;

import com.egregius.Addressbooktodatabase.model.Addressbook;
import org.springframework.data.repository.CrudRepository;


public interface AddressbookRepository extends CrudRepository<Addressbook, Long> {

}
