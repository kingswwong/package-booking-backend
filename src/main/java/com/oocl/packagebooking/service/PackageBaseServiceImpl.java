package com.oocl.packagebooking.service;

import com.oocl.packagebooking.base.BaseServiceImpl;
import com.oocl.packagebooking.entity.PackageBase;
import com.oocl.packagebooking.repository.PackageBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageBaseServiceImpl extends BaseServiceImpl<PackageBase,Long> implements PackageBaseService {

    public PackageBaseServiceImpl(@Autowired PackageBaseRepository packageBaseRepository) {
        super(packageBaseRepository);
    }
}
