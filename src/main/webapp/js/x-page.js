// 分页查询对象
var xPage = {
    // 请求地址
    url: '',
    // 表格数据
    dataList: [],
    // 搜索数据
    sd: {},
    // 分页索引
    pageIndex: 1,
    // 每页数据条数
    pageSize: 5,
    // 最大页
    pageMax: 1,
    // 分页序号
    pageList: [],
    // 上一页
    goUp: function () {
        if (xPage.pageIndex > 1) {
            xPage.pageIndex = xPage.pageIndex - 1;
            xPage.getData(xPage.pageIndex);
        }
    },
    // 下一页
    goDown: function () {
        if (xPage.pageIndex < xPage.pageMax) {
            xPage.pageIndex = xPage.pageIndex + 1;
            xPage.getData(xPage.pageIndex);
        }
    },
    // 计算分页数
    runPage: function (max) {
        xPage.pageMax = max;
        xPage.pageList = [];
        for (var i = 1; i <= max; i++) {
            xPage.pageList.push(i);
        }
    },
    // 获取数据
    getData: function (nowIndex) {
        xPage.pageIndex = nowIndex;
        var sdStr = JSON.stringify(xPage.sd);
        $.ajax({
            url: xPage.url,
            type: "post",
            data: {
                pageIndex: nowIndex,
                pageSize: xPage.pageSize,
                sd: sdStr
            },
            dataType: "JSON",
            success: function (resp) {
                xPage.dataList = resp.dataList;
                xPage.runPage(resp.pageCount);
            },
            error: function () {
                alert("系统错误请联系管理员！！");
            }
        });
    },
    // 刷新页面
    reload: function() {
        xPage.getData(xPage.pageIndex);
    },
    // 初始化方法
    init: function (url) {
        xPage.url = url;
        xPage.getData(xPage.pageIndex);
    }
};