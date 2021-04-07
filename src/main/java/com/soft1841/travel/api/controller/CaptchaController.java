package com.soft1841.travel.api.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.soft1841.travel.api.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName CaptchaController
 * @Description Captcha控制层
 * @Author wanghuanle
 * @Date 2020/4/21
 * @Version 1.0
 */
@RestController
@Slf4j
@Api(tags = "获取验证码接口", value = "用户相关的Rest API")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CaptchaController {
    @Resource
    private DefaultKaptcha defaultKaptcha;
    @Resource
    private RedisService redisService;

    @GetMapping("/captcha")
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public void defaultCaptcha(String name) {
        //取得HttpServletResponse对象
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletResponse response = sra.getResponse();
        //生成验证码文本
        String text = defaultKaptcha.createText();
        log.info(text);
        //将验证码存入redis，配置的失效时间单位是分钟
        redisService.set(name, text, 2L);
        //生成验证码图片，并通过response输出到客户端浏览器
        BufferedImage image = defaultKaptcha.createImage(text);
        //设置response的响应内容类型为图片格式
        assert response != null;
        response.setContentType("image/jpeg");
        response.setDateHeader("Expires", 0);
        try {
            //通过ImageIO将验证码图片通过response的字节输出流传回客户端
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
