var prefix = "/fpgl/fpcx"

$(function() {
		var columns = [{
            checkbox: true
        },
        {
            field: 'id',
            title: '主键',
            visible:false
        },
        {
            field: 'fpdm',
            title: '发票代码'
        },
        {
            field: 'fphm',
            title: '发票号码'
        },
        {
            field: 'gfmc',
            title: '购方名称'
        },
        {
            field: 'xfmc',
            title: '销方名称'
        },
        {
            field: 'bz',
            title: '备注'
        },
        {
            field: 'zfbz',
            title: '作废标志',
            align: 'center',
            formatter: function(value, row, index) {
                if (value == 1) {
                    return '<span class="label label-danger">作废</span>';
                } else {
                    return '<span class="label label-success">正常</span>';
                }
            }
        },
        {
            field: 'kprq',
            title: '开票日期'
        },
        {
            title: '操作',
            align: 'center',
            formatter: function(value, row, index) {
            	var actions = [];
            	actions.push('<a class="btn btn-warning btn-sm" href="#" title="详细信息" onclick="detail(\'' + row.id + '\')"><i class="fa fa-search"></i></a>');
            	return actions.join('');
            }
        }];
	var url = prefix + "/list";
	$.initTable(columns, url);
});

/*操作日志-详细*/
function detail(id) {
    var url = prefix + '/detail/' + id;
    layer_show("发票详情", url, '1000', '600');
}

// 批量删除
function batchRemove() {
	var rows = $.getSelections("operId");
	if (rows.length == 0) {
		$.modalMsg("请选择要删除的数据", "warning");
		return;
	}
	$.modalConfirm("确认要删除选中的" + rows.length + "条数据吗?", function(r) {
		_ajax(prefix + '/batchRemove', { "ids": rows }, "post", r);
	});
}