<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<div id="d1"></div>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
    $(function(){

        $("#d1").click(function(){
            let stuObj = {id:1,name:"xxx",age:20};
            $.ajax({
                url : "http://localhost/ajax",
                type : 'POST',
                dataType: 'json',
                contentType: "application/json",
                data : JSON.stringify(stuObj),//转为json格式
                success : function(data) {
                }
            });
        })
</script>
</body>
</html>
