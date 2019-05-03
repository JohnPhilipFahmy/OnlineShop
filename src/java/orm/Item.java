package orm;

public class Item {

    private int ItemId;
    private String ItemType;
    private String ItemName;
    private String Price;
    private boolean Offer;
    
    private String PriceAfterOffer;
  
    private String PriceUnit;
    private String OfferStart;
    private String OfferEnd;
    private String quantity;

   

    public Item(int ItemId, String ItemName,String ItemTybe, String Price, boolean Offer, String PriceAfterOffer,  String PriceUnit, String OfferStart, String OfferEnd, String quantity) {
      this.ItemId=ItemId;
        this.ItemType = ItemTybe;
        this.ItemName = ItemName;
        this.Price = Price;
        this.Offer = Offer;
        this.PriceAfterOffer = PriceAfterOffer;
       
        this.PriceUnit = PriceUnit;
        this.OfferStart = OfferStart;
        this.OfferEnd = OfferEnd;
        this.quantity = quantity; }
     public Item( int ItemId,String ItemName, String Price,String quantity) {

      this.ItemId=ItemId;
        this.ItemName = ItemName;
        this.Price = Price;
        
        this.quantity = quantity; }

    public Item() {
   }

   

    

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }

    public String getItemTybe() {
        return ItemType;
    }

    public void setItemTybe(String ItemTybe) {
        this.ItemType = ItemTybe;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public boolean isOffer() {
        return Offer;
    }

    public void setOffer(boolean Offer) {
        this.Offer = Offer;
    }

    public String getPriceAfterOffer() {
        return PriceAfterOffer;
    }

    public void setPriceAfterOffer(String PriceAfterOffer) {
        this.PriceAfterOffer = PriceAfterOffer;
    }



    public String getPriceUnit() {
        return PriceUnit;
    }

    public void setPriceUnit(String PriceUnit) {
        this.PriceUnit = PriceUnit;
    }

    public String getOfferStart() {
        return OfferStart;
    }

    public void setOfferStart(String OfferStart) {
        this.OfferStart = OfferStart;
    }

    public String getOfferEnd() {
        return OfferEnd;
    }

    public void setOfferEnd(String OfferEnd) {
        this.OfferEnd = OfferEnd;
    }

}
