package cn.mall.shop.controller;

import cn.mall.shop.data.ResultVO;
import cn.mall.shop.data.UserVO;
import cn.mall.shop.mybatis.dao.UserMapper;
import cn.mall.shop.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public ResultVO login(UserVO user) {
        List<User> userList = userMapper.getUserByName(user.getName());
        for(User u : userList) {
            if(u.getName().equals(user.getName()) && u.getPasswd().equals(user.getPasswd())) {
                ResultVO resultVO = this.getSuccess();
                return resultVO;
            }
        }
        return this.getFailure();
    }

}
