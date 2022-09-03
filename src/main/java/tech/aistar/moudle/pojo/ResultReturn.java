package tech.aistar.moudle.pojo;

import java.io.Serializable;

public class ResultReturn implements Serializable {
    private String code;//状态码-http状态码
    private String msg;//描述信息
    private Object data;//查询的结果
    //空参构造 alt+insert
    public ResultReturn(){

    }
    //两参的构造

    public ResultReturn(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultReturn(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }




    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultReturn{");
        sb.append("code='").append(code).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
