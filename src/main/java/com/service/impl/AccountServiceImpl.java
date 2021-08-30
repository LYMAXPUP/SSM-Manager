package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dao.AccountMapper;
import com.model.Account;
import com.service.AccountService;
import com.utils.PageData;
import com.utils.PageUtils;
import com.utils.TableData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper am;

    @Override
    public TableData<Account> list(PageData pd) {
        TableData<Account> td = new TableData<>(pd);
        // 查询参数
        String account = null;
        String passwd = null;
        JSONObject searchData = pd.getSd();
        if(searchData!=null){
            account = searchData.getString("account");
            passwd = searchData.getString("passwd");
        }
        // 分页Max值
        Integer count = am.listCount(account, passwd);
        td.setDataCount(count);
        if(count>0){
            List<Account> list = am.list(account, passwd, PageUtils.getRb(pd));
            td.setDataList(list);
        }
        return td;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Account ac) {
        if(ac.getId()>0){
            //
            am.change(ac);
        }else{
            am.add(ac);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void del(List<Integer> idList) {
        am.del(idList);
    }
}
