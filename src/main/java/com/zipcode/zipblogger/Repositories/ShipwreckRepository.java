package com.zipcode.zipblogger.Repositories;

import com.zipcode.zipblogger.Models.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

//Include shipwreck entity and primary key type: long within jpa repository args.
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {


}
