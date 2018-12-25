package com.gl.website.util;

public class ParamVerifyUtil {


    public static  boolean  queryTest (Object... obj){
        if(obj==null)
            return false;
        for(int i=0;i<obj.length;i++) {
            if(obj[i]==null)
                return false;

            if(obj[i] instanceof  String) {
                String str=(String)obj[i];
                if(str.trim().length()<1)
                    return false;
            }
        }

        return true;

    }
}
