package com.example.springmybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
//@Reporistry @Service @Component @Controller.....
@ComponentScan(basePackages = "com.example.springmybatis")
//可以扫描到mybatis对应的接口文件中的组件@Mapper
@MapperScan(basePackages = "com.example.springmybatis.dao")
public class SpringConfig {

    //1.针对mybatis要变成spring容器管理，也就意味着要把原来的DButil中的内容直接交给了spring处理

    //sqlsessionFactory  如果说之前还有数据源我们还要加入数据源的管理DateSource
    //1.1 针对数据库的配置信息进行解析
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

    //1.3 把数据源丢给对应的SQlSessionFactory
    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //引入数据源
        sqlSessionFactoryBean.setDataSource(dataSource());
        //要引入mybatis.xml配置文件
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis.xml"));
        return sqlSessionFactoryBean;
    }

}
