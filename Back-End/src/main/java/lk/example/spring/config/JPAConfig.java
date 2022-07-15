package lk.example.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "lk.example.spring.repo")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class JPAConfig {

    @Autowired
    Environment environment;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter va){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(va);
        bean.setDataSource(ds);
        bean.setPackagesToScan(environment.getRequiredProperty("entity.package.name"));
        return bean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform(environment.getRequiredProperty("my.app.dialect"));
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUrl(environment.getRequiredProperty("my.app.url"));
        source.setUsername(environment.getRequiredProperty("my.app.username"));
        source.setPassword(environment.getRequiredProperty("my.app.password"));
        source.setDriverClassName(environment.getRequiredProperty("my.app.driverclassname"));
        return source;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
