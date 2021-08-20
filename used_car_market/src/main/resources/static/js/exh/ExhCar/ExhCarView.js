var ExhCarView = {
    pageSize: 20,        //每页获取的条数
    pageNumber: 1,       //页数
    res: null,
    condeiton:''        //筛选的条件
};


/**
 * 初始化视图
 */
ExhCarView.initView = function () {
    /**
     * 初次条件查询
     */
    ExhCarView.queryData();
};

/**
 * 初始化查询条件点击事件
 */
ExhCarView.queryClick = function(){
    /**
     * 点击品牌
     */
    brandClick = function(msg){
        //获取车系
        $.ajax({
            url: $("#RootPath").val() + "/exhCar/getCarSeries",     //请求地址
            type: "post",       //提交方式
            dataType: "json",   //
            async: false,       //异步
            data: {             //提交的数据
                'brand':msg.id,
                'series':0,
                'model':0
            },
            success:function (data) {    //成功返回
                //点击品牌时去除筛选框中的车系
                if ($("#car-series") !== null){
                    //车系删除
                    $("#car-series").remove();
                }
                var str = '';
                for (var i = 0 ; i < data.length ; i++){
                    str += "<li value='"+data[i].dicttypecode+"' onclick='seriesClick(this)'><a href='#'>"+data[i].dicttypename+"</a></li>"
                }
                $("#series").html(str);
            },
            error:function () {         //失败返回
                alert("数据返回失败");
            }
        });
        //添加到条件筛选框中
        ExhCarView.addCondition(msg);
        //查询数据
        ExhCarView.queryData();
    };

    /**
     * 点击车系
     */
    seriesClick = function (msg) {
        //将所选的条件放入条件筛选中
        ExhCarView.addCondition(msg);
        //查询数据
        ExhCarView.queryData();
    };

    /**
     * 点击价格区间
     */
    priceClick = function (msg) {
        if (msg.id === 'priceSub'){
            msg.attributes['value'].value = 'price';
            msg.innerText = $('#minPrice').val() + '-' + $('#maxPrice').val() + '万';
        }
        //将所选的条件放入条件筛选中
        ExhCarView.addCondition(msg);
        //查询数据
        ExhCarView.queryData();
    };

    /**
     * 点击车龄
     */
    vehicleAgeChange = function (msg) {
        //获取当前选中的对象
        let optionSelected = msg.options[msg.selectedIndex];
        //选中选项的value
        let optionValue = optionSelected.innerText;
        //选择了车龄默认选项
        if (optionValue === '车龄'){
            //如果选择了车龄选项，删除筛选框中的相应选项
            ExhCarView.removeCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }else {     //选择了其他选项
            //将所选的条件放入条件筛选中
            ExhCarView.addCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }
    };

    /**
     * 点击里程
     */
    mileageChange = function (msg) {
        //获取当前选中的对象
        let optionSelected = msg.options[msg.selectedIndex];
        //选中选项的value
        let optionValue = optionSelected.innerText;
        //选择了车龄默认选项
        if (optionValue === '里程'){
            //如果选择了车龄选项，删除筛选框中的相应选项
            ExhCarView.removeCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }else {     //选择了其他选项
            //将所选的条件放入条件筛选中
            ExhCarView.addCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }
    };

    /**
     * 点击使用性质
     */
    usepropertiesChange = function (msg) {
        //获取当前选中的对象
        let optionSelected = msg.options[msg.selectedIndex];
        //选中选项的value
        let optionValue = optionSelected.innerText;
        //选择了使用性质默认选项
        if (optionValue === '使用性质'){
            //如果选择了使用性质选项，删除筛选框中的相应选项
            ExhCarView.removeCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }else {     //选择了其他选项
            //将所选的条件放入条件筛选中
            ExhCarView.addCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }
    };

    /**
     * 点击产权性质
     */
    propertyrightChange = function (msg) {
        //获取当前选中的对象
        let optionSelected = msg.options[msg.selectedIndex];
        //选中选项的value
        let optionValue = optionSelected.innerText;
        //选择了产权性质默认选项
        if (optionValue === '产权性质'){
            //如果选择了使用产权性质，删除筛选框中的相应选项
            ExhCarView.removeCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }else {     //选择了其他选项
            //将所选的条件放入条件筛选中
            ExhCarView.addCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }
    };

    /**
     * 点击车辆等级
     * @param msg
     */
    levelChange = function (msg) {
        //获取当前选中的对象
        let optionSelected = msg.options[msg.selectedIndex];
        //选中选项的value
        let optionValue = optionSelected.innerText;
        //选择了车辆等级默认选项
        if (optionValue === '车辆等级'){
            //如果选择了车辆等级，删除筛选框中的相应选项
            ExhCarView.removeCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }else {     //选择了其他选项
            //将所选的条件放入条件筛选中
            ExhCarView.addCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }
    };

    /**
     * 点击排放标准
     * @param msg
     */
    emissionstandardChange = function (msg) {
//获取当前选中的对象
        let optionSelected = msg.options[msg.selectedIndex];
        //选中选项的value
        let optionValue = optionSelected.innerText;
        //选择了车辆等级默认选项
        if (optionValue === '排放标准'){
            //如果选择了车辆等级，删除筛选框中的相应选项
            ExhCarView.removeCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }else {     //选择了其他选项
            //将所选的条件放入条件筛选中
            ExhCarView.addCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }
    };

    /**
     * 点击燃油类型
     * @param msg
     */
    fueltypeChange = function (msg) {
        //获取当前选中的对象
        let optionSelected = msg.options[msg.selectedIndex];
        //选中选项的value
        let optionValue = optionSelected.innerText;
        //选择了车龄默认选项
        if (optionValue === '燃油类型'){
            //如果选择了车龄选项，删除筛选框中的相应选项
            ExhCarView.removeCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }else {     //选择了其他选项
            //将所选的条件放入条件筛选中
            ExhCarView.addCondition(optionSelected);
            //查询数据
            ExhCarView.queryData();
        }
    }


};

