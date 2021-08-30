package com.utils;

import org.apache.ibatis.session.RowBounds;

public class PageUtils {
    public static RowBounds getRb(PageData pd) {
        //select xx limit 0,5 / 5,5
        int offset = (pd.getPageIndex() - 1) * pd.getPageSize();
        int limit = pd.getPageSize();
        return new RowBounds(offset, limit);
    }
}
