/*
 * Copyright (c) 2018 Yu Ning
 * FileName: ClassUtils.java
 * Author:   ningyu
 * Date:     2018年2月8日
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package cn.tsoft.framework.testing.jmeter.plugin.util;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import cn.tsoft.framework.testing.jmeter.plugin.dubbo.sample.MethodArgument;

import com.google.common.reflect.TypeToken;

public class ClassUtils {

	private static final String TYPE_NAME_PREFIX = "class ";

	public static String getClassName(Type type) {
		if (type == null) {
			return "";
		}
		String className = type.toString();
		if (className.startsWith(TYPE_NAME_PREFIX)) {
			className = className.substring(TYPE_NAME_PREFIX.length());
		}
		return className;
	}

	@SuppressWarnings("rawtypes")
	public static String[] getMethodParamType(String interfaceName,
			String methodName) {
		try {
			// 创建类
			Class<?> class1 = Class.forName(interfaceName);
			// 获取所有的公共的方法
			Method[] methods = class1.getMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] paramClassList = method.getParameterTypes();
					String[] paramTypeList = new String[paramClassList.length];
					int i = 0;
					for (Class className : paramClassList) {
						paramTypeList[i] = className.getName();
						i++;
					}
					return paramTypeList;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void parseParameter(Type type,List<String> paramterTypeList, 
			List<Object> parameterValuesList, MethodArgument arg)
			throws ClassNotFoundException {
		String className = getClassName(type);
		if (className.equals("int")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Integer.parseInt(arg.getParamValue()));
		} else if (className.equals("double")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Double.parseDouble(arg.getParamValue()));
		} else if (className.equals("short")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Short.parseShort(arg.getParamValue()));
		} else if (className.equals("float")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Float.parseFloat(arg.getParamValue()));
		} else if (className.equals("long")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Long.parseLong(arg.getParamValue()));
		} else if (className.equals("byte")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Byte.parseByte(arg.getParamValue()));
		} else if (className.equals("boolean")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Boolean.parseBoolean(arg.getParamValue()));
		} else if (className.equals("char")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(arg.getParamValue().charAt(0));
		} else if (className.equals("java.lang.String")
				|| className.equals("String") || className.equals("string")) {
			paramterTypeList.add("java.lang.String");
			parameterValuesList.add(String.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Integer")
				|| className.equals("Integer") || className.equals("integer")) {
			paramterTypeList.add("java.lang.Integer");
			parameterValuesList.add(Integer.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Double")
				|| className.equals("Double")) {
			paramterTypeList.add("java.lang.Double");
			parameterValuesList.add(Double.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Short")
				|| className.equals("Short")) {
			paramterTypeList.add("java.lang.Short");
			parameterValuesList.add(Short.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Long")
				|| className.equals("Long")) {
			paramterTypeList.add("java.lang.Long");
			parameterValuesList.add(Long.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Float")
				|| className.equals("Float")) {
			paramterTypeList.add("java.lang.Float");
			parameterValuesList.add(Float.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Byte")
				|| className.equals("Byte")) {
			paramterTypeList.add("java.lang.Byte");
			parameterValuesList.add(Byte.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Boolean")
				|| className.equals("Boolean")) {
			paramterTypeList.add("java.lang.Boolean");
			parameterValuesList.add(Boolean.valueOf(arg.getParamValue()));
		} else {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(JsonUtils.formJson(arg.getParamValue(),
					type));
		}
	}
	
	@SuppressWarnings("serial")
	public static void parseParameter(List<String> paramterTypeList, 
			List<Object> parameterValuesList, MethodArgument arg) {
		String className = arg.getParamType();
		if (className.equals("int")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Integer.parseInt(arg.getParamValue()));
		} else if (className.equals("double")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Double.parseDouble(arg.getParamValue()));
		} else if (className.equals("short")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Short.parseShort(arg.getParamValue()));
		} else if (className.equals("float")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Float.parseFloat(arg.getParamValue()));
		} else if (className.equals("long")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Long.parseLong(arg.getParamValue()));
		} else if (className.equals("byte")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Byte.parseByte(arg.getParamValue()));
		} else if (className.equals("boolean")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(Boolean.parseBoolean(arg.getParamValue()));
		} else if (className.equals("char")) {
			paramterTypeList.add(arg.getParamType());
			parameterValuesList.add(arg.getParamValue().charAt(0));
		} else if (className.equals("java.lang.String")
				|| className.equals("String") || className.equals("string")) {
			paramterTypeList.add("java.lang.String");
			parameterValuesList.add(String.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Integer")
				|| className.equals("Integer") || className.equals("integer")) {
			paramterTypeList.add("java.lang.Integer");
			parameterValuesList.add(Integer.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Double")
				|| className.equals("Double")) {
			paramterTypeList.add("java.lang.Double");
			parameterValuesList.add(Double.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Short")
				|| className.equals("Short")) {
			paramterTypeList.add("java.lang.Short");
			parameterValuesList.add(Short.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Long")
				|| className.equals("Long")) {
			paramterTypeList.add("java.lang.Long");
			parameterValuesList.add(Long.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Float")
				|| className.equals("Float")) {
			paramterTypeList.add("java.lang.Float");
			parameterValuesList.add(Float.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Byte")
				|| className.equals("Byte")) {
			paramterTypeList.add("java.lang.Byte");
			parameterValuesList.add(Byte.valueOf(arg.getParamValue()));
		} else if (className.equals("java.lang.Boolean")
				|| className.equals("Boolean")) {
			paramterTypeList.add("java.lang.Boolean");
			parameterValuesList.add(Boolean.valueOf(arg.getParamValue()));
		} else {
			try {
				Class<?> clazz = Class.forName(className);
				paramterTypeList.add(arg.getParamType());
				parameterValuesList.add(JsonUtils.formJson(arg.getParamValue(), clazz));
			} catch (ClassNotFoundException e) {
				//不是jdk或者lib下的类，使用通用map格式反序列化值
				paramterTypeList.add(arg.getParamType());
				parameterValuesList.add(JsonUtils.formJson(arg.getParamValue(), new TypeToken<Map<String,Object>>() {}.getType()));
			}
		}
	}
}
