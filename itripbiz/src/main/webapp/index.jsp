<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<body>
<<<<<<< HEAD
<h2>Hello World!itripbiz</h2>
=======
<h2>Hello World!</h2>
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(function () {
        //按钮单击时执行
        $("#testAjax").click(function () {
            //Ajax调用处理
            $.ajax({
                type: "POST",
                url: "/api/hotel/queryhotcity",
                data: {type:"xasx",name:"测试"},
                dataType:"application/json",
                success: function (data) {
                    $("#content").text(data);
                }
            });
        });
    });
</script>
<input type="button" value="提交" id="testAjax"/>
<textarea rows="10" cols="10" id="content"></textarea>
>>>>>>> fa4d28ff0753f79fecdbddc9cf7b092b90afc9d2
</body>
</html>
