package com.mpersd.qualitronics.config;

import java.util.ResourceBundle;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@ComponentScan(basePackages = "com.mpersd.qualitronics")
@Configuration
@EnableTransactionManagement
@EnableSwagger2
public class AppConfig implements WebMvcConfigurer{

	
	/**	
	 * swagger 2
	 */
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	/**
	 * Capa de presentacion MVC
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/content/**")
		.addResourceLocations("/content/");
		
		//Swagger2
		 registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");
	 
	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    //End swagger2
	}
	
	@Bean(value="viewResolver")
	public ViewResolver viewResolver() {
		System.out.println("se crea bean vierResolver");
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/vistas/");
		vr.setSuffix(".jsp");
		return vr;
	}
	@Bean
	public MessageSource messageSurce() {
		ResourceBundleMessageSource msg = new ResourceBundleMessageSource();
		msg.setBasename("mensajes");
		
		return msg;
	}
	
	/**
	 * capa de datos 
	 */
		
	@Bean("ds-local")
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost/qualitronics");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.mpersd.qualitronics.entities");
		emf.setPersistenceUnitName("springPU");
		
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		vendor.setShowSql(true);
		vendor.setDatabase(Database.MYSQL);
		
		emf.setJpaVendorAdapter(vendor);
		
		return emf;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txm = new JpaTransactionManager();
		txm.setEntityManagerFactory(emf);
		return txm;
	}
	
	
	
	
	

}
