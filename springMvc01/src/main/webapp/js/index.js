$(function () {

    query();

    $("#query").click(function () {
        query();
        $("#upd").hide();
        $("#add").show();
        $("input[name='id']").val("");
        $("input[name='name']").val("");
        $("input[name='age']").val("");
    });

    $("#add").click(function () {
        add();
    });

    $("#upd").click(function () {
        upd();
    });
    $("#myTbody").on("click","#del",function () {
        del($(this).parent().parent().children("td:eq(0)").text());
    })
    $("#myTbody").on("click","#replace",function () {
        replace(this);
    })


})

function query() {
    $.ajax({
        url:"/student/query",
        type:'get',
        dataType:'json',
        contentType:"application/json",
        success:function (data) {
            let myTbody=$("#myTbody");
            myTbody.empty();
            $.each(data,function (i,val) {
                let tr=$("<tr></tr>");
                let id = $("<td>"+val.id+"</td>");
                let name = $("<td>"+val.name+"</td>");
                let age = $("<td>"+val.age+"</td>");
                let operating = $("<td></td>");
                operating.append("<input type='button' id='del' value='删除'>" +
                    "<input type='button' id='replace' value='修改'>");
                tr.append(id,name,age,operating);
                myTbody.append(tr);
            });

        }
    });
}

function add(){
    let name=$("input[name='name']").val();
    let age=$("input[name='age']").val();
    let stu={name,age};
    $.ajax({
        url:"/student/insert",
        type:'post',
        data:JSON.stringify(stu),
        contentType: "application/json",
        dataType:'json',
        success:function (result) {
            if (200==result.code){
                alert(result.msg);
                query();
            }else {
                alert(result.msg);
            }

        }
    });
}



function del(id) {
    $.ajax({
        url:"/student/delete/"+id,
        type:'get',
        dataType:'json',
        success:function (result) {
            if (200==result.code){
                alert(result.msg);
                query();
            }else {
                alert(result.msg);
            }

        }
    });
}

function replace(e) {
    $("#add").hide();
    $("#upd").show();
    let tr = $(e).parent().parent();
    $("input[name='id']").val(tr.children("td:eq(0)").text());
    let name=$("input[name='name']");
    let age=$("input[name='age']");
    name.val(tr.children("td:eq(1)").text());
    age.val(tr.children("td:eq(2)").text());
}

function upd() {
    $("#upd").hide();
    let id=$("input[name='id']").val();
    let name=$("input[name='name']").val();
    let age=$("input[name='age']").val();
    let stu={id,name,age}
    $.ajax({
        url:"/student/update",
        type:'post',
        data:JSON.stringify(stu),
        contentType: "application/json",
        dataType:'json',
        success:function (result) {
            if (200==result.code){
                alert(result.msg);
                query();
            }else {
                alert(result.msg);
            }
        }
    });
    $("#add").show();
    $("input[name='id']").val("");
    $("input[name='name']").val("");
    $("input[name='age']").val("");
}
