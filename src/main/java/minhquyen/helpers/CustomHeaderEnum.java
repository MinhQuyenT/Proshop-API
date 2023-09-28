package minhquyen.helpers;

import java.util.HashMap;
import java.util.Map;

public enum CustomHeaderEnum {

    //Nếu có header thì gán vào, không có thì bỏ trống....
    content_type("content-type","application/x-www-form-urlencoded" ),
    X_RAPIDAPI_KEY("X-RapidAPI-Key", "5b10e24840msh451c08a36ec4f9dp1c16e9jsne6b5837f5c01"),
    //    X_RAPIDAPI_HOST("X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com"),
    X_RAPIDAPI_HOST("X-RapidAPI-Host", "twttrapi.p.rapidapi.com");

    private final String headerName;
    private final String headerValue;
    private static final Map<String, String> headerMap = new HashMap<>();

    static {
        for (CustomHeaderEnum headerEnum : values()) {
            headerMap.put(headerEnum.headerName, headerEnum.headerValue);
        }
    }

    CustomHeaderEnum(String headerName, String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public static Map<String, String> getHeaders() {
        return headerMap;
    }
}
