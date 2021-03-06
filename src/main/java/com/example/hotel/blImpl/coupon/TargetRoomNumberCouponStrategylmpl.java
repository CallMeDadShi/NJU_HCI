package com.example.hotel.blImpl.coupon;

import com.example.hotel.bl.coupon.CouponMatchStrategy;
import com.example.hotel.po.Coupon;
import com.example.hotel.vo.OrderVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TargetRoomNumberCouponStrategylmpl implements CouponMatchStrategy {
    /**
     * 判断某个订单是否满足多间优惠
     * @param orderVO
     * @return
     */
    @Override
    public boolean isMatch(OrderVO orderVO, Coupon coupon) {

        if (coupon.getCouponType() == 2
                && orderVO.getRoomNum()>=3
                && coupon.getStatus()==1)
        {
            System.out.println("多间");
            return true;
        }
        return false;
    }


}
