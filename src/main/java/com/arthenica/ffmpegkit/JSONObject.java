package org.json;

import java.util.HashMap;
import java.util.Map;

/**
 * Simplified JSONObject implementation for stubs.
 */
public class JSONObject {
    private final Map<String, Object> map = new HashMap<>();
    
    public JSONObject() {
        // Default constructor
    }
    
    /**
     * Get the value object associated with a key.
     *
     * @param key A key string.
     * @return The object associated with the key.
     * @throws JSONException if the key is not found.
     */
    public Object get(String key) throws JSONException {
        if (!map.containsKey(key)) {
            throw new JSONException("JSONObject[" + key + "] not found.");
        }
        return map.get(key);
    }
    
    /**
     * Put a key/value pair in the JSONObject.
     *
     * @param key   A key string.
     * @param value An object which is the value.
     * @return this.
     * @throws JSONException If the value is non-finite number.
     */
    public JSONObject put(String key, Object value) throws JSONException {
        if (value != null) {
            testValidity(value);
            map.put(key, value);
        } else {
            remove(key);
        }
        return this;
    }
    
    /**
     * Remove a name and its value, if present.
     *
     * @param key The name to be removed.
     * @return The value that was associated with the name, or null if there was no value.
     */
    public Object remove(String key) {
        return map.remove(key);
    }
    
    /**
     * Throw an exception if the object is an NaN or infinite number.
     *
     * @param o The object to test.
     * @throws JSONException If o is a non-finite number.
     */
    static void testValidity(Object o) throws JSONException {
        if (o != null) {
            if (o instanceof Double) {
                Double d = (Double) o;
                if (d.isInfinite() || d.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            } else if (o instanceof Float) {
                Float f = (Float) o;
                if (f.isInfinite() || f.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return map.toString();
    }

    /**
     * Determine if the JSONObject contains a specific key.
     *
     * @param key A key string.
     * @return true if the key exists in the JSONObject.
     */
    public boolean has(String key) {
        return map.containsKey(key);
    }
    
    /**
     * Get the string associated with a key.
     *
     * @param key A key string.
     * @return A string which is the value.
     * @throws JSONException if the key is not found or if the value is not a String.
     */
    public String getString(String key) throws JSONException {
        Object object = get(key);
        if (object instanceof String) {
            return (String) object;
        }
        throw new JSONException("JSONObject[" + key + "] is not a string.");
    }
    
    /**
     * Get the int value associated with a key.
     *
     * @param key A key string.
     * @return The integer value.
     * @throws JSONException if the key is not found or if the value cannot be converted to an integer.
     */
    public int getInt(String key) throws JSONException {
        Object object = get(key);
        if (object instanceof Number) {
            return ((Number) object).intValue();
        }
        throw new JSONException("JSONObject[" + key + "] is not a number.");
    }
    
    /**
     * Get the keys of the JSONObject.
     *
     * @return An iterator of the keys.
     */
    public Iterator<String> keys() {
        return map.keySet().iterator();
    }
    
    /**
     * Get the key set of the JSONObject.
     *
     * @return A set of keys.
     */
    public Set<String> keySet() {
        return map.keySet();
    }
}