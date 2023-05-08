import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class konta {
    private MongoClient client = MongoClients.create("mongodb+srv://wiktork2002:Wk102030@test.9eo0luc.mongodb.net/?retryWrites=true&w=majority");
    private MongoDatabase db = client.getDatabase("konta");
    private MongoCollection<Document> col = db.getCollection("konta");
    public void add(String login,String haslo, String imie, String nazwisko)
    {
          long count = col.countDocuments()+1;
          String counts = Long.toString(count);
        Document samp = new Document("_id",counts).append("login",login);
        samp.append("haslo",haslo);
        samp.append("imie",imie);
        samp.append("nazwisko",nazwisko);
        col.insertOne(samp);
    }
    public void clear()
    {
        client.close();
    }
    public void print()
    {
        for(Document doc:col.find())
        {
            System.out.println(doc.toString());
        }
    }
    public long find(String login, String haslo)
    {
        Document pom = new Document("login",login);
        pom.append("haslo",haslo);
        return col.countDocuments(pom);
    }
    public long find2(String login)
    {
        Document pom = new Document("login",login);
        return col.countDocuments(pom);
    }
}
