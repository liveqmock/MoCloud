<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<jh:define source="&resourcePagePage.Unit" alias="resourcePage"></jh:define>
<HTML>
<HEAD>
<jsp:include page="/cloud/manage/common/jeui.jsp"></jsp:include>
<link rel="stylesheet" href="/cloud/acs/btn_title.css" type="text/css" media="screen" />
</HEAD>
<script>
$(function(){	
	var flag = "<jh:write source='&base.ouid' />";
	if(flag == ""){
    alert("连接超时~！");
    parent.parent.location.href="/cloud/home/Frame.wa"; 
  }
  
  var oriDisplayCd = $("#oriDisplayCd").val();	
	if(oriDisplayCd =="1"){
		$("#displayCd").attr("checked",true);
	}else{
		$("#displayCd").attr("checked",false);
	}
	
	var oriIconUrl = $("#oriIconUrl").val();
	$("#oriIcon").attr("src",oriIconUrl);
	
	var url = "/cloud/product/resource/module/ResourceModule.wa?do=selectAll&date="+new Date().valueOf();
	var data = null;
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#moduleId').combobox('loadData', toJsonObject(msg));
		 if($('#oriModuleId').val() != 0){
			$('#moduleId').combobox("select",$('#oriModuleId').val());
		 }
		 
		url = "/cloud/product/resource/channel/ResourceChannel.wa?do=selectByModuleId&date="+new Date().valueOf();
		data ={"moduleId":$('#moduleId').combobox("getValue")};
		$.ajax({
	   			type:"POST",
	   			url:url,
	   			data:data,
	   			success:function(msg){
		 			$('#channelId').combobox('loadData',toJsonObject(msg));
					if($('#oriChannelId').val() != 0){
						$('#channelId').combobox("select",$('#oriChannelId').val());
					}
					},
	   			fail:function(){
	   	 			alert("error");
	   			}
			});
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
})



function onModuleSelect(record){
	var url = "/cloud/product/resource/channel/ResourceChannel.wa?do=selectByModuleId&date="+new Date().valueOf();
	var data ={"moduleId":$('#moduleId').combobox("getValue")};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#channelId').combobox('clear');
		 $('#channelId').combobox('loadData', toJsonObject(msg));
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

function submitForm(){
	if(!checkValidateboxValid())return; 
	if(!checkImageType()) return; 
	
	if($('#moduleId').combobox("getValue").length == 0){
		alertx("请指定模块");
		return;
	}
	
	if($('#channelId').combobox("getValue").length == 0){
		alertx("请指定频道");
		return;
	}
	
	progress();
	
	var url = "/cloud/product/resource/page/ResourcePage.wa?do=canModify&date="+new Date().valueOf();
	var data ={"ouid":$('#ouid').val(),"code":$('#code').val()};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 closeProgress();
		 var result = toJsonObject(msg);
		 
		 if(result == '1'){
			 alertx("此代码已存在！","wrning",function(){
				 $('#code').focus();
			 });
		 }
		 else{
			 $('#form').submit();
		 }
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

</script>
<body class="body">
<div class="easyui-panel" fit='true'>
  <form id="form" method="post" action="/cloud/product/resource/page/ResourcePage.wa?do=updateSave" enctype="multipart/form-data">
    <div id="cy_right" style="width:100%">
      <div class="right_title"> <span>编辑资源页</span> </div>
      <div class="btn_bar" style='boder:1px solid black'>
        <div class="nav_btn"> <a href="#" onClick="submitForm()" class="sub_btn"></a> <a href="/cloud/product/resource/page/ResourcePage.wa" class="back_btn"></a> </div>
      </div>
    </div>
    <div class='cy_edit_panel'>
      <table border="0">
        <tr>
          <td align="left" style="width:80px">编号</td>
          <td align="left"><input id="ouid" name="ouid" style="width:80px;text-align:right;" class="disabled" readonly value="<jh:write source='&resourcePage.ouid'/>"/>
            <input name="userId" style="display:none" value="<jh:write source='&base.ouid' />"/>
            <input type="checkbox" id="displayCd" name="displayCd" checked="true">显示</input>
            <input id="oriDisplayCd" style="display:none" value="<jh:write source='&resourcePage.displayCd'/>"/></td>
        </tr>
        <tr>
        <td align="left">图标</td>
        <td align="left"><img id="oriIcon" onerror="imgNotfind();"/>
          <input id="oriIconUri" style="display:none" value="<jh:write source='&resourcePage.iconUrl' />"/>
          <input id="iconUrl" name="iconUrl" type="file" class="checkImageType"/><font color="#FF0000">(100*100)</font></td>
      </tr>
        <tr>
          <td align="left">模块</td>
          <td align="left"><select class="easyui-combobox" id="moduleId" name="moduleId" style="width:600px;" data-options="valueField:'ouid',textField:'label',onSelect:onModuleSelect,editable:false"/>
            <input id="oriModuleId" name="oriModuleId" readonly type="hidden" value="<jh:write source='&resourcePage.moduleId'/>"/></td>
        </tr>
       	<tr>
          <td align="left">频道</td>
          <td align="left"><select class="easyui-combobox" id="channelId" name="channelId" style="width:600px;" data-options="valueField:'ouid',textField:'label',editable:false"/>
            <input id="oriChannelId" name="oriChannelId" readonly type="hidden" value="<jh:write source='&resourcePage.channelId'/>"/></td>
        </tr>
        <tr>
          <td align="left" style="width:80px">代码</td>
          <td align="left"><input id="code" name="code" autocomplete="off" style="width:600px;text-align:left;" class="easyui-validatebox textbox" 
        validtype="length[0,80]" value="<jh:write source='&resourcePage.code'/>"/></td>
        </tr>
        <tr>
          <td align="left">标题</td>
          <td align="left" ><input id="label" class="easyui-validatebox textbox notnull" autocomplete="off" style="width:600px;text-align:left;" validtype="length[1,200]" data-options="required:true" name="label" value="<jh:write source='&resourcePage.label'/>"/></td>
        </tr>
        <tr>
          <td align="left">排序值</td>
          <td align="left"><input id="displayOrder" name="displayOrder" class="easyui-numberbox" style="width:600px;text-align:right" data-options="required:true" value="<jh:write source='&resourcePage.displayOrder'/>"/></td>
        </tr>
        <tr>
          <td align="left">备注</td>
          <td align="left"><textarea id="note" name="note" autocomplete="off" class="border_change" style="width:600px;height:140px"><jh:write source='&resourcePage.note' format='text'/></textarea></td>
        </tr>
      </table>
    </div>
  </form>
</div>
</body>
</HTML>