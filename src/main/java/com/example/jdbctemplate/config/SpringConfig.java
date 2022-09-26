package com.example.jdbctemplate.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@ComponentScan(basePackages = "com.example.jdbctemplate")
////打开事务支持--一般放在启动执行类上或者配置加载类上
@EnableTransactionManagement
public class SpringConfig {

    private static Map<String,String> map = new ConcurrentHashMap<>();
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("D:\\idea\\springdemo174\\src\\main\\resources\\db.properties")));
            map.put("driver",properties.getProperty("driver"));
            map.put("url",properties.getProperty("url"));
            map.put("username",properties.getProperty("username"));
            map.put("password",properties.getProperty("password"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("读取配置文件成功");
        }
    }
    //1.2 数据源的配置 Druid
    @Bean("dataSource")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(map.get("username"));
        dataSource.setDriverClassName(map.get("driver"));
        dataSource.setPassword(map.get("password"));
        dataSource.setUrl(map.get("url"));
        dataSource.setMaxActive(50);
        dataSource.setMaxWait(6000L);
        return dataSource;
    }

    @Bean("jdbcTemplate")
   public JdbcTemplate jdbcTemplate(){
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            jdbcTemplate.setDataSource(dataSource());
            return jdbcTemplate;
   }

   @Bean("transactionManager")
    public TransactionManager transactionManager(){
       DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
   }

}
