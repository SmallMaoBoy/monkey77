	function FileUpload(goodId) {
		 $.ajaxFileUpload
         (
             {
                 url: 'UploadAction_execute?type=1&goodId='+goodId, //用于文件上传的服务器端请求地址
                 secureuri: false,
                 //是否需要安全协议，一般设置为false
                 fileElementId: 'file', //文件上传域的ID
                 dataType: 'json', //返回值类型 一般设置为json
                 success: function (data,status)  //服务器成功响应处理函数
                 {
                	 	var parsedJson = jQuery.parseJSON(data);
                	 	if(parsedJson.statusCode==0){
                	 		$("#img").attr("src",parsedJson.picUrl);
                	 	}else{
                	 		alert("上传失败");
                	 	}
                	 	
                 },
                 error: function (data, status, e) {  
                     alert(e);  
                 }  
             }
         )
         return false;

	}
	
	//轮播图上传
	function FileListUpload(goodId,num,type) {
		 $.ajaxFileUpload
        (
            {
                url: 'UploadAction_execute?type='+type+'&goodId='+goodId, //用于文件上传的服务器端请求地址
                secureuri: false,
                //是否需要安全协议，一般设置为false
                fileElementId: 'file'+num, //文件上传域的ID
                dataType: 'json', //返回值类型 一般设置为json
                success: function (data,status)  //服务器成功响应处理函数
                {
               	 	var parsedJson = jQuery.parseJSON(data);
               	 	if(parsedJson.statusCode==0){
               	 		$("#img"+num).attr("src",parsedJson.picUrl);
               	 	}else{
               	 		alert("上传失败");
               	 	}
               	 	
                },
                error: function (data, status, e) {  
                    alert(e);  
                }  
            }
        )
        return false;

	}

