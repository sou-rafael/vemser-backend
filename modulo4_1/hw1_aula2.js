db.createCollection("comentario");

db.comentario.insertMany([
    {
        "idComentario": 1,
        "idPostagem": 1,
        "descricao": "Gostei demais",
        "curtidas": "12",
        "data": new Date(2022, 1, 1),
        "usuario": {
            "id": 1,
            "nome": "Rafael",
            "tipo": "DEV"
        }
    },
    {
        "idComentario": 2,
        "idPostagem": 1,
        "descricao": "Simplesmenmte genial",
        "curtidas": "127",
        "data": new Date(2020, 1, 1),
        "usuario": {
            "id": 2,
            "nome": "Gabriel",
            "tipo": "ADMIN"
        }
    },
    {
        "idComentario": 3,
        "idPostagem": 2,
        "descricao": "Vou apagar.",
        "curtidas": "5000",
        "data": new Date(2022, 8, 4),
        "usuario": {
            "id": 2,
            "nome": "Gabriel",
            "tipo": "ADMIN"
        }
    }
]);

db.comentario.insertOne([
    {
        "idComentario": 4,
        "idPostagem": 3,
        "descricao": "Achei interessante demais",
        "curtidas": "512",
        "data": new Date(2022, 4, 1),
        "usuario": {
            "id": 1,
            "nome": "Rafael",
            "tipo": "DEV"
        }
    }
])

db.comentario.updateOne(
    { "descricao": { $regex: /demais/ } },
    { $set: { "descricao": "Absurdo!!" } }
);

db.comentario.find({ idPostagem: 1 },
    {
        descricao: true,
        usuario: {
            nome: true,
            tipo:true
        },
        data: true
    }
)

db.comentario.find({
    data:{
        $gte:new Date(2022,1,1)
    }
})


db.comentario.deleteOne(
    { "descricao": { $regex: /vou/ } },
)

db.comentario.deleteMany({})
