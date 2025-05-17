package org.baeldung.web.controller.projet.superAdmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.baeldung.persistence.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/SuperAdmin")
public class SuperAdminController {


    @Transactional
    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView ret = new ModelAndView();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user1");

        if (user != null) {
            ret.addObject("user", user);
        }

        ret.setViewName("/SuperAdmin/db-dashboard");
        return ret;
    }

    @RequestMapping(value = "/db-vendor-hotels")
    public ModelAndView showAllHotels(HttpServletRequest request) {
        ModelAndView ret = new ModelAndView();
        ret.setViewName("/SuperAdmin/db-vendor-hotels");
        return ret;
    }

    @RequestMapping(value = "/db-vendor-add-hotel")
    public ModelAndView showAddHotel(HttpServletRequest request) {
        ModelAndView ret = new ModelAndView();
        ret.setViewName("/SuperAdmin/db-vendor-add-hotel");
        return ret;
    }   
}
