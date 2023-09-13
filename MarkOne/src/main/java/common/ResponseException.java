package common;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseException extends RuntimeException implements Serializable {

    private String code ="ERROR_EXCEPTION_OCCURRED";
    private String message =  "ERROR_EXCEPTION_OCCURRED";

    private Object data;


    public ResponseException(String code, String msg){
        this.code = code;
        this.message = msg;
    }

    public ResponseException(String code, String msg, Object data){
        this.code = code;
        this.message = msg;
        this.data = data;
    }
}
