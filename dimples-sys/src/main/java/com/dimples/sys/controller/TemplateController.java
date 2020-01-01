package com.dimples.sys.controller;

import com.dimples.common.transport.ResponseDTO;
import com.dimples.sys.po.Template;
import com.dimples.sys.service.TemplateService;
import com.dimples.sys.service.TemplateUserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户模板配置
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/11/27
 */
@Slf4j
@Api(tags = "用户模板配置")
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Resource
    private TemplateService templateService;
    @Resource
    private TemplateUserService templateUserService;

    @ApiOperation("新增用户模板")
    @PostMapping("/add")
    public ResponseDTO add(Template template) {
        templateService.insertSelective(template);
        return ResponseDTO.success();
    }

    /**
     * 用户新增模板包括新增和更新一个模板，在更新模板时如果传入了模板id即为更新
     * 更新时需要去数据库对比是否更改，如果更改，直接新增当前模板，原模板保持不变
     * 如果没有传入active的值，默认用户添加一个模板时贵为用户激活当前模板
     *
     * @param template Template
     * @param userId   Long
     * @return ResponseDTO
     */
    @ApiOperation("用户新增模板并绑定")
    @PostMapping("/add/{userId}")
    public ResponseDTO add(Template template, @PathVariable Long userId, @RequestParam(defaultValue = "false") boolean active) {
        int result = templateService.add(template, userId, active);
        return result > 0 ? ResponseDTO.success() : ResponseDTO.failed();
    }

    @ApiOperation("绑定用户与模板")
    @PostMapping("/bind/user")
    public ResponseDTO bind(Long templateId, Long userId) {
        int result = templateUserService.bind(templateId, userId);
        return result > 0 ? ResponseDTO.success() : ResponseDTO.failed();
    }
}

















