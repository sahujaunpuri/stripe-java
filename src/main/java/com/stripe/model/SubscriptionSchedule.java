package com.stripe.model;

import com.google.gson.annotations.SerializedName;

import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;

import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SubscriptionSchedule extends ApiResource
    implements MetadataStore<SubscriptionSchedule>, HasId {
  /**
   * Either `charge_automatically`, or `send_invoice`. When charging automatically, Stripe will
   * attempt to pay the underlying subscription at the end of each billing cycle using the default
   * source attached to the customer. When sending an invoice, Stripe will email your customer an
   * invoice with payment instructions.
   */
  @SerializedName("billing")
  String billing;

  /**
   * Define thresholds at which an invoice will be sent, and the subscription advanced to a new
   * billing period.
   */
  @SerializedName("billing_thresholds")
  Subscription.BillingThresholds billingThresholds;

  /**
   * Time at which the subscription schedule was canceled. Measured in seconds since the Unix epoch.
   */
  @SerializedName("canceled_at")
  Long canceledAt;

  /**
   * Time at which the subscription schedule was completed. Measured in seconds since the Unix
   * epoch.
   */
  @SerializedName("completed_at")
  Long completedAt;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /**
   * Object representing the start and end dates for the current phase of the subscription schedule,
   * if it is `active`.
   */
  @SerializedName("current_phase")
  CurrentPhase currentPhase;

  /** ID of the customer who owns the subscription schedule. */
  @SerializedName("customer")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Customer> customer;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  @SerializedName("id")
  String id;

  /** The subscription schedule's default invoice settings. */
  @SerializedName("invoice_settings")
  InvoiceSettings invoiceSettings;

  /**
   * Has the value `true` if the object exists in live mode or the value `false` if the object
   * exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format.
   */
  @SerializedName("metadata")
  Map<String, String> metadata;

  /** String representing the object's type. Objects of the same type share the same value. */
  @SerializedName("object")
  String object;

  /** Configuration for the subscription schedule's phases. */
  @SerializedName("phases")
  List<Phase> phases;

  /**
   * Time at which the subscription schedule was released. Measured in seconds since the Unix epoch.
   */
  @SerializedName("released_at")
  Long releasedAt;

  /** ID of the subscription once managed by the subscription schedule (if it is released). */
  @SerializedName("released_subscription")
  String releasedSubscription;

  /** Behavior of the subscription schedule and underlying subscription when it ends. */
  @SerializedName("renewal_behavior")
  String renewalBehavior;

  /**
   * Interval and duration at which the subscription schedule renews for when it ends if
   * `renewal_behavior` is `renew`.
   */
  @SerializedName("renewal_interval")
  RenewalInterval renewalInterval;

  /** ID of the current revision of the subscription schedule. */
  @SerializedName("revision")
  String revision;

  /** Possible values are `not_started`, `active`, `completed`, `released`, and `canceled`. */
  @SerializedName("status")
  String status;

  /** ID of the subscription managed by the subscription schedule. */
  @SerializedName("subscription")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Subscription> subscription;

  /** Get id of expandable `customer` object. */
  public String getCustomer() {
    return (this.customer != null) ? this.customer.getId() : null;
  }

  public void setCustomer(String id) {
    this.customer = ApiResource.setExpandableFieldId(id, this.customer);
  }

  /** Get expanded `customer`. */
  public Customer getCustomerObject() {
    return (this.customer != null) ? this.customer.getExpanded() : null;
  }

  public void setCustomerObject(Customer expandableObject) {
    this.customer = new ExpandableField<Customer>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `subscription` object. */
  public String getSubscription() {
    return (this.subscription != null) ? this.subscription.getId() : null;
  }

  public void setSubscription(String id) {
    this.subscription = ApiResource.setExpandableFieldId(id, this.subscription);
  }

  /** Get expanded `subscription`. */
  public Subscription getSubscriptionObject() {
    return (this.subscription != null) ? this.subscription.getExpanded() : null;
  }

  public void setSubscriptionObject(Subscription expandableObject) {
    this.subscription =
        new ExpandableField<Subscription>(expandableObject.getId(), expandableObject);
  }

  // <editor-fold desc="cancel">
  /**
   * Cancel a subscription schedule.
   */
  public SubscriptionSchedule cancel() throws StripeException {
    return this.cancel((RequestOptions) null);
  }

  /**
   * Cancel a subscription schedule.
   */
  public SubscriptionSchedule cancel(RequestOptions options) throws StripeException {
    return cancel(null, options);
  }

  /**
   * Cancel a subscription schedule.
   */
  public SubscriptionSchedule cancel(Map<String, Object> params) throws StripeException {
    return this.cancel(params, null);
  }

  /**
   * Cancel a subscription schedule.
   */
  public SubscriptionSchedule cancel(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return request(RequestMethod.POST, String.format("%s/cancel",
        instanceUrl(SubscriptionSchedule.class, this.getId())), params, SubscriptionSchedule.class,
            options);
  }
  // </editor-fold>

  // <editor-fold desc="create">
  /**
   * Create a subscription schedule.
   */
  public static SubscriptionSchedule create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /**
   * Create a subscription schedule.
   */
  public static SubscriptionSchedule create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return request(RequestMethod.POST, classUrl(SubscriptionSchedule.class), params,
        SubscriptionSchedule.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="list">
  /**
   * List all subscription schedules.
   */
  public static SubscriptionScheduleCollection list(Map<String, Object> params)
      throws StripeException {
    return list(params, null);
  }

  /**
   * List all subscription schedules.
   */
  public static SubscriptionScheduleCollection list(Map<String, Object> params,
      RequestOptions options)
      throws StripeException {
    return requestCollection(classUrl(SubscriptionSchedule.class), params,
        SubscriptionScheduleCollection.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="release">
  /**
   * Release a subscription schedule.
   */
  public SubscriptionSchedule release() throws StripeException {
    return this.release((RequestOptions) null);
  }

  /**
   * Release a subscription schedule.
   */
  public SubscriptionSchedule release(RequestOptions options) throws StripeException {
    return release(null, options);
  }

  /**
   * Release a subscription schedule.
   */
  public SubscriptionSchedule release(Map<String, Object> params) throws StripeException {
    return this.release(params, null);
  }

  /**
   * Release a subscription schedule.
   */
  public SubscriptionSchedule release(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return request(RequestMethod.POST, String.format("%s/release",
        instanceUrl(SubscriptionSchedule.class, this.getId())), params,
            SubscriptionSchedule.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="retrieve">
  /**
   * Retrieve a subscription schedule.
   */
  public static SubscriptionSchedule retrieve(String id) throws StripeException {
    return retrieve(id, (RequestOptions) null);
  }

  /**
   * Retrieve a subscription schedule.
   */
  public static SubscriptionSchedule retrieve(String id, RequestOptions options)
      throws StripeException {
    return retrieve(id, null, options);
  }

  /**
   * Retrieve a subscription schedule.
   */
  public static SubscriptionSchedule retrieve(String id, Map<String, Object> params,
      RequestOptions options)
      throws StripeException {
    return request(RequestMethod.GET, instanceUrl(SubscriptionSchedule.class, id), params,
        SubscriptionSchedule.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="update">
  /**
   * Update a subscription schedule.
   */
  @Override
  public SubscriptionSchedule update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Update a subscription schedule.
   */
  @Override
  public SubscriptionSchedule update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return request(RequestMethod.POST, instanceUrl(SubscriptionSchedule.class, this.id), params,
        SubscriptionSchedule.class, options);
  }
  // </editor-fold>

  // <editor-fold desc="revisions">
  /**
   * List a subscription schedule's revisions.
   */
  public SubscriptionScheduleRevisionCollection revisions()
      throws StripeException {
    return revisions(null, null);
  }

  /**
   * List a subscription schedule's revisions.
   */
  public SubscriptionScheduleRevisionCollection revisions(Map<String, Object> params)
      throws StripeException {
    return revisions(params, null);
  }

  /**
   * List a subscription schedule's revisions.
   */
  public SubscriptionScheduleRevisionCollection revisions(Map<String, Object> params,
      RequestOptions options) throws StripeException {
    String url = instanceUrl(SubscriptionSchedule.class, this.getId()) + "/revisions";
    return requestCollection(url, params, SubscriptionScheduleRevisionCollection.class, options);
  }
  // </editor-fold>

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class CurrentPhase extends StripeObject {
    @SerializedName("end_date")
    Long endDate;

    @SerializedName("start_date")
    Long startDate;
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class InvoiceSettings extends StripeObject {
    /**
     * Number of days within which a customer must pay invoices generated by this subscription
     * schedule. This value will be `null` for subscription schedules where
     * `billing=charge_automatically`.
     */
    @SerializedName("days_until_due")
    Long daysUntilDue;
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class Phase extends ApiResource {
    /**
     * A non-negative decimal between 0 and 100, with at most two decimal places. This represents
     * the percentage of the subscription invoice subtotal that will be transferred to the
     * application owner's Stripe account during this phase of the schedule.
     */
    @SerializedName("application_fee_percent")
    BigDecimal applicationFeePercent;

    /** ID of the coupon to use during this phase of the subscription schedule. */
    @SerializedName("coupon")
    @Getter(lombok.AccessLevel.NONE)
    @Setter(lombok.AccessLevel.NONE)
    ExpandableField<Coupon> coupon;

    /** The end of this phase of the subscription schedule. */
    @SerializedName("end_date")
    Long endDate;

    /** Plans to subscribe during this phase of the subscription schedule. */
    @SerializedName("plans")
    List<PhaseItem> plans;

    /** The start of this phase of the subscription schedule. */
    @SerializedName("start_date")
    Long startDate;

    /**
     * If provided, each invoice created during this phase of the subscription schedule will apply
     * the tax rate, increasing the amount billed to the customer.
     */
    @SerializedName("tax_percent")
    BigDecimal taxPercent;

    /** When the trial ends within the phase. */
    @SerializedName("trial_end")
    Long trialEnd;

    /** Get id of expandable `coupon` object. */
    public String getCoupon() {
      return (this.coupon != null) ? this.coupon.getId() : null;
    }

    public void setCoupon(String id) {
      this.coupon = ApiResource.setExpandableFieldId(id, this.coupon);
    }

    /** Get expanded `coupon`. */
    public Coupon getCouponObject() {
      return (this.coupon != null) ? this.coupon.getExpanded() : null;
    }

    public void setCouponObject(Coupon expandableObject) {
      this.coupon = new ExpandableField<Coupon>(expandableObject.getId(), expandableObject);
    }
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class PhaseItem extends StripeObject {
    /**
     * Define thresholds at which an invoice will be sent, and the related subscription advanced to
     * a new billing period.
     */
    @SerializedName("billing_thresholds")
    SubscriptionItem.BillingThresholds billingThresholds;

    /** ID of the plan to which the customer should be subscribed. */
    @SerializedName("plan")
    @Getter(lombok.AccessLevel.NONE)
    @Setter(lombok.AccessLevel.NONE)
    ExpandableField<Plan> plan;

    /** Quantity of the plan to which the customer should be subscribed. */
    @SerializedName("quantity")
    Long quantity;

    /** Get id of expandable `plan` object. */
    public String getPlan() {
      return (this.plan != null) ? this.plan.getId() : null;
    }

    public void setPlan(String id) {
      this.plan = ApiResource.setExpandableFieldId(id, this.plan);
    }

    /** Get expanded `plan`. */
    public Plan getPlanObject() {
      return (this.plan != null) ? this.plan.getExpanded() : null;
    }

    public void setPlanObject(Plan expandableObject) {
      this.plan = new ExpandableField<Plan>(expandableObject.getId(), expandableObject);
    }
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class RenewalInterval extends StripeObject {
    /** Interval at which to renew the subscription schedule for when it ends. */
    @SerializedName("interval")
    String interval;

    /** Number of intervals to renew the subscription schedule for when it ends. */
    @SerializedName("length")
    Long length;
  }
}
