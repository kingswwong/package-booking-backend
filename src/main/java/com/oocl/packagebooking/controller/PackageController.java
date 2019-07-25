package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.base.BaseController;
import com.oocl.packagebooking.entity.PackageBase;
import com.oocl.packagebooking.service.PackageBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/packages")
public class PackageController extends BaseController<PackageBase, Long> {

    @Autowired
    private PackageBaseService packageBaseService;

    public PackageController(@Autowired PackageBaseService packageBaseService) {
        super(packageBaseService);
    }

    @GetMapping(params = "status")
    public List<PackageBase> findPackageBaseByStatus(@RequestParam(name = "status")int status){
        return packageBaseService.findAllByStatus(status);
    }

    @PutMapping
    public PackageBase findByAppointmentAndUpdate(@RequestBody PackageBase packageBase){
        return packageBaseService.findAllByTrackingNumberAndUpdateStatus(packageBase);
    }
}
