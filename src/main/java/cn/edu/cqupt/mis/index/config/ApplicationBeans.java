package cn.edu.cqupt.mis.index.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 应用的 Bean 集合
 */
@Configurable
public class ApplicationBeans {
    /**
     * 整个应用会用到的数据源
     */
    ApplicationProperties properties = new ApplicationProperties();

    /**
     * 这里是 alibaba 的 DataSource
     */
    @Bean
    public DruidDataSource getDruidDataSource () {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(properties.mysqlUsername);
        druidDataSource.setPassword(properties.mysqlPassword);
        druidDataSource.setUrl("jdbc:mysql://"+properties.mysqlHost+":"+properties.mysqlPort+"/"+properties.mysqlDatabaseName+"?useSSL=false&allowPublicKeyRetrieval=true");
        return druidDataSource;
    }

    /**
     * mybatis-spring 框架当中的 SqlSessionFactoryBean，用来生成 SqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean (@Autowired DruidDataSource druidDataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        sqlSessionFactoryBean.setMapperLocations(properties.mybatisMapperResources);
        return sqlSessionFactoryBean;
    }

    /**
     * spring-jdbc 当中的 DataSourceTransactionManager 负责管理数据库的事务
     */
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager (@Autowired DruidDataSource druidDataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(druidDataSource);
        return dataSourceTransactionManager;
    }

    /**
     * mybatis 框架当中的 MapperScannerConfigurer 自动扫描 Mapper.xml 类
     */
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer () {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("cn.edu.cqupt.mis.sso");
        return mapperScannerConfigurer;
    }

}
