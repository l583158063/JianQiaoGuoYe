package com.jianqiaoguoye.infra.repository.impl;

import io.choerodon.mybatis.domain.AuditDomain;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CommonRepositoryImpl {

    static <T extends AuditDomain> void handleSubmit(BaseRepositoryImpl<T> repository, List<T> list) {
        List<T> createList = new ArrayList<>();
        List<T> deleteList = new ArrayList<>();
        List<T> updateList = new ArrayList<>();
        for (T t : list) {
            switch (t.get_status()) {
                case create:
                    createList.add(t);
                    break;
                case delete:
                    deleteList.add(t);
                    break;
                case update:
                    updateList.add(t);
                    break;
                default:
                    break;
            }
        }
        if (CollectionUtils.isNotEmpty(createList)) {
            repository.batchInsertSelective(createList);
        }
        if (CollectionUtils.isNotEmpty(deleteList)) {
            repository.batchDeleteByPrimaryKey(deleteList);
        }
        if (CollectionUtils.isNotEmpty(updateList)) {
            repository.batchUpdateByPrimaryKeySelective(updateList);
        }
    }
}
