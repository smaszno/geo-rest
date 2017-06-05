package org.smaszno.geo.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by smaszno on 2017-06-05.
 */
@Configuration
public class GeoRestH2ConsoleConfiguration {

        @Bean
        ServletRegistrationBean h2servletRegistration(){
            ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
            registrationBean.addUrlMappings("/console/*");
            return registrationBean;
        }

}
