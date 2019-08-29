function post(){
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    $.ajax({
        type: "post",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (res) {
            if(res.code == 200){
                $("#comment_section").hide();
            }else {
                if(res.code == 2003){
                    var isAccepted = confirm(res.message);
                    if(isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=3eabf8aa4a4e848e7244&redirect_uri=http://localhost:8888/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                }else {
                    alert(Response.message);
                }
            }
        },
        dataType:"json"
    });
}