package com.dimples.sys.configure;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.google.common.collect.Lists;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * sys的系统配置
 * 配置mybatis-plus分页
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/8
 */
@Configuration
public class DimplesSystemConfigure {
    /**
     * 配置MyBatis Plus分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = Lists.newArrayList();
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }
}

















