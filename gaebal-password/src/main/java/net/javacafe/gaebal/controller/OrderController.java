package net.javacafe.gaebal.controller;

import net.javacafe.gaebal.security.UserToOrderDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 임형태
 * @since 2015.10.28
 */
@Controller
public class OrderController {
    private static final List<Order> orders = new ArrayList<>();

    static {
        orders.add(new Order("2015-11-28 15:09:21", "황전민", "경기도 성남시 판교동", "010-9870-812358", "후라이드 1 마리"));
        orders.add(new Order("2015-11-28 14:22:13", "송강오", "서울시 마포구 마교동", "010-5566-5384", "파닭 1 마리, 맥주 1000cc"));
        orders.add(new Order("2015-11-28 13:42:22", "유아민", "경기도 용신히 동백동", "010-4499-5213", "반반 1 마리"));
        orders.add(new Order("2015-11-28 13:23:42", "원번", "서울시 서초구 서초동", "010-3984-9292", "양념 1 마리 후라이드 1마리 콜라 1.5l 1개"));
        orders.add(new Order("2015-11-28 13:21:23", "장돈건", "서울시 용산구 용산동", "010-9876-1234", "양념 1 마리, 맥주 3000cc"));
        orders.add(new Order("2015-11-28 13:01:11", "혼길돈", "서울시 강남구 삼성동", "010-1111-8282", "반반 1 마리, 콜라 1.5l 1개"));
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView order(Principal principal) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("orders", orders);
        UserToOrderDetails u = ((UserToOrderDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        mav.addObject("user", u);
        return mav;
    }

    public static class Order {
        private String datetime;
        private String name;
        private String address;
        private String cellphone;
        private String order;

        public Order(String datetime, String name, String address, String cellphone, String order) {
            this.datetime = datetime;
            this.name = name;
            this.address = address;
            this.cellphone = cellphone;
            this.order = order;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCellphone() {
            return cellphone;
        }

        public void setCellphone(String cellphone) {
            this.cellphone = cellphone;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }


}

