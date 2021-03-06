package com.jianqiaoguoye.api.controller.v1;

import com.jianqiaoguoye.config.SwaggerTags;
import com.jianqiaoguoye.domain.entity.Customer;
import com.jianqiaoguoye.domain.repository.CustomerRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.helper.SecurityTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 会员 管理 API
 *
 * @author weixin.lu@hand-china.com 2020-04-23 10:58:21
 */
@Api(tags = SwaggerTags.CUSTOMER)
@RestController("customerController.v1")
@RequestMapping("/v1/customers")
public class CustomerController extends BaseController {

    @Autowired
    private CustomerRepository customerRepository;

    @ApiOperation(value = "会员列表")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping
    public ResponseEntity<?> list(Customer customer, @ApiIgnore @SortDefault(value = Customer.FIELD_CUSTOMER_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Customer> list = customerRepository.pageAndSort(pageRequest, customer);
        return Results.success(list);
    }

    @ApiOperation(value = "会员明细")
    @Permission(level = ResourceLevel.SITE)
    @GetMapping("/{customerId}")
    public ResponseEntity<?> detail(@PathVariable Long customerId) {
        Customer customer = customerRepository.selectByPrimaryKey(customerId);
        return Results.success(customer);
    }

    @ApiOperation(value = "创建会员")
    @Permission(level = ResourceLevel.SITE)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        customerRepository.insertSelective(customer);
        return Results.success(customer);
    }

    @ApiOperation(value = "修改会员")
    @Permission(level = ResourceLevel.SITE)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Customer customer) {
        SecurityTokenHelper.validToken(customer);
        customerRepository.updateByPrimaryKeySelective(customer);
        return Results.success(customer);
    }

    @ApiOperation(value = "删除会员")
    @Permission(level = ResourceLevel.SITE)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Customer customer) {
        SecurityTokenHelper.validToken(customer);
        customerRepository.deleteByPrimaryKey(customer);
        return Results.success();
    }

}
