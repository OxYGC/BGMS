
$(document).ready(function () {
	initTableConfig();
	autoLoadDataTable();
	//定时任务
	setInterval(function () {
		autoLoadDataTable();
	},2000)
})

function autoLoadDataTable(){
	//如果有不同的table需要刷新,直接添加不同的URL数据源和不同的ID标签就可以了
	RefreshTable('#datatables', base_url + '/page1/getDatas');
}

//配置DataTables
function initTableConfig(){
	$('#datatables').DataTable({
		"paging":   false,
		"ordering": false,
		"info":     false,
		"searching":false,
		"ordering":false,
		columns: [
			{data: 'id' , title:'ID' },
			{ data: 'ip' , title:'是否正常', "visible": false},
			{
				data: 'port' ,
				title:'服务地址',
				render: function (data,type,row) {
					// console.log('data'+data+'type'+type+'row'+row+'rowid'+row.id);
					var ip = row.ip;
					var port = row.port;
					return '<td> '+ip+':'+port+'</td>';
				}
			},
			{ data: 'isLined' , title:'是否正常'},
			{ data: 'online' , title:'是否在线'},
			{ data: 'iafStatus' , title:'IAF状态'},
			{
				// data: 'iafStatus',
				title:'操作',
				render: function (data,type,row) {
					var ip = row.ip;
					var port = row.port;
					return '<td> <button class="btn btn-danger btn-xs"  onclick ="online(this)" style="width:40%"  ip = "'+row.ip+'" port = "'+row.port+'">上线</button>' +
						'<button class="btn btn-danger btn-xs"  onclick ="online(this)" style="width:40%"  ip = "'+row.ip+'" port = "'+row.port+'">下线</button></td>';
				}
			}
		],
	});
}
//刷新数据
function RefreshTable(tableId, urlData){
	$.getJSON(urlData, null, function( json )
	{
		table = $(tableId).dataTable();
		oSettings = table.fnSettings();
		table.fnClearTable(this);//动态刷新关键部分语句，只会根据后台数据有变化才会刷新
		for (var i=0; i<json.length; i++)
		{
			table.oApi._fnAddData(oSettings, json[i]);//注意取得的jason串的字符数量，要与html中列的数量要有对应
		}
		oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
		table.fnDraw();
	});
}

function online(obj){
	var ip = $(obj).attr('ip');
	var port = $(obj).attr('port');
	console.log(ip+".............."+port);
}


//页面数据渲染
function svcDatas(){
	var html;
	$.ajax({
		type : 'GET',
		url : base_url + '/risk/getDatas',
		success : function(data){
			for(var i = 0; i<data.length;i++){
				html += '<table class="display" style="width:80%"> <tbody> <tr>' +
					'<td>'+data[i].id+'</td>' +
					'<td>'+data[i].ip+':'+data[i].port+'</td>' +
					'<td>'+data[i].isLined+'</td>' +
					'<td>'+data[i].online+'</td>' +
					'<td>'+data[i].iafStatus+'</td>' +
					'<td> <button class="btn btn-danger btn-xs add">添加</button></td>' +
					'</tr></tbody>'
			}

		},
	});
	$("#svcData").html(html);
}

