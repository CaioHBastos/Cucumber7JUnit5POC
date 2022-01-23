#language: pt

@ConsultarUsuario
Funcionalidade: Consultar os dados dos usuarios


  Fundo:
    Dado que quero consultar os dados dos usuarios

  Cenario: Consultar os dados de usuarios quando nao existe cadastro na base
    Quando informo que quero visualizar os usuarios na base sem cadastro
    Entao devera ser exibido o corpo da resposta vazio

  Cenario: Consultar os dados de todos os usuarios
    Quando informo que quero visualizar os usuarios na base com cadastro
    Entao devera ser exibido os dados de todos os usuarios