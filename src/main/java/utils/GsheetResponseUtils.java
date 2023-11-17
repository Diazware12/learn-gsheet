package utils;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.stream.Collectors;

public class GsheetResponseUtils {

  public static<T> List<T> getGsheetResponse(String applicationName, String spreadsheetId,
      String range, Class<T> clazz)
      throws Exception {
    //fetch response
    ValueRange response = fetchResponse(applicationName,spreadsheetId,range);

    //fetch header
    List<Object> headerValue = response.getValues().get(0);

    //filter valid data
    List<List<Object>> listOfData = filterData(response.getValues(), headerValue.size());

    //remove header value
    listOfData.remove(0);

    //process to convert data to request class
    String content = JsonConverterUtil.convertDataToJson(listOfData,headerValue);
    Type type = TypeToken.getParameterized(List.class,clazz).getType();
    return new Gson().fromJson(content, type);
  }

  private static List<List<Object>> filterData(List<List<Object>> datas, int headerValue){
    List<List<Object>> filter = datas.stream().filter(x -> x.size() < headerValue).collect( //filter -> normalize data
        Collectors.toList()); //2

    List<List<Object>> finalResult = datas;

    for (List<Object> objectSelector : filter) { //2
      for (int j = objectSelector.size(); j < headerValue; j++) {
        objectSelector.add("");
      }

      finalResult.removeIf(x -> x.get(0).equals(objectSelector.get(0)));
      finalResult.add(objectSelector);
    }

    return finalResult;
  }

  private static ValueRange fetchResponse(String applicationName, String spreadsheetId,
      String range)
      throws IOException, GeneralSecurityException {
    final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY,
        CredentialUtils.fetch(HTTP_TRANSPORT, JSON_FACTORY))
        .setApplicationName(applicationName)
        .build().spreadsheets().values()
        .get(spreadsheetId, range)
        .execute();
  }

}
