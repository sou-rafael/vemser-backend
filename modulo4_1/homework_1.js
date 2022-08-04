db.createCollection("postagem")

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
        }])

db.postagem.find({})

db.postagem.find({}).pretty()

db.postagem.find({
    "tipoPostagem":"PENSAMENTOS"
}).pretty()