/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetointegrador;

/**
 *
 * @author MOISESSILVASANTOSBAR
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import dao.*;
import exception.ValidacaoException;
import model.*;

public class ProjetoIntegrador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Caminhao> listaCaminhao = new ArrayList<>();
        List<Talhao> listaTalhao = new ArrayList<>();
        List<Checkin> listaCheckin = new ArrayList<>();
        List<Viagem> listaViagem = new ArrayList<>();
        
        boolean sair;
        boolean valido;
        int opcao;
        
        System.out.println("===  SISTEMA DE GESTÃO FROTANA ===");
        do {
            valido = false;
            sair = false;
            System.out.println("--- x -- menu  principal -- x ---");
            System.out.println("1 | Menu de Caminhao");
            System.out.println("2 | Menu de Talhão");
            System.out.println("3 | Menu de Viagem");
            System.out.println("4 | Menu de Check-in");
            System.out.println("5 | Sair do Sistema...");
            System.out.println("Digite a sua opção (n° correspondente): ");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1 -> { //MENU DE CAMINHAO
                    sair = false;
                    do {
                        valido = false;
                        System.out.println("\n--- x -- menu  de CAMINHÃO -- x ---");
                        System.out.println("1 | Cadastrar Caminhão");
                        System.out.println("2 | Atualizar Caminhão");
                        System.out.println("3 | Remover Caminhão");
                        System.out.println("4 | Buscar Caminhão por ID");
                        System.out.println("5 | Listar todos os Caminhões");
                        System.out.println("6 | Voltar ao menu Principal...");
                        System.out.println("Digite a sua opção (n° correspondente): ");
                        opcao = sc.nextInt();
                        sc.nextLine();
                        
                        switch (opcao) {
                            case 1 -> { //ADICIONAR CAMINHÃO
                                CaminhaoDAO cDao = new CaminhaoDAO();
                                valido = false;
                                
                                while (!valido) {
                                    Caminhao c = new Caminhao();
                                    try {
                                        System.out.println("\n--- x -- CADASTRO DE CAMINHÃO -- x ---");
                                        
                                        System.out.print("Digite a Placa do Caminhão (formato: 'ABC-1234'): ");
                                        String placa = sc.nextLine();
                                        c.setPlaca(placa);
                                        
                                        System.out.print("Digite o Modelo do Caminhão: ");
                                        String modelo = sc.nextLine();
                                        c.setModelo(modelo);
                                        
                                        System.out.print("Digite a Capacidade de Toneladas do Caminhão: ");
                                        Double capacidade = Double.parseDouble(sc.nextLine());
                                        c.setCapacidadeTon(capacidade);
                                        
                                        System.out.print("Digite o status atual do Caminhão (DISPONIVEL ou INDISPONIVEL): ");
                                        String status = sc.nextLine();
                                        c.setStatusAtual(status);
                                        
                                        System.out.print("Digite um comentário (opcional): ");
                                        String comentario = sc.nextLine();
                                        c.setComentario(comentario);
                                        
                                        cDao.adiciona(c);
                                        System.out.println("Caminhão adicionado com Sucesso.");
                                        valido = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números com ponto (ex: 10.5)!");   
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    } 
                                }
                            }
                            case 2 -> { //ATUALIZAR CAMINHAO
                                CaminhaoDAO cDao = new CaminhaoDAO();
                                valido = false;
                                
                                while (!valido) {
                                    Caminhao c = new Caminhao();
                                    try {
                                        System.out.println("\n--- x -- ATUALIZAÇÃO DE CAMINHÃO -- x ---");
                                        
                                        System.out.print("Digite a Placa do Caminhão (formato: 'ABC-1234'): ");
                                        String placa = sc.nextLine();
                                        c.setPlaca(placa);
                                        
                                        System.out.print("Digite o Modelo do Caminhão: ");
                                        String modelo = sc.nextLine();
                                        c.setModelo(modelo);
                                        
                                        System.out.print("Digite a Capacidade de Toneladas do Caminhão: ");
                                        Double capacidade = Double.parseDouble(sc.nextLine());
                                        c.setCapacidadeTon(capacidade);
                                        
                                        System.out.print("Digite o status atual do Caminhão (DISPONIVEL ou INDISPONIVEL): ");
                                        String status = sc.nextLine();
                                        c.setStatusAtual(status);
                                        
                                        System.out.print("Digite um comentário (opcional): ");
                                        String comentario = sc.nextLine();
                                        c.setComentario(comentario);
                                        
                                        System.out.println("Digite o ID do Caminhão que deseja atualizar: ");
                                        int id = Integer.parseInt(sc.nextLine());
                                        
                                        if (cDao.buscarId(id)) {
                                            cDao.atualiza(c);
                                            valido = true;
                                            System.out.println("Caminhão Atualizado com Sucesso.");
                                        } else {
                                            System.out.println("ERRO: ID de Caminhão inexistente. Voltando ao Menu...");
                                            valido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 3 -> { //REMOVER CAMINHAO
                                CaminhaoDAO cDao = new CaminhaoDAO();
                                valido = false;
                                while (!valido) {
                                    try {
                                        System.out.println("\n--- x -- REMOÇÃO DE CAMINHÃO -- x ---");
                                        System.out.println("Digite o ID do Caminhão que deseja apagar: ");
                                        int id = Integer.parseInt(sc.nextLine());
                                        
                                        if (cDao.buscarId(id)) {
                                            cDao.remova(id);
                                            System.out.println("Caminhão deletado com sucesso.");
                                            valido = true;
                                        } else {
                                            System.out.println("ERRO: ID de Caminhão inexistente. Voltando ao Menu...");
                                            valido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 4 -> { //BUSCAR CAMINHAO POR ID
                                CaminhaoDAO cDao = new CaminhaoDAO();
                                valido = false;
                                while (!valido) {
                                    try {
                                        System.out.println("\n--- x -- BUSCA DE CAMINHÃO -- x ---");
                                        System.out.println("Digite o ID do Caminhão que deseja buscar: ");
                                        int id = Integer.parseInt(sc.nextLine());
                                        
                                        if (cDao.buscarId(id)) {
                                            System.out.println(cDao.buscarPorId(id));
                                            valido = true;
                                        } else {
                                            System.out.println("ERRO: ID de Caminhão inexistente. Voltando ao Menu...");
                                            valido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 5 -> { //LISTAR TODOS
                                CaminhaoDAO cDao = new CaminhaoDAO();
                                listaCaminhao = cDao.listaTodos();

                                System.out.println("\n--- x -- LISTAGEM DOS CAMINHÕES -- x ---");

                                // 1. Primeiro verifica se a lista está vazia
                                if (listaCaminhao.isEmpty()) {
                                    System.out.println("Nenhum Caminhão Cadastrado...");
                                } else {
                                    // 2. Só faz o laço se houver dados
                                    for (Caminhao c : listaCaminhao) {
                                        // O println chama o toString() que você configurou
                                        System.out.println(c);
                                        System.out.println("------------------------------------");
                                    }
                                }
                            }
                            case 6 -> { //VOLTAR AO MENU ANTERIOR
                                sair = true;
                                System.out.println("Voltando ao menu principal...");
                            }
                            default -> { //DIGITOU ERRADO, PEREÇA
                                System.out.println("ERRO: Digite alguma opção válida.");
                            } 
                        }
                    } while (!sair); // FECHA MENU DO CAMINHÃO
                }
                case 2 -> { //MENU DO TALHÃO
                    sair = false;
                    do {
                        valido = false;
                        System.out.println("\n--- x -- menu  de TALHÃO -- x ---");
                        System.out.println("1 | Cadastrar Talhão");
                        System.out.println("2 | Atualizar Talhão");
                        System.out.println("3 | Remover Talhão");
                        System.out.println("4 | Buscar Talhão por ID");
                        System.out.println("5 | Listar todos os Talhões");
                        System.out.println("6 | Voltar ao menu Principal...");
                        System.out.println("Digite a sua opção (n° correspondente): ");
                        opcao = sc.nextInt();
                        sc.nextLine();
                        
                        switch (opcao) {
                            case 1 -> { //CADASTRAR TALHÃO
                                TalhaoDAO tDao = new TalhaoDAO();
                                valido = false;
                                
                                while (!valido) {
                                    Talhao t = new Talhao();
                                    try {
                                        System.out.println("\n--- x -- CADASTRO DE TALHÃO -- x ---");
                                        
                                        System.out.println("Digite o Codigo (área) do Talhão: ");
                                        t.setCodigoArea(sc.nextLine());
                                        
                                        System.out.println("Digite o Tonelada de Cada por Hectare (estimado): ");
                                        double brix = Double.parseDouble(sc.nextLine());
                                        t.setBrix(brix);
                                        
                                        System.out.println("Digite a Data do Plantio do Talhão (DIA/MES/ANO): ");
                                        String dataPlantio = sc.nextLine();
                                        t.setDataPlantio(dataPlantio);
                                        
                                        System.out.println("Digite a umidade do Talhão: ");
                                        double umidade = Double.parseDouble(sc.nextLine());
                                        t.setUmidade(umidade);
                                        
                                        System.out.println("Tem florada (1 = sim | 2 = não): ");
                                        int temFlorada = Integer.parseInt(sc.nextLine());
                                        if (temFlorada == 1) {
                                            t.setTemFlorada(true);
                                        } else if (temFlorada == 2) {
                                            t.setTemFlorada(false);
                                        } else {
                                            throw new ValidacaoException("ERRO: Insira uma opção válida.");
                                        }
                                        
                                        tDao.adiciona(t);
                                        System.out.println("Talhão adicionado com sucesso.");
                                        valido = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números com ponto (ex: 10.5)!");   
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    } 
                                }
                            }
                            case 2 -> { //ATUALIZAR TALHÃO
                                TalhaoDAO tDao = new TalhaoDAO();
                                valido = false;
                                
                                while (!valido) {
                                    Talhao t = new Talhao();
                                    try {
                                        System.out.println("\n--- x -- ATUALIZAÇÃO DE TALHÃO -- x ---");
                                        
                                        System.out.println("Digite o Codigo (área) do Talhão: ");
                                        String area = sc.nextLine();
                                        t.setCodigoArea(area);
                                        
                                        System.out.println("Digite o Tonelada de Cada por Hectare (estimado): ");
                                        double brix = Double.parseDouble(sc.nextLine());
                                        t.setBrix(brix);
                                        
                                        System.out.println("Digite a Data do Plantio do Talhão (DIA/MES/ANO): ");
                                        String dataPlantio = sc.nextLine();
                                        t.setDataPlantio(dataPlantio);
                                        
                                        System.out.println("Digite a umidade do Talhão: ");
                                        double umidade = Double.parseDouble(sc.nextLine());
                                        t.setUmidade(umidade);
                                        
                                        System.out.println("Tem florada (1 = sim | 2 = não): ");
                                        int temFlorada = Integer.parseInt(sc.nextLine());
                                        if (temFlorada == 1) {
                                            t.setTemFlorada(true);
                                        } else if (temFlorada == 2) {
                                            t.setTemFlorada(false);
                                        } else {
                                            throw new ValidacaoException("ERRO: Insira uma opção válida.");
                                        }
                                        
                                        System.out.println("Digite o ID do Talhão que deseja atualizar: ");
                                        int id = Integer.parseInt(sc.nextLine());
                                        
                                        if (tDao.buscarId(id)) {
                                            tDao.atualiza(t);
                                            System.out.println("Caminhão Atualizado com Sucesso.");
                                            valido = true;
                                        } else {
                                            System.out.println("ERRO: ID de Caminhão inexistente. Voltando ao Menu...");
                                            valido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números com ponto (ex: 10.5)!");   
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    } 
                                }
                            }
                            case 3 -> { //APAGAR TALHÃO
                                TalhaoDAO tDao = new TalhaoDAO();
                                valido = false;
                                while (!valido) {
                                    try {
                                        System.out.println("\n--- x -- REMOÇÃO DE TALHÃO -- x ---");
                                        System.out.println("Digite o ID do Talhão que deseja apagar: ");
                                        int id = Integer.parseInt(sc.nextLine());
                                        
                                        if (tDao.buscarId(id)) {
                                            tDao.remova(id);
                                            System.out.println("Talhão deletado com sucesso.");
                                            valido = true;
                                        } else {
                                            System.out.println("ERRO: ID de Talhão inexistente. Voltando ao Menu...");
                                            valido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 4 -> { //BUSCAR POR ID TALHÃO
                                TalhaoDAO tDao = new TalhaoDAO();
                                valido = false;
                                while (!valido) {
                                    try {
                                        System.out.println("\n--- x -- BUSCA DE TALHÃO -- x ---");
                                        System.out.println("Digite o ID do Talhão que deseja buscar: ");
                                        int id = Integer.parseInt(sc.nextLine());
                                        
                                        if (tDao.buscarId(id)) {
                                            System.out.println(tDao.buscarPorId(id));
                                            valido = true;
                                        } else {
                                            System.out.println("ERRO: ID de Talhão inexistente. Voltando ao Menu...");
                                            valido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 5 -> { //LISTAR TODOS TALHÃO
                                TalhaoDAO tDao = new TalhaoDAO();
                                listaTalhao = tDao.listaTodos();

                                System.out.println("\n--- x -- LISTAGEM DOS TALHÕES -- x ---");

                                // 1. Primeiro verifica se a lista está vazia
                                if (listaTalhao.isEmpty()) {
                                    System.out.println("Nenhum Talhão Cadastrado...");
                                } else {
                                    // 2. Só faz o laço se houver dados
                                    for (Talhao t : listaTalhao) {
                                        // O println chama o toString() que você configurou
                                        System.out.println(t);
                                        System.out.println("------------------------------------");
                                    }
                                }
                            }
                            case 6 -> { //VOLTAR PARA MENU
                                sair = true;
                                System.out.println("Voltando ao menu principal...");
                            }
                            default -> { //DIGITOU ERRADO, PEREÇA
                                System.out.println("ERRO: Digite alguma opção válida.");
                            } 
                        }
                    } while (!sair);
                }
                case 3 -> { //MENU DE VIAGEM
                    sair = false;
                    do {
                        valido = false;
                        System.out.println("\n--- x -- menu  de VIAGEM -- x ---");
                        System.out.println("1 | Iniciar Viagem");
                        System.out.println("2 | Finalizar Viagem");
                        System.out.println("3 | Atualizar Viagem");
                        System.out.println("4 | Remover Viagem");
                        System.out.println("5 | Buscar Viagem por ID");
                        System.out.println("6 | Listar todos as Viagens");
                        System.out.println("7 | Voltar ao menu Principal...");
                        System.out.println("Digite a sua opção (n° correspondente): ");
                        opcao = sc.nextInt();
                        sc.nextLine();
                    
                        switch (opcao) {
                            case 1 -> { //Iniciar Viagem
                                ViagemDAO vDao = new ViagemDAO();
                                CaminhaoDAO cDao = new CaminhaoDAO();
                                TalhaoDAO tDao = new TalhaoDAO();
                                
                                if (cDao.listaTodos().isEmpty() || tDao.listaTodos().isEmpty()) {
                                    System.out.println("\nERRO: Não é possível iniciar uma viagem!");
                                    System.out.println("Certifique-se de que existem CAMINHÕES e TALHÕES cadastrados primeiro.");
                                } else {
                                    while (!valido) {
                                        Viagem v = new Viagem();
                                        try {
                                            System.out.println("\n--- x -- INICIAR VIAGEM -- x ---");

                                            // 1. Selecionar o Caminhão
                                            System.out.print("Digite o ID do Caminhão: ");
                                            int idCam = Integer.parseInt(sc.nextLine());
                                            Caminhao c = cDao.buscarPorId(idCam);
                                            if (c == null) throw new ValidacaoException("Caminhão não encontrado!");
                                            v.setCaminhao(c);

                                            // 2. Selecionar o Talhão
                                            System.out.print("Digite o ID do Talhão: ");
                                            int idTal = Integer.parseInt(sc.nextLine());
                                            Talhao t = tDao.buscarPorId(idTal);
                                            if (t == null) throw new ValidacaoException("Talhão não encontrado!");
                                            v.setTalhao(t);

                                            // O banco geralmente gera a Data e o Status 'EM ANDAMENTO' sozinho,
                                            // então aqui a gente já pode mandar salvar!
                                            vDao.registrarInicio(v); 

                                            System.out.println("Viagem iniciada com sucesso!");
                                            valido = true;

                                        } catch (NumberFormatException e) {
                                            System.out.println("ERRO: Digite apenas números para os IDs!");
                                        } catch (ValidacaoException e) {
                                            System.out.println("\n" + e.getMessage());
                                        }
                                    }
                                }
                            }
                            case 2 -> { //Finalizar Viagem
                                ViagemDAO vDao = new ViagemDAO();

                                while (!valido) {
                                    try {
                                        if (vDao.listaTodos().isEmpty()) {
                                                System.out.println("Certifique-se de que existem VIAGENS cadastrados primeiro.");
                                        } else {
                                            System.out.println("\n--- x -- FINALIZAR VIAGEM -- x ---");

                                            System.out.print("Digite o ID da Viagem que deseja finalizar: ");
                                            int idViagem = Integer.parseInt(sc.nextLine());

                                            // 1. Busca a viagem para ter certeza que ela existe
                                            Viagem v = vDao.buscarPorId(idViagem);

                                            if (v == null) {
                                                throw new ValidacaoException("ERRO: Viagem não encontrada!");
                                            }

                                            // 2. Preenche o Peso Bruto
                                            System.out.print("Digite o Peso Bruto (Kg): ");
                                            double pesoBruto = Double.parseDouble(sc.nextLine());
                                            v.setPesoBruto(pesoBruto);

                                            // 4. Chama o método de atualizar no DAO
                                            vDao.registrarFim(v); 

                                            System.out.println("Viagem finalizada com sucesso!");
                                            valido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite um valor numérico válido!");
                                    } catch (ValidacaoException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                            case 3 -> { //Atualizar Viagem
                                ViagemDAO vDao = new ViagemDAO();
                                CaminhaoDAO cDao = new CaminhaoDAO();
                                TalhaoDAO tDao = new TalhaoDAO();

                                while (!valido) {
                                    try {
                                        System.out.println("\n--- x -- ATUALIZAR DADOS DA VIAGEM -- x ---");
                                        
                                        if (vDao.listaTodos().isEmpty()) {
                                            System.out.println("Certifique-se de que existem VIAGENS cadastrados primeiro.");
                                            valido = true;
                                        } else {
                                            System.out.print("Digite o ID da Viagem que deseja alterar: ");
                                            int idViagem = Integer.parseInt(sc.nextLine());

                                            // 1. Busca a viagem atual para verificar se existe
                                            Viagem v = vDao.buscarPorId(idViagem);
                                            if (v == null) {
                                                throw new ValidacaoException("ERRO: Viagem não encontrada!");
                                            }

                                            // 2. Atualizar Caminhão
                                            System.out.print("Novo ID do Caminhão: ");
                                            int idCam = Integer.parseInt(sc.nextLine());
                                            Caminhao c = cDao.buscarPorId(idCam);
                                            if (c == null) {
                                                throw new ValidacaoException("Caminhão não encontrado!");
                                            }
                                            v.setCaminhao(c);

                                            // 3. Atualizar Talhão
                                            System.out.print("Novo ID do Talhão: ");
                                            int idTal = Integer.parseInt(sc.nextLine());
                                            Talhao t = tDao.buscarPorId(idTal);
                                            if (t == null) {
                                                throw new ValidacaoException("Talhão não encontrado!");
                                            }
                                            v.setTalhao(t);

                                            // 4. Atualizar Datas (Usando seu Validador de Timestamp)
                                            System.out.print("Nova Data/Hora Início (dd/MM/yyyy HH:mm): ");
                                            v.setDataHoraInicio(sc.nextLine()); // O set do seu model já deve usar o Validador

                                            System.out.print("Nova Data/Hora Fim (dd/MM/yyyy HH:mm): ");
                                            v.setDataHoraFim(sc.nextLine());

                                            // 5. Atualizar Peso
                                            System.out.print("Novo Peso Bruto (Kg): ");
                                            v.setPesoBruto(Double.parseDouble(sc.nextLine()));

                                            // 6. Salvar no Banco
                                            vDao.atualiza(v);

                                            System.out.println("Viagem atualizada com sucesso!");
                                            valido = true;
                                        }
                                    }   catch (NumberFormatException e) {
                                        System.out.println("ERRO: Formato numérico inválido!");
                                    } catch (ValidacaoException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                            case 4 -> { //Remover Viagem
                                ViagemDAO vDao = new ViagemDAO();

                                while (!valido) {
                                    try {
                                        if (vDao.listaTodos().isEmpty()) {
                                            System.out.println("Certifique-se de que existem VIAGENS cadastrados primeiro.");
                                        } else {
                                            System.out.println("\n--- x -- REMOVER VIAGEM -- x ---");
                                            System.out.print("Digite o ID da Viagem que deseja EXCLUIR: ");
                                            int id = Integer.parseInt(sc.nextLine());

                                            // 1. Validação de segurança: o ID existe?
                                            if (vDao.buscarId(id)) { // Usando aquele seu método que retorna boolean
                                                System.out.print("Tem certeza que deseja excluir a viagem " + id + "? (S/N): ");
                                                String confirma = sc.nextLine().toUpperCase();

                                                if (confirma.equals("S")) {
                                                    vDao.remova(id); // O método que você já deve ter no DAO
                                                    System.out.println("Viagem removida com sucesso!");
                                                } else {
                                                    System.out.println("Operação cancelada.");
                                                }
                                                valido = true; // Sai do loop independente se excluiu ou cancelou
                                            } else {
                                                throw new ValidacaoException("ERRO: ID de Viagem inexistente.");
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("[ERRO] Digite um ID numérico válido!");
                                    } catch (ValidacaoException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                            case 5 -> { //Buscar Viagem por ID
                                ViagemDAO vDao = new ViagemDAO();
                                valido = false;
                                while (!valido) {
                                    try {
                                        System.out.println("\n--- x -- BUSCA DE VIAGEM -- x ---");
                                        System.out.print("Digite o ID da Viagem que deseja buscar: ");
                                        int id = Integer.parseInt(sc.nextLine());

                                        if (vDao.buscarId(id)) {
                                            // Aqui o segredo: o println chama automaticamente o toString()
                                            System.out.println(vDao.buscarPorId(id));
                                            valido = true;
                                        } else {
                                            System.out.println("ERRO: ID de Viagem inexistente. Voltando ao Menu...");
                                            valido = true; // Para ele não ficar preso se o cara errar
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite apenas números!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 6 -> { //Listar todos as Viagens
                                ViagemDAO vDao = new ViagemDAO();
                                listaViagem = vDao.listaTodos();

                                System.out.println("\n--- x -- LISTAGEM DAS VIAGENS -- x ---");

                                // 1. Primeiro verifica se a lista está vazia
                                if (listaViagem.isEmpty()) {
                                    System.out.println("Nenhuma Viagem Cadastrado...");
                                } else {
                                    // 2. Só faz o laço se houver dados
                                    for (Viagem v : listaViagem) {
                                        // O println chama o toString() que você configurou
                                        System.out.println(v);
                                        System.out.println("------------------------------------");
                                    }
                                }
                            }
                            case 7 -> { //VOLTAR PARA MENU
                                    sair = true;
                                    System.out.println("Voltando ao menu principal...");
                                }
                            default -> { //DIGITOU ERRADO, PEREÇA
                                System.out.println("ERRO: Digite alguma opção válida.");
                            } 
                        }
                    
                    } while (!sair);
                }
                case 4 -> { //MENU DE CHECKIN
                    sair = false;
                    do {
                        valido = false;
                        System.out.println("\n--- x -- menu  de Check-in -- x ---");
                        System.out.println("1 | Cadastrar Check-in");
                        System.out.println("2 | Atualizar Check-in");
                        System.out.println("3 | Remover Check-in");
                        System.out.println("4 | Buscar Check-in por ID");
                        System.out.println("5 | Listar todos os Check-in");
                        System.out.println("6 | Voltar ao menu Principal...");
                        System.out.println("Digite a sua opção (n° correspondente): ");
                        opcao = sc.nextInt();
                        sc.nextLine();
                        
                        switch (opcao) {
                            case 1 -> { //Cadastrar Check-in
                                CheckinDAO chDao = new CheckinDAO();
                                ViagemDAO vDao = new ViagemDAO();

                                // Validação: Só faz check-in se existir uma viagem ativa
                                if (vDao.listaTodos().isEmpty()) {
                                    System.out.println("\nERRO: Não existem viagens cadastradas para realizar check-in!");
                                } else {
                                    while (!valido) {
                                        Checkin ch = new Checkin();
                                        try {
                                            System.out.println("\n--- x -- REGISTRAR CHECK-IN -- x ---");

                                            // 1. Vincular à Viagem
                                            System.out.print("Digite o ID da Viagem: ");
                                            int idViagem = Integer.parseInt(sc.nextLine());

                                            // Buscamos a viagem completa para garantir que ela existe
                                            Viagem v = vDao.buscarPorId(idViagem);
                                            if (v == null) {
                                                throw new ValidacaoException("Viagem não encontrada!");
                                            }

                                            ch.setViagem(v);

                                            // 2. Localização (Texto/Cidade/Coordenada)
                                            System.out.print("Digite a Localização Atual (Ex: Passo Fundo - RS): ");
                                            String local = sc.nextLine();
                                            ch.setLocalizacao(local);

                                            // 3. Salvar no Banco
                                            // A data/hora do check-in geralmente é gerada pelo banco (NOW())
                                            chDao.registrarCheckin(ch);

                                            System.out.println("Check-in registrado com sucesso!");
                                            valido = true;

                                        } catch (NumberFormatException e) {
                                            System.out.println("ERRO: Digite um ID de viagem válido!");
                                        } catch (ValidacaoException e) {
                                            System.out.println("\n" + e.getMessage());
                                        }
                                    }
                                }
                            }
                            case 2 -> { //Atualizar Check-in
                                CheckinDAO chDao = new CheckinDAO();
                                ViagemDAO vDao = new ViagemDAO();

                                while (!valido) {
                                    try {
                                        if (chDao.listaTodos().isEmpty()) {
                                            System.out.println("Certifique-se de que existem CHECK-INs cadastrados primeiro.");
                                            valido = true;
                                        } else {
                                            System.out.println("\n--- x -- ATUALIZAR CHECK-IN -- x ---");
                                            System.out.print("Digite o ID do Check-in que deseja alterar: ");
                                            int idCheckin = Integer.parseInt(sc.nextLine());

                                            // 1. Busca o check-in atual para verificar se existe
                                            // Você pode usar um método buscarPorId no seu CheckinDAO
                                            Checkin ch = chDao.buscarPorId(idCheckin);
                                            if (ch == null) {
                                                throw new ValidacaoException("ERRO: Check-in não encontrado!");
                                            }

                                            // 2. Atualizar a Viagem (Caso tenha vinculado ao ID errado)
                                            System.out.print("Novo ID da Viagem (ID atual: " + ch.getViagem().getIdViagem() + "): ");
                                            int idViagem = Integer.parseInt(sc.nextLine());
                                            Viagem v = vDao.buscarPorId(idViagem);
                                            if (v == null) {
                                                throw new ValidacaoException("Viagem não encontrada!");
                                            }
                                            ch.setViagem(v);

                                            // 3. Atualizar Localização
                                            System.out.print("Nova Localização: ");
                                            ch.setLocalizacao(sc.nextLine());

                                            // 4. Atualizar Data/Hora do Registro (Usando seu Validador)
                                            // IMPORTANTE: Como você quer editar o registro manual, usamos o formato dd/MM/yyyy HH:mm
                                            System.out.print("Nova Data/Hora (dd/MM/yyyy HH:mm): ");
                                            String novaData = sc.nextLine();
                                            // Aqui seu model deve converter essa String para Timestamp/LocalDateTime
                                            ch.setDataHoraRegistro(novaData);

                                            // 5. Salvar no Banco
                                            chDao.atualizarCheckin(ch);

                                            System.out.println("Check-in atualizado com sucesso!");
                                            valido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Formato numérico ou de data inválido!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 3 -> { //Remover Check-in
                                CheckinDAO chDao = new CheckinDAO();
                                valido = false;

                                while (!valido) {
                                    try {
                                        if (chDao.listaTodos().isEmpty()) {
                                            System.out.println("Certifique-se de que existem CHECK-INs cadastrados primeiro.");
                                        } else {
                                            System.out.println("\n--- x -- REMOVER CHECK-IN -- x ---");
                                            System.out.print("Digite o ID do Check-in que deseja EXCLUIR: ");
                                            int id = Integer.parseInt(sc.nextLine());

                                            // 1. Validamos se o ID existe antes de tentar apagar
                                            if (chDao.buscarId(id)) {
                                                // Buscamos o objeto só para mostrar um detalhe e confirmar
                                                Checkin ch = chDao.buscarPorId(id);
                                                System.out.print("Tem certeza que deseja excluir o check-in em '" + ch.getLocalizacao() + "'? (S/N): ");
                                                String confirma =  sc.nextLine().toUpperCase();

                                                if (confirma.equals("S")) {
                                                    chDao.deletarCheckin(id);
                                                    System.out.println("Check-in removido com sucesso!");
                                                } else {
                                                    System.out.println("Operação cancelada.");
                                                }
                                                valido = true;
                                            } else {
                                                System.out.println("ERRO: ID de Check-in inexistente. Voltando ao Menu...");
                                                valido = true;
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("ERRO: Digite um ID numérico válido!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 4 -> { //Buscar Check-in por ID
                                CheckinDAO chDao = new CheckinDAO();
                                valido = false;

                                while (!valido) {
                                    try {
                                        System.out.println("\n--- x -- BUSCA DE CHECK-IN -- x ---");
                                        System.out.print("Digite o ID do Check-in que deseja buscar: ");
                                        int id = Integer.parseInt(sc.nextLine());

                                        // 1. Verificamos se o ID existe
                                        if (chDao.buscarId(id)) {
                                            // 2. O println chama o toString() do seu Model Checkin
                                            System.out.println("\n--- DADOS DO CHECK-IN ---");
                                            System.out.println(chDao.buscarPorId(id));
                                            System.out.println("-------------------------");
                                            valido = true;
                                        } else {
                                            System.out.println("ERRO: ID de Check-in inexistente. Voltando ao Menu...");
                                            valido = true;
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("[ERRO] Digite um ID numérico válido!");
                                    } catch (ValidacaoException e) {
                                        System.out.println("\n" + e.getMessage());
                                    }
                                }
                            }
                            case 5 -> { //Listar todos os Check-in
                                CheckinDAO chDao = new CheckinDAO();
                                listaCheckin = chDao.listaTodos();

                                System.out.println("\n--- x -- LISTAGEM DOS CHECK-INs -- x ---");

                                // 1. Primeiro verifica se a lista está vazia
                                if (listaCheckin.isEmpty()) {
                                    System.out.println("Nenhuma Check-in Cadastrado...");
                                } else {
                                    // 2. Só faz o laço se houver dados
                                    for (Checkin ch : listaCheckin) {
                                        // O println chama o toString() que você configurou
                                        System.out.println(ch);
                                        System.out.println("------------------------------------");
                                    }
                                }
                            }
                            case 6 -> { //VOLTAR PARA MENU
                                    sair = true;
                                    System.out.println("Voltando ao menu principal...");
                                }
                            default -> { //DIGITOU ERRADO, PEREÇA
                                System.out.println("ERRO: Digite alguma opção válida.");
                            }
                        }
                        
                    } while (!sair);
                }
                case 5 -> { //SAIR = TRUE
                    sair = true;
                    System.out.println("Desligando o sistema...");
                }
                default -> { //DIGITOU ERRADO, VOU TE MATAR
                    System.out.println("ERRO: Digite alguma opção válida."); 
                }
            }  
        } while (!sair); 
    }    
}