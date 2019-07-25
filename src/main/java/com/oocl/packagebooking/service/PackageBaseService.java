package com.oocl.packagebooking.service;

import com.oocl.packagebooking.base.BaseService;
import com.oocl.packagebooking.entity.PackageBase;

import java.util.Date;
import java.util.List;

public interface PackageBaseService extends BaseService<PackageBase,Long> {
    List<PackageBase> findAllByStatus(int status);
    PackageBase findAllByTrackingNumberAndUpdateStatus(PackageBase packageBase);
}
