package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.service.TravelNodeService;
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
 * @since 2021-05-16
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "游记接口", value = "游记相关的Rest API")
@RestController
@RequestMapping("/travelNode")
public class TravelNodeController {
    @Resource
    private TravelNodeService travelNodeService;

    /**
     * 根据id查询游记详细信息
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询游记详细信息", notes = "根据id查询游记详细信息")
    //@PathVariable路径传参的注解
    Result getAttractionsInfo(@PathVariable Integer id) {
        return travelNodeService.getTravelNodeById(id);
    }
    /**
     * 分页查询
     * @param pageDto
     * @return
     */
    @PostMapping("/page")
    @ApiOperation(value = "分页查询游记详细信息", notes = "分页查询游记详细信息")
    Result getByPage(@RequestBody @Valid PageDto pageDto) {
        return travelNodeService.getByPage(pageDto);
    }

    /**
     * 模糊查询游记接口
     * @param field
     * @return
     */
    @GetMapping("/blur")
    @ApiOperation(value = "模糊查询游记信息", notes = "模糊查询游记信息")
    public Result blurSelectAttrations (@Valid @Param("field") @Size(min = 2,message = "关键字不得少于两个字") String field) {
        return travelNodeService.blurSelect(field);
    }

    /**
     * 查询热门游记信息
     */
    @GetMapping(value = "/all")
    @ApiOperation(value = "查询热门游记信息", notes = "查询热门游记信息")
    public Result getTopAttrationsList() {
        return travelNodeService.getTopTravelNodeInfo();
    }
}
