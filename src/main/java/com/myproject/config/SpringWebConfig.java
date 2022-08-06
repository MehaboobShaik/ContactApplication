package com.myproject.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * MVC layer three majoy components should be there 1.controller (it will search
 * through((basePackages = {"com.myproject"}) 2.viewresolver(bean)
 */

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan(basePackages = { "com.myproject" })
@EnableWebMvc
public class SpringWebConfig extends    WebMvcConfigurerAdapter {
	/**
	 * addResourceHandlers method can be used to acccess the static resources like
	 * jsp pages style.css or .js it should be adddes in this method then only sprin
	 * will permit
	 **/

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		super.addResourceHandlers(registry);
	}

	/**
	 * The ViewResolver provides a mapping between view names and actual views. The
	 * View interface addresses the preparation of the request and hands the request
	 * over to one of the view technologies.
	 * 
	 * @return
	 */

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver internalViewResolveer = new InternalResourceViewResolver();
		internalViewResolveer.setViewClass(JstlView.class);
		internalViewResolveer.setPrefix("/WEB-INF/view/");
		internalViewResolveer.setSuffix(".jsp");
		return internalViewResolveer;

	}
	

}
