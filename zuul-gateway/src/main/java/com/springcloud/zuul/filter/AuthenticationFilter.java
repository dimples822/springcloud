package com.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证过滤器
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/14
 */
@Component
public class AuthenticationFilter extends ZuulFilter {

    /**
     * 过滤器类型
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @return pre 表示在请求之前执行
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 表示过滤器的执行顺序，当一个请求在同一个阶段的时候，存在多个过滤器的时候，多个过滤器的执行顺序问题
     *
     * @return 0 表示最先执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 写逻辑判断，是否要过滤
     * 本文true,永远过滤
     *
     * @return true 表示生效
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的业务
     *
     * @return Object
     */
    @Override
    public Object run() {
        //拦截所有的服务接口，判断服务接口上是否有传递userToken参数
        //1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2.获取request
        HttpServletRequest request = currentContext.getRequest();
        //3.获取token的时候，从请求头中获取
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)) {
            //不会继续执行,不会去调用服务接口，网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("userToken is null");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        //正常调用其他服务接口
        return null;
    }

}












