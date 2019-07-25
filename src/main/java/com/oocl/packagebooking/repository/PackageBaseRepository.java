package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.base.BaseRepository;
import com.oocl.packagebooking.entity.PackageBase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageBaseRepository extends BaseRepository<PackageBase,Long> {
    List<PackageBase> findAllByStatus(int status);
    List<PackageBase> findAllByTrackingNumber(String trackingNumber);
}
