package com.cai.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Mapper
@Repository
public interface AccountDao {

    int decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
