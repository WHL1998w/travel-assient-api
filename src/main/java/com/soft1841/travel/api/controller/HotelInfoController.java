package com.soft1841.travel.api.controller;


import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.AppointmentAttraDto;
import com.soft1841.travel.api.domain.dto.AppointmentHotelDto;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.service.HotelInfoService;
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
 * @since 2021-05-06
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "酒店接口", value = "酒店相关的Rest API")
@RestController
@RequestMapping("/hotelInfo")
public class HotelInfoController {

    @Resource
    private HotelInfoService hotelInfoService;

    /**
     * 根据酒店id查询酒店详细信息
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据酒店id查询酒店详细信息", notes = "根据酒店id查询酒店详细信息")
    //@PathVariable路径传参的注解
    Result getHotelsInfo(@PathVariable Integer id) {
        return hotelInfoService.getHotelInfoById(id);
    }

    /**
     * 分页查询
     * @param pageDto
     * @return
     */
    @PostMapping("/page")
    @ApiOperation(value = "分页查询酒店详细信息", notes = "分页查询酒店详细信息")
    Result getByPage(@RequestBody @Valid PageDto pageDto) {
        return hotelInfoService.getByPage(pageDto);
    }

    /**
     * 模糊查询酒店接口
     * @param field
     * @return
     */
    @GetMapping("/blur")
    @ApiOperation(value = "模糊查询酒店接口", notes = "模糊查询酒店接口")
    public Result blurSelectAttrations (@Valid @Param("field") @Size(min = 2,message = "关键字不得少于两个字") String field) {
        return hotelInfoService.blurSelect(field);
    }

    /**
     * 查询热门酒店信息
     */
    @GetMapping(value = "/all")
    @ApiOperation(value = "查询热门酒店信息", notes = "查询热门酒店信息")
    public Result getTopAttrationsList() {
        return hotelInfoService.getTopHotelsInfo();
    }

    /**
     * 预约酒店
     * @param hotelDto
     * @return
     */
    @PostMapping("/appointment")
    @ApiOperation(value = "预约酒店", notes = "预约酒店")
    public Result insertAppoinHotels(@RequestBody AppointmentHotelDto hotelDto){
        log.info((hotelDto.toString()));
        return this.hotelInfoService.insertAppoinHotel(hotelDto);
    }
}
