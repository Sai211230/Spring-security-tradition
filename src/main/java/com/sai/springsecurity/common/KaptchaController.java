package com.sai.springsecurity.common;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FastByteArrayOutputStream;
import com.google.code.kaptcha.Producer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author SAI
 * @create 2023-06-18
 */
@AllArgsConstructor
@RequestMapping("/kaptcha")
@RestController
public class KaptchaController {

    private final Producer producer;

    /**
     * 获取验证码图片base64编码
     * @param session
     * @return
     * @throws IOException
     */
    @GetMapping("/vc")
    public String getVerifyCode(HttpSession session) throws IOException {
        String code = producer.createText();
        session.setAttribute("kaptcha", code);
        BufferedImage bi = producer.createImage(code);
        FastByteArrayOutputStream fos = new FastByteArrayOutputStream();
        ImageIO.write(bi, "png", fos);
        return Base64.encode(fos.toByteArray());
    }
}
