
import com.poo.entity.Aluno;

import java.util.Scanner;

public class SistemaNotasAlunos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo(a) ao cálculo da média de todas as notas do ano de cada aluno!");

        System.out.print("Digite a quantidade de alunos: ");
        int quantidadeAlunos = scanner.nextInt();

        System.out.print("Digite a quantidade de provas para calcular a média: ");
        int quantidadeProvas = scanner.nextInt();
        scanner.nextLine();

        Aluno[] alunos = new Aluno[quantidadeAlunos];

        recebeAlunoNotas(alunos, quantidadeProvas, scanner);
        calculaMediaNotas(alunos, quantidadeProvas);
        exibeAlunosMedia(alunos);

    }




    public static void recebeAlunoNotas(Aluno[] argAlunos, int argProvas, Scanner argScan) {

        for (int i = 0; i < argAlunos.length; i++) {

            System.out.printf("Digite o nome do %d° aluno: ", i + 1);
            String nomeAluno = argScan.next();

            argAlunos[i] = new Aluno(nomeAluno, argProvas);


            argScan.nextLine();

            for (int j = 0; j < argProvas; j++) {

                System.out.printf("Digite a %dª nota de %s: ", j + 1, nomeAluno);
                argAlunos[i].setNotas(argScan.nextDouble(), j);

                argScan.nextLine();

                while (argAlunos[i].getNotas(j) < 0 || argAlunos[i].getNotas(j) > 10) {

                    System.out.printf("A nota %.1f é inválida, digite uma entre 0 à 10: ", argAlunos[i].getNotas(j));
                    argAlunos[i].setNotas(argScan.nextDouble(), j);

                }

            }

            System.out.println();

        }

    }

    private static void calculaMediaNotas(Aluno[] argAlunos, int argProvas) {

        for (int i = 0; i < argAlunos.length; i++) {

            double sum = 0;

            for (int j = 0; j < argProvas; j++) {

                sum += argAlunos[i].getNotas(j);

            }

            argAlunos[i].setMedia(sum / argProvas);

        }


    }
    
    private static void exibeAlunosMedia(Aluno[] argAlunos) {

        System.out.println("LISTA DOS ALUNOS E SUAS MÉDIAS:");
        for (int i = 0; i < argAlunos.length; i++) {

            System.out.printf("\nNome do aluno: %s\n", argAlunos[i].getNome());
            System.out.printf("Media: %.1f\n", argAlunos[i].getMedia());
            
        }
        
    }

}
