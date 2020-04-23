package com.jianqiaoguoye.domain.repository;

import org.hzero.mybatis.base.BaseRepository;
import com.jianqiaoguoye.domain.entity.Customer;

/**
 * 当用户注册成功会将对应信息写入，当用户个人信息处修改个人信息后保存后写入资源库
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface CustomerRepository extends BaseRepository<Customer> {
    
}
