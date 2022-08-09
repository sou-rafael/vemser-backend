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

db.postagem.insertMany(
    [
        {
            "idPostagem":1,
            "idUsuario":2,
            "tipoPostagem":"VAGAS",
            "titulo":"Oportunidade de trabalho remoto",
            "descricao":"Vaga em aberto para trabalhar remoto.",
            "foto":"http...",
            "curtidas":0,
            "data": new Date.now()
        },
        {
            "idPostagem":2,
            "idUsuario":4,
            "tipoPostagem":"PENSAMENTOS",
            "titulo":"Pensamentos positivos",
            "descricao":"Por vezes sentimos que aquilo que fazemos não é senão uma gota de água no mar. Mas o mar seria menor se lhe faltasse uma gota.",
            "foto":"http...",
            "curtidas":10,
            "data": new Date.now()
        }
    ])

db.postagem.insertOne(
    {
        "idPostagem":3,
        "idUsuario":1,
        "tipoPostagem":"PENSAMENTOS",
        "titulo":"Continuação de pensamentos positivos",
        "descricao":"Se a sua vida for a melhor coisa que já te aconteceu, acredite, você tem mais sorte do que pode imaginar.",
        "foto":"http...",
        "curtidas":150,
        "data": new Date.now()
    }
)
//FIND
db.comentario.find({}).sort({curtidas:-1})

db.postagem.find({
tipoPostagem: "PENSAMENTOS",
data:{$gte: new Date(2010,1,1)}
})

//UPDATE
db.comentario.updateOne(
    { "descricao": { $regex: /demais/ } },
    { $set: { "descricao": "Absurdo!!" } }
);

db.postagem.updateMany(
    { tipoPostagem: "PENSAMENTOS" },
    { $set: { foto:"nenhuma foto"}}
)

//PROJECTION
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

//AGGREGATE
db.postagem.aggregate([
    {$group: {_id: "$tipoPostagem", countQuantity: {$count:{}}}}
])

db.postagem.aggregate([
    {$match: {titulo: { $regex: /positivo/ }}},
    {$group: {_id: "$tipoPostagem", countQuantity: {$count:{}}}}
])

//DELETE
db.comentario.deleteOne(
    { "descricao": { $regex: /vou/ } },
)

db.comentario.deleteMany({})
