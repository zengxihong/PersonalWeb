 
 var firstName=["苏","夏","陌","诗","漠","染","安","浅","木","伊","颜","唯","洛","雨","悠","子","筱","简","晗","宇","景","苒","若","沫","夕","雅","朵","涵","梦","曦","旋","暄","默","言","柒","嫣","紫","荨","希","帆","凉","落","尘","语","轩","歌","熙","韵","影","莫","然","枫"];
 //var middleName=["","",""];
 var lastName=["梦琪","之桃","慕青","尔岚","初夏","沛菡","傲珊","曼文",'乐菱',"惜文","香寒","新柔","语蓉","海安","夜蓉","涵柏","水桃","醉蓝","语琴","从彤","傲晴","语兰","又菱","碧彤","元霜","怜梦","紫寒","妙彤","曼易","南莲","紫翠","雨寒","易烟","如萱","若南","伟祺","从安","寻菡","秋寒","谷槐","文轩","立诚","立果","明轩","楷瑞","炎彬","鹏煊","幼南","沛山","不尤","道天","剑愁",'千筹',"广缘","天奇","道罡","远望","乘风","剑心","道之","乘云","绝施","冥幽","天抒","剑成","士萧","文龙","一鸣","剑鬼","半仙","万言","剑封","远锋","天与","元正","世开","不凡","醉山","语堂","懿轩","雅阳","鑫鹏","文昊","松思","水云","山柳","荣轩","绮彤","沛白",'慕蕊',"觅云"];
 



function randomName(){
	var randomFName=Math.floor(Math.random()*(firstName.length-1));
	//var randomMName=Math.floor(Math.random()*(middleName.length-1));
	var randomLName=Math.floor(Math.random()*(lastName.length-1));
	//var name=firstName[randomFName]+middleName[randomMName]+lastName[randomLName];
	var name=firstName[randomFName]+lastName[randomLName];

	$("#name").val(name);

	 
}
function Reset(){

$("#name").val("");
$("#message").val("");

}
function MessageSubmit(){
	if($.trim($("#name").val())=="")
		$("#name").val("不愿透露姓名的小哥哥/小姐姐~");

	if($.trim($("#message").val())!=""){
		var time=new Date();
		$.post("./login/postInfo.action",{name:$.trim($("#name").val()),msg:$.trim($("#message").val()),time:time.toLocaleString()},function(data){
			alert(data);
			
		},"json");
		
	}
	else{

		alert("写点意见咯！");
	}
}
function view(){

	location.href="./msg.html";
}