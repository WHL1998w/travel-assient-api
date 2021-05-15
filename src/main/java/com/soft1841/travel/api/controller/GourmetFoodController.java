package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.service.GourmetFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Size;

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

    /**
     * 分页查询
     * @param pageDto
     * @return
     */
    @PostMapping("/page")
    @ApiOperation(value = "分页查询餐厅详细信息", notes = "分页查询餐厅详细信息")
    Result getByPage(@RequestBody @Valid PageDto pageDto) {
        return gourmetFoodService.getByPage(pageDto);
    }

    /**
     * 模糊查询餐厅接口
     * @param field
     * @return
     */
    @GetMapping("/blur")
    @ApiOperation(value = "模糊查询餐厅接口", notes = "模糊查询餐厅接口")
    public Result blurSelectAttrations (@Valid @Param("field") @Size(min = 2,message = "关键字不得少于两个字") String field) {
        return gourmetFoodService.blurSelect(field);
    }

    /**
     * 查询热门美食信息
     */
    @GetMapping(value = "/all")
    @ApiOperation(value = "查询热门美食信息", notes = "查询热门美食信息")
    public Result getTopGourmetFoodList() {
        return gourmetFoodService.getTopGourmentFood();
    }

}
