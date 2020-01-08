package com.dimples.zuul.filter;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayParamFlowItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulErrorFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPostFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPreFilter;
import com.google.common.collect.Sets;
import com.netflix.zuul.ZuulFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

/**
 * 进行接口限流
 * 限定同一个IP、同一个接口在某段时间内的请求次数
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/8
 */
@Slf4j
@Configuration
public class DimplesGatewaySentinelFilter {

    @Bean
    public ZuulFilter sentinelZuulPreFilter() {
        return new SentinelZuulPreFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulPostFilter() {
        return new SentinelZuulPostFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulErrorFilter() {
        return new SentinelZuulErrorFilter();
    }

    /**
     * @ PostConstruct 表示在对象加载完成后，会自动执行的方法
     */
    @PostConstruct
    public void doInit() {
        initGatewayRules();
    }

    /**
     * 定义接口请求限流，限流规则：
     * 60秒内同一个IP，同一个接口最多访问 10次
     */
    private void initGatewayRules() {
        Set<ApiDefinition> definitions = Sets.newHashSet();
        Set<ApiPredicateItem> predicateItems = Sets.newHashSet();
        predicateItems.add(new ApiPathPredicateItem().setPattern("/auth/oauth/token"));
        ApiDefinition definition = new ApiDefinition("token")
                .setPredicateItems(predicateItems);
        definitions.add(definition);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);

        Set<GatewayFlowRule> rules = Sets.newHashSet();

        rules.add(new GatewayFlowRule("token")
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_CUSTOM_API_NAME)
                .setParamItem(
                        new GatewayParamFlowItem()
                                .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM)
                                .setMatchStrategy(SentinelGatewayConstants.PARAM_MATCH_STRATEGY_EXACT)
                                .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_CLIENT_IP)
                )
                .setCount(10)
                .setIntervalSec(60)
        );
        GatewayRuleManager.loadRules(rules);
    }

}

































