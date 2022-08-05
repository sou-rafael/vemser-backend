use vem_ser
db.alunos.insertMany([
    {
        "nome": "Rafael Ferreira",
        "data_nascimento": new Date(1982,1,29)
    },
    {
        "nome": "Tasia Peixoto",
        "data_nascimento": new Date(1982,8,30)
    },
    {
        "nome": "Maria Auxiliadora",
        "data_nascimento": new Date(1955,1,25)
    }])

db.alunos.find(
    {
        "nome": "Samuel Peixoto"
    }
).pretty()  
// tem que estar exatamente como foi passado.

db.alunos.find({
    "nome":{$regex:/el/}
  })    
// contem este trecho.

db.alunos.find({
    "data_nascimento": {$gte:new Date(2012,1,1)},
})      
// datas de nascimento mais recentes q essa data.

db.alunos.find({
    "data_nascimento": {$lte:new Date(2012,1,1)},
})      
// datas de nascimento mais antigas q essa data.