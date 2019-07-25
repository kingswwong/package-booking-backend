package com.oocl.packagebooking.service;

import com.oocl.packagebooking.base.BaseServiceImpl;
import com.oocl.packagebooking.entity.PackageBase;
import com.oocl.packagebooking.repository.PackageBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PackageBaseServiceImpl extends BaseServiceImpl<PackageBase,Long> implements PackageBaseService {

    @Autowired
    private PackageBaseRepository packageBaseRepository;

    public PackageBaseServiceImpl(@Autowired PackageBaseRepository packageBaseRepository) {
        super(packageBaseRepository);
    }

    @Override
    public List<PackageBase> findAllByStatus(int status) {
        return packageBaseRepository.findAllByStatus(status);
    }

    @Override
    public PackageBase findAllByTrackingNumberAndUpdateStatus(PackageBase packageBase) {
        List<PackageBase> packageBases = packageBaseRepository.findAllByTrackingNumberAndUpdateStatus(packageBase.getTrackingNumber());
        if(packageBases.size() > 0){
            PackageBase oldPackageBase = packageBases.get(0);
            oldPackageBase.setAppointmentTime(packageBase.getAppointmentTime());
            oldPackageBase.setStatus(packageBase.getStatus());
            packageBaseRepository.save(oldPackageBase);
            return oldPackageBase;
        }
        return null;
    }
}
