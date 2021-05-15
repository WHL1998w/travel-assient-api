package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.service.GourmetFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-15
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "美食接口", value = "美食相关的Rest API")
@RestController
@RequestMapping("/gourmetFood")
public class GourmetFoodController {

    @Resource
    private GourmetFoodService gourmetFoodService;

    /**
     * 根据id查询餐厅详细信息
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询餐厅详细信息", notes = "根据id查询餐厅详细信息")
    //@PathVariable路径传参的注解
    Result getGourmentFood(@PathVariable Integer id) {
        return gourmetFoodService.getGourmentFoodById(id);
    }

}
