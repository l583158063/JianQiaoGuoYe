package com.jianqiaoguoye.infra.repository.impl;

import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import com.jianqiaoguoye.domain.entity.Customer;
import com.jianqiaoguoye.domain.repository.CustomerRepository;
import org.springframework.stereotype.Component;

/**
 * 当用户注册成功会将对应信息写入，当用户个人信息处修改个人信息后保存后写入 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {

  
}
