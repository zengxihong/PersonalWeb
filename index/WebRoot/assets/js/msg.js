$(function(){
 

/*var data={
    "re": [
        {
            "name": "John",
            "msg": "Doe"
        },
        {
            "name": "Anna",
            "msg": "Smith"
        },
        {
            "name": "Peter",
            "msg": "Jones"
        }
    ]
};*/
var msgHtml="";

	 $.get(".//login/GetMsg.action",function(data){

			for(var i=0;i<data.re.length;i++){

				 msgHtml+=	"<div class=\"story\">"
 				+"<div class=\"m_top\">"
					+"<div class = \"aut_na\">"
					+"<h4><strong>"+data.re[i].name+"</strong>&nbsp;&nbsp;&nbsp;</h4>"
					+"</div>"
				+"<div class=\"btn-group btn-group-xs edit_ri\" role=\"group\" aria-label=\"...\">"
					 
				+"</div>"
				+"</div>"
				+"<p class=\"story_time\">"+data.re[i].time+"</p>"
				+"<p class=\"story_m\">"+data.re[i].msg+"</p>"
		+"</div>"
			}




$("#messDivId").append(msgHtml);


 },"json");




})