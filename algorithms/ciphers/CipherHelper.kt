// For android

import android.util.Base64
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class CipherHelper {
    private val salt = "Your salt"

    // mdp can be code pin or password
    fun encrypt(pInput: String, mdp: String): String? {
        var s: String? = null
        try {

            val key = hashString("SHA-256", salt + mdp).substring(32)

            val aesKey = SecretKeySpec(key.toByteArray(), "AES")
            val cipher = Cipher.getInstance("AES")

            cipher.init(Cipher.ENCRYPT_MODE, aesKey)
            val encrypted = cipher.doFinal(pInput.toByteArray(Charsets.UTF_8))
            s = Base64.encodeToString(encrypted, Base64.DEFAULT)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return s ?: ""
    }

    // mdp can be code pin or password
    fun decrypt(pInput: String, mdp: String): String {

        var decrypted: String? = null
        try {


            val key = hashString("SHA-256", salt + mdp).substring(32)
            val aesKey = SecretKeySpec(key.toByteArray(Charsets.UTF_8), "AES")
            val cipher = Cipher.getInstance("AES")

            cipher.init(Cipher.DECRYPT_MODE, aesKey)
            var encrypted = Base64.decode(pInput, Base64.DEFAULT)
            decrypted = String(cipher.doFinal(encrypted), Charsets.UTF_8)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return decrypted ?: ""
    }

    private fun hashString(type: String, input: String): String {
        val HEX_CHARS = "0123456789ABCDEF"
        val bytes = MessageDigest
                .getInstance(type)
                .digest(input.toByteArray())
        val result = StringBuilder(bytes.size * 2)

        bytes.forEach {
            val i = it.toInt()
            result.append(HEX_CHARS[i shr 4 and 0x0f])
            result.append(HEX_CHARS[i and 0x0f])
        }

        return result.toString()
    }
}