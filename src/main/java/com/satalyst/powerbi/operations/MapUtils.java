package com.satalyst.powerbi.operations;

import com.satalyst.powerbi.model.Column;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Aidan Morgan
 */
public class MapUtils {

	public static String getString(Map map, String name) {
		if (map.containsKey(name))
			return (String) map.get(name);
		return "";
	}

	public static List<Map> getList(Map map, String name) {
		if (map.containsKey(name))
			return (List<Map>) map.get(name);
		return null;
	}

	public static UUID getUuid(Map map, String name) {
		if (map.containsKey(name))
			return UUID.fromString(getString(map, name));
		return null;
	}

	public static List<Column> getColumns(Map map, String name) {
		if (map.containsKey(name))
			return (List<Column>) map.get(name);
		return null;
	}

	public static Double getDouble(Map map, String name) {
		if (map.containsKey(name))
			return (Double) map.get(name);
		return null;
	}
}
