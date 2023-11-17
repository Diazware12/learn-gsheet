package utils;

import com.google.gson.Gson;
import java.util.List;

public class JsonConverterUtil {

  private static final String JSON_MAP_ATTRIBUTE = "\"%s\":\"%s\"";
  private static final String JSON_MAP_OBJECT = "{%s}";

  private static final String JSON_MAP_ATTRIBUTE_COMMA = "\"%s\":\"%s\",";
  private static final String JSON_MAP_OBJECT_COMMA = "{%s},";

  public static String convertDataToJson(List<List<Object>> datas, List<Object> headerValue){
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    int index = 0;

    for (List<Object> objectSelector : datas) {
      if (index == datas.size()-1){
        sb.append(String.format(JSON_MAP_OBJECT,convertDataToJsonObject(objectSelector,headerValue)));
      } else {
        sb.append(String.format(JSON_MAP_OBJECT_COMMA,convertDataToJsonObject(objectSelector,headerValue)));
      }
      index++;
    }

    sb.append("]");

    return sb.toString();
  }

  private static StringBuilder convertDataToJsonObject(List<Object> objectSelector,List<Object> header){
    StringBuilder stringBuilder = new StringBuilder();

    for (int j = 0; j < header.size(); j++) {
      if (j == header.size()-1){
        stringBuilder.append(String.format(JSON_MAP_ATTRIBUTE,header.get(j),objectSelector.get(j)));
      } else {
        stringBuilder.append(String.format(JSON_MAP_ATTRIBUTE_COMMA,header.get(j),objectSelector.get(j)));
      }
    }

    return stringBuilder;
  }


}
