package com.armoury.backend.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    /** 1000 : 요청 성공  */
    SUCCESS(true, 1000, "요청 성공"),

    /** 2000 : Request 오류 */

    /** 3000 : Response 오류*/
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    /** 4000 : DB 오류 */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}