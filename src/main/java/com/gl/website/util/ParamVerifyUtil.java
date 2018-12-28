package com.gl.website.util;

import java.util.ArrayList;
import java.util.HashMap;

public class ParamVerifyUtil {


    public static  boolean  verification (Object... obj){
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
