
/**
 * 校验输入是否为空	
 * @param element 需要校验的输入框元素
 * @param spanEle element后跟的span标记
 */
function validate(element,spanEle){
	spanEle.html("");
	var $value = element.val();
	if($value == null || $value == ""){
		spanEle.html("can not be null or blank");
		spanEle.css("color","red");
	}
}
		
/**
 * 清除input输入框的value值
 * @param element
 */
function clearInputValue(element){
	element.val("");
}

/**
 * input输入框绑定焦点移入和移除事件做内容校验
 * @param element 需要校验的输入框元素
 * @param spanEle element后跟的span标记
 */
function inputValidate(element,spanEle){
	element.focus(function(){
		spanEle.html("");
	});
	
	element.blur(function(){
		validate(element,spanEle);
	});
}

/**
 * 判断字符串是否为空或null
 * @param str
 */
function isNullOrBlank(str){
	if(null != str && $.trim(str).length>0){
		return false;
	}else{
		return true;
	}
}


/**
 * 添加错误提示
 * @param errorSpan
 * @param msg
 */
function appendErrMsg(errorSpan,msg){
	errorSpan.html(msg);
	errorSpan.css("color","red");
}

