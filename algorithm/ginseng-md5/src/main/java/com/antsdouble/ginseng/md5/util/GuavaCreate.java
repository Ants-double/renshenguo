package com.antsdouble.ginseng.md5.util;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * @author lyy08
 */
public class GuavaCreate {
    public static String createMd5(String input){

        // com.google.common.hash.Hashing.md5()
        // If you must interoperate with a system that requires MD5, then use this method, despite its deprecation. But if you can choose your hash function, avoid MD5, which is neither fast nor secure. As of January 2017, we suggest:
        // For security: Hashing.sha256() or a higher-level API.
        // For speed: Hashing.goodFastHash(int), though see its docs for caveats.
        HashFunction hashFunction = Hashing.md5();

        HashCode hash = hashFunction.hashString(input, StandardCharsets.UTF_8);
        return hash.toString();
    }
}
