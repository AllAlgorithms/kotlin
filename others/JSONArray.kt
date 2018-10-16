package fr.imprimerienationale.innolab.inwallet.extensions

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


fun JSONArray.parse(jsonString: String): JSONArray? {
    return try {
        JSONArray(jsonString)
    } catch (e: JSONException) {
        null
    }
}

fun JSONArray.getStringOrNull(index: Int): String? {
    return try {
        this.getString(index)
    } catch (e: JSONException) {
        null
    }
}

fun JSONArray.getIntOrNull(index: Int): Int? {
    return try {
        this.getInt(index)
    } catch (e: JSONException) {
        null
    }
}

fun JSONArray.getLongOrNull(index: Int): Long? {
    return try {
        this.getLong(index)
    } catch (e: JSONException) {
        null
    }
}

fun JSONArray.getDoubleOrNull(index: Int): Double? {
    return try {
        this.getDouble(index)
    } catch (e: JSONException) {
        null
    }
}

fun JSONArray.getBooleanOrNull(index: Int): Boolean? {
    return try {
        this.getBoolean(index)
    } catch (e: JSONException) {
        null
    }
}

fun JSONArray.getJSONObjectOrNull(index: Int): JSONObject? {
    return try {
        this.getJSONObject(index)
    } catch (e: JSONException) {
        null
    }
}

fun JSONArray.getJSONArrayOrNull(index: Int): JSONArray? {
    return try {
        this.getJSONArray(index)
    } catch (e: JSONException) {
        null
    }
}