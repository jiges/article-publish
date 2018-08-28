/**
 * 插入文章
 * @authors Cobra Liu (lhg@nongrj.com)
 * @date    2017-05-04 18:34:50
 */
;(function($){
    $(function () {
        var href = window.location.href;
        if(href.indexOf("?id=") > 0) {
            $.ajax({
                type: 'POST',
                url: '/article/getById',
                data: {
                    id: href.substring(href.indexOf("?id=") + 4)
                },
                success: function (res) {
                    $("#id").val(res.id);
                    $("#catid").val(res.category);
                    $("#title").val(res.title);
                    var ue = UE.getEditor('editor');
                    ue.ready(function(){
                        ue.setContent(res.content);
                        ue.focus();
                    });

                }
            });
        } else {
            var ue = UE.getEditor('editor');
            ue.ready(function(){
                ue.setContent("");
                ue.focus();
            });
        }
    });
})(jQuery);

function save() {
    var ue = UE.getEditor('editor'),
        title = $("#title").val(),
        category = $("#catid").val(),
        content = ue.getContent();

    if(title == "") {
        alert("请输入标题!");
        return;
    }

    if(category == "") {
        alert("请选择栏目!");
        return;
    }

    if(content == "") {
        alert("请输入内容!");
        return;
    }

    $.ajax({
        type: 'POST',
        url: '/article/insert',
        data: {
            id:$("#id").val(),
            title: title,
            category: category,
            content: content
        },
        success: function (res) {
            var o = eval('(' + res + ')');
            if(o.code = 1) {
                alert("保存成功");
                window.location.href = "index.html";
            }
        }
    });
}

function publish() {
    var ue = UE.getEditor('editor'),
        title = $("#title").val(),
        category = $("#catid").val(),
        content = ue.getContent();

    if(title == "") {
        alert("请输入标题!");
        return;
    }

    if(category == "") {
        alert("请选择栏目!");
        return;
    }

    if(content == "") {
        alert("请输入内容!");
        return;
    }

    $.ajax({
        type: 'POST',
        url: '/article/publish',
        data: {
            id:$("#id").val(),
            title: title,
            category: category,
            content: content
        },
        success: function (res) {
            var o = eval('(' + res + ')');
            if(o.code = 1) {
                alert("发布成功");
                window.location.href = "index.html";
            }
        }
    });


}
