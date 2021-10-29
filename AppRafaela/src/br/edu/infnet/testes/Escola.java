package br.edu.infnet.testes;

import java.util.Scanner;

public class Escola {
	
	private static String[] nomes;
	private static float[] notaum;
	private static float[] notadois;

	private static final int QTDE_MAX = 100;
	private static int qtde = 0;

    private static void impressao(){
		System.out.println("-- Relatório da Turma --");

        for (int j = 0; j < qtde; j++) {
			impressao(j);
		}
		System.out.println("-----------------------------------");
	}

	private static float calcularMedia(int idx){
		return (notaum[idx] + notadois[idx]) / 2;
	}

    private static String obterSituacao(float media){
    	if (media < 4) {
    		return "Reprovado";
    	} else if (media > 4 && media < 7) {
    		return "Prova final";
    	}
    	return "Aprovado";
	}

	private static void impressao(int index){
		float media = calcularMedia(index);

		String situacao = obterSituacao(media);		

		System.out.println(
				index + " - " + "Nome: " + nomes[index] + " - " + "AV1: " + notaum[index] + " - " + "AV2: " +
				notadois[index] + " - " + "Média: " + media + " :: " + situacao);
	}

    public static void main(String[] args){

		nomes = new String[QTDE_MAX];
		notaum = new float[QTDE_MAX];
		notadois = new float[QTDE_MAX];

		int opcao = 0;		

		Scanner in = new Scanner(System.in);

        do {
			System.out.println("[1] Registrar as notas de um novo aluno.");
			System.out.println("[2] Consultar boletim de um aluno"); 
			System.out.println("[3] Consultar notas da turma");
			System.out.println("[4] Sair");
			System.out.print("Informe a opção desejada: ");
			opcao = in.nextInt();
			
			switch (opcao) {
                case 1:
				if(qtde < QTDE_MAX) {
					System.out.print("Informe o nome do aluno: ");
					nomes[qtde] = in.next();
					
					System.out.print("Informe a nota da AV1: ");
					notaum[qtde] = in.nextFloat();
					
					System.out.print("Informe a nota da AV2: ");
					notadois[qtde] = in.nextFloat();

                    System.out.println("Aluno registrado com o código " + qtde);
                    
                    System.out.println("-----------------------------------");

					qtde++;
					
				} else {
					System.out.println("Impossível realizar o cadastramento!!!");
				}
				break;

                case 2:
				System.out.println("Informe o código do aluno: ");
				int codigo = in.nextInt();

				if(codigo >= 0 && codigo < qtde) {
					impressao(codigo);
				} else {
					System.out.println("O código " + codigo + " é inválido!!");
				}				
				break;

			case 3:
				impressao();			
				break;

			case 4:
				System.out.println("Sair");
				break;
				
			default:
				System.out.println("Opção inválida!!!");
				break;
			}			
		} while (opcao != 4);
		
		in.close();
		
		System.out.println("Processamento realizado!!!");
	}
}



