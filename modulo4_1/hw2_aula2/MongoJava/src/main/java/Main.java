import com.mongodb.Block;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vem_ser");
        mongoDatabase.createCollection("alunos2");

        MongoCollection<Document> alunos = mongoDatabase.getCollection("alunos2");

        //insert novo aluno
        Document novoAluno = new Document("nome", "Lucas")
                .append("data_nascimento", new Date(2000, 12, 5));
        alunos.insertOne(novoAluno);

        Document novoAluno1 = new Document("nome", "Samuel")
                .append("data_nascimento", new Date(2012, 9, 24));
        Document novoAluno2 = new Document("nome", "Alice Peixoto")
                .append("data_nascimento", new Date(2016, 5, 26));
        Document novoAluno3 = new Document("nome", "Mateus")
                .append("data_nascimento", new Date(2018, 3, 22));
        Document novoAluno4 = new Document("nome", "Tasia")
                .append("data_nascimento", new Date(1982, 8, 30));
        Document novoAluno5 = new Document("nome", "Maria Auxiliadora")
                .append("data_nascimento", new Date(2000, 12, 5));

        List<Document> inserts = new ArrayList<>();
        inserts.add(novoAluno1);
        inserts.add(novoAluno2);
        inserts.add(novoAluno3);
        inserts.add(novoAluno4);
        inserts.add(novoAluno5);

        alunos.insertMany(inserts);

        //Listar aluno
        Document documents = alunos.find(new Document("nome", "Alice Peixoto")).first();
        System.out.println(documents.toJson());

        // agregação
        alunos.aggregate(
                Arrays.asList(
                        match(Filters.gte("data_nascimento", new Date(2000, 1, 1))),
                        group("$nome")
                )).forEach((Block<? super Document>) doc -> System.out.println(doc.toJson()));

        //update
        alunos.updateOne(Filters.eq("nome", "Maria Auxiliadora"), new Document("$set", new Document("nome", "Auxiliadora")));

        //delete
        Document toDelete = alunos.find(new Document("nome", "Lucas")).first();
        DeleteResult deleteResult = alunos.deleteOne(toDelete);
        System.out.println(deleteResult);

        alunos.drop();

    }
}
