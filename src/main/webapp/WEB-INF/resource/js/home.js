var priceFlag = 0, startTime = '', endTime = '';


$(function () {
    queryAll(priceFlag);

    $("#shouRu").click(function () {
        priceFlag = $('#shouRu').attr('data-value');
        queryAll(priceFlag);
        $("#shouRu").addClass('leixing');
        $("#zhiChu").removeClass('leixing');
        $('#startTime').val('');
        $('#endTime').val('');

    });

    $("#zhiChu").click(function () {
        priceFlag = $('#zhiChu').attr('data-value');
        queryAll(priceFlag);
        $("#zhiChu").addClass('leixing');
        $("#shouRu").removeClass('leixing');
        $('#startTime').val('');
        $('#endTime').val('');
    });

    $('#searchQuery').click(function () {
        startTime = $('#startTime').val();
        endTime = $('#endTime').val();
        queryBySearch(priceFlag, startTime, endTime);
    });


    var thisDialog = $('#dialog').dialog({
        autoOpen: false,
        modal: true
    });
    $("#addShouZhang").click(function () {
        $('#addTime').fdatepicker({format: 'yyyy-mm-dd', pickTime: false});
        $("#dialog").dialog("open");
        $("#dSure").click(function () {
            addShouZhang();
            thisDialog.dialog("close");
        });
        $("#dClose").click(function () {
            thisDialog.dialog("close");
        });
    });

    $('#delShouZhang').click(function () {
        var ids = [];
        $("table input:checkbox").each(function () {
            if ($(this)[0].checked == true) {
                ids.push($(this)[0].dataset.id);
            }
        });
        delShouZhang(ids);
    });


    $('#startTime').fdatepicker({format: 'yyyy-mm-dd', pickTime: false});
    $('#endTime').fdatepicker({format: 'yyyy-mm-dd', pickTime: false});

    //鼠标事件
    $('#shouRu').hover(function () {
        if (!$('#shouRu').hasClass('leixing')) {
            $('#shouRu').css('color', '#ca963b');
        }
    }, function () {
        $('#shouRu').css('color', '');
    });

    $('#zhiChu').hover(function () {
        if (!$('#zhiChu').hasClass('leixing')) {
            $('#zhiChu').css('color', '#ca963b');
        }
    }, function () {
        $('#zhiChu').css('color', '');
    });

});


function delShouZhang(ids) {
    $.ajax({
        url: '/deleteZD',
        traditional: true,
        data: {
            ids: ids,
            priceFlag: priceFlag
        },
        type: 'post',
        dateType: 'json',
        success: function (data) {
            queryBySearch(priceFlag, startTime, endTime);

        }

    })
}

function queryBySearch(priceFlag, startTime, endTime) {
    $.ajax({
        url: '/queryBySearch',
        data: {
            priceFlag: priceFlag,
            startTime: startTime,
            endTime: endTime
        },
        type: 'post',
        dateType: 'json',
        success: function (data) {
            if (data) {
                var html = template('allZhangDanTpl', {list: data});
                $('#allZhangDanHtml').html(html);
            }
        }

    });
}

function queryAll(priceFlag) {
    $.ajax({
        url: '/queryAll',
        data: {
            pageSize: 0,
            pageNum: 10,
            lFlag: priceFlag
        },
        type: 'get',
        dateType: 'JSON',
        success: function (data) {
            if (data) {
                var dataList = data.pageInfo.list;
                var html = template('allZhangDanTpl', {list: dataList});
                $('#allZhangDanHtml').html(html);
            }
        }

    })
}

function addShouZhang() {
    var data = {
        "price": $('#addPrice').val(),
        "goodsName": $('#addName').val(),
        "billType": $('input[name=leiFlag]').val(),
        "billTime": $('#addTime').val(),
        "remark": $('#addMark').val()
    }

    $.ajax({
        url: '/saveZD',
        data: {
            data: JSON.stringify(data)
        },
        type: 'post',
        dateType: 'json',
        success: function (data) {
            if (data) {
                queryAll();
            }
        }

    })
}
