package com.flikendo.datastorage.Repositories;

import com.flikendo.datastorage.Components.FuelStation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Date: 04-23-2023
 * Author: Flikendo
 *
 * MongoRepository class. This class connect with MongoDB and make CRUD operations
 */

public interface MongoRepository extends MongoRepository<FuelStation, String> {
    public FuelStation findByBusinessName(String businessName);
    public List<FuelStation> findByLocation(String location);
}