/**
 * 添加到当前条件筛选
 * @param msg
 */
ExhCarView.addCondition = function(msg){
    //筛选条件框ul
    let screenCondition = document.getElementById('screenCondition');
    //ul下的li
    var li = screenCondition.getElementsByTagName('li');
    //别的长度
    var length = screenCondition.getElementsByTagName('li').length;
    for (var i = 0 ; i < length ; i++){
        //条件筛选中对应li的value值
        var liValue = li[i].id;
        //将要放入筛选条件的id值（例如：'car-brand'）
        var msgValue = msg.attributes['value'].value;

        //如果两个id一样，则删除条件筛选中的id值对应的li（例如：两个id都是car-brand，但品牌的查询条件只能由一个，所以要将筛选条件中的那个删除）
        if (liValue === msgValue){
            //删除相同类型的
            screenCondition.children[i].remove();
            break;
        }
    }
    //向筛选条件（ul）中添加一个新的选项（li）
    var pLi = document.createElement('li');
    //pLi.innerText = msg.innerText;
    pLi.id = msg.attributes['value'].value;
    pLi.innerHTML = "<a href='#'>"+msg.innerText+"<span class='glyphicon glyphicon-remove' style='padding-left: 10px'></span></a>";
    screenCondition.appendChild(pLi);
};

/**
 * 从当前条件筛选中删除一个条件选项
 * @param msg
 */
ExhCarView.removeCondition = function(msg){
    //筛选条件框ul
    let screenCondition = document.getElementById('screenCondition');
    //ul下的li
    var li = screenCondition.getElementsByTagName('li');
    //别的长度
    var length = screenCondition.getElementsByTagName('li').length;
    for (var i = 0 ; i < length ; i++){
        //条件筛选中对应li的value值
        var liValue = li[i].id;
        //将要放入筛选条件的id值（例如：'car-brand'）
        var msgValue = msg.attributes['value'].value;
        //如果两个id一样，则删除条件筛选中的id值对应的li（例如：两个id都是car-brand，但品牌的查询条件只能由一个，所以要将筛选条件中的那个删除）
        if (liValue === msgValue){
            //删除相同类型的
            screenCondition.children[i].remove();
            break;
        }
    }
};



