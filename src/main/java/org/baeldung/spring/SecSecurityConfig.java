package org.baeldung.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.baeldung.persistence.dao.RoleRepository;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.model.Role;
import org.baeldung.persistence.model.User;
import org.baeldung.security.CustomRememberMeServices;
import org.baeldung.security.google2fa.CustomAuthenticationProvider;
import org.baeldung.security.google2fa.CustomWebAuthenticationDetailsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configuration
@ComponentScan(basePackages = { "org.baeldung.security" })
// @ImportResource({ "classpath:webSecurityConfig.xml" })
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private LogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private CustomWebAuthenticationDetailsSource authenticationDetailsSource;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public SecSecurityConfig() {
        super();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/webjars/**",
                "/email_templates/**",
                "/resources/**",
                "/img/**",
                "/images/**",
                "/contactform/**",
                "/font/**",
                "/fonts/**",
                "/ico/**",
                "/css/**",
                "/css1/**",
                "/vendor/**",
                "/img1/**",
                "/font-awesome/**",
                "/scss/**",
                "/js1/**",
                "/skins/**",
                "/js/**",
                "/assets/**",
                "/uploads/**",
                "/Admin/**",
                "/public/**");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/Hebergement/Appartement/**").permitAll()
                .antMatchers("/portfolio/**", "/founder/*", "/changePassword*", "/services", "/about-us", "/blog", 
                             "/project-item", "/blog-item", "/contact-us", "/produits", "/", "/expiredAccount1*", 
                             "/icons*", "/icon-variations*", "/animations*", "/typography*", "/components*", "/table*", 
                             "/index-alt3*", "/index-alt2*", "/", "/404*", "/testimonials*", "/pricingbox*", 
                             "/index-alt2*", "/index*", "/index", "/login*", "/logout*", "/signin/**", "/signup/**", 
                             "/customLogin", "/access-denied*", "/post-right-sidebar*", "/post-left-sidebar*", 
                             "/blog-right-sidebar*", "/blog-left-sidebar*", "/portfolio-detail*", "/portfolio-4cols*", 
                             "/portfolio-3cols*", "/portfolio-2cols*", "/testimonials*", "/pricingbox*", "/about*", 
                             "/user/registration*", "/registrationConfirm*", "/expiredAccount*", "/registration*", 
                             "/badUser*", "/contact*", "/search*", "/user/resendRegistrationToken*", "/forgetPassword*", 
                             "/user/resetPassword*", "/user/changePassword*", "/emailError*", "/resources/**", 
                             "/resources/static/**", "/resources/static/Admin**", "/old/user/registration*", 
                             "/successRegister*", "/qrcode*", "/webjars/**", "/prestations/*", "/portfolios", 
                             "/register*", "/convert*", "/showInfo", "/api/**", "/policy-and-terms", 
                             "/Hebergement/**", "/Appartement/**", "/**/*.html") 
                .permitAll()
                .antMatchers("/index", "/contact*").anonymous()
                .antMatchers("/SuperAdmin/**").hasAuthority("SUPERADMIN_PRIVILEGE")
                .antMatchers("/Admin/**").hasAuthority("ADMIN_PRIVILEGE")
                .antMatchers("/SubAdmin/**").hasAuthority("SUBADMIN_PRIVILEGE")
                
                .antMatchers("/HebergementsAdmin/**").hasAuthority("HEBERGEMENTS_ADMIN_PRIVILEGE")
                .antMatchers("/SiteAdmin/**").hasAuthority("SITEADMIN_PRIVILEGE")
                .antMatchers("/Chef/**").hasAuthority("CHEF_PRIVILEGE")
                .antMatchers("/Client/**").hasAuthority("CLIENT_PRIVILEGE")
                .antMatchers("/user/updatePassword*", "/user/savePassword*", "/updatePassword*").hasAuthority("CHANGE_PASSWORD_PRIVILEGE")
                .anyRequest().hasAuthority("READ_PRIVILEGE")
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .failureUrl("/login?error=true")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .authenticationDetailsSource(authenticationDetailsSource)
                .permitAll()
                .and()
            .logout()
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .invalidateHttpSession(false)
                .logoutSuccessUrl("/logout.html?logSucc=true")
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
            .rememberMe()
                .rememberMeServices(rememberMeServices())
                .key("theKey");
    }

    // beans

    @Bean
    public DaoAuthenticationProvider authProvider() {
        final CustomAuthenticationProvider authProvider = new CustomAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        CustomRememberMeServices rememberMeServices = new CustomRememberMeServices("theKey", userDetailsService,
                new InMemoryTokenRepositoryImpl());
        return rememberMeServices;
    }
}