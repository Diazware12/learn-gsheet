package class_from_json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GsheedSpreadsheetDataBean {
  private String shipper_id;
  private String name;
  private String contact;
  private String email;
  private String address;
  private String postcode;
  private String bank_name;
  private String bank_branch;
  private String bank_account_number;
  private String bank_account_proof;
  private String ic_number;
}