/**
 * 条件查询
 */
ExhCarView.queryData = function(){
    var brand = '';         //品牌
    var series = '';        //车系
    var price = '';         //价格
    var vehicleAge = '';    //车龄
    var mileage = '';       //里程
    var useproperties = ''; //使用性质
    var propertyright = ''; //产权性质
    var level = '';         //车辆等级
    var emissionstandard = '';  //排放标准

    var fueltype = '';      //燃油类型
    //筛选条件框ul
    let screenCondition = document.getElementById('screenCondition');
    //ul下的li
    var li = screenCondition.getElementsByTagName('li');
    //别的长度
    var length = screenCondition.getElementsByTagName('li').length;
    for (var i = 0 ; i < length ; i++){
        //条件筛选中对应li的value值
        var liValue = li[i].id;
        if ('car-brand' === liValue){
            brand = li[i].innerText;
        }else if ('car-series' === liValue){
            series = li[i].innerText;
        }else if ('price' === liValue){
            price = li[i].innerText;
        }else if ('vehicleAge' === liValue){
            vehicleAge = li[i].innerText;
        }else if ('mileage' === liValue){
            mileage = li[i].innerText;
        }else if ('car-useproperties' === liValue){
            useproperties = li[i].innerText;
        }else if ('car-propertyright' === liValue){
            propertyright = li[i].innerText;
        }else if ('car-level' === liValue){
            level = li[i].innerText;
        }else if ('car-emissionstandard' === liValue){
            emissionstandard = li[i].innerText;
        }else if ('fueltype' === liValue){
            fueltype = li[i].innerText;
        }
    }
    //从后台取数据
    $.ajax({
        url: $("#RootPath").val() + "/exhCar/exhCarViewList",     //请求地址
        type: "post",       //提交方式
        dataType: "json",
        async: false,       //异步
        data: {
            'brand':brand,          //品牌
            'series':series,        //车系
            'price':price,          //价格
            'vehicleAge':vehicleAge,    //车龄
            'mileage':mileage,          //里程
            'useproperties':useproperties,  //使用性质
            'propertyright':propertyright,  //产权性质
            'level':level,          //车辆等级
            'emissionstandard':emissionstandard,    //排放标准
            'fueltype':fueltype,    //燃油类型
        },
        success: function (data) {    //成功返回
            //清空页面
            var d = document.getElementById("view").getElementsByTagName("div");
            for(var i=0;i<d.length;i++){
                d[i].innerHTML='';
            }
            //需要生成的行数
            // var linesCount = parseInt(data.length / 4) + 1;
            var linesCount = data.length === 4?1:parseInt(data.length / 4) + 1;
            //最后一行的列数
            var colsEnd = data.length % 4 === 0 ? 4 : data.length % 4;
            //当前所在数据的位置
            var nowPosition = 0;

            //用于动态生成的字符串
            var str = '';
            if (data.length > 0 ){      //只有在返回的数据条数大于0时才形成视图
                //确定返回数据的条数与生成视图中的数据条数是否相同
                if (data.length !== linesCount*4 + colsEnd -4){
                    //alert("生成数据长度与页面数据数量不同！将对最后一行的数据进行强制清零！");
                    colsEnd = 0;
                }
                //生成视图
                for (var i = 0; i < linesCount; i++) { //遍历行数
                    if (i === linesCount - 1) {  //到最后一行了
                        str +=
                            "<div class='row' style='border:0px solid #000'>";
                        for (var j = 0; j < colsEnd; j++) {    //遍历列数
                            str +=
                                "<div class='col-sm-3 bg_car' id='"+data[nowPosition].sheetid+"' onclick='ExhCarView.picture(this)' onmouseover='picturesOver(this)' onmouseleave='picturesLeave(this)'>" +
                                "<br/>" +
                                "<div class='car_img' style='height: 70%;width: 100%;'>" +
                                "<img class='img-rounded' style='height:100%;width: 100%;' src=" + $("#RootPath").val() + data[nowPosition].exhPicturesList[0].path + ">" +
                                "</div>" +
                                "<div style='height: 30%;width: 100%;padding: 10px 10px'>" +
                                "<span class='car_brand'>" + data[nowPosition].exhCarDetailed.brand + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_series'>" + data[nowPosition].exhCarDetailed.series + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_model'>" + data[nowPosition].exhCarDetailed.model + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<br/>" +
                                "<span class='car_useproperties'>" + data[nowPosition].useproperties + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_propertyright'>" + data[nowPosition].propertyright + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_mileage'>" + data[nowPosition].mileage + "</span>万公里&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_level'>" + data[nowPosition].exhCarDetailed.level + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<br/>" +
                                "<span class='car_price'>" + "全款：" + data[nowPosition].price + "&nbsp;万元</span>&nbsp;&nbsp;&nbsp;" +
                                "<br/>" +
                                "<span class='car_registrationtime'>" + "上牌日期：" + data[nowPosition].registrationtime + "</span>" +
                                "</div>" +
                                "</div>";
                            nowPosition++;
                        }
                        str += "</div>"
                    } else {                 //没到最后一行
                        str += "<div class='row' style='border:0px solid #000'>";
                        for (var j = 0; j < 4; j++) {      //遍历列数
                            str +=
                                "<div class='col-sm-3 bg_car' id='"+data[nowPosition].sheetid+"' onclick='ExhCarView.picture(this)' onmouseover='picturesOver(this)' onmouseleave='picturesLeave(this)'>" +
                                "<br/>" +
                                "<div class='car_img' style='height: 70%;width: 100%;'>" +
                                "<img class='img-rounded' style='height:100%;width: 100%;' src=" + $("#RootPath").val() + data[nowPosition].exhPicturesList[0].path + ">" +
                                "</div>" +
                                "<div style='height: 30%;width: 100%;padding: 10px 10px'>" +
                                "<span class='car_brand'>" + data[nowPosition].exhCarDetailed.brand + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_series'>" + data[nowPosition].exhCarDetailed.series + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_model'>" + data[nowPosition].exhCarDetailed.model + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<br/>" +
                                "<span class='car_useproperties'>" + data[nowPosition].useproperties + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_propertyright'>" + data[nowPosition].propertyright + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_mileage'>" + data[nowPosition].mileage + "</span>万公里&nbsp;&nbsp;&nbsp;" +
                                "<span class='car_level'>" + data[nowPosition].exhCarDetailed.level + "</span>&nbsp;&nbsp;&nbsp;" +
                                "<br/>" +
                                "<span class='car_price'>" + "全款：" + data[nowPosition].price + "&nbsp;万元</span>&nbsp;&nbsp;&nbsp;" +
                                "<br/>" +
                                "<span class='car_registrationtime'>" + "上牌日期：" + data[nowPosition].registrationtime + "</span>" +
                                "</div>" +
                                "</div>";
                            nowPosition++;
                        }
                        str += "</div>"
                    }
                }
            }
            $("#view").append(str);
        },
        error: function () {         //失败返回
            alert("数据返回失败");
        }
    });

};

