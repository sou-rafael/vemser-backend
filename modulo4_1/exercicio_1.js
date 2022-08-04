use vem_ser
db.alunos.insertMany([
    {
        "nome": "Samuel Peixoto",
        "data_nascimento": new Date(2012, 09, 24)
    },
    {
        "nome": "Alice Peixoto",
        "data_nascimento": new Date(2016, 05, 26)
    },
    {
        "nome": "Mateus Peixoto",
        "data_nascimento": new Date(2018, 03, 22)
    }])

db.alunos.find({})

db.alunos.find().pretty()

db.alunos.find(
    {
        "nome": "Samuel Peixoto"
    }
).pretty()