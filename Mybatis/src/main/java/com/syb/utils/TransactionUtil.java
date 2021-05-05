package com.syb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @author Abin
 * @date Created in 2021/5/5 0:10
 * @Modified By:
 * @Description
 */
@Component
public class TransactionUtil {

   @Autowired
   DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * @author Abin
     * @date Create in 2021/5/5 0:14
     * @Param
     * @Description 开启事务
     */
    public TransactionStatus begin() {
        TransactionStatus transaction =
                dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transaction;
    }

    /**
     * @author Abin
     * @date Create in 2021/5/5 0:15
     * @Param
     * @Description 提交事务
     */
    public void commit(TransactionStatus transaction) {
        dataSourceTransactionManager.commit(transaction);
    }

    /**
     * @author Abin
     * @date Create in 2021/5/5 0:15
     * @Param
     * @Description 回滚事务
     */
    public void rollback(TransactionStatus transaction) {
        dataSourceTransactionManager.rollback(transaction);
    }

}
