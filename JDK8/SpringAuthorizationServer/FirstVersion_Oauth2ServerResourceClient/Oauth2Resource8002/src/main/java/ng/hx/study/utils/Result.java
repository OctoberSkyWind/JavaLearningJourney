package ng.hx.study.utils;


import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * //@Setter(AccessLevel.NONE) 表示禁用set方法，防止篡改结果
 */
@Data
//@Setter(AccessLevel.NONE)
@Accessors(chain = true)
public class Result<T> {
    /**
     * 返回码
     */
    private Integer code;

    private String message;

    /**
     * 数据
     */
    private T data;
    /**
     * message
     */


    /**
     * 时间
     */
    private LocalDateTime time;

    public Result(Integer code, T data) {
        this.code = code;
        this.message = "";
        this.data = data;
        this.time = LocalDateTime.now();
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.time = LocalDateTime.now();
    }
}
