package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.base.BaseController;
import com.oocl.packagebooking.entity.PackageBase;
import com.oocl.packagebooking.service.PackageBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/packages")
public class PackageController extends BaseController<PackageBase, Long> {
    public PackageController(@Autowired PackageBaseService packageBaseService) {
        super(packageBaseService);
    }

}
