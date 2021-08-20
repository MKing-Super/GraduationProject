CarInformation = {};
/**
 * 车辆轮播图
 */
CarInformation.initCarousel = function () {
    // 初始化自动轮播
    $("#carPictures").carousel('cycle');
    // 循环轮播到上一个项目
    $(".prev-slide").click(function () {
        $("#carPictures").carousel('prev');
    });
    // 循环轮播到下一个项目
    $(".next-slide").click(function () {
        $("#carPictures").carousel('next');
    });
};

/**
 * 按钮
 */
CarInformation.initButton = function(){
    /**
     * 初始化“收藏”按钮
     */
    $.ajax({
        url:"/userCollections/collectButton",
        dataType:"json",
        type:"post",
        data:{
            'exhCarSheetid':$("#exhCarSheetid").val()
        },
        success:function (data) {
            switch (data.state) {
                case '0':       //收藏表中已经有这条数据了
                    document.getElementById('collect').className = 'btn btn-warning btn-lg';
                    document.getElementById('collect').innerText = '已收藏';
                    break;
                case '1':       //收藏表中没有这条数据
                case '403':     //用户未登录
                    break;
                default:        //后天代码返回数据出错
                    alert("返回了未知数据！！！")
            }
        },
        error:function (date) {
            alert("AJAX返回数据失败！！！");
        }
    });


};

/**
 * 点击函数
 */
CarInformation.initClick = function () {
    /**
     * 点击收藏车辆
     */
    collectClick = function (msg) {
        $.ajax({
            url:"/userCollections/userCollectionsAdd",
            dataType:"json",
            type:"post",
            data:{
                'exhCarSheetid':$("#exhCarSheetid").val()
            },
            success:function (data) {
                switch (data.state) {
                    case '403':     //用户未登录
                        alert(data.msg);
                        break;
                    case '0':       //已经删除了数据库中的信息
                        msg.className = 'btn btn-info btn-lg';
                        msg.innerText = '我要收藏';
                        break;
                    case '1':       //成功插入收藏表
                        msg.className = 'btn btn-warning btn-lg';
                        msg.innerText = '已收藏';
                        break;
                    case '500':     //数据插入失败
                        alert(data.msg);
                        break;
                    default:        //后天代码返回数据出错
                        alert("返回了未知数据！！！")
                }
            },
            error:function (date) {
                alert("AJAX返回数据失败！！！");
            }
        });
    };

};

$(function () {
    CarInformation.initCarousel();      //车辆轮播图初始化
    CarInformation.initButton();
    CarInformation.initClick();        //按钮初始化
});