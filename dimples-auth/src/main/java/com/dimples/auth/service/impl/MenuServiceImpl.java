package com.dimples.auth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dimples.auth.mapper.MenuMapper;
import com.dimples.auth.po.Menu;
import com.dimples.auth.service.MenuService;
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService{

}
