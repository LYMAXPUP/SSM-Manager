package com.service;

import com.model.Account;
import com.utils.PageData;
import com.utils.TableData;

import java.util.List;

public interface AccountService {
    TableData<Account> list(PageData pd);

    // 增加或更新
    void save(Account ac);

    void del(List<Integer> idList);
}
