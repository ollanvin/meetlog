package app.meetlog.mobile.core.util.crypto

import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * AES-256-GCM for on-device backup payloads (key must be managed by the app, e.g. Android Keystore).
 */
object AesGcmBackupCipher {
    private const val TAG_BITS = 128
    private const val IV_LENGTH_BYTES = 12
    private const val TRANSFORMATION = "AES/GCM/NoPadding"

    fun encrypt(aesKey256: ByteArray, plaintext: ByteArray): ByteArray {
        require(aesKey256.size == 32) { "AES-256 key must be 32 bytes" }
        val iv = ByteArray(IV_LENGTH_BYTES).also { SecureRandom().nextBytes(it) }
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(
            Cipher.ENCRYPT_MODE,
            SecretKeySpec(aesKey256, "AES"),
            GCMParameterSpec(TAG_BITS, iv)
        )
        val ciphertext = cipher.doFinal(plaintext)
        return iv + ciphertext
    }

    fun decrypt(aesKey256: ByteArray, blob: ByteArray): ByteArray {
        require(aesKey256.size == 32) { "AES-256 key must be 32 bytes" }
        require(blob.size > IV_LENGTH_BYTES) { "Invalid ciphertext" }
        val iv = blob.copyOfRange(0, IV_LENGTH_BYTES)
        val ct = blob.copyOfRange(IV_LENGTH_BYTES, blob.size)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(
            Cipher.DECRYPT_MODE,
            SecretKeySpec(aesKey256, "AES"),
            GCMParameterSpec(TAG_BITS, iv)
        )
        return cipher.doFinal(ct)
    }
}
