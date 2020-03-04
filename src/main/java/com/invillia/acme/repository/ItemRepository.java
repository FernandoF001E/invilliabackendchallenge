package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
