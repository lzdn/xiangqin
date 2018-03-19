package com.xiangqin.conf;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfiguration {

	@Bean
	public ServletRegistrationBean<StatViewServlet> druidServlet() {
		ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<StatViewServlet>();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings("/druid/*");
	 
		reg.addInitParameter("loginUsername", "admin");
		reg.addInitParameter("loginPassword", "admin");
		return reg;
	}

	@Bean
	public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
		FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

	@Bean
	public DataSource druidDataSource(@Value("${spring.datasource.driver-class-name}") String driver,
			@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String username,
			@Value("${spring.datasource.password}") String password,
			@Value("${spring.datasource.initialsize}") int initialSize,
			@Value("${spring.datasource.max-wait}") int maxwait,
			@Value("${spring.datasource.max-active}") int maxactive,
			@Value("${spring.datasource.test-on-borrow}") boolean testonborrow) {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driver);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setMaxWait(maxwait);
		druidDataSource.setMaxActive(maxactive);
		druidDataSource.setInitialSize(initialSize);
		druidDataSource.setTestOnBorrow(testonborrow);

		try {
			druidDataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}
}