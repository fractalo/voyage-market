package voyage.market.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import voyage.market.controller.Message;
import voyage.market.exception.NotFoundException;

@RestControllerAdvice
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public Message notFoundExHandle(NotFoundException e) {
        return new Message(e.getMessage());
    }

}
