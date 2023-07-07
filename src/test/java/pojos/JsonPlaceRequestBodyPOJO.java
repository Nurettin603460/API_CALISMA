package pojos;

public class JsonPlaceRequestBodyPOJO {

    /*{
        "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
    }*/
    //1.aşama: Obje içerisindeki tüm key değerlerini class level.de private variable olarak hazırla.
    // değişkenlerin hepsi private yapılmalı. çünkü enculpciluation özelliklerinden yararlanmak için..
    private String title;
    private String body;
    private int userId;
    private int id;

    //2.aşama: Getter Setter ları hazırla. (Getter --> sadece okuma, setter--> sadece set yapma) (sağ tıkla, getter and setter.a tıkla. hepsini seç.
               //Not:değişkenler private değil de public yapılsaydı getter setter.a gerek kalmazdı.


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3.Aşama: Tüm parametleri içeren constructor oluştur.

    public JsonPlaceRequestBodyPOJO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4.Aşama: Parametreli constructor oluşturduğumuzdan parametresiz constructor "öldüğünden" tekrar ihtiyaç olabilir diye
                // parametresiz constructor oluşturuyoruz. sağ tıkla, generate--> constructor--> alt kısımda select none tıkla.


    public JsonPlaceRequestBodyPOJO() {
    }

    //5. Aşama: toString metodu oluştur: Sağ tıkla, generate--> toString--> ok.(hepsi seçili)
        // toString; bir kalıp hazırlar. Örneği aşağıda yorum satırında belirtilmiştir. Map gibi yazıyor: Key-Value.

    @Override
    public String toString() {
        return "JsonPlaceRequestBodyPOJO{" +// {
                "title='" + title + '\'' +  //title='Ahmet'
                ", body='" + body + '\'' +  //,body='Merhaba'
                ", userId=" + userId +      //,userId=10
                ", id=" + id +              //,id=70
                '}';                        // }
    }
}