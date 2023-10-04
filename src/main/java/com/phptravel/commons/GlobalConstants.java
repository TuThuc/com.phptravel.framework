package com.phptravel.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GlobalConstants {
private static GlobalConstants globalInstance;
private GlobalConstants(){

}
public static GlobalConstants getGlobalConstants() {
    if (globalInstance == null) {
        synchronized (GlobalConstants.class) {
            if (globalInstance == null) {
                globalInstance = new GlobalConstants();
            }
        }
    }
        return globalInstance;
    }
    private final long shortTimeout = 5;
    private final long longTimeout = 30;
    private final long retryTestFail = 3;
}