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
            $.each(data,function (i,item) {
                let tr=$("<tr></tr>");
                let id = $("<td></td>").append(item.id);
                let name = $("<td></td>").append(item.name);
                let age = $("<td></td>").append(item.age);
                let operating = $("<td></td>").append("<input type='button' id='del' value='删除'>" +
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
        success:function (data) {
            if (200==data.code){
                alert(data.msg);
                query();
            }else {
                alert(data.msg);
            }

        }
    });
}



function del(id) {
    $.ajax({
        url:"/student/delete/"+id,
        type:'get',
        dataType:'json',
        success:function (data) {
            if (200==data.code){
                alert(data.msg);
                query();
            }else {
                alert(data.msg);
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
        success:function (data) {
            if (200==data.code){
                alert(data.msg);
                query();
            }else {
                alert(data.msg);
            }
        }
    });
    $("#add").show();
    $("input[name='id']").val("");
    $("input[name='name']").val("");
    $("input[name='age']").val("");
}
