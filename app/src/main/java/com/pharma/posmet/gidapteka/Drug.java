package com.pharma.posmet.gidapteka;

/**
 * Created by posmet on 15.12.2017.
 */

public class Drug {
    private String name;
    private String art;
    private int pic;
    private String maker;
    private String price;

    public Drug(String name, String art,int pic,String maker, String price){
        this.name = name;
        this.art = art;
        this.pic=pic;
        this.maker=maker;
        this.price=price;
    }
    public String getName() {return this.name;   }
    public void setName(String name){this.name = name;}
    public String getArt() {return this.art;   }
    public void setArt(String art){this.art = art;}
    public int getPic() {return this.pic;   }
    public void setPic(int pic){this.pic = pic;}
    public String getMaker() {return this.maker;   }
    public void setMaker(String maker){this.maker = maker;}
    public String getPrice() {return this.price;   }
    public void setPrice(String price){this.price = price;}
}
