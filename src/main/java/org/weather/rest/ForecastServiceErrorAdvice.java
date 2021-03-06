package org.weather.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.weather.errors.ApiErrorData;
import org.weather.errors.ForecastServiceError;

@ControllerAdvice
public class ForecastServiceErrorAdvice {
    @ResponseBody
    @ExceptionHandler(ForecastServiceError.class)
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    ApiErrorData serviceError(ForecastServiceError ex) {
        return new ApiErrorData(ex.statusCode,ex.getMessage());
    }
}
