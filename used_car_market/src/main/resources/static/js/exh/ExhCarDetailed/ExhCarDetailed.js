var ExhCarDetailed = {
    id: "ExhCarDetailedTable",    //表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    pageSize: 20,        //每页获取的条数
    pageNumber: 1,       //页数
    seItemIds: null,    //选中多行数据的id
};

/**
 * 初始化table
 */
ExhCarDetailed.initTable = function () {
    $('#ExhCarDetailedTable').bootstrapTable({
        url: '/exhCarDetailed/list',         //请求后台的URL（*）
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
       // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
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
        //data:[{'id':'111','name':'222','level':'333','desc':'4444'}],   //不使用url，可以使用假数据
        columns: [                          //表头（注意区分大小写）
            {checkbox: true},
            {
                field:'ttt',title: '序号', align: "center", halign: 'center', width: 50, formatter: function (value, row, index) {
                    return (ExhCarDetailed.pageNumber - 1) * ExhCarDetailed.pageSize + 1 + index;
                }
            },
            {field: 'brand', title: '品牌', halign: 'center', align: 'center'},
            {field: 'series', title: '车系', halign: 'center', align: 'center'},
            {field: 'model', title: '车型', halign: 'center', align: 'center'},
            {field: 'maunfaturer', title: '厂商', halign: 'center', align: 'center'},
            {field: 'level', title: '等级', halign: 'center', align: 'center'},
            {field: 'engine', title: '发动机', halign: 'center', align: 'center'},
            {field: 'gearbox', title: '变速箱', halign: 'center', align: 'center'},
            {field: 'size', title: '尺寸', halign: 'center', align: 'center'},
            {field: 'structure', title: '车身结构', halign: 'center', align: 'center'},
            {field: 'emissionstandard', title: '排放标准', halign: 'center', align: 'center'},
            {field: 'displacement', title: '排量', halign: 'center', align: 'center'},
            {field: 'fueltype', title: '燃油类型', halign: 'center', align: 'center'},
        ],

    });
};

/**
 * 检查是否选中
 */
ExhCarDetailed.check = function () {
    var selected = $('#ExhCarDetailedTable').bootstrapTable('getSelections');    //获取选中数据的数组
    if (selected.length == 0 || selected.length > 1) {
        alert("请先选中表格中的某一记录！");
        return false;
    } else {
        alert("已经选择了一条~~~");
        ExhCarDetailed.seItem = selected[0];
        return true;
    }
};

/**
 * 检查是否选中多条记录
 */
ExhCarDetailed.checks = function () {
    var selected = $('#ExhCarDetailedTable').bootstrapTable('getSelections');    //获取选中数据的数组
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
        ExhCarDetailed.seItemIds = eId;
        ExhCarDetailed.seItems = selected;
        return true;
    }
};

/**
 * 按钮操作
 */
ExhCarDetailed.initButton = function () {
    /**
     * 添加按钮
     */
    $("#btn_add").click(function () {
        window.location.href = $("#RootPath").val() + "/exhCarDetailed/toAdd";
        //window.location.href = $("#RootPath").val() + "/exhCar/toExhCarAdd";
    });

    /**
     * 修改按钮
     */
    $("#btn_edit").click(function () {
        ExhCarDetailed.checks();
    });

    /**
     * 删除按钮
     */
    $("#btn_delete").click(function () {
        // var k = ExhCarDetailed.checks();
            alert('请前往车辆管理进行删除操作~');
            window.location.href = $("#RootPath").val() + "/exhCar/toExhCar";

    });
};

/**
 * 初始化
 */
$(function () {
    ExhCarDetailed.initTable();         //表格初始化
    ExhCarDetailed.initButton();        //按钮初始化
});
