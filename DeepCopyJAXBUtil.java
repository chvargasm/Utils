package com.latam.pax.displaypnr.ws.impl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;


/**
 * 
 * @author cvargasm
 *
 */
public class DeepCopyJAXBUtil {
	
	
	public static <T> T deepCopyJAXB(T object, Class<T> clazz) {
		  try {
		    JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		    JAXBElement<T> contentObject = new JAXBElement<T>(new QName(clazz.getSimpleName()), clazz, object);
		    JAXBSource source = new JAXBSource(jaxbContext, contentObject);
		    return jaxbContext.createUnmarshaller().unmarshal(source, clazz).getValue();
		  } catch (JAXBException e) {
		      throw new RuntimeException(e);
		  }
		}

	@SuppressWarnings("unchecked")
	public static <T> T deepCopyJAXB(T object) {
		  if(object==null) throw new RuntimeException("Can't guess at class");
		  return deepCopyJAXB(object, (Class<T>) object.getClass());
		}

}
