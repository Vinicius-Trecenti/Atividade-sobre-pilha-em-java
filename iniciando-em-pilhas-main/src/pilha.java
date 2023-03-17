4import javax.swing.JOptionPane;

public class pilha {
    
    public static void main(String[] args) throws Exception {

        // Atividade 04 - Pilha usando vetor
        // Implemente a classe Pilha com os seguintes atributos e métodos:
        // - Atributos: int vet[], int topo, int tamanho
        // - Métodos: void empilhar(int), void desempilhar(), int topo(), boolean vazia(), boolean cheia(), int tamanho()
        // teste sua classe e todas suas funcionalidades !
         
        int topo=0; //numero do topo sendo o valor proprio
        int tamanho; //varia de acordo com empilhar e desempilhar sendo o indice 
        //int tamanho_fixo;

        topo = Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho da pilha:"));
        System.out.println("PILHA CRIADA COM O TAMANHO IGUAL A: "+ topo);

        int vet[] = new int[topo];
        tamanho = topo;
        topo=0; //zerando para voltar a começar do indice zero

        // for(int i=0; i<tamanho;i++){
        //     System.out.println(i);
        // }

        String escolha[] = {"Empilhar", "Desempilhar", "Cancelar"};
        int retorno = 3;
        

        do{
            retorno = JOptionPane.showOptionDialog(
            null, "Escolha se deseja empilhar ou desempilhar", 
            "Escolha", JOptionPane.DEFAULT_OPTION, 
            JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);

            if(retorno == 0){
                int num = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor que deseja inserir:")); 
                pilha.empilhar(vet, num, topo, tamanho);
                if(cheia(topo, tamanho) == false){
                    topo = tamanho(topo, 1);
                }
                
                //System.out.println(topo);
    
            }else if(retorno == 1){
                pilha.desempilhar(vet, topo-1, tamanho);
                if(vazia(topo) == false){
                    topo = tamanho(topo, -1);
                }

                //System.out.println(topo);

            }else if(retorno == 2){
                JOptionPane.showMessageDialog(null, "PROGRAMA ENCERRADO");
                
                System.out.println("-------- PILHA --------");
                
                for(int i=topo-1; i>=0; i--){
                    System.out.println(vet[i]);
                }
                
                System.out.println("-----------------------");
                         
            }
        }while(retorno != 2);
    
        //System.out.println(vet[topo]);
    }

    public static void empilhar(int vetor[], int numero, int indice, int tamanho_fixo) {

        if(cheia(indice, tamanho_fixo) == false){
            JOptionPane.showMessageDialog(null, "Elemento adicionado na pilha");
            vetor[indice] = numero; 
        }else{
            JOptionPane.showMessageDialog(null, "Pilha cheia");
        }

    }

    public static void desempilhar(int vetor[], int indice, int tamanho_fixo) {
        if(vazia(indice) == false){
            JOptionPane.showMessageDialog(null, "Elemento desempilhado ");
            JOptionPane.showMessageDialog(null, "Elemento do topo: " + vetor[indice-1]);
        }else{
            JOptionPane.showMessageDialog(null, "Pilha está vazia");
        }
    }

    public static void topo(int vetor[], int indice) {
        //erro printando o valor do topo ainda 
        JOptionPane.showMessageDialog(null, "O elemento do topo  é: "+ vetor[indice]);
    }

    public static boolean vazia(int indice) {
        if(indice<=0){
            return true;
        }
        else{
            return false;
        }

    }

    public static boolean cheia(int indice, int tamanho_pilha) {
        if(indice >= tamanho_pilha){
            return true;
        }
        else{
            return false; 
        }
        
    }

    public static int tamanho(int tamanho, int movimento) {
        
        if(movimento == 1){
            tamanho = tamanho + 1;

        } 
        else if(movimento < 1){
            tamanho = tamanho - 1;

        }
        JOptionPane.showMessageDialog(null, "O tamanho da pilha atual é: " + (tamanho));
        return tamanho;
    }

}