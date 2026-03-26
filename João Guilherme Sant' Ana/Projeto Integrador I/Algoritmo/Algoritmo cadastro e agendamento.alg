algoritmo "Gestao_Fertilizacao"
var
    opcao: inteiro
    id_planta, id_funcionario, id_area, id_tempo, id_analise, id_agendamento: inteiro
    fase_crescimento, nome_funcionario, cargo_funcionario: caractere
    descricao_area, tipo_solo, data_previsao, data_analise: caractere
    data_agendada, tipo_fertilizante, status: caractere
    precipitacao_mm, velocidade_vento_kmh, umidade_ar: real
    umidade_solo_atual, nivel_nitrogenio: real

inicio
    id_planta <- 0
    id_funcionario <- 0
    id_area <- 0
    id_tempo <- 0
    id_analise <- 0
    id_agendamento <- 0
    opcao <- -1

    repita
        escreval("====================================")
        escreval("1 - Cadastrar Planta")
        escreval("2 - Cadastrar Funcionario")
        escreval("3 - Cadastrar Area de Plantio")
        escreval("4 - Cadastrar Previsao do Tempo")
        escreval("5 - Cadastrar Analise de Solo")
        escreval("6 - Realizar Agendamento (TRIGGER)")
        escreval("0 - Sair")
        escreval("====================================")
        leia(opcao)

        escolha opcao
            caso 1
                id_planta <- id_planta + 1
                escreval("ID Planta Gerado: ", id_planta)
                escreval("Fase de Crescimento: ")
                leia(fase_crescimento)

            caso 2
                id_funcionario <- id_funcionario + 1
                escreval("ID Funcionario Gerado: ", id_funcionario)
                escreval("Nome: ")
                leia(nome_funcionario)
                escreval("Cargo: ")
                leia(cargo_funcionario)

            caso 3
                id_area <- id_area + 1
                escreval("ID Area Gerado: ", id_area)
                escreval("Descricao: ")
                leia(descricao_area)
                escreval("Tipo de Solo: ")
                leia(tipo_solo)

            caso 4
                id_tempo <- id_tempo + 1
                escreval("ID Previsao Gerado: ", id_tempo)
                escreval("Data da Previsao: ")
                leia(data_previsao)
                escreval("Precipitacao (mm): ")
                leia(precipitacao_mm)
                escreval("Velocidade do Vento (km/h): ")
                leia(velocidade_vento_kmh)
                escreval("Umidade do Ar (%): ")
                leia(umidade_ar)

            caso 5
                id_analise <- id_analise + 1
                escreval("ID Analise Gerado: ", id_analise)
                escreval("Data da Analise: ")
                leia(data_analise)
                escreval("Umidade do Solo Atual: ")
                leia(umidade_solo_atual)
                escreval("Nivel de Nitrogenio: ")
                leia(nivel_nitrogenio)

            caso 6
                id_agendamento <- id_agendamento + 1
                escreval("ID Agendamento Gerado: ", id_agendamento)
                escreval("Data Desejada para Agendamento: ")
                leia(data_agendada)
                escreval("Tipo de Fertilizante: ")
                leia(tipo_fertilizante)

                se (data_agendada = data_previsao) e (precipitacao_mm > 10.0) entao
                    escreval("ERRO: Agendamento bloqueado. Previsao de chuva acima de 10mm.")
                    status <- "Bloqueado"
                senao
                    escreval("SUCESSO: Agendamento salvo no sistema.")
                    status <- "Aprovado"
                fimse
        fimescolha
    ate opcao = 0
fimalgoritmo
