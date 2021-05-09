package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.vo.AttrationsInfoVo;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.service.AttractionsInfoService;
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
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghuanle
 * @since 2021-04-24
 */

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "景点接口", value = "景点相关的Rest API")
@RestController
@RequestMapping("/attractionsInfo")
public class AttractionsInfoController {


    @Resource
    private AttractionsInfoService attractionsInfoService;


    /**
     * 根据id查询景点详细信息
     */
    @GetMapping("/{poiId}")
    @ApiOperation(value = "根据id查询景点详细信息", notes = "根据id查询景点详细信息")
    //@PathVariable路径传参的注解
    Result getAttractionsInfo(@PathVariable String poiId) {
        log.info(attractionsInfoService.getAttractionsById(poiId).toString());
        return attractionsInfoService.getAttractionsById(poiId);
    }

    /**
     * 分页查询
     * @param pageDto
     * @return
     */
    @PostMapping("/page")
    @ApiOperation(value = "分页查询景点详细信息", notes = "分页查询景点详细信息")
    Result getByPage(@RequestBody @Valid PageDto pageDto) {
        return attractionsInfoService.getByPage(pageDto);
    }

    /**
     * 模糊查询景点接口
     * @param field
     * @return
     */
    @GetMapping("/blur")
    @ApiOperation(value = "模糊查询景点信息", notes = "模糊查询景点信息")
    public Result blurSelectAttrations (@Valid @Param("field") @Size(min = 2,message = "关键字不得少于两个字") String field) {
        return attractionsInfoService.blurSelect(field);
    }

    @GetMapping(value = "/all")
    @ApiOperation(value = "查询热门景点信息", notes = "查询热门景点信息")
    public Result getTopAttrationsList() {
        return attractionsInfoService.getTopAttrationsInfo();
    }
}
