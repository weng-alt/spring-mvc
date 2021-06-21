<html>
<script type="text/javascript" src="js/jquery.js"></script>
<body>
<div id="d1">Hello World!</div>
<form action="/user/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file" />
    <input type="submit"/>
</form>
</body>
<script type="text/javascript">
    $(function () {
        $("#d1").click(function () {
            let stuObj = {id: 1, name: "xxx", age: 20};
            $.ajax({
                url: "/user/ajax",
                type: 'POST',
                dataType: 'json',
                contentType: "application/json",
                data: JSON.stringify(stuObj),//转为json格式
                success: function (data) {

                }
            });
        });
    })
</script>
</html>
