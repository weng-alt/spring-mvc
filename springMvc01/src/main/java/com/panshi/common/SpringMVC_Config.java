package com.panshi.common;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@MapperScan("com.panshi.mapper")
@Import({JdbcConfig.class})
@PropertySource("classpath:jdbcConfig.properties")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringMVC_Config {

    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dtm = new DataSourceTransactionManager();
        dtm.setDataSource(dataSource);
        return dtm;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactoryBean(ComboPooledDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sfb.setConfigLocation(resolver.getResource("classpath:SqlMapConfig.xml"));
        return sfb.getObject();
    }

    @Bean("sqlSession")
    public SqlSessionTemplate createSqlSession(SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate st = new SqlSessionTemplate(sqlSessionFactory);
        return st;
    }

}