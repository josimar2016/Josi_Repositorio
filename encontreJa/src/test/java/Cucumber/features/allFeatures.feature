#language: pt
Funcionalidade: Deverá ser possivel registar um novo utilizador na plataforma

@registarUser
    Cenário: Os campos de registo de User estão todos preenchidos com dados válidos
    Dado O nome Afonso
    E Email afonso@ua.pt
    E Telefone 919191911
    E Localizacao Aveiro
    E Password 1212
    Quando Eu seleciono enviar
    Então Eu devo ficar registado com sucesso

@registarProfissional
    Cenário: Os campos de registo de Profissional estão todos preenchidos com dados válidos
    Dado O nome maria
    E Email maria@ua.pt
    E Telefone 123456789
    E Localizacao Aveiro
    E Password qwerty
    E Area carpinteiro
    E Descricao vontade de trabalhar
    E Custo 25
    E CustoDeslocacao 10
    Quando Eu seleciono registarPro
    Então Eu devo ficar registado com sucesso


@login
    Cenário: Os campos de login estão preenchidos com dados válidos
    Dado O meu email é afonso@ua.pt
    E Password é 1212
    Quando Eu Selecionar Login
    Então O meu login vai ser efetuado com sucesso

@EncontrarProfissional
    Cenário: Os campos de encontrar Profissional estão preenhidos
    Dado O que preciso é de uma empregada de limpeza
    E Na localidade de Aveiro
    Quando Eu selecionar pesquisar
    Então Devo receber a informação que existe pelo menos uma empregada com o nome de maria amelia