/**
 * 筛选框点击删除
 */
ExhCarView.condeitonClick = function(){
    //点击当前的已经筛选的条件，删除
    $('#screenCondition').delegate("li","click",function(){
        //如果点击车辆品牌，将一起删除车系
        if (this.id === 'car-brand'){
            //车系删除
            $("#car-series").remove();
        }
        //如果点击车龄筛选框，将会把车龄查询框置默认“车龄”
        if (this.id === 'vehicleAge'){
            //根据选项的显示值进行默认选中
            //获取下拉框对象
            let vehicleAgeSelect = document.getElementById('vehicleAgeSelect');
            //获取下拉框选项
            let selected = vehicleAgeSelect.getElementsByTagName('option');
            //选中选项
            selected[0].selected = true;
        }
        //如果点击里程筛选框，将会把里程查询框置默认“里程”
        if (this.id === 'mileage'){
            //根据选项的显示值进行默认选中
            //获取下拉框对象
            let vehicleAgeSelect = document.getElementById('mileageSelect');
            //获取下拉框选项
            let selected = vehicleAgeSelect.getElementsByTagName('option');
            //选中选项
            selected[0].selected = true;
        }
        //如果点击使用性质筛选框，将会把使用性质查询框置默认“使用性质”
        if (this.id === 'car-useproperties'){
            //根据选项的显示值进行默认选中
            //获取下拉框对象
            let vehicleAgeSelect = document.getElementById('usepropertiesSelect');
            //获取下拉框选项
            let selected = vehicleAgeSelect.getElementsByTagName('option');
            //选中选项
            selected[0].selected = true;
        }
        //如果点击产权性质筛选框，将会把产权性质查询框置默认“产权性质”
        if (this.id === 'car-propertyright'){
            //根据选项的显示值进行默认选中
            //获取下拉框对象
            let vehicleAgeSelect = document.getElementById('propertyrightSelect');
            //获取下拉框选项
            let selected = vehicleAgeSelect.getElementsByTagName('option');
            //选中选项
            selected[0].selected = true;
        }
        //如果点击车辆等级筛选框，将会把车辆等级查询框置默认“车辆等级”
        if (this.id === 'car-level'){
            //根据选项的显示值进行默认选中
            //获取下拉框对象
            let vehicleAgeSelect = document.getElementById('levelSelect');
            //获取下拉框选项
            let selected = vehicleAgeSelect.getElementsByTagName('option');
            //选中选项
            selected[0].selected = true;
        }
        //如果点击排放标准筛选框，将会把车辆等级查询框置默认“排放标准”
        if (this.id === 'car-emissionstandard'){
            //根据选项的显示值进行默认选中
            //获取下拉框对象
            let vehicleAgeSelect = document.getElementById('emissionstandardSelect');
            //获取下拉框选项
            let selected = vehicleAgeSelect.getElementsByTagName('option');
            //选中选项
            selected[0].selected = true;
        }
        //如果点击燃油类型筛选框，将会把燃油类型查询框置默认“燃油类型”
        if (this.id === 'fueltype'){
            //根据选项的显示值进行默认选中
            //获取下拉框对象
            let vehicleAgeSelect = document.getElementById('fueltypeSelect');
            //获取下拉框选项
            let selected = vehicleAgeSelect.getElementsByTagName('option');
            //选中选项
            selected[0].selected = true;
        }

        this.remove();
        //this.parentNode.removeChild(this)
        //根据当前的筛选条件进行查询
        ExhCarView.queryData();
    });
};

/**
 * 跳转到车辆详情页
 */
ExhCarView.picture = function(msg){
    //打开另一个新页面
    window.open($("#RootPath").val() + "/exhCar/toCarInformation/" + msg.id);
};

/**
 * 光标选择的样式
 */
ExhCarView.mouseSelectStyle = function(){
    /**
     * 鼠标悬浮在图片上
     * @param msg
     */
    picturesOver = function (msg) {
        var d = msg.style;
        d.backgroundColor = 'rgba(119,247,236,0.22)';
        d.borderRadius = '10px';
        d.cursor = 'pointer';
    };

    /**
     * 鼠标离开图片
     * @param msg
     */
    picturesLeave = function (msg) {
        msg.style.backgroundColor = '#dee2e6';
    };
};


/**
 * 初始化
 */
$(function () {
    ExhCarView.initView();      //初始化页面
    ExhCarView.queryClick();    //初始化查询框点击事件
    ExhCarView.condeitonClick();    //初始化筛选框点击删除
    ExhCarView.mouseSelectStyle();  //初始化光标选择的样式
});
