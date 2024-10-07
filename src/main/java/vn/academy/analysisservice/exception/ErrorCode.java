package vn.academy.analysisservice.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    ANALYSIS_NOT_EXIST(40401, "Analysis is not exist.", HttpStatus.NOT_FOUND),
    ;

    Integer code;
    String message;
    HttpStatus status;
}
