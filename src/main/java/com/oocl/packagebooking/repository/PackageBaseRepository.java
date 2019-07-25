package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.base.BaseRepository;
import com.oocl.packagebooking.entity.PackageBase;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageBaseRepository extends BaseRepository<PackageBase,Long> {
}
