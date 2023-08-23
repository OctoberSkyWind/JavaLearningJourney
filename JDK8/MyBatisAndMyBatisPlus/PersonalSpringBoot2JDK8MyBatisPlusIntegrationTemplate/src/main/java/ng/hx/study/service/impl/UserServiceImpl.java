package ng.hx.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ng.hx.study.mapper.UserMapper;
import ng.hx.study.model.po.User;
import ng.hx.study.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
