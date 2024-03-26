package py.com.solar.commonsapi.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class MyBatisConfig {

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource mybatisConfigXml = resolver.getResource("classpath:mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);

        sqlSessionFactoryBean.setTypeAliasesPackage("py.com.solar.commonsapi.entity");

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("py.com.solar.commonsapi.repository");
        return mapperScannerConfigurer;
    }

}