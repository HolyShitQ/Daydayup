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
        success: function (Response) {
            if(Response.code == 200){
                $("#comment_section").hide();
            }else {
                alert(Response.message);
            }
        },
        dataType:"json"
    });
}