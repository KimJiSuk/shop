package com.back.shop;

import org.springframework.http.HttpStatus;

import java.util.StringJoiner;

public class ApiUtils {
    public static <T> ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }

    public static ApiResult<?> error(String message, HttpStatus status) {
        return new ApiResult<>(false, null, new ApiError(message, status));
    }

    public static class ApiError {
        private final String message;
        private final int status;

        ApiError(String message, HttpStatus status) {
            this.message = message;
            this.status = status.value();
        }

        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ApiError.class.getSimpleName() + "[", "]")
                    .add("message='" + message + "'")
                    .add("status=" + status)
                    .toString();
        }
    }

    public static class ApiResult<T> {
        private final boolean success;
        private final T response;
        private final ApiError error;

        private ApiResult(boolean success, T response, ApiError error) {
            this.success = success;
            this.response = response;
            this.error = error;
        }

        public boolean isSuccess() {
            return success;
        }

        public ApiError getError() {
            return error;
        }

        public T getResponse() {
            return response;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ApiResult.class.getSimpleName() + "[", "]")
                    .add("success=" + success)
                    .add("response=" + response)
                    .add("error=" + error)
                    .toString();
        }
    }
}
