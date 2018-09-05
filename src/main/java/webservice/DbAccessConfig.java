package webservice;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"model", "webservice"})
@PropertySource("classpath:database.properties")
public class DbAccessConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getLocalSessionFactoryBean() {
        LocalSessionFactoryBean bean = null;
        try {
            bean = new LocalSessionFactoryBean();
            bean.setPackagesToScan("model", "webservice");
            bean.setDataSource(getDataSource());
            bean.setHibernateProperties(getHibernateProperties());
            bean.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.username"));
        dataSource.setPassword(env.getProperty("database.password"));

        return dataSource;
    }

    private Properties getHibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProp.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProp.put("hibernate.current_session_context_class", "thread");
        hibernateProp.put("hibernate.format_sql",
                env.getProperty("hibernate.format_sql"));
        return hibernateProp;
    }


}
