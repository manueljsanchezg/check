package org.springframework.samples.petclinic.grooming;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CouponService {
    private CouponRepository cr;

    @Autowired
    public CouponService(CouponRepository cr){
        this.cr=cr;
    }

    @Transactional
    public Coupon save(Coupon d) {
        return cr.save(d);
    }
    
    @Transactional(readOnly = true)
    public List<Coupon> getAll() {
        return cr.findAll();
    }    

    public void addVisit(Coupon c, Visit v) throws UnfeasibleCouponException {
        // TODO: Change this
    }
}
