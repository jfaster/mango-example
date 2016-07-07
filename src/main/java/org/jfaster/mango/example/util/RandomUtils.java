package org.jfaster.mango.example.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author ash
 */
public class RandomUtils {

    public static String randomStringId(int count) {
        return RandomStringUtils.random(count, false, true);
    }

}
