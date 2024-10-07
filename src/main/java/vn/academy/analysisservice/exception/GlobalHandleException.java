package vn.academy.analysisservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.academy.analysisservice.dto.ApiResponse;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handlingApiException(ApiException exception) {
        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity.status(errorCode.getStatus()).body(ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build());
    }
}
