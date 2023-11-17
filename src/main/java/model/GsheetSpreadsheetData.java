package model;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GsheetSpreadsheetData {

  @SerializedName("shipper_id")
  private Long shipperId;
  private String name;
  private String contact;
  private String email;
  private String address;
  private String postcode;
  @SerializedName("bank_name")
  private String bankName;
  @SerializedName("bank_branch")
  private String bankBranch;
  @SerializedName("bank_account_number")
  private String bankAccountNumber;
  @SerializedName("bank_account_proof")
  private String bankAccountProof;
  @SerializedName("ic_number")
  private String icNumber;

}
