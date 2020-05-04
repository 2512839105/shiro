
var progressInterval

/**
 * 创建进度条遮罩  设置定时器
 * @param workTime 预计执行完时间workTime 秒
 */
function createProgress(workTime) {
    //获取循环执行 间隔 ，预计执行完时间/90，默认300毫秒执行一次
    var interval = workTime ? workTime*1000/90 : 200
    var html = '<div class="progress progress-modal"><div id="progress" class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" style="min-width: 2em;">0%</div></div><div class="progress-overlay"></div>'
    $('body').append(html)
    var time = 0;
    progressInterval = setInterval(function () {
        time++;
        $("#progress").css('width',time+'%')
        $("#progress").text(time+'%')
        if(time==90){
            clearInterval(progressInterval)
        }
    },interval)
}

/**
 * 关闭进度条遮罩
 */
function clearProgress() {
    $(".progress").remove();
    $(".progress-overlay").remove()
    clearInterval(progressInterval)
}


/**
 * 导出父子表
 * @param table 主表
 * @param title 导出主表表名
 * @param url 明细url地址
 * @param tableDetail 明细表
 * @param column 导出表时显示隐藏列
 * @param primaryKey 对应单号字段
 */
function exportDetailList(table, title, url, tableDetail, column, primaryKey) {
    var selectedData = table.bootstrapTable('getAllSelections');
    if (selectedData.length > 0) {
        $.each(selectedData, function (index, item) {
            delete item.id;
        });
        var jsonData = {"total": selectedData.length, "rows": selectedData};
        var rows = jsonData.rows;
        var urlData = ""
        var data = new Array();
        for(var inx in rows) {
            var param = new Object();
            param.name = primaryKey;
            param.value = rows[inx][primaryKey];
            data.push(param);
        }
        //发送请求，获取所有主表对应的明细数据
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            success: function (json) {
                tableDetail.bootstrapTable('showColumn',column)
                tableDetail.bootstrapTable('load', json);
                tableDetail.tableExport({
                    type: 'excel',
                    fileName: title + "明细"
                });
                tableDetail.bootstrapTable('hideColumn',column)
                tableDetail.bootstrapTable('refresh');
            }
        });
        table.bootstrapTable('load', jsonData);
        table.tableExport({
            type: 'excel',
            fileName: title
        });
    } else {
        var allData = table.bootstrapTable('getData');
        if (allData.length == 0) {
            msgAlert("提示", "当前页面没有数据", "warning");
            return;
        }
        msgConfirm("提示", "导出当前页面所有数据,\n一次最多可导出1000条数据,选择每页显示\'1000\'条记录", function () {
            var jsonData = {"total": allData.length, "rows": allData};
            var rows = jsonData.rows;
            var urlData = ""
            var data = new Array();
            for(var inx in rows) {
                var param = new Object();
                param.name = primaryKey;
                param.value = rows[inx][primaryKey];
                data.push(param);
            }
            //发送请求，获取所有主表对应的明细数据
            $.ajax({
                url: url,
                type: "POST",
                data: data,
                success: function (json) {
                    tableDetail.bootstrapTable('showColumn',column)
                    tableDetail.bootstrapTable('load', json);
                    tableDetail.tableExport({
                        type: 'excel',
                        fileName: title + "明细"
                    });
                    tableDetail.bootstrapTable('hideColumn',column)
                    tableDetail.bootstrapTable('refresh');
                }
            });
            table.bootstrapTable('load', jsonData);
            table.tableExport({
                type: 'excel',
                fileName: title
            });
        })
    }
    table.bootstrapTable('refresh');
}