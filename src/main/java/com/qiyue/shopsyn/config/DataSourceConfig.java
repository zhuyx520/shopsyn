package com.qiyue.shopsyn.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan(basePackages = {"com.qiyue.shopsyn.dao.primary","com.qiyue.shopsyn.dao.second"}, sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {
	// --------------------------配置第一数据源-----------------------
	
	@Value("${spring.datasource.driver-class-name}")
    String driverClassPrimary;
    @Value("${spring.datasource.url}")
    String urlPrimary;
    @Value("${spring.datasource.username}")
    String userNamePrimary;
    @Value("${spring.datasource.password}")
    String passWordPrimary;
    
    // 配置数据源-1
    @Bean(name = "primaryDataSource")
    @Primary
    public DataSource primaryDataSource() {
    	
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName(driverClassPrimary);
    	dataSource.setUrl(urlPrimary);
    	dataSource.setUsername(userNamePrimary);
    	dataSource.setPassword(passWordPrimary);
    	return dataSource;
    }
    
    // 创建事务-1
    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // 创建模板-1
    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(
    		@Qualifier("primaryDataSource")DataSource dataSource) {
    	return new JdbcTemplate(dataSource);
    }

    // --------------------------配置第二数据源-----------------------
    @Value("${spring.datasource.secondary.driver-class-name}")
    String driverClassSecondary;
    @Value("${spring.datasource.secondary.url}")
    String urlSecondary;
    @Value("${spring.datasource.secondary.username}")
    String userNameSecondary;
    @Value("${spring.datasource.secondary.password}")
    String passWordSecondary;
    
    // 配置数据源-2
    @Bean(name = "secondaryDataSource")
    public DataSource secondaryDataSource() {
    	
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName(driverClassSecondary);
    	dataSource.setUrl(urlSecondary);
    	dataSource.setUsername(userNameSecondary);
    	dataSource.setPassword(passWordSecondary);
    	return dataSource;
    }
    
    // 创建事务-2
    @Bean(name = "secondaryTransactionManager")
    @Primary
    public DataSourceTransactionManager secondTransactionManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    // 创建模板-2
    @Bean(name = "secondarySqlSessionTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
    		@Qualifier("secondaryDataSource")DataSource dataSource) {
    	return new JdbcTemplate(dataSource);
    }

 // --------------------------配置动态数据源-----------------------
    
	@Bean(name = "dynamicDataSource")
	public DynamicDataSource DataSource(@Qualifier("primaryDataSource") DataSource test1DataSource,
			@Qualifier("secondaryDataSource") DataSource test2DataSource) {
		Map<Object, Object> targetDataSource = new HashMap<>();
		targetDataSource.put(DataSourceType.DataBaseType.PRIMARY01, test1DataSource);
		targetDataSource.put(DataSourceType.DataBaseType.SECONDARY02, test2DataSource);
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSource);
		dataSource.setDefaultTargetDataSource(test1DataSource);
		return dataSource;
	}

	@Bean(name = "SqlSessionFactory")
	public SqlSessionFactory test1SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dynamicDataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
		return bean.getObject();
	}

}