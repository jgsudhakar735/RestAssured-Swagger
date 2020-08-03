package com.jgsudhakar.restassured.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.restassured.utils.RestAssuredConstants
 * @Date : 15/07/2020
 */
public class RestAssuredConstants {
    public static String REST_ASSURED_URL;

    /**
     * This map initially read the data from the properties file and set in the header parameter map.
     * Those Keys which maps with "H:" will be stored in this map.
     * */
    private static Map<String, Object> headerParamMap = new HashMap<>();

    /**
     * This map initially read the data from the properties file and set in the Body parameter map.
     * Those Keys which maps with "B:" will be stored in this map.
     * */
    private static Map<String, Object> bodyParamMap = new HashMap<>();

    /**
     * This map initially read the data from the properties file and set in the Query parameter map.
     * Those Keys which maps with "Q:" will be stored in this map.
     * */
    private static Map<String, Object> queryParamMap = new HashMap<>();

    /**
     * This map initially read the data from the properties file and set in the Path parameter map.
     * Those Keys which maps with "P:" will be stored in this map.
     * */
    private static Map<String, Object> pathParamMap = new HashMap<>();

    /**
     * Those which is not mapped with any of the above data should be mapped / stored to this map.
     * */
    private static Map<String, Object> miscMap = new HashMap<>();

    static {
        // Reading the property file to set the Header and Body parameters while constructing the
        // Test Case. The data should be set with "H" / "B" / "P" in the key
        // H- Refers to Header Parameter
        // B- Body Parameters
        // Q- Query Parameter
        // P- Path Parameter

        try (InputStream input = RestAssuredConstants.class.getClassLoader().getResourceAsStream("constant.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            prop.forEach((key, value) -> {
               String keyData =  (String)key;
               String[] val= ((String)value).split("@");
                if(null != val && val.length >1){
                    if(val[1].equalsIgnoreCase("H"))
                        headerParamMap.put(keyData,val[0]);
                    else if(val[1].equalsIgnoreCase("B"))
                        bodyParamMap.put(keyData,val[0]);
                    else if(val[1].equalsIgnoreCase("Q"))
                        queryParamMap.put(keyData,val[0]);
                    else if(val[1].equalsIgnoreCase("P"))
                        pathParamMap.put(keyData,val[0]);
                }else
                    miscMap.put(keyData,value);

            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method will return the Header map data which is set in the constant file. to retrieve this you need to pass the header key to get the value if
     * you need to customize the data from header parameter
     * */
    public static Object getHeaderValue(String key) {
        Object object = headerParamMap.get(key);
        if(null == object)
            return "";
        return object;
    }

    /**
     * This method will return the Body map data which is set in the constant file. to retrieve this you need to pass the body parameter key to get the value if
     * you need to customize the data from body  parameter
     * */
     public static Object getBodyValue(String key) {
            Object object = bodyParamMap.get(key);
            if(null == object)
                return "";
            return object;
    }

    /**
     * This method will return the Path Param map data which is set in the constant file. to retrieve this you need to pass the path key to get the value if
     * you need to customize the data from path parameter
     * */
    public static Object getPathValue(String key) {
            Object object = pathParamMap.get(key);
            if(null == object)
                return "";
            return object;
    }

    /**
     * This method will return the Query map data which is set in the constant file. to retrieve this you need to pass the query key to get the value if
     * you need to customize the data from query parameter
     * */
     public static Object getQueryValue(String key) {
            Object object = queryParamMap.get(key);
            if(null == object)
                return "";
            return object;
    }

    /**
     * This method will return the Misc map data which is set in the constant file. to retrieve this you need to miscellanies  the header key to get the value if
     * you need to customize the data from misc parameter
     * */
    public static Object getMiscValue(String key) {
        Object object = miscMap.get(key);
        if(null == object)
            return "";
        return object;
        }

}
