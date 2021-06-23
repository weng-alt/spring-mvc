package com.panshi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {

    private int code;
    private String msg;
    private Object data;

    public static Msg init(int code, String msg, Object data){
        Msg m=new Msg(code,msg,data);
        return m;
    }

}
