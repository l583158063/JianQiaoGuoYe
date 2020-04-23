package com.jianqiaoguoye.infra.mapper;

import com.jianqiaoguoye.domain.entity.Customer;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * 当用户注册成功会将对应信息写入，当用户个人信息处修改个人信息后保存后写入Mapper
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
public interface CustomerMapper extends BaseMapper<Customer> {

}
