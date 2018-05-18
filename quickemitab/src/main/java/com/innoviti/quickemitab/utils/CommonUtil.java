package com.innoviti.quickemitab.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class CommonUtil {


  /**
   * Method to copy the the list of beans properties from source to destination
   * class bean
   * 
   * @param sourceList
   * @param D
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  @SuppressWarnings("unchecked")
  public static <Source, Destination> List<Destination> copyListBeanProperty(Iterable<Source> sourceList,
                                                                             Class<?> Destiniation) throws InstantiationException,
                                                                                                IllegalAccessException {
    List<Destination> list = new ArrayList<Destination>();
    for(Source source : sourceList) {
      list.add((Destination) copyBeanProperties(source, Destiniation));
    }
    return list;
  }

  /**
   * Method to copy the the bean properties from source to destination class
   * bean
   * 
   * @param source
   * @param Destination
   * @return
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  @SuppressWarnings("unchecked")
  public static <Source, Destination> Destination copyBeanProperties(Source source, Class<?> Destination) {
    Destination destination = null;
	try {
		destination = (Destination) Destination.newInstance();
		BeanUtils.copyProperties(source, destination);
	} catch (InstantiationException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	}
    return destination;
  }
  
	/**
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String convertObjectToJsonStr(Object obj) {
		String jsonStr = null;
		try {
			ObjectMapper mapperObj = new ObjectMapper();
			jsonStr = mapperObj.writeValueAsString(obj);
			System.out.println("JSon file created");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

}
