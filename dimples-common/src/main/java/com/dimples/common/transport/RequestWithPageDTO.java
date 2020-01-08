package com.dimples.common.transport;

import java.io.Serializable;

import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/1
 */
@Data
public class RequestWithPageDTO implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;

    /**
     * 当前页面数据量
     */
    private Integer pageSize = 10;
    /**
     * 当前页码
     */
    private Integer pageNum = 1;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;

    /**
     * JSON参数
     */
    private String params;

}
