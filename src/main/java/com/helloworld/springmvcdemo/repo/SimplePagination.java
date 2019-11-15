package com.helloworld.springmvcdemo.repo;

import java.util.List;

public interface SimplePagination<T> {

    List<T> findAllByPagination(int page, int itemPerPage);

    int findTotalPages(int itemPerPage);
}
