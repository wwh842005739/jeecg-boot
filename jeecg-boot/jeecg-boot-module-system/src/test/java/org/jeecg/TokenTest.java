package org.jeecg;

import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.system.util.JwtUtil;
import org.jeecg.common.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * All rights Reserved, Designed By www.sibionics.com
 *
 * @Version V1.0
 * @Title: TokenTest
 * @Package: org.jeecg
 * @Description:
 * @Author: Created by wwh
 * @Date: 2020/10/22 15:55
 * @Company: 深圳硅基仿生科技有限公司
 * @Copyright: 2020 www.sibionics.com.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JeecgSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TokenTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){
        // 生成token
        String token = JwtUtil.sign("jeecg", "123456");
        // 设置token缓存有效时间
        redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
        redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME*2 / 1000);
        System.err.println(token);
    }
}
