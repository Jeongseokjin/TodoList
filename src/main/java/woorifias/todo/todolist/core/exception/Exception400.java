package woorifias.todo.todolist.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import woorifias.todo.todolist.core.dto.ResponseDTO;
import woorifias.todo.todolist.core.dto.ValidDTO;


// 유효성 검사 실패, 잘못된 파라미터 요청
@Getter
public class Exception400 extends RuntimeException {

    private String key;
    private String value;

    public Exception400(String key, String value) {
        super(value);
        this.key = key;
        this.value = value;
    }

    public ResponseDTO<?> body() {
        ValidDTO validDTO = new ValidDTO(key, value);
        return new ResponseDTO<>(HttpStatus.BAD_REQUEST, "badRequest", validDTO);
    }

    public HttpStatus status() {
        return HttpStatus.BAD_REQUEST;
    }
}