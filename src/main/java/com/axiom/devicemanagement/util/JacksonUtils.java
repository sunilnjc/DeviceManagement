package com.axiom.devicemanagement.util;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JacksonUtils {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	Logger logger = LogManager.getLogger(JacksonUtils.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	
	private JacksonUtils() {

	}

	public static String toJson(Object inputObj) {

		try {
			return mapper.writeValueAsString(inputObj);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return Objects.toString(inputObj);
	}

	public static Object fromJson(String json, Class<?> clazz) {

		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<JSONObject> getValuesForGivenKey(JSONArray jsonArray) {
	    return IntStream.range(0, jsonArray.length())
	      .mapToObj(index -> ((JSONObject)jsonArray.get(index)))
	      .collect(Collectors.toList());
	}
	
@PostConstruct
private void initDatabase(){
	try {
		JSONArray json = new JSONArray(IOUtils.toString(new URL("https://a511e938-a640-4868-939e-6eef06127ca1.mock.pstmn.io/handsets/list"), Charset.forName("UTF-8")));
		List<JSONObject> jsonList = getValuesForGivenKey(json);
		for(JSONObject jsonObj :jsonList) {
			Document doc = Document.parse(jsonObj.toString());
			mongoTemplate.insert(doc, "device");
		}
	} catch (DuplicateKeyException e) {
		logger.warn("Duplicate entry --- This entry already exists in the database");
	}
	catch (JSONException | IOException e) {
		// TODO Auto-generated catch block
		logger.warn("Duplicate entry --- This entry already exists in the database");
	}
}
}