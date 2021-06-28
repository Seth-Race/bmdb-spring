package com.bmdb.db;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Credit;

public interface CreditRepo extends CrudRepository<Credit, Integer> {

}
