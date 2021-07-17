package com.prison.net.backend;

public enum ErrorCode {

    CODE_001,
    CODE_002,
    CODE_003,
    CODE_004,
    CODE_005;

    public static String getReason(ErrorCode code){
        String reason = null;
        switch (code){
            case CODE_001:
                reason = "Failed to create playerdata file";
                break;
            case CODE_002:
                reason = "Failed to establish connection to database";
                break;
            case CODE_003:
                break;
            case CODE_004:
                break;
            case CODE_005:
                break;
        }
        return reason;
    }

}
