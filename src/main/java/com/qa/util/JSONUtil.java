package com.qa.util;

import java.io.IOException;
import com.google.gson.*;

public class JSONUtil {

	private Gson genny;

	public JSONUtil() {
		this.genny = new Gson();
	}

	public String getJSONForObject(Object obj) {
		return genny.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz){
		
		return genny.fromJson(jsonString, clazz);
	}

}