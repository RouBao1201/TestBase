package com.syb.service;

import java.util.List;

/**
 * @author Abin
 * @date Created in 2021/5/1 0:15
 * @Modified By:
 * @Description
 */
public interface BaseService<T> {
    List<T> findAll();
}
