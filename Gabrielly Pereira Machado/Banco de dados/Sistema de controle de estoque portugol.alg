algoritmo "SistemaControleEstoque"

var
nome_produto : vetor[1..100] de caractere
categoria : vetor[1..100] de caractere
fornecedor : vetor[1..100] de caractere
filial : vetor[1..100] de caractere

preco : vetor[1..100] de real
valor_compra : vetor[1..100] de real

qtd_compra : vetor[1..100] de inteiro
qtd_distribuicao : vetor[1..100] de inteiro

continuar : caractere
i, total : inteiro

inicio

escreval("================================")
escreval("SISTEMA DE CONTROLE DE ESTOQUE")
escreval("================================")

i <- 1
continuar <- "S"

enquanto continuar <> "N" faca

```
  escreval("")
  escreval("CADASTRO DE PRODUTO")

  escreva("Nome do produto: ")
  leia(nome_produto[i])

  escreva("Categoria: ")
  leia(categoria[i])

  escreva("Preco: ")
  leia(preco[i])

  escreval("Produto cadastrado!")

  escreval("")
  escreval("REGISTRO DE COMPRA")

  escreva("Fornecedor: ")
  leia(fornecedor[i])

  escreva("Quantidade comprada: ")
  leia(qtd_compra[i])

  escreva("Valor da compra: ")
  leia(valor_compra[i])

  escreval("Compra registrada!")

  escreval("")
  escreval("DISTRIBUICAO PARA FILIAL")

  escreva("Nome da filial: ")
  leia(filial[i])

  escreva("Quantidade enviada: ")
  leia(qtd_distribuicao[i])



  escreval("")
  escreva("Deseja cadastrar outro produto? (S/N): ")
  leia(continuar)

  i <- i + 1
```

fimenquanto

total <- i - 1

escreval("")
escreval("RELATORIO FINAL")
escreval("------------------------------------------------")

para i <- 1 ate total faca
escreval("Produto: ", nome_produto[i])
escreval("Categoria: ", categoria[i])
escreval("Preco: ", preco[i])
escreval("Fornecedor: ", fornecedor[i])
escreval("Quantidade comprada: ", qtd_compra[i])
escreval("Valor da compra: ", valor_compra[i])
escreval("Filial: ", filial[i])
escreval("Quantidade distribuida: ", qtd_distribuicao[i])
escreval("------------------------------------------------")
fimpara

escreval("Total de registros: ", total)
escreval("Processamento finalizado.")

fimalgoritmo


