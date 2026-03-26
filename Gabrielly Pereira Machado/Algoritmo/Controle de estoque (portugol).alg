algoritmo "SistemaControleEstoque"

var
nome_produto : vetor[1..100] de caractere
categoria : vetor[1..100] de caractere
fornecedor : vetor[1..100] de caractere
filial : vetor[1..100] de caractere

preco : vetor[1..100] de real
qtd_compra : vetor[1..100] de inteiro
qtd_distribuicao : vetor[1..100] de inteiro
estoque_final : vetor[1..100] de inteiro

continuar : caractere
i, total : inteiro

inicio

escreval("========================================")
escreval("   SISTEMA DE CONTROLE DE ESTOQUE")
escreval("========================================")

i <- 1
continuar <- "S"

enquanto continuar <> "N" faca

```
  escreval("")
  escreval(">>> CADASTRO DE PRODUTO <<<")

  escreva("Nome do produto: ")
  leia(nome_produto[i])

  escreva("Categoria: ")
  leia(categoria[i])

  escreva("Preço: ")
  leia(preco[i])

  escreval("Produto cadastrado com sucesso!")

  escreval("")
  escreval(">>> REGISTRO DE COMPRA <<<")

  escreva("Fornecedor: ")
  leia(fornecedor[i])

  escreva("Quantidade comprada: ")
  leia(qtd_compra[i])

  enquanto qtd_compra[i] < 0 faca
     escreva("Valor inválido! Digite novamente: ")
     leia(qtd_compra[i])
  fimenquanto

  escreval("Compra registrada!")

  escreval("")
  escreval(">>> DISTRIBUIÇÃO PARA FILIAL <<<")

  escreva("Nome da filial: ")
  leia(filial[i])

  escreva("Quantidade enviada: ")
  leia(qtd_distribuicao[i])

  enquanto qtd_distribuicao[i] < 0 faca
     escreva("Valor invalido! Digite novamente: ")
     leia(qtd_distribuicao[i])
  fimenquanto

  // Cálculo de estoque final
  estoque_final[i] <- qtd_compra[i] - qtd_distribuicao[i]

  escreval("Distribuicao registrada!")

  escreval("")
  escreva("Deseja cadastrar outro produto? (S/N): ")
  leia(continuar)

  i <- i + 1
```

fimenquanto

total <- i - 1

escreval("")
escreval("========================================")
escreval("           RELATÓRIO FINAL")
escreval("========================================")

para i <- 1 ate total faca
escreval("Produto: ", nome_produto[i])
escreval("Categoria: ", categoria[i])
escreval("Preço: R$ ", preco[i]:0:2)
escreval("Fornecedor: ", fornecedor[i])
escreval("Quantidade Comprada: ", qtd_compra[i])
escreval("Filial: ", filial[i])
escreval("Quantidade Distribuida: ", qtd_distribuicao[i])
escreval("Estoque Final: ", estoque_final[i])
escreval("----------------------------------------")
fimpara

escreval("Total de registros: ", total)
escreval("Sistema finalizado com sucesso.")

fimalgoritmo

