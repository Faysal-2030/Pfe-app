package org.baeldung.web.controller.projet.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.baeldung.persistence.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Client")
public class ClientController {
    @Transactional
	@RequestMapping(value = "/index")
	public ModelAndView wxAutoLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView ret = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user1");

		if (user != null) {
			// Add user information
			ret.addObject("user", user);
		}

		ret.setViewName("/Client/index");
		return ret;
	}
}
