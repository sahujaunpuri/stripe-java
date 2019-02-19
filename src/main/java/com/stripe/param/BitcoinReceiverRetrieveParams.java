// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class BitcoinReceiverRetrieveParams extends ApiRequestParams {
  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  private BitcoinReceiverRetrieveParams(List<String> expand) {
    this.expand = expand;
  }

  public static Builder builder() {
    return new com.stripe.param.BitcoinReceiverRetrieveParams.Builder();
  }

  public static class Builder {
    private List<String> expand;

    /** Finalize and obtain parameter instance from this builder. */
    public BitcoinReceiverRetrieveParams build() {
      return new BitcoinReceiverRetrieveParams(this.expand);
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link
     * BitcoinReceiverRetrieveParams#expand} for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }
  }
}