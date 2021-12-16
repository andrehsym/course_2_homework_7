package pro.sky.java.homeworks.course2.homework_7.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This employee already exists in our list")
public class EmployeeAlreadyExistsException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "This employee already exists in our list";

    public EmployeeAlreadyExistsException() { super(DEFAULT_MESSAGE);}
   public EmployeeAlreadyExistsException(String message) {
        super(DEFAULT_MESSAGE);
    }

    public EmployeeAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyExistsException(Throwable cause) {
        super(cause);
    }



}
