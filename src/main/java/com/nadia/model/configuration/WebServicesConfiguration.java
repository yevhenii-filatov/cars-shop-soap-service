package com.nadia.model.configuration;

import jakarta.servlet.Servlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.SoapEnvelopeLoggingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author Yevhenii Filatov
 * @since 6/1/23
 */

@EnableWs
@Configuration
public class WebServicesConfiguration extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<Servlet> messageDispatcherServlet() {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "carsshop")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema carsshopSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CarsshopPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/carsshop");
        wsdl11Definition.setSchema(carsshopSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema carsshopSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schema.xsd"));
    }

    @Bean
    public EndpointInterceptor[] interceptors() {
        return new EndpointInterceptor[]{
           new PayloadLoggingInterceptor(),
           new SoapEnvelopeLoggingInterceptor()
        };
    }
}
