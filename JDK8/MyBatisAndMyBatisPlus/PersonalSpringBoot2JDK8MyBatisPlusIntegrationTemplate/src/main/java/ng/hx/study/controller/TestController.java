package ng.hx.study.controller;

import ng.hx.study.mapper.UserMapper;
import ng.hx.study.model.po.User;
import ng.hx.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
//@RequestMapping("test")
public class TestController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{type}/{test}", method = RequestMethod.GET)
    @ResponseBody
    public Object test(@PathVariable("type") int type, @PathVariable("test") int test) {
        if (type == 1) {
            User user = userService.getById("1");
            if (user != null)
                return user;
        }
        if (type == 2) {
            User user = userMapper.selectById("1");
            if (user != null)
                return user;
        }
        switch (test) {
            case 1:
                return "case 1";
            default:
                break;
        }
        return "hello world";
    }

    @RequestMapping(value = "/t1", method = RequestMethod.GET)
    @ResponseBody
    public Object t1() {
        return "t1 ";
    }
}
/*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TestController.class)
class TestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        String json = "{}";
        ResultActions resultActions = mockMvc.perform(get("/1")  // 请求方式+路径
                        .contentType(MediaType.APPLICATION_JSON)   //用contentType表示具体请求中的媒体类型信息，MediaType.APPLICATION_JSON表示互联网媒体类型的json数据格式（见备注）
                        .content(json)     //accept指定客户端能够接收的内容类型
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));//验证响应contentType == application/json

        resultActions.andDo(print());
        System.out.println("==================================================");
        System.out.println(resultActions.andReturn().getResponse().getContentAsString());
    }
}
*/