package com.dao;

import com.model.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    //查询全部/按条件查
    List<Account> list(@Param("account") String account, @Param("passwd") String passwd, RowBounds rb);
    //查询总记录数或按条件查询的总记录数(为分页提供Max值)
    Integer listCount(@Param("account") String account, @Param("passwd") String passwd);
    //增加
    Integer add(@Param("ac") Account ac);
    //删(多条)
    Integer del(@Param("ids") List<Integer> ids);
    //改
    Integer change(@Param("ac") Account ac);
}
