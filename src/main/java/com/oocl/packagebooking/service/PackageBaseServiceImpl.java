package com.oocl.packagebooking.service;

import com.oocl.packagebooking.base.BaseServiceImpl;
import com.oocl.packagebooking.entity.PackageBase;
import com.oocl.packagebooking.exception.PackageNotFoundException;
import com.oocl.packagebooking.repository.PackageBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    public PackageBase findAllByTrackingNumberAndUpdateStatus(PackageBase packageBase) throws Exception {
        List<PackageBase> packageBases = packageBaseRepository.findAllByTrackingNumber(packageBase.getTrackingNumber());
        if(packageBase.getAppointmentTime() != null){
            Date date = packageBase.getAppointmentTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String hour = simpleDateFormat.format(date).split(" ")[1].split(":")[0];
            if(!(Integer.parseInt(hour) >= 9 && Integer.parseInt(hour) <= 18)) {
                return null;
            }
        }
        if(packageBases.size() > 0){
            PackageBase oldPackageBase = packageBases.get(0);
            if(oldPackageBase.getStatus() == 2){
                throw new PackageNotFoundException();
            }
            oldPackageBase.setAppointmentTime(packageBase.getAppointmentTime());
            oldPackageBase.setStatus(packageBase.getStatus());
            packageBaseRepository.save(oldPackageBase);
            return oldPackageBase;
        }
        throw new PackageNotFoundException();
    }
}
