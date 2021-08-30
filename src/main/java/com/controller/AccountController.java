package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.Account;
import com.service.AccountService;
import com.utils.PageData;
import com.utils.StringUtils;
import com.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {
    @Resource
    private AccountService as;

    // 全部数据转JSON传前端
    @RequestMapping("/account-list.ajax")
    public String accountList(PageData pd){
        return WebUtils.returnData(as.list(pd));
    }

    @RequestMapping("/account-save.ajax")
    public String accountSave(Account ac){
        as.save(ac);  // 如果失败了返回Exception，后面的就不执行了
        JSONObject data = new JSONObject();
        data.put("type", 0);
        return data.toString();
    }

    @RequestMapping("/account-del.ajax")
    public String accountDel(String ids){
        JSONObject data = new JSONObject();
        if(StringUtils.isEmpty(ids)){
            data.put("type", -1);
            return data.toString();
        }
        String[] idArr = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for(String id:idArr){
            idList.add(Integer.parseInt(id));
        }
        as.del(idList);
        data.put("type", 0);
        return data.toString();
    }
}
