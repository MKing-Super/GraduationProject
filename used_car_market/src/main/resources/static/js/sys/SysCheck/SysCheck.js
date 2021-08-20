var BootstrapTable = {
    id: "tb_departments",    //表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    pageSize: 20,        //每页获取的条数
    pageNumber: 1,       //页数
    seItemIds: null,    //选中多行数据的id
    res: null
};

/**
 * 初始化table
 */
BootstrapTable.initTable = function () {

    $('#tb_departments').bootstrapTable({
        url: '/sysCheck/sysCheckList',         //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        queryParams: function queryParams(params) {      //传递参数（*）
            var queryData = {
                pageNumber: this.pageNumber,
                pageSize: this.pageSize,
            };
            return queryData;
        },
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 1,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 800,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        dataType: "json",                    //数据格式
        locale: "zh-CN",
        responseHandler: function (res) {          //获取返回的数据
            BootstrapTable.res = res;
            return res;
        },
        columns: [                          //表头（注意区分大小写）
            {checkbox: true},
            {
                field: 'ttt', title: '序号', align: "center", halign: 'center', width: 50,
                formatter: function (value, row, index) {
                    return (BootstrapTable.pageNumber - 1) * BootstrapTable.pageSize + 1 + index;
                }
            },
            {field: 'registrationtime', title: '上牌时间', halign: 'center', align: 'center'},
            {field: 'mileage', title: '表显里程', halign: 'center', align: 'center'},
            {field: 'transferrecord', title: '过户次数', halign: 'center', align: 'center'},
            {field: 'price', title: '车辆价格', halign: 'center', align: 'center'},
            {field: 'useproperties', title: '使用性质', halign: 'center', align: 'center'},
            {field: 'propertyright', title: '产权性质', halign: 'center', align: 'center'},
            {field: 'state', title: '车辆状态', halign: 'center', align: 'center'},
            // {field: 'userid', title: '用户', halign: 'center', align: 'center'},

            {field: 'exhCarDetailed.brand', title: '品牌', halign: 'center', align: 'center'},
            {field: 'exhCarDetailed.series', title: '车系', halign: 'center', align: 'center'},
            {field: 'exhCarDetailed.model', title: '车型', halign: 'center', align: 'center'},
            {
                field: 'sheetid', title: '操作', align: "center", halign: 'center', width: 300,
                formatter: function (value, row, index) {
                    var str = '<a class="btn btn-success" id="' + value + '" onclick="checkView(this)">查看</a>'+
                        '&nbsp;&nbsp;&nbsp;&nbsp;' +
                        '<a class="btn btn-success" id="' + value + '" onclick="checkAgree(this)">通过</a>' +
                        '&nbsp;&nbsp;&nbsp;&nbsp;' +
                        '<a class="btn btn-danger" id="' + value + '" onclick="checkRefuse(this)">拒绝</a>';
                    return str;
                }
            },
        ]
    });

};

/**
 * 审核
 */
BootstrapTable.checkQuery = function () {
    /**
     * 审核通过
     */
    checkAgree = function (msg) {
        if (confirm('确定审核通过吗？') === true) {
            $.ajax({
                url: $("#RootPath").val() + "/sysCheck/sysCheckAgree",     //请求地址
                type: "post",       //提交方式
                dataType: "json",   //
                async: false,       //异步
                data: {             //提交的数据
                    'sheetid':msg.id,
                },
                success: function (data) {    //成功返回
                    if (data){
                        alert("审核成功~车辆进入待售阶段");
                        location.reload();
                    }else {
                        alert("提交审核通过失败！");
                    }
                },
                error: function () {         //失败返回
                    alert("数据返回失败");
                }
            });
        }
    };

    /**
     * 审核不通过
     */
    checkRefuse = function (msg) {
        if (confirm('确定审核不通过吗？') === true) {
            //alert(msg.id);

            $.ajax({
                url: $("#RootPath").val() + "/exhCar/carCheckRefuse",     //请求地址
                type: "post",       //提交方式
                dataType: "json",   //
                async: false,       //异步
                data: {             //提交的数据
                    'sheetid':msg.id,
                },
                success: function (data) {    //成功返回
                    if (data){
                        alert("审核未~车辆进入审核未通过阶段");
                        location.reload();
                    }else {
                        alert("提交审核未通过失败！");
                    }
                },
                error: function () {         //失败返回
                    alert("数据返回失败");
                }
            });

        }
    }
};

/**
 * 检查是否选中
 */
BootstrapTable.check = function () {
    var selected = $('#tb_departments').bootstrapTable('getSelections');    //获取选中数据的数组
    if (selected.length == 0 || selected.length > 1) {
        alert("请先选中表格中的某一记录！");
        return false;
    } else {
        alert("已经选择了一条~~~");
        BootstrapTable.seItem = selected[0];
        return true;
    }
};

/**
 * 检查是否选中多条记录
 */
BootstrapTable.checks = function () {
    var selected = $('#tb_departments').bootstrapTable('getSelections');    //获取选中数据的数组
    var ids = [];   //存储相应字段的数组
    if (selected.length == 0) {
        alert("请至少选中一条记录！");
        return false;
    } else {
        alert("已经选择了一条或多条~~~")
        for (var i = 0, l = selected.length; i < l; i++) {
            var r = selected[i];
            ids.push(r.id);     //将每条信息对应的任意字段赋给数组
        }
        var eId = ids.join(',');
        BootstrapTable.seItemIds = eId;
        BootstrapTable.seItems = selected;
        return true;
    }
};

/**
 * 按钮操作
 */
BootstrapTable.initButton = function () {

};

/**
 * 查看
 * @param msg
 */
checkView = function (msg) {
    window.open($("#RootPath").val() + "/exhCar/toCarInformation/" + msg.id);
    // window.open($("#RootPath").val() + "/exhCar/toCarInformation/" + "c2cf8c663e144b73b65582b97691adb7");
    //alert(msg.id)
};

/**
 * 初始化
 */
$(function () {
    BootstrapTable.initTable();         //表格初始化
    BootstrapTable.initButton();        //按钮初始化
    BootstrapTable.checkQuery();
});
