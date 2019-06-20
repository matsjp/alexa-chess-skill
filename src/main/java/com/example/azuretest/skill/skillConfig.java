package com.example.azuretest.skill;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class skillConfig {

    @Autowired
    private ChessNameSpeechlet mySpeechlet;

    @Bean
    public ServletRegistrationBean<SpeechletServlet> registerServlet() {

        SpeechletServlet speechletServlet = new SpeechletServlet();
        speechletServlet.setSpeechlet(mySpeechlet);

        return new ServletRegistrationBean<>(speechletServlet, "/alexaservice");
    }
}
