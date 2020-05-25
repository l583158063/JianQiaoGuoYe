package com.jianqiaoguoye.infra.repository.impl;

import com.jianqiaoguoye.domain.entity.Customer;
import com.jianqiaoguoye.domain.repository.CustomerRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

/**
 * 资源库实现
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {


}
