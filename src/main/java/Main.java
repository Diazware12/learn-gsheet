import class_from_json.GsheetSpreadsheetDataV2;
import java.util.List;
import model.GsheetSpreadsheetData;
import model.Shipper;
import utils.GsheetResponseUtils;

public class Main {

  public static void main(String args[]) throws Exception {
    //NVQA-12337 - [Common Ext] Google sheet util part 1 (mirza & diaz)
    final String SHIPPER_APPLICATION_NAME = "shipper";
    final String shipperSpreadsheetId = "1J7YW-7oQtkuNKAsdcJ8UBjTpZ7vbSzYsuw3xX-6h20I";
    final String shipperRange = "Shipper1!A:B";
    List<Shipper> shipper = GsheetResponseUtils.getGsheetResponse(SHIPPER_APPLICATION_NAME,
        shipperSpreadsheetId, shipperRange, Shipper.class);

    //NVQA-12338 - [Common Ext] Google sheet util part 2 (diaz)
    final String APPLICATION_NAME = "foo";
    final String spreadsheetId = "1MTY4xvJ4nnghJPmAJ8Wd0HA8nPWUrAqa8RfcxRdSbSI";
    final String range = "Sheet1!A:K";
    List<GsheetSpreadsheetData> foo = GsheetResponseUtils.getGsheetResponse(APPLICATION_NAME,
        spreadsheetId, range, GsheetSpreadsheetData.class);

  }

}
