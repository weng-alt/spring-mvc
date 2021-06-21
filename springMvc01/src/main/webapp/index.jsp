<html>
<script type="text/javascript" src="js/jquery.js"></script>
<body>
<div id="d1">Hello World!</div>
<form enctype="multipart/form-data" method="post" onsubmit="return false">
    <input type="file" name="file" />
    <input type="submit" id="d2"/>
</form>
</body>
<script type="text/javascript">
    $(function () {
        $("#d2").click(function () {
            let stuObj = {id: 1, name: "xxx", age: 20};
            let fd = new FormData();
            let a = $("input[name=file]")[0].files[0];
            fd.append("file",a);
            $.ajax({
                url: "/user/upload",
                processData : false,
                contentType : false,
                type: 'POST',
                data: fd,//转为json格式
                success: function (data) {
                    alert(data);
                }
            });
        });
    })
</script>
</html>
