package org.baeldung.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.baeldung.persistence.dao.RoleRepository;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.model.Role;
import org.baeldung.persistence.model.User;
import org.baeldung.persistence.model.VerificationToken;

import org.baeldung.service.MailClient;
import org.baeldung.service.UserService;

import org.baeldung.web.dto.MessageDto;
import org.baeldung.web.util.MailContent;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;
import java.util.Collections;

@Controller
public class HomeController {

    // @GetMapping("/") public String root() { return "index"; }
    @Autowired
    private MailClient mailClient;
    @Autowired
    private MessageSource messages;
    @Autowired
    private UserRepository userRepository;

    @GetMapping({ "/", "/index" })
    public ModelAndView wxAutoLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView ret = new ModelAndView();
        HttpSession session = request.getSession();

        ret.setViewName("index");

        return ret;
    }

    @GetMapping("login")
    public ModelAndView wxAutoLogin2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView ret = new ModelAndView();
        HttpSession session = request.getSession();

        ret.setViewName("login");

        return ret;
    }

    @GetMapping("register")
    public ModelAndView wxAutoLogin1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView ret = new ModelAndView();
        HttpSession session = request.getSession();

        ret.setViewName("register");

        return ret;
    }
}
