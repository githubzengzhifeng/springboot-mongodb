package com.unionman.springbootmongodbdemo.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

/**
 * @description mongoDB 配置
 * @author Zhifeng.Zeng
 */
@Configuration
@EnableConfigurationProperties(MongoProperties.class)
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    private MongoProperties properties;

    @Override
    public MongoClient mongoClient(){
        return new MongoClient(properties.getHost(),properties.getPort());
    }

    @Override
    public String getDatabaseName(){
        return properties.getDatabase();
    }

    /**
     * @description: 去除“_class”字段
     * @return MappingMongoConverter
     * @date 2018/08/15 16:24
     * @author Rong.Jia
     * @throws Exception
     */
    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        MappingMongoConverter mmc = super.mappingMongoConverter();
        mmc.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mmc;
    }

}
