function selectCompany(id) {
    selectCompanyByTap($("#companyName"), id);
}

function selectStore(storeId, storeName) {
    selectStoreByTag($("#companyName"), $("#storeName"), storeId, storeName);
}

function selectStoreName(storeId, storeName) {
    selectStoreNameByTag($("#companyName"), $("#storeName"), storeId, storeName);
}

function selectCompanyByTap(companyTag, id, storeName) {
    var hasSelected = false;
    $.ajax({
        url: "../../../system/company/listSelect.action",
        type: "post",
        dataType: "json",
        success: function (json) {
            if (json.statusCode == 200) {
                if (json.rows.length > 0) {
                    for (i = 0; i < json.rows.length; i++) {
                        var companyId = json.rows[i].companyId;
                        if (id && id == companyId) {
                            hasSelected = true;
                            companyTag.append("<option value='" + json.rows[i].companyId + "' selected>" + json.rows[i].companyName + "</option>");
                        } else {
                            companyTag.append("<option value='" + json.rows[i].companyId + "'>" + json.rows[i].companyName + "</option>");
                        }
                    }
                    companyTag.selectpicker('refresh');
                    companyTag.selectpicker('render');

                    if (hasSelected) {
                        companyTag.attr("disabled", true);
                    }
                }
            }
        }
    });
}

function selectStoreByTag(companyTag, storeTag, storeId, storeName) {
    if(storeId){
        storeTag.append("<option value='" + storeId + "' selected>" + storeName + "</option>");
    }else {
        companyTag.change(function () {
            initStoreSelectByCompanyId(storeTag, storeId, $(this).val());
        })
    }
}

function initStoreSelectByCompanyId(storeTag, storeId, companyId) {
    storeTag.empty();
    $.ajax({
        url: "../../../system/store/listByCompanyId.action",
        data: {"companyId": companyId},
        type: "post",
        dataType: "json",
        success: function (json) {
            storeTag.append("<option value=''>请选择</option>");
            if(json.rows && json.rows.length > 0){
                $.each(json.rows, function (i, obj) {
                    if(storeId == obj.storeId){
                        storeTag.append("<option value='" + obj.storeId + "' selected>" + obj.storeName + "</option>");
                    }else {
                        storeTag.append("<option value='" + obj.storeId + "'>" + obj.storeName + "</option>");
                    }
                })
            }
            storeTag.selectpicker('refresh');
            storeTag.selectpicker('render');
        }
    });
}


//-选择的值为名称-------------------------------------------------------------------------------------
function selectStoreNameByTag(companyTag, storeTag, storeId, storeName) {
    if(storeId){
        storeTag.append("<option value='" + storeName + "' selected>" + storeName + "</option>");
    }else {
        companyTag.change(function () {
            initStoreNameSelectByCompanyId(storeTag, storeId, $(this).val());
        })
    }
}

function initStoreNameSelectByCompanyId(storeTag, storeId, companyId) {
    storeTag.empty();
    $.ajax({
        url: "../../../system/store/listByCompanyId.action",
        data: {"companyId": companyId},
        type: "post",
        dataType: "json",
        success: function (json) {
            storeTag.append("<option value=''>请选择</option>");
            if(json.rows && json.rows.length > 0){
                $.each(json.rows, function (i, obj) {
                    if(storeId == obj.storeId){
                        storeTag.append("<option value='" + obj.storeName + "' selected>" + obj.storeName + "</option>");
                    }else {
                        storeTag.append("<option value='" + obj.storeName + "'>" + obj.storeName + "</option>");
                    }
                })
            }
            storeTag.selectpicker('refresh');
            storeTag.selectpicker('render');
        }
    });
}