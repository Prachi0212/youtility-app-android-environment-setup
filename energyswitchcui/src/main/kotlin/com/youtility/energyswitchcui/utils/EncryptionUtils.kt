package com.youtility.energyswitchcui.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by Mohit Rajput on 4/4/19.
 * Utility for encrypting, encoding and generating hash for a string
 */
object EncryptionUtils {
    fun getSHA256(input: String): String {
        try {
            // Static getInstance method is called with hashing SHA
            val md = MessageDigest.getInstance("SHA-256")

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            val messageDigest = md.digest(input.toByteArray())

            // Convert byte array into signum representation
            val no = BigInteger(1, messageDigest)

            // Convert message digest into hex value
            var hashtext = no.toString(16)

            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            return hashtext
        } catch (e: NoSuchAlgorithmException) {
            return e.localizedMessage
        }
    }
}
