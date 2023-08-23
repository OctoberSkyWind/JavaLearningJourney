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
    /**
     * 数据
     */
    private T data;
    /**
     * message
     */
    private String message;

    /**
     * 时间
     */
    private LocalDateTime time;

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
        this.message = "";
        this.time = LocalDateTime.now();
    }

    public Result(Integer code, T data, String message, LocalDateTime time) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.time = time;
    }
}
