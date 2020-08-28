package com.cai.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StorageDao {

    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
