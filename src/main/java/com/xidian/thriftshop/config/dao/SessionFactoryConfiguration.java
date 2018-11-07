package com.xidian.thriftshop.config.dao;

import com.xidian.thriftshop.config.dao.DataSourceConfiguration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
@Configuration
public class SessionFactoryConfiguration {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Value("${mybatis_configuration}")
    private String mybatisConfigPathFile;
    @Value("${mapper_path}")
    private String mapperPath;
    @Value("${domain_package}")
    private String domainPackage;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //配置mybatisconfig
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigPathFile));
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        String PackagePath=PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        //配置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //配置mapper映射
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(PackagePath));
        //映射实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(domainPackage);
        return sqlSessionFactoryBean;
    }
}
